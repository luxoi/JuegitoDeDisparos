package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ObMejora extends Rectangle {
    private PanelJuego panelJuego;
    private Image image;
    private AnimationTimer animationTimer;

    public ObMejora(){
        super(Math.random()*470, -30,40,50);
        Image image = new Image("file:src/recursos/mejora.png");

        setFill(new ImagePattern(image));
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
