package com.example.JuegoDeDisparosv1.utiles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Puntuacion extends Text {
    private static int puntuacion = 0;
    public static double multiplicador = 1;
    private static Puntuacion p = new Puntuacion();


    private Puntuacion(){
        super(String.valueOf(puntuacion));
        setFont(new Font("Roboto", 40));
        setFill(Color.RED);
    }

    public static void subirPuntuacion(int cantidad){
        double puntos = cantidad * multiplicador;
        int puntosInt = (int) Math.round(puntos);
        puntuacion += puntosInt; // Sumar puntosInt en lugar de cantidad
        p.setText(String.valueOf(puntuacion));
    }

    public static Puntuacion getPuntuacion(){
        return p;
    }

    public static void aumentarMultiplicador(boolean subir){

        if(subir){
            multiplicador += 0.1;
            System.out.println(multiplicador);
        }else {
            multiplicador = 1;
        }

    }

    public static int getPuntos(){
        return puntuacion;
    }
}
