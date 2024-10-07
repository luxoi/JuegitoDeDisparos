package com.example.JuegoDeDisparosv1.utiles;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ETPuntuacion extends Text {
    private static int puntuacion = 0;
    public static double multiplicador = 1;
    private static ETPuntuacion p = new ETPuntuacion();
    private  Font fuente;

    private ETPuntuacion(){
        super(String.valueOf(puntuacion));
        fuente = Font.loadFont("file:src/recursos/Farmshow.ttf", 50);
        setFont(fuente);
        setFill(Color.BLACK);
    }

    public static void subirPuntuacion(int cantidad){
        double puntos = cantidad * multiplicador;
        int puntosInt = (int) Math.round(puntos);
        puntuacion += puntosInt; // Sumar puntosInt en lugar de cantidad
        p.setText(String.valueOf(puntuacion));
    }

    public static ETPuntuacion getPuntuacion(){
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

    public static void reiniciar() {
        puntuacion = 0;
        p.setText(String.valueOf(puntuacion));
    }
}
