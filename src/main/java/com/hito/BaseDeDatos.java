package com.hito;

import com.hito.servidor.Maquillaje;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class BaseDeDatos{

    public void DatosMaquillaje() throws SQLException {

        try {
            FileWriter fw=new FileWriter("maquillaje.txt");
            //Utilizo el JDBC para conectarme a la base de datos
            String usuario = "root";
            String password = "curso";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mimaquillaje", usuario, password);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM maquillaje");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Conexion hecha");
            try {
                //rs.beforeFirst();
                while (rs.next()){
                    fw.write(rs.getString("id_producto"));
                    fw.write(",");
                    fw.write(rs.getString("producto"));
                    fw.write(",");
                    fw.write(rs.getString("marca"));
                    fw.write(",");
                    fw.write(rs.getString("categoria"));
                    fw.write(",");
                    fw.write(rs.getString("descripcion"));
                    fw.write(";");
                    fw.write("\n");
                }
                System.out.println("Se han mostrado todos los datos");
            } catch (SQLException e) {
                System.out.println("No se ha podido realizar la consulta");
            }
            fw.close();
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
