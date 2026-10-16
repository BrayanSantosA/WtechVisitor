package model;

import java.util.ArrayList;
import java.util.List;

import visitor.Visitante;

public class Pedido {

    private static class Item {
        final Producto producto;
        final int cantidad;

        Item(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }
    }

    private final List<Item> items = new ArrayList<>();

    public void agregar(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        items.add(new Item(producto, cantidad));
    }

    public void aceptar(Visitante v) {
        for (Item item : items) {
            for (int i = 0; i < item.cantidad; i++) {
                item.producto.aceptar(v);
            }
        }
    }
}
