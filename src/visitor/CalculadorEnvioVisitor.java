package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Producto;
import model.Tablet;
import model.Television;

public class CalculadorEnvioVisitor implements Visitante {
    private double envioTotal = 0;

    private void acumular(Producto p) {
        double porcentajeEnvio = (p.getPesoGramos() / 100) * 2;
        envioTotal += p.getPrecio() * porcentajeEnvio / 100;
    }

    @Override
    public void visitar(Tablet tablet) { acumular(tablet); }

    @Override
    public void visitar(Portatil portatil) { acumular(portatil); }

    @Override
    public void visitar(ComputadoraTorre torre) { acumular(torre); }

    @Override
    public void visitar(Television television) { acumular(television); }

    public double getEnvioTotal() {
        return envioTotal;
    }
}
