package com.example.JuegoDeDisparosv1;

import com.example.JuegoDeDisparosv1.utiles.GestionEscenas;
import com.example.JuegoDeDisparosv1.vista.MenuInicio;
import com.example.JuegoDeDisparosv1.vista.PanelRaiz;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JuegoDeDisparosv1Application extends Application {
	private static Stage escenario;

	@Override
	public void start(Stage escenario) throws Exception {
		this.escenario = escenario;
		GestionEscenas.escenaMenu();
		escenario.show();
	}
	public static void main(String[] args) {
		SpringApplication.run(JuegoDeDisparosv1Application.class, args);
		launch(args);
	}

	public static Stage getEscenario(){
		return escenario;
	}

}
