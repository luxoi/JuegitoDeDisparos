package com.example.JuegoDeDisparosv1.vista;

import com.example.JuegoDeDisparosv1.utiles.Conectar;
import com.example.JuegoDeDisparosv1.utiles.GestionEscenas;
import com.example.JuegoDeDisparosv1.utiles.Puntuacion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PanelPuntuaciones extends BorderPane {
    private Text text;
    private Button botonMenu;

    private TableView<Puntuacion> tabla;
    private TableColumn<Puntuacion, Integer> colPuntos;
    private TableColumn<Puntuacion, String> colTiempo;

    public PanelPuntuaciones() {
        text = new Text("MEJORES PUNTUACIONES");
        botonMenu = new Button("Volver");
        prepararColumnas();
        montarEscena();
    }

    private void montarEscena() {
        text.setFont(new Font("Roboto", 35));
        setTop(text);
        BorderPane.setAlignment(text, Pos.CENTER);

        setCenter(tabla);

        botonMenu.setOnAction(e -> GestionEscenas.escenaMenu());
        setBottom(botonMenu);
        BorderPane.setAlignment(botonMenu, Pos.CENTER);
        BorderPane.setMargin(botonMenu, new Insets(20));
    }

    private void prepararColumnas() {
        tabla = new TableView<Puntuacion>();
        tabla.setMaxHeight(275);

        colPuntos = new TableColumn<>("Puntos");
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        colPuntos.setPrefWidth(240);

        colTiempo = new TableColumn<>("Tiempo");
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        colTiempo.setPrefWidth(240);

        tabla.getColumns().addAll(colPuntos, colTiempo);

        tabla.setItems(Conectar.obtenerLista());
    }
}
