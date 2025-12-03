package ar.org.centro8.java.curso.herencia.cuenta;

import ar.org.centro8.java.curso.herencia.cliente.Cliente;
import ar.org.centro8.java.curso.herencia.cliente.ClienteEmpresa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {
    private double saldoDolares;

    // Constructor
    /**
     * Al implmentar el setCliente no lo mandamos definido sino que lo pasamos en null
     * @param nroCuenta
     * @param saldo
     * @param cliente // lo paso en null
     * @param saldoDolares
     */
    public CuentaConvertibilidad(int nroCuenta, double saldo, Cliente cliente, double saldoDolares) {
        super(nroCuenta, saldo, null); // lo paso en null
        this.saldoDolares = saldoDolares;
        setCliente(cliente); // valido el setCliente que tengo a continuacion
    }

    /**
     * Con esta validacion corroboro que la cuentaConvertibilidad siempre se le asigne
     * un clienteEmpresa y no otra cosa
     */
    @Override
    public void setCliente(Cliente clienteEmpresa) {
        if (clienteEmpresa instanceof ClienteEmpresa) {
            super.setCliente(clienteEmpresa);
        } else {
            System.out.println("No se puede asignar un cliente que no sea cuenta empresa");
        }
    }

    // Metodos convertibilidad
    // Convertir pesos a dolares
    /**
     * Con este metodo, el montoPesos es un monto independiente deñ
     * saldo y ese montoPesos se convierte y si se deposita en el saldoDolares.
     * 
     * @param montoPesos     monto que no se obtiene del saldo de la cuenta, pero si
     *                       impacta en el saldoDolares.
     * @param tasaConversion
     */
    public void convertirPesoADolar(double montoPesos, double tasaConversion) {
        if (montoPesos <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }
        double dolares = montoPesos / tasaConversion;
        saldoDolares += dolares;
        System.out.println("Conversion y deposito realizadas. Usted deposito: " + montoPesos + " ARS y recibira "
                + dolares + " USD.");
    }

    // Convertir dolares a pesos
    /**
     * Con este metodo, el montoDolares es un monto independiente deñ
     * saldoDolares y ese montoDolares se convierte y si se deposita en el saldo.
     * 
     * @param montoDolares   monto que no se obtiene del saldoDolares de la cuenta,
     *                       pero si impacta en el saldo
     * @param tasaConversion
     */
    public void convertirDolarAPeso(double montoDolares, double tasaConversion) {
        if (montoDolares <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }
        double pesos = montoDolares * tasaConversion;
        setSaldo(getSaldo() + pesos);
        System.out.println("Conversion y deposito realizadas. Usted deposito:  " + montoDolares + " USD y recibira "
                + pesos + " ARS.");
    }

    // Metodos para dolares
    public void depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolares += monto;
            System.out.println("Deposito en dolares realizado. El saldo en dolares actual es: " + getSaldo());
        } else {
            System.out.println("El monto en dolares a depositar debe ser mayor a 0");
        }
    }

    public void extraerDolares(double monto) {
        if (monto <= 0) {
            System.out.println("El monto en dolares a extraer debe ser mayor a 0");
        } else if (monto > saldoDolares) {
            System.out.println("No hay saldo suficiente en dolares");
        } else {
            saldoDolares -= monto;
            System.out.println("Extraccion realizada. El saldo en dolares actual es: " + saldoDolares);
        }
    }

    // Metodos para pesos
    /**
     * Deposito el chque teniendo en cuenta que su monto sea mayor a 0 recibo un
     * cheque.
     * 
     * @param cheque
     */
    public void depositarCheque(Cheque cheque) {
        if (cheque.getMonto() <= 0) {
            System.out.println("El monto del cheque debe ser mayor a 0.");
            return; // esto inicialmente era para la validacion del localdate que descarte y adapte
                    // el codigo, el return (aca explico que hace). Al solo validar el monto, puedo
                    // hacer como en el depositar efectivo (por ejemplo).
        }
        setSaldo(getSaldo() + cheque.getMonto());
        System.out.println("Cheque depositado por " + cheque.getMonto() + ". Saldo actual: " + getSaldo());
    }
}