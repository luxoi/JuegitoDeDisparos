package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.utiles.Disparo;
import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class PJ extends Rectangle {
    private PanelJuego panelJuego;
    private boolean moviendoIzquierda, moviendoDerecha;
    private static Bounds posicion;
    private static int nDisparos = 3;
    public PJ(){
        super(250, 480, 50, 50);;
        setFill(Color.CORNFLOWERBLUE);
        ponerEnAccion();
        panelJuego = PanelJuego.getPanelJuego();
        animarPJ();
    }

    private void ponerEnAccion(){
        sceneProperty().addListener((observar, antiguaEscena, nuevaEscena)
                            -> {
                 if(nuevaEscena != null){
                     requestFocus();
                 }
        });
        this.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT){
                moviendoIzquierda = true;
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT){
                moviendoDerecha = true;
            }
        });
        setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT){
                moviendoIzquierda = false;
            }
            if (e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT){
                moviendoDerecha = false;
            }
            if (e.getCode() == KeyCode.SPACE) disparar();
        });
    }

    private void disparar(){
        if (Disparo.getnDisparos() < nDisparos){
            Bounds posPJ = this.getBoundsInParent();
            Disparo d = new Disparo(posPJ.getCenterX(), posPJ.getMinY());
            panelJuego.getChildren().add(d);
        }
    }

    private void mover(){
        if(moviendoIzquierda && getBoundsInParent().getMinX() > 0){
            setLayoutX(getLayoutX() - 3);
        }
        if(moviendoDerecha && getBoundsInParent().getMaxX() < panelJuego.getWidth() ){
            setLayoutX(getLayoutX() + 3);
        }
    }

    private  void animarPJ(){
        AnimationTimer t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                mover();
                posicion = getBoundsInParent();
            }
        };
        t.start();
    }

    public static Bounds getPosicion(){
        return posicion;
    }

    public static void aumentarDisparos(){
        nDisparos++;
    }
}
