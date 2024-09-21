package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class EnemigoZig extends EnemigoAbs {

    private boolean derecha;
    private Image image;

    public EnemigoZig() {
        super(Math.random() * 460, -25, 25, 40,
                (Math.random() * 2) + dificultad, 2, 25);
        derecha = Math.random() > 0.5;
        establecerImagen();
        setFill(new ImagePattern(image));
        bajar();
    }

    private void establecerImagen() {
        if (derecha) {
            image = new Image("file:src/recursos/zigD.png");
        } else {
            image = new Image("file:src/recursos/zigI.png");
        }
    }

    @Override
    protected void bajar() {
        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 0.2);

                if (derecha) {
                    setLayoutX(getLayoutX() + velocidad);
                } else {
                    setLayoutX(getLayoutX() - velocidad);
                }

                // Cambiar de dirección si llega al borde derecho
                if (getBoundsInParent().getMaxX() >= panelJuego.getWidth()) {
                    derecha = false;
                    establecerImagen();
                    setFill(new ImagePattern(image));  // Actualiza la imagen
                }

                // Cambiar de dirección si llega al borde izquierdo
                if (getBoundsInParent().getMinX() <= 0) {
                    derecha = true;
                    establecerImagen();
                    setFill(new ImagePattern(image));  // Actualiza la imagen
                }

                comprobarMuerte();
            }
        };
        t.start();
    }
}
