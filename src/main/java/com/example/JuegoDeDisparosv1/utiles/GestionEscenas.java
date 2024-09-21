package com.example.JuegoDeDisparosv1.utiles;

import com.example.JuegoDeDisparosv1.JuegoDeDisparosv1Application;
import com.example.JuegoDeDisparosv1.vista.MenuInicio;
import com.example.JuegoDeDisparosv1.vista.PanelPuntuaciones;
import com.example.JuegoDeDisparosv1.vista.PanelRaiz;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionEscenas {
    private static Stage escenario;
    private static Scene esMenu, esJuego, esPuntos;

    static {
        escenario = JuegoDeDisparosv1Application.getEscenario();
        esMenu = new Scene(new MenuInicio(), 500, 600);
    }

    public static void escenaMenu(){
        escenario.setScene(esMenu);
    }

    public static void escenaJuego(){
        esJuego = new Scene(new PanelRaiz(), 500, 600);
        ContadorTiempo.empezar();
        escenario.setScene(esJuego);
    }

    public static void escenaPuntos(){
        esPuntos = new Scene(new PanelPuntuaciones(), 500, 600);
        escenario.setScene(esPuntos);
    }
}
