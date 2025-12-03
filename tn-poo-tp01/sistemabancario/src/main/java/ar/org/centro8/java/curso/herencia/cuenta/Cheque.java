package ar.org.centro8.java.curso.herencia.cuenta;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cheque {
    private double monto;
    private String bancoEmisor;
    private LocalDate fechaPago;

}