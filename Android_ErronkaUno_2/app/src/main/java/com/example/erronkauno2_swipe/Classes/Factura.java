package com.example.erronkauno2_swipe.Classes;

import java.util.List;

public class Factura {
    Client persona;
    Product producto;
    List<Product> productos;
    int cantidad;
    Float precio;
    String name;
    Float price_total;
    Float amount_total;


    public Factura(Client persona, Product producto, int cantidad, Float precio) {
        this.persona = persona;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;

    }

    public Factura(String name, Client persona, List<Product> productos, Float price_total, Float amount_total, int cantidad){
        this.name = name;
        this.persona = persona;
        this.price_total = price_total;
        this.amount_total = amount_total;
        this.cantidad = cantidad;
        this.productos = productos;


    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice_total() {
        return price_total;
    }

    public void setPrice_total(Float price_total) {
        this.price_total = price_total;
    }

    public Float getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(Float amount_total) {
        this.amount_total = amount_total;
    }

    public Client getPersona() {
        return persona;
    }

    public void setPersona(Client persona) {
        this.persona = persona;
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "persona='" + persona + '\'' +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }


}
