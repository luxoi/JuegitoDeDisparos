package com.example.JuegoDeDisparosv1.vista;

import com.example.JuegoDeDisparosv1.utiles.ContadorTiempo;
import com.example.JuegoDeDisparosv1.utiles.Puntuacion;
import com.example.JuegoDeDisparosv1.utiles.Vida;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Stack;

public class PanelInferior extends StackPane {

    private Puntuacion puntos;
    private ArrayList<Vida> vidas;
    private static PanelInferior panelInferior;
    private HBox hbox;
    public PanelInferior(){
        puntos = Puntuacion.getPuntuacion();
        vidas = Vida.getVidas();
        hbox = new HBox(10);
        setStyle("-fx-background-color: GRAY");
        montarEscena();
        panelInferior = this;
    }

    private void montarEscena() {
        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        Region espacio2 = new Region();
        HBox.setHgrow(espacio2, Priority.ALWAYS);

        for(Vida v:vidas) hbox.getChildren().add(v);
        hbox.getChildren().addAll(espacio, ContadorTiempo.getContador(),espacio2,puntos);
        hbox.setAlignment(Pos.CENTER);

        getChildren().addAll(hbox, ContadorTiempo.getContador());
        StackPane.setAlignment(ContadorTiempo.getContador(), Pos.CENTER);
    }

    public static PanelInferior getPanelInferior(){
        return panelInferior;
    }

    public HBox getHbox(){
        return hbox;
    }
}
