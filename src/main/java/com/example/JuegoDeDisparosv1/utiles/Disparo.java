package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.enemigo.EnemigoAbs;
import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Disparo extends Rectangle {
    private PanelJuego panelJuego;
    private AnimationTimer t;
    private boolean enPantalla;
    private static int nDisparos = 0;
    private static double ancho = 3;

    public Disparo(Double posX, Double posY){
        super(posX-1.5, posY-25, 3,25);
        nDisparos++;
        panelJuego = PanelJuego.getPanelJuego();
        enPantalla = true;
        setFill(Color.WHITE);
        subir();
    }
    private void subir(){
        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {

                setLayoutY(getLayoutY() - 2.0);
                if(getBoundsInParent().getMaxY() <= 0) enPantalla = false;

                ArrayList<EnemigoAbs> enemigos = GestionEnemigo.getEnemigos();
                for (int i=0;i<enemigos.size(); i++){
                    EnemigoAbs e = enemigos.get(i);
                    if(getBoundsInParent().intersects(e.getBoundsInParent())){
                        enPantalla = false;
                        e.reducirVida();

                        if(e.conseguirVida()<=0){
                            e.getAnimador().stop();
                            panelJuego.getChildren().remove(e);
                            enemigos.remove(e);
                            ETPuntuacion.subirPuntuacion(e.getPuntuacion());
                            ETPuntuacion.aumentarMultiplicador(true);
                        }
                    }
                }

                if (!enPantalla){
                    nDisparos--;
                    t.stop();
                    panelJuego.getChildren().remove(Disparo.this);
                }
            }
        };
        t.start();
    }

    public static int getnDisparos(){
        return nDisparos;
    }

    public static void aumentarAncho() {
        ancho += 1;
        System.out.println("El ancho del disparo es: " + ancho);
    }
}
