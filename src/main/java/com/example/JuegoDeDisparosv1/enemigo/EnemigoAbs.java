package com.example.JuegoDeDisparosv1.enemigo;

import com.example.JuegoDeDisparosv1.utiles.GestionEnemigo;
import com.example.JuegoDeDisparosv1.utiles.PJ;
import com.example.JuegoDeDisparosv1.utiles.Vida;
import com.example.JuegoDeDisparosv1.vista.PanelJuego;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class EnemigoAbs extends Rectangle {
    protected PanelJuego panelJuego;
    protected double velocidad;
    protected int vida;
    protected Image imagen;
    protected AnimationTimer t;
    protected int puntuacion;
    protected static double dificultad = 0;
    private static final double MAX_DIFICULTAD = 2.0;

    public EnemigoAbs(double posX, double posY, double tamX, double tamY,
                      double velocidad, int vida,int puntuacion){
        super(posX, posY, tamX, tamY);
        this.velocidad = velocidad;
        this.vida = vida;
        this.puntuacion = puntuacion;
        panelJuego = PanelJuego.getPanelJuego();
        // Incrementa la dificultad con un límite superior
        if (dificultad < MAX_DIFICULTAD) {
            dificultad += 0.01;
            System.out.println("La dificultad del juego esta en "+dificultad);
        }


    }

    protected abstract void bajar();

    public int conseguirVida(){
        return vida;
    }

    public void reducirVida(){
        vida--;
    }

    public int getPuntuacion(){
        return puntuacion;
    }

    public  AnimationTimer getAnimador(){
        return t;
    }

    protected void comprobarMuerte(){
        if (getBoundsInParent().getMaxY() >= panelJuego.getHeight()
                || getBoundsInParent().intersects(PJ.getPosicion())) {
                panelJuego.getChildren().remove(this);
                GestionEnemigo.getEnemigos().remove(this);
                Vida.reducirVida();
                t.stop();
        }
    }
}
