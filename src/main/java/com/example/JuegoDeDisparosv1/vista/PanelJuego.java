package com.example.JuegoDeDisparosv1.vista;

import com.example.JuegoDeDisparosv1.utiles.GestionEnemigo;
import com.example.JuegoDeDisparosv1.utiles.GestionObjetos;
import com.example.JuegoDeDisparosv1.utiles.PJ;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class PanelJuego extends Pane {
    private static PanelJuego panelJuego;
    private PJ pj;

    private Rectangle valla;

        public PanelJuego(){
            panelJuego = this;
            pj = new PJ();
            valla = new Rectangle(0, 500, 500, 60);
            montarEscena();
            GestionEnemigo.comenzar();
            GestionObjetos.comenzar();
        }

        public void montarEscena(){
            this.setStyle("-fx-background-image: url('file:src/recursos/fondoJuego.png'); " +
                          "-fx-background-size: cover;");
            Image imagenValla = new Image("file:src/recursos/valla.png");
            valla.setFill(new ImagePattern(imagenValla));
            getChildren().addAll(pj, valla);
            //añadir el pj al panel
        }

        public static PanelJuego getPanelJuego(){
            return panelJuego;
        }
}
