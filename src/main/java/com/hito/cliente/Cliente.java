package com.hito.cliente;

import com.hito.InterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Registry registry;
        Scanner sc = new Scanner(System.in);
        try {
            registry = LocateRegistry.getRegistry("192.168.56.1", 5055); // Buscamos el registro pasadole la IP y el puerto

            InterfaceRMI canciones = (InterfaceRMI) registry.lookup(""); // Buscamos el objeto remoto

            int opc_int;
            String opc_str;


        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }
        sc.close();
}
