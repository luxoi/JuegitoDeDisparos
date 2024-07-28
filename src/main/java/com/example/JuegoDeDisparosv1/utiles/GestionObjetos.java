package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;


public class GestionObjetos {
    private static AnimationTimer animationTimer;
    private static PanelJuego panelJuego;
    private static boolean crearObj = false;

    public static void comenzar(){
        panelJuego = PanelJuego.getPanelJuego();
        animationTimer = new AnimationTimer() {

            @Override
            public void handle(long ahora) {
                if ((ContadorTiempo.getSegundos() % 17) == 0
                    && crearObj == true){
                    ObMejora objeto = new ObMejora();
                    panelJuego.getChildren().add(objeto);
                    crearObj = false;
                }
                if ((ContadorTiempo.getSegundos() % 17) != 0){
                    crearObj = true;
                }
            }
        };
        animationTimer.start();
    }
}
