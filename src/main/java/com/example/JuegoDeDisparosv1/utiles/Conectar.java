package com.example.JuegoDeDisparosv1.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {

    private static Connection micon;
    private static Statement miSt;

    public static void conectar(){
        try {
            Connection miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegodedisparos",
                    "PruebaRapida", "");
            miSt = miCon.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void desconectar(){
        try{
            miSt.close();
            micon.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void EnviarPuntuacion(){
        int puntos = Puntuacion.getPuntos();
        String tiempo = ContadorTiempo.formatoContador();

        conectar();
    }

}
