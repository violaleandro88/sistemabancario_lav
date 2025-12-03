package ar.org.centro8.java.curso.herencia.cuenta;

import ar.org.centro8.java.curso.herencia.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CajaDeAhorro extends Cuenta {
    private double tasaInteres;

    // Constructor
    /**
     * El constructor no pide la tasa, si no que la definimos al crear el objeto y es igual para cada objeto de la clase
     * @param nroCuenta
     * @param saldo
     * @param cliente
     */
    public CajaDeAhorro(int nroCuenta, double saldo, Cliente cliente) {
        super(nroCuenta, saldo, cliente);
        this.tasaInteres = 0.50; // Defino la tasa por defecto
    }

    // Metodos
    @Override
    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            System.out.println("Deposito realizado. El saldo actual es: " + getSaldo());
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    @Override
    public void extraerEfectivo(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a extraer debe ser mayor a 0");
        } else if (getSaldo() < monto) {
            System.out.println("No hay saldo suficiente");
        } else {
            setSaldo(getSaldo() - monto);
            System.out.println("Extraccion realizada. El saldo actual es: " + getSaldo());
        }
    }

    /**
     * El metodo no espera un parametro, se calcula solo sobre el saldo de la cuenta y con la tasaInteres definida
     */
    public void cobrarInteres() {
        double interesGanado = (getSaldo() * (tasaInteres / 100) / 12);
        setSaldo(getSaldo() + (Math.round(interesGanado * 100) / 100));
        System.out.println("Intereses Cobrados. El saldo actual es: " + getSaldo());
        }

}
