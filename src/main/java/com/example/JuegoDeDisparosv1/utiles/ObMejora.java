package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ObMejora extends Rectangle {
    private PanelJuego panelJuego;
    private Image image;
    private AnimationTimer animationTimer;

    public ObMejora(){
        super(Math.random()*470, -30,30,30);
        setFill(Color.GOLD);
        panelJuego = PanelJuego.getPanelJuego();
        bajar();
    }

    private void bajar() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 1);
                comprobarColision();
            }
        };

        animationTimer.start();
    }

    private void comprobarColision() {
        if (getBoundsInParent().getMaxY()>= panelJuego.getHeight()){
            panelJuego.getChildren().remove(this);
            animationTimer.stop();
        }

        if (getBoundsInParent().intersects(PJ.getPosicion())){
            panelJuego.getChildren().remove(this);
            animationTimer.stop();
            PJ.aumentarDisparos();
            Disparo.aumentarAncho();
        }
    }
}
