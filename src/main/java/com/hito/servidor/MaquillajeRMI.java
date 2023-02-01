package com.hito.servidor;

import com.hito.BaseDatos;
import com.hito.InterfaceRMI;

import java.rmi.RemoteException;
import java.util.Scanner;

public class MaquillajeRMI extends Maquillaje implements InterfaceRMI {
    Scanner sc = new Scanner(System.in);
    BaseDatos bd = new BaseDatos();
    private static final long seralVersionUID = 1L;

    public MaquillajeRMI(int id_producto, String producto, String marca, String categoria, String descripcion, float precio, int stock) {
        super(id_producto, producto, marca, categoria, descripcion, precio, stock);
    }

    @Override
    public String selectall() throws RemoteException {
        bd.DataBase();
        return "SELECT * FROM maquillaje";
    }

    @Override
    public String bucar() throws RemoteException {
        bd.DataBase();
        int opcion = sc.nextInt();
        String filtro = "";

        System.out.println("Dime por que campo quieres buscar");
        System.out.println("1. Nombre del producto");
        System.out.println("2. Marca");
        System.out.println("3. Categoria");
        System.out.println("4. Stock");
        System.out.println("5. Salir de la busqueda");

        do {
            switch (opcion) {
                case 1:
                    System.out.println("Dime el nombre del producto");
                    filtro = sc.nextLine();
                    return "SELECT * FROM maquillaje WHERE producto = " + filtro;
                case 2:
                    System.out.println("Dime la marca");
                    filtro = sc.nextLine();
                    return "SELECT * FROM maquillaje WHERE marca = " + filtro;
                case 3:
                    System.out.println("Dime la categoria");
                    filtro = sc.nextLine();
                    return "SELECT * FROM maquillaje WHERE categoria = " + filtro;
                case 4:
                    System.out.println("Dime el stock");
                    filtro = sc.nextLine();
                    return "SELECT * FROM maquillaje WHERE stock = " + filtro;
                case 5:
                    System.out.println("Saliendo de la busqueda...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcion != 5);

        return null;
    }

    @Override
    public String insertar() throws RemoteException {
        bd.DataBase();



        return "INSERT INTO maquillaje (producto, marca, categoria, descripcion, precio, stock) VALUES (" + producto + ", " + marca + ", " + categoria + ", " + descripcion + ", " + precio + ", " + stock + ")";
    }

    @Override
    public String actualizar() throws RemoteException {
        bd.DataBase();

        System.out.println("Dime el id del producto que quieres actualizar");
        int id_producto = Integer.parseInt(sc.nextLine());

        if (rs.absolute(id_producto)){

        }




        return null;
    }

    @Override
    public String eliminar() throws RemoteException {
        return null;
    }
}




