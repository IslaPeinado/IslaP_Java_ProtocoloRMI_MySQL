package com.hito;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {
    public String selectall() throws RemoteException;
    public String bucar() throws RemoteException;
    public String insertar() throws RemoteException;
    public String actualizar() throws RemoteException;
    public String eliminar() throws RemoteException;

}
