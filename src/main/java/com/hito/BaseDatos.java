package com.hito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BaseDatos {

    public void DataBase() {
        //Utilizo el JDBC para conectarme a la base de datos
        String conexion = "jdbc:mysql://localhost:3306/beautyShop";
        //Le paso el usuario y la contraseña
        String usuario = "root";
        String password = "curso";
        Connection con;
        Statement stmt;
        ResultSet rs = null;
    }
}
