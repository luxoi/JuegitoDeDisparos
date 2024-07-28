package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class EnemigoJefe extends EnemigoAbs{

    public EnemigoJefe(){
        super(150, -100, 200, 100,
                (Math.random()*2)+dificultad, 10, 1000);
        setFill(Color.PURPLE);
        bajar();
    }


    @Override
    protected void bajar() {
        t =  new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 0.3);
                comprobarMuerte();
            }
        };
        t.start();
    }
}
