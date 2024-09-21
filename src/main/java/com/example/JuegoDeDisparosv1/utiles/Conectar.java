package com.example.JuegoDeDisparosv1.utiles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Conectar {

    private static Connection miCon;
    private static Statement miSt;

    private static void conectar() {
        try {
            miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegodedisparos", "root", "root");
            miSt = miCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void desconectar() {
        try {
            if (miSt != null) miSt.close();
            if (miCon != null) miCon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void enviarPuntuacion() {
        if (comprobarPuntuacion()) {
            int puntos = ETPuntuacion.getPuntos();
            String tiempo = ContadorTiempo.formatoContador();
            conectar();
            try {
                miSt.execute("INSERT INTO puntosdisparo (puntuacion, tiempo) VALUES ('" + puntos + "','" + tiempo + "')");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                desconectar();
            }
        }
    }

    private static boolean comprobarPuntuacion() {
        conectar();
        try {
            ResultSet miRs = miSt.executeQuery("SELECT puntuacion FROM puntosdisparo ORDER BY puntuacion DESC");
            miRs.last();
            int numRegistros = miRs.getRow();
            if (numRegistros < 10) {
                return true;
            }
            int puntos = ETPuntuacion.getPuntos();
            if (puntos > miRs.getInt("puntuacion")) {
                miSt.execute("DELETE FROM puntosdisparo WHERE puntuacion='" + miRs.getInt(1) + "'");
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            desconectar();
        }
    }

    public static ObservableList<Puntuacion> obtenerLista() {
        ObservableList<Puntuacion> lista = FXCollections.observableArrayList();
        conectar();
        try {
            ResultSet miRs = miSt.executeQuery("SELECT * FROM juegodedisparos.puntosdisparo ORDER BY puntuacion DESC");
            while (miRs.next()) {
                int puntos = miRs.getInt(1);
                String tiempo = miRs.getString(2);
                lista.add(new Puntuacion(puntos, tiempo));
                System.out.println("Puntuacion: " + puntos + ", Tiempo: " + tiempo); // Mensaje de depuración
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            desconectar();
        }
    }
}
