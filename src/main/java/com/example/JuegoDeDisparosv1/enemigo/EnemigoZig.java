package com.example.JuegoDeDisparosv1.enemigo;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class EnemigoZig extends EnemigoAbs{

    private boolean derecha;

    public EnemigoZig(){
        super(Math.random()*460, -25, 25, 40,
                (Math.random()*2)+dificultad, 2, 25);
        setFill(Color.GREENYELLOW);
        derecha = Math.random() > 0.5 ? true:false;
        bajar();
    }

    @Override
    protected void bajar() {
        t =  new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 0.2);

                if(derecha){
                    setLayoutX(getLayoutX()+velocidad);
                }else {
                    setLayoutX(getLayoutX()-velocidad);
                }

                if (getBoundsInParent().getMaxX() >= panelJuego.getWidth()){
                    derecha = false;
                }

                if (getBoundsInParent().getMinX() <= 0){
                    derecha = true;
                }

                comprobarMuerte();
            }
        };
        t.start();
    }
}
