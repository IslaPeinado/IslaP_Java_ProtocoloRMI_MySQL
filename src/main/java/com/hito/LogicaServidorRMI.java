package com.hito;

import com.hito.servidor.Maquillaje;

import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class LogicaServidorRMI extends UnicastRemoteObject implements InterfaceRMI{

    private static final long serialVersionUID = 1L; // Controlador de versiones

    private static ArrayList<Maquillaje> listaMaquillaje = new ArrayList<>(); // Lo creamos para almacemnar los datos de la tabla maquillaje


    public LogicaServidorRMI() throws IOException, SQLException {
        BaseDeDatos db = new BaseDeDatos();
        db.DatosMaquillaje();
        contenidoFichero();
    }


    @Override
    public String buscarId(int id) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            String idString = String.valueOf(id);
            if(maq.getId_producto() == (parseInt(idString))){
                System.out.println(maq+"\n");
                resultado+=maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String bucarProducto(String producto) throws RemoteException {
        String resultado="";
        System.out.println(listaMaquillaje);
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getProducto().contains(producto)){
                System.out.println(maq+"\n");
                resultado+=maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarMarca(String marca) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getMarca().contains(marca)){
                System.out.println(marca);
                System.out.println(maq+"\n");
                resultado+=maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarCategoria(String categoria) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getCategoria().contains(categoria)){
                System.out.println(maq+"\n");
                resultado+=maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarDescripcion(String descripcion) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getDescripcion().contains(descripcion)){
                System.out.println(maq+"\n");
                resultado+=maq+"\n";
            }
        }
        return resultado;
    }


    // Leer el contenido del fichero para utilizarlos en los metodos RMI.
    public static Maquillaje contenidoFichero() throws IOException {
        Scanner sc = new Scanner(new FileReader("maquillaje.txt")).useDelimiter(";");
        Maquillaje maq=null;
        String[] linea;
        while(sc.hasNext()) {
            linea= sc.nextLine().split(",");
            int id_producto= parseInt(linea[0]);
            String producto=linea[1];
            String marca=linea[2];
            String categoria=linea[3];
            String descripcion=linea[4];

            maq = new Maquillaje(id_producto, producto, marca, categoria, descripcion);
            listaMaquillaje.add(maq);
        }
        return maq;
    }


}


