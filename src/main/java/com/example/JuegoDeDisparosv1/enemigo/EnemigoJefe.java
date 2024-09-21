package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class EnemigoJefe extends EnemigoAbs{

    public EnemigoJefe(){
        super(150, -150, 210, 150,
                (Math.random()*2)+dificultad, 10, 1000);
        Image image = new Image("file:src/recursos/jefe.png");
        setFill(new ImagePattern(image));
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
