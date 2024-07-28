package com.example.JuegoDeDisparosv1.vista;

import com.example.JuegoDeDisparosv1.utiles.GestionEnemigo;
import com.example.JuegoDeDisparosv1.utiles.GestionObjetos;
import com.example.JuegoDeDisparosv1.utiles.PJ;
import javafx.scene.layout.Pane;

public class PanelJuego extends Pane {
    private static PanelJuego panelJuego;
    private PJ pj;
        public PanelJuego(){
            panelJuego = this;
            pj = new PJ();
            montarEscena();
            GestionEnemigo.comenzar();
            GestionObjetos.comenzar();
        }

        public void montarEscena(){
            getChildren().add(pj);
            //añadir el pj al panel
        }

        public static PanelJuego getPanelJuego(){
            return panelJuego;
        }
}
