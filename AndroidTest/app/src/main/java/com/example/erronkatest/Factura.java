package com.example.erronkatest;

public class Factura {
    Client persona;
    Product producto;
    int cantidad;
    Float precio;


    public Factura(Client persona, Product producto, int cantidad, Float precio) {
        this.persona = persona;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;

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
