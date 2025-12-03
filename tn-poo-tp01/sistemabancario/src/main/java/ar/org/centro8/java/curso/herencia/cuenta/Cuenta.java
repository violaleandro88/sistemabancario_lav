package ar.org.centro8.java.curso.herencia.cuenta;

import ar.org.centro8.java.curso.herencia.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Cuenta {
    private int nroCuenta;
    private double saldo;
    private Cliente cliente;

    //Metodos a implemetar (aca me di cuenta que si no lo ponia abstract me daba error, lo que insulte)
    public abstract void depositarEfectivo(double monto);
    public abstract void extraerEfectivo(double monto);

}
