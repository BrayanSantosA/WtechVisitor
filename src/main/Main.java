package main;

import model.ComputadoraTorre;
import model.Pedido;
import model.Portatil;
import model.Tablet;
import model.Television;
import visitor.CalculadorEnvioVisitor;
import visitor.CalculadorSubtotalVisitor;

public class Main {

    private static void imprimirResumen(String titulo, Pedido pedido) {
        CalculadorSubtotalVisitor subtotal = new CalculadorSubtotalVisitor();
        pedido.aceptar(subtotal);

        CalculadorEnvioVisitor envio = new CalculadorEnvioVisitor();
        pedido.aceptar(envio);

        double total = subtotal.getSubtotal() + envio.getEnvioTotal();

        System.out.println("   " + titulo + "   ");
        System.out.printf("Subtotal: USD %.2f%n", subtotal.getSubtotal());
        System.out.printf("Envío:    USD %.2f%n", envio.getEnvioTotal());
        System.out.printf("Total:    USD %.2f%n%n", total);
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.agregar(new Tablet(), 2);
        pedido.agregar(new Portatil(), 1);
        pedido.agregar(new ComputadoraTorre(), 1);
        pedido.agregar(new Television(), 1);
        imprimirResumen("Pedido con productos", pedido);

        imprimirResumen("Pedido vacío", new Pedido());

        try {
            new Pedido().agregar(new Tablet(), 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Cantidad inválida rechazada: " + e.getMessage());
        }
    }
}
