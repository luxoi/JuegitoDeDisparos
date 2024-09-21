package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class EnemigoComun extends EnemigoAbs{

    public EnemigoComun() {
        super(Math.random()*450, -60, 70, 60,
                (Math.random()*2)+dificultad, 1, 5);
        Image image = new Image("file:src/recursos/comun.png");

        setFill(new ImagePattern(image));
        bajar();
    }

    @Override
    protected void bajar() {
        t =  new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + velocidad);
                comprobarMuerte();
            }
        };
        t.start();
    }

}
