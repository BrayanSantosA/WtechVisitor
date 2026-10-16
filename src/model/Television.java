package model;

import visitor.Visitante;

public class Television implements Producto {
    private final String nombre;
    private final double precio;
    private final double pesoGramos;

    public Television() {
        this("Televisión", 300, 4000);
    }

    public Television(String nombre, double precio, double pesoGramos) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoGramos = pesoGramos;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getPrecio() { return precio; }

    @Override
    public double getPesoGramos() { return pesoGramos; }

    @Override
    public void aceptar(Visitante v) {
        v.visitar(this);
    }
}
