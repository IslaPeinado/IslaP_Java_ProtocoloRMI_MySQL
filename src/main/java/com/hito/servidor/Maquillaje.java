package com.hito.servidor;

public class Maquillaje {

    private int id_producto;
    private String producto;
    private String marca;
    private String categoria;
    private String descripcion;
    private float precio;
    private int stock;


    // Constructor
    public Maquillaje(int id_producto, String producto, String marca, String categoria, String descripcion, float precio, int stock) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.marca = marca;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }


    // Getters
    public int getId_producto() {
        return id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
