package com.hito;



import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class Servidor {
    
    private static final long serialVersionUID = 1L; // Controlador de versiones

    public static void main(String[] args) {
        String host = null;
        int puerto=5055;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
            
        } catch (UnknownHostException e) {
            System.out.println("No se ha encontrado la IP");
        }
        
        try {
            Registry registro = LocateRegistry.createRegistry(puerto);
            LogicaServidorRMI cliente = new LogicaServidorRMI();
            registro.rebind("Maquillaje_1", cliente);
            System.out.println("Host " + host + " - Puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("Fallo en el registro");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
