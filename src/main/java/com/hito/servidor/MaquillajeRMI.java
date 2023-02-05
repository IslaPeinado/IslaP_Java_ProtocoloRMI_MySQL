package com.hito.servidor;

import com.hito.InterfaceRMI;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.Scanner;

public class MaquillajeRMI extends Maquillaje implements InterfaceRMI {

   BaseDatos db = new BaseDatos();
    private static final long seralVersionUID = 1L;
    Scanner sc = new Scanner(System.in);

    public MaquillajeRMI (int id_producto, String producto, String marca, String categoria, String descripcion, float precio, int stock) {
        super(id_producto, producto, marca, categoria, descripcion, precio, stock);
    }


    @Override
    public String selectall() throws RemoteException {
        return db.selectall();
    }

    @Override
    public String bucar() throws RemoteException {

        int opcion = sc.nextInt();
        String filtro = "";

        System.out.println("Dime por que campo quieres buscar");
        System.out.println("1. Nombre del producto");
        System.out.println("2. Marca");
        System.out.println("3. Categoria");
        System.out.println("4. Stock");
        System.out.println("5. Mostar todos los productos");
        System.out.println("6. Salir de la busqueda");

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
                    selectall();
                case 6:
                    System.out.println("Saliendo de la busqueda...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcion != 6);

        return null;
    }

    @Override
    public String insertar() throws RemoteException {

        System.out.println("Nombre del producto");
        String producto = sc.nextLine();
        System.out.println("Marca");
        String marca = sc.nextLine();
        System.out.println("Categoria");
        String categoria = sc.nextLine();
        System.out.println("Descripcion");
        String descripcion = sc.nextLine();
        System.out.println("Precio");
        float precio = sc.nextFloat();
        System.out.println("Stock");
        int stock = sc.nextInt();

        return "INSERT INTO maquillaje (producto, marca, categoria, descripcion, precio, stock) VALUES (" + producto + ", " + marca + ", " + categoria + ", " + descripcion + ", " + precio + ", " + stock + ")";
    }

    @Override
    public String actualizar() throws RemoteException {

        System.out.println("¿Sabes el id del producto que quieres actualizar? S/N");
        String opcion = sc.nextLine();
        if (opcion=="S"){
            System.out.println("Id del producto a actualizar");
            //System.out.println("Recuerda sino quieres actualizar un campo, dejarlo en blanco");
            int id_producto = sc.nextInt();
            System.out.println("Nombre del producto");
            String producto = sc.nextLine();
            System.out.println("Marca");
            String marca = sc.nextLine();
            System.out.println("Categoria");
            String categoria = sc.nextLine();
            System.out.println("Descripcion");
            String descripcion = sc.nextLine();
            System.out.println("Precio");
            float precio = sc.nextFloat();
            System.out.println("Stock");
            int stock = sc.nextInt();
        } else {
            selectall();
        }


        return null;
    }

    @Override
    public String eliminar() throws RemoteException {

        System.out.println("¿Sabes el id del producto que quieres eliminar? S/N");
        String opcion = sc.nextLine();
        if (opcion=="S"){
            System.out.println("Id del producto a eliminar");
            int id_producto = sc.nextInt();
            return "DELETE FROM maquillaje WHERE id_producto = " + id_producto;
        } else {
            selectall();
        }
        return null;
    }
}




