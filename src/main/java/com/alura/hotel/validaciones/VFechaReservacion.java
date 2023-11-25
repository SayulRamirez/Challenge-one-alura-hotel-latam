package com.alura.hotel.validaciones;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

/**
 * {@link Class} para validar las fechas del los campos de la interfaz del usuario.
 */
public class VFechaReservacion {

    /**
     * Valida que no se llenen todos los campos del formulario
     * de lo contrario lanza un {@link RuntimeException}.
     * @param fFechaEntrada Fecha con formato {@link String}.
     * @param fFechaSalida Fecha con formato {@link String}.
     */
    public static void isNull(String fFechaEntrada, String fFechaSalida) {
        if (fFechaEntrada.isBlank() || fFechaSalida.isBlank()) {
            JOptionPane.showMessageDialog(null, "Seleccionar una fecha de entrada y de salida, por favor.");
            throw new RuntimeException("Fechas incorrectas");
        }
    }

    /**
     * Valida que las primer fecha sea mayor a la segunda fecha y que estas no sean menores
     * a la fecha actual de lo contrario lanza un {@link RuntimeException}.
     * @param fFechaEntrada Fecha con formato {@link String}.
     * @param fFechaSalida Fecha con formato {@link String}.
     */
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
