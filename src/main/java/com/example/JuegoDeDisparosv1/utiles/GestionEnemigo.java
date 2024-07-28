package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.enemigo.EnemigoAbs;
import com.example.JuegoDeDisparosv1.enemigo.EnemigoComun;
import com.example.JuegoDeDisparosv1.enemigo.EnemigoJefe;
import com.example.JuegoDeDisparosv1.enemigo.EnemigoZig;
import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class GestionEnemigo {

    //Atributoes de la generacion de enemigos
    private static AnimationTimer t;
    private static PanelJuego panelJuego;
    private static long tAparicion = 2_000_000_000;
    private static long tAnterior = 0;
    static boolean prueba = true;
    //array donde generamos todos los enemigos generados.
    public static ArrayList<EnemigoAbs> enemigos = new ArrayList<>();

    public static void comenzar(){
        panelJuego = PanelJuego.getPanelJuego();
        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
            if (ahora - tAnterior >= tAparicion){

                if (tAparicion > 500_000_000) {
                    tAparicion -= 5_000_000; // Reduce el decremento si es necesario
                } else {
                    tAparicion = 500_000_000; // Establece un límite inferior
                }

                EnemigoAbs e = new EnemigoComun();
                EnemigoAbs e2 = Math.random() > 0.15 ? new EnemigoComun() : new EnemigoZig();

                enemigos.add(e);
                enemigos.add(e2);
                panelJuego.getChildren().addAll(e, e2);

                if(tAparicion<1_800_000_000 && Math.random()>0.95){
                    EnemigoAbs e3 = new EnemigoJefe();
                    enemigos.add(e3);
                    panelJuego.getChildren().add(e3);
                    prueba = false;
                }

                tAnterior = ahora;
                }
            }
        };
        t.start();
    }

    public static ArrayList<EnemigoAbs> getEnemigos(){
        return enemigos;
    }
}
