package ar.org.centro8.java.curso.herencia.cuenta;

import ar.org.centro8.java.curso.herencia.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {
    private double giroDescubierto;

    // Constructor
    /**
     * El constructor no pide el giroDescubierto, si no que lo definimos al crear el objeto y es igual para cada objeto de la clase
     * @param nroCuenta
     * @param saldo
     * @param cliente
     */
    public CuentaCorriente(int nroCuenta, double saldo, Cliente cliente) {
        super(nroCuenta, saldo, cliente);
        this.giroDescubierto = 5000;
    }

    // Metodos
    /**
     * Deposito el chque teniendo en cuenta que su monto sea mayor a 0 recibo un cheque.
     * @param cheque
     */
    public void depositarCheque(Cheque cheque) {
        if (cheque.getMonto() <= 0) {
            System.out.println("El monto del cheque debe ser mayor a 0.");
            return;
        }
        setSaldo(getSaldo() + cheque.getMonto());
        System.out.println("Cheque depositado por " + cheque.getMonto() + ". Saldo actual: " + getSaldo());
    }

    @Override
    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Deposito realizado. El saldo actual es: " + getSaldo());
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    /**
     * Extraigo efectivo teniendo en cuenta el giroDescubierto de la cuenta corriente, lo unico que le paso es el monto a extaer
     */
    @Override
    public void extraerEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a extraer debe ser mayor a 0");
        } else if (getSaldo() + giroDescubierto < monto) {
            System.out.println("El saldo de la cuenta no permite realizar la extraccion.");
        } else {
            setSaldo(getSaldo() - monto);
            System.out.println("Extraccion realizada. El saldo actual es: " + getSaldo());
        }

    }
}
