package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.enemigo.EnemigoAbs;
import com.example.JuegoDeDisparosv1.vista.PanelInferior;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Vida extends Rectangle {
    private Image image = new Image("file:src/recursos/png-transparent-pixel-heart.png");
    private static ArrayList<Vida> vidas;
    private static int indiceActual = 2;

    private Vida() {
        super(50, 50);
        setFill(new ImagePattern(image));
    }

    public static synchronized ArrayList<Vida> getVidas() {
        if (vidas == null) {
            crearVidas();
        }
        return vidas;
    }

    private static synchronized void crearVidas() {
        vidas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vidas.add(new Vida());
        }
    }

    public static synchronized void reducirVida() {
        if (indiceActual >= 0) {
            Vida v = vidas.get(indiceActual);
            PanelInferior.getPanelInferior().getHbox().getChildren().remove(v);
            vidas.remove(indiceActual);
            indiceActual--;
            ETPuntuacion.aumentarMultiplicador(false);
            if (indiceActual== -1) {
                perder();
            }
        }
    }

    private static void perder() {
        Conectar.enviarPuntuacion();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GestionEscenas.escenaPuntos();
        GestionEnemigo.reiniciar();
        ETPuntuacion.reiniciar();
        ContadorTiempo.reiniciar();
        EnemigoAbs.reiniciar();
        vidas = null;
        indiceActual = 2;
    }
}



