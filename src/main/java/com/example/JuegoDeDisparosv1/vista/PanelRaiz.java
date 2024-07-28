package com.example.JuegoDeDisparosv1.vista;

import javafx.scene.layout.BorderPane;



public class PanelRaiz extends BorderPane {
    public PanelRaiz(){
        setCenter(new PanelJuego());
        setBottom(new PanelInferior());

    }
}
