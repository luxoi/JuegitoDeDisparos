package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class EnemigoComun extends EnemigoAbs{

    public EnemigoComun() {
        super(Math.random()*450, -50, 50, 50,
                (Math.random()*2)+dificultad, 1, 5);
        setFill(Color.RED);
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
