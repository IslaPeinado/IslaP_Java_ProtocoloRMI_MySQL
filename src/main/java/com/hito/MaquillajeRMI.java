package com.hito;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaquillajeRMI extends Maquillaje implements InterfaceRMI {

    private static final long serialVersionUID = 1L; // Controlador de versiones

    private ArrayList<Maquillaje> listaMaquillaje = new ArrayList<>(); // Lo creamos para almacemnar los datos de la tabla maquillaje

    public MaquillajeRMI(int id_producto, String producto, String marca, String categoria, String descripcion) {
        super(id_producto, producto, marca, categoria, descripcion);
    }

    @Override
    public String buscarId(int id) throws RemoteException {
        return null;
    }

    @Override
    public String bucarProducto(String producto) throws RemoteException {
        String resultado="";
        for (Maquillaje maq : listaMaquillaje) {
            if (maq.getProducto().contains(producto)) {
                System.out.println(maq + "\n");
                resultado += maq + "\n";
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
                resultado += maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarCategoria(String categoria) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getCategoria().contains(categoria)){
                System.out.println(categoria);
                System.out.println(maq+"\n");
                resultado += maq+"\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarDescripcion(String descripcion) throws RemoteException {
        String resultado="";
        for(Maquillaje maq : listaMaquillaje){
            if(maq.getDescripcion().contains(descripcion)){
                System.out.println(descripcion);
                System.out.println(maq+"\n");
                resultado += maq+"\n";
            }
        }
        return resultado;
    }
}




