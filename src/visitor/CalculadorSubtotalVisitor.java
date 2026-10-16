package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Producto;
import model.Tablet;
import model.Television;

public class CalculadorSubtotalVisitor implements Visitante {
    private double subtotal = 0;

    private void sumar(Producto p) {
        subtotal += p.getPrecio();
    }

    @Override
    public void visitar(Tablet tablet) { sumar(tablet); }

    @Override
    public void visitar(Portatil portatil) { sumar(portatil); }

    @Override
    public void visitar(ComputadoraTorre torre) { sumar(torre); }

    @Override
    public void visitar(Television television) { sumar(television); }

    public double getSubtotal() {
        return subtotal;
    }
}
