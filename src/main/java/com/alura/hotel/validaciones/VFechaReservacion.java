package com.alura.hotel.validaciones;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

public class VFechaReservacion {
    public static void isNull(String fFechaEntrada, String fFechaSalida) {
        if (fFechaEntrada.isBlank() || fFechaEntrada.isBlank()) {
            JOptionPane.showMessageDialog(null, "Seleccionar una fecha de entrada y de salida, por favor.");
            throw new RuntimeException("Fechas incorrectas");
        }
    }

    public static void validarFechas(String fFechaEntrada, String fFechaSalida) {
        LocalDate entrada = LocalDate.parse(fFechaEntrada);
        LocalDate salida = LocalDate.parse(fFechaSalida);
        LocalDate now = LocalDate.now();

        if (Period.between(entrada, salida).getDays() < 1 || now.isAfter(entrada) || now.isAfter(salida)){
            JOptionPane.showMessageDialog(null, "La fecha de entrada debe de ser inferior a la de salida");
            throw new RuntimeException("Entrada < Salida");
        }
    }
}
