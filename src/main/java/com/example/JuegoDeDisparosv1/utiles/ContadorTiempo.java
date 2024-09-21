package com.example.JuegoDeDisparosv1.utiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ContadorTiempo{
    private static int segundos = 0;
    private static Label etiqueta;
    private static Timeline tl;
    private static ContadorTiempo contadorTiempo = new ContadorTiempo();

    private ContadorTiempo(){
        etiqueta = new Label();
        etiqueta.setFont(new Font("Roboto", 30));
        actEtiqueta();

        tl = new Timeline(new KeyFrame(Duration.seconds(1),e-> {
            segundos++;
            actEtiqueta();
             })
         );

        tl.setCycleCount(Timeline.INDEFINITE);
        empezar();
    }

    public static String formatoContador(){
        int minutos = segundos/60;
        int segundosF = segundos%60;
        return String.format("%02d:%02d", minutos, segundosF);
    }

    private static void actEtiqueta(){
        etiqueta.setText(formatoContador());
    }

    public static void empezar(){
        tl.play();
    }

    public static Label getContador(){
        return etiqueta;
    }

    public static int getSegundos(){
        return segundos;
    }

    public static void reiniciar() {
        tl.stop();
        segundos = 0;
        actEtiqueta();
    }
}
