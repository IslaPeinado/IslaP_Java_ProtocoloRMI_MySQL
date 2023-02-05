package com.hito;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {
    public String buscarId(int id) throws RemoteException;
    public String bucarProducto(String producto) throws RemoteException;
    public String buscarMarca(String marca) throws RemoteException;
    public String buscarCategoria(String categoria ) throws RemoteException;
    public String buscarDescripcion(String descripcion) throws RemoteException;

}
