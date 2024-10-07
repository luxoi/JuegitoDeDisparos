package com.example.JuegoDeDisparosv1.vista;

import com.example.JuegoDeDisparosv1.utiles.GestionEscenas;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuInicio extends BorderPane {
    private Button bJugar, bSalir;
    private VBox boxBotones;
    private Font    fuente;


    public MenuInicio(){
        fuente = Font.loadFont("file:src/recursos/Farmshow.ttf", 40);
        bJugar = new Button("Jugar");
        bSalir = new Button("Salir");
        boxBotones = new VBox(10);
         setStyle("-fx-background-image: url('file:src/recursos/fondoInicio1.png');" +
                  "-fx-background-size: cover;");
        montarEscena();
    }

    private void montarEscena() {
        bJugar.setOnAction(e-> GestionEscenas.escenaJuego());
        estiloBoton(bJugar);
        bSalir.setOnAction(e->System.exit(0));
        estiloBoton(bSalir);
        boxBotones.getChildren().addAll(bJugar, bSalir);
        boxBotones.setAlignment(Pos.CENTER);
        setCenter(boxBotones);
        //BorderPane.setMargin(boxBotones, new Insets(50));
    }

    private void estiloBoton(Button boton){
        boton.setMinHeight(70);
        boton.setMinWidth(180);
        boton.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background-image: url('file:src/recursos/boton.png');" +
                "-fx-background-size: cover;"
        );
        boton.setFont(fuente);
        boton.setTextFill(Color.WHITE);
    }
}
