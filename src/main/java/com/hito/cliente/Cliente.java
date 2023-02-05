package com.hito.cliente;

import com.hito.InterfaceRMI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String host;

        try {
            host= InetAddress.getLocalHost().getHostAddress();
            Registry registro = LocateRegistry.getRegistry(host, 5055);
            System.out.println("Hemos obtenido el registro");
            InterfaceRMI objRMI = (InterfaceRMI) registro.lookup("Maquillaje_1");
            System.out.println("Obejeto obtenido");
            System.out.println();

            String filtro;
            int id;
            int opc;

            do {
                System.out.println("¿Que desea buscar?");
                System.out.println("1. ID");
                System.out.println("2. Producto");
                System.out.println("3. Marca");
                System.out.println("4. Categoria");
                System.out.println("5. Descripcion");
                System.out.println("6. Salir");

                opc = sc2.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println("Introduzca el ID del producto");
                        id = sc2.nextInt();
                        System.out.println(objRMI.buscarId(id));
                        break;
                    case 2:
                        System.out.println("Introduzca el nombre del producto");
                        filtro = sc.next();
                        System.out.println(objRMI.bucarProducto(filtro));
                        break;
                    case 3:
                        System.out.println("Introduzca la marca del producto");
                        filtro = sc.nextLine();
                        System.out.println(objRMI.buscarMarca(filtro));;
                        break;
                    case 4:
                        System.out.println("Introduzca la categoria del producto");
                        filtro = sc.nextLine();
                        System.out.println(objRMI.buscarCategoria(filtro));
                        break;
                    case 5:
                        System.out.println("Introduzca la descripcion del producto");
                        filtro = sc.nextLine();
                        System.out.println(objRMI.buscarDescripcion(filtro));
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }

            } while (opc !=6);


        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
