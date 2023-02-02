package com.hito;

import java.sql.*;
import java.util.Scanner;

public class BaseDatos {

    public void selectall() {
        //Conexion con la base de datos MySQL

        //Utilizo el JDBC para conectarme a la base de datos
        String conexion = "jdbc:mysql://localhost:3306/MiMaquillage";
        //Le paso el usuario y la contraseña
        String usuario = "root";
        String password = "curso";
        Connection con;
        Statement stmt;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(conexion, usuario, password);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Comprobamos que la conexion se ha realizado correctamente sino salta una excepcion
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se ha podido abrir la BD");
            return;
        }

        try {
            rs = stmt.executeQuery("SELECT * FROM maquillaje");
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_producto"));
                System.out.println("Producto: " + rs.getString("producto"));
                System.out.println("Marca: " + rs.getString("marca"));
                System.out.println("Categoria: " + rs.getString("categoria"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Precio: " + rs.getFloat("precio"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("-------------------------------------------------");
            }
        } catch (SQLException e) {
            //Si hay algun error, mostramos un mensaje por consola
            System.out.println("No se ha podido obtener la tabla productos");
        }
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido cerrar la conexion");
        }
    }
}
