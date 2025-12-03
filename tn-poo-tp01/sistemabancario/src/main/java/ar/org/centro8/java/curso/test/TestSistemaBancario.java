package ar.org.centro8.java.curso.test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.herencia.cliente.ClienteEmpresa;
import ar.org.centro8.java.curso.herencia.cliente.ClienteIndividual;
import ar.org.centro8.java.curso.herencia.cuenta.CajaDeAhorro;
import ar.org.centro8.java.curso.herencia.cuenta.Cheque;
import ar.org.centro8.java.curso.herencia.cuenta.CuentaConvertibilidad;
import ar.org.centro8.java.curso.herencia.cuenta.CuentaCorriente;

public class TestSistemaBancario {
    public static void main(String[] args) {

        // Cliente individual 1 y 2
        System.out.println("\n** Test Cliente Indivudial **");
        ClienteIndividual cliente1 = new ClienteIndividual(001, "Mario Cecilio", "Arce", "4390289");
        System.out.println(cliente1);

        ClienteIndividual cliente2 = new ClienteIndividual(002, "Leonardo Guillermo", "Mattioli", "13501692");
        System.out.println(cliente2);

        // Cliente Empresa 3 y 4
        System.out.println("\n** Test Cliente Empresa **");
        ClienteEmpresa cliente3 = new ClienteEmpresa(003, "Tropitango Bailable", "20336682410");
        System.out.println(cliente3);

        ClienteEmpresa cliente4 = new ClienteEmpresa(004, "Bus Bailable", "27336682411");
        System.out.println(cliente4);

        // Cheques 1, 2 y 3
        System.out.println("\n** Test Cheque **");
        Cheque cheque1 = new Cheque(1500, "Santander Rio", LocalDate.of(2026, 4, 21));
        System.out.println(cheque1);

        System.out.println("\n** Test Cheque **"); // Debe dar error porque esta en 0
        Cheque cheque2 = new Cheque(0, "Santander Rio", LocalDate.of(2026, 3, 20));
        System.out.println(cheque2);

        System.out.println("\n** Test Cheque **");
        Cheque cheque3 = new Cheque(3500, "Banco Comafi", LocalDate.of(2026, 2, 7));
        System.out.println(cheque3);

        // Caja de Ahorro 1
        System.out.println("\n** Test caja de ahorro **");
        CajaDeAhorro cuenta1 = new CajaDeAhorro(001, 0, cliente1);
        System.out.println(cuenta1);

        System.out.println("\n** Test depositarEfectivo**");
        cuenta1.depositarEfectivo(150000);
        System.out.println(cuenta1.getSaldo());

        System.out.println("\n**Test de extraerEfectivo***");
        cuenta1.extraerEfectivo(50000);
        System.out.println(cuenta1.getSaldo());

        System.out.println("\n**Test de extraerEfectivo excede***"); // Esto debe indicar que no se puede extraer el
                                                                     // monto porque supera al saldo
        cuenta1.extraerEfectivo(250000);
        System.out.println(cuenta1.getSaldo());

        System.out.println("\n**Test de cobrarIntereses**");
        cuenta1.cobrarInteres();
        System.out.println(cuenta1.getSaldo());

        // CUENTA CORRIENTE (ACA ME DI CUENTA QUE DEBIERA HABER INDICADO EL SALDO EN 0
        // PARA LA CA Y LA CC PARA NO TENER QUE PASAR EL 0)
        System.out.println("\n** Test cuenta corriente");
        CuentaCorriente cuenta2 = new CuentaCorriente(002, 0, cliente2);
        System.out.println(cuenta2);

        System.out.println("\n** Test depositarEfectivo **");
        cuenta2.depositarEfectivo(5000);
        System.out.println(cuenta2.getSaldo());

        System.out.println("\n**Test de extraerEfectivo **");
        cuenta2.extraerEfectivo(5000); // Saldo queda en 0
        System.out.println(cuenta2.getSaldo());

        System.out.println("\n**Test de extraerEfectivo giroDescubierto **");
        cuenta2.extraerEfectivo(3000); // El saldo quedaba en 0 pero usa el descubierto
        System.out.println(cuenta2.getSaldo());

        System.out.println("\n**Test de extraerEfectivo giroDescubierto excede **");
        cuenta2.extraerEfectivo(7000); // Aca debiera indicar que no se puede realizar la extraccion porque excede el
                                       // saldo incluyendo el descubierto
        System.out.println(cuenta2.getSaldo());

        System.out.println("\n** Test depositarCheque **");
        cuenta2.depositarCheque(cheque1);
        ;
        System.out.println(cuenta2.getSaldo());

        System.out.println("\n** Test depositarCheque con error **"); // Esto debe fallar porque el cheque tiene monto 0
        cuenta2.depositarCheque(cheque2);
        ;
        System.out.println(cuenta2.getSaldo());

        // CUENTA CONVERTIBILIDAD
        System.out.println("\n** Test cuenta Convertibilidad");
        CuentaConvertibilidad cuenta3 = new CuentaConvertibilidad(003, 0, cliente3, 0);
        System.out.println(cuenta3);

        // aca ya lo hice en clase, deposito efectivo
        System.out.println("\n** Test cuenta depositar efectivo");
        cuenta3.depositarEfectivo(5000);
        System.out.println(cuenta3.getSaldo());

        // aca ya lo hice en clase, deposito dolares
        System.out.println("\n** Test cuenta depositar dolares");
        cuenta3.depositarDolares(500);
        System.out.println(cuenta3.getSaldoDolares());

        System.out.println("\n** Test cuenta convertir pesos a dolares y viceversa");
        cuenta3.convertirPesoADolar(100_000, 0.1); // si esto funciona debiera dar 10_000, saldo dolar queda en 10_500
        System.out.println(cuenta3.getSaldoDolares());
        
        cuenta3.convertirDolarAPeso(500, 10); // si esto funciona debiera dar 5_000, saldo pesos queda en 5_500
        System.out.println(cuenta3.getSaldo());

        System.out.println("\n** Test depositarCheque **");
        cuenta3.depositarCheque(cheque3);
        System.out.println(cuenta3.getSaldo());
        
        System.out.println("\n** Test cuenta extraer dolares");
        cuenta3.extraerDolares(500); // debiera dar error porque no tiene saldo en dolares
        System.out.println(cuenta3.getSaldoDolares());

        // CUENTA CONVERTIBILIDAD CON EL CAMBIO DE ULTIMO MOMENTO
        System.out.println("\n** Test cuenta Convertibilidad cliente Individual");
        CuentaConvertibilidad cuenta4 = new CuentaConvertibilidad(004, 0, cliente1, 0);
        System.out.println(cuenta4);

    }
}