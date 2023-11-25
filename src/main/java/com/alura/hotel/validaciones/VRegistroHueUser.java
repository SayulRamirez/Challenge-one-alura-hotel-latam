package com.alura.hotel.validaciones;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

public class VRegistroHueUser {

    /**
     * Valida que los campos no esten en blanco, lanza un mensaje de error y un {@link RuntimeException}
     * si los campos van en blanco.
     * @param nombre {@link String}
     * @param apellido {@link String}
     * @param fecha {@link String} Nacimiento.
     * @param tel {@link String} Telefono.
     */
    public static void validarCampos(String nombre, String apellido, String fecha, String tel) {

        if (nombre.isBlank() || apellido.isBlank() || fecha.isBlank() || tel.isBlank()) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.");
            throw new RuntimeException("Campos en balnco");
        }
    }

    /**
     * Valida que la perdona sea mayor de edad. De lo contrario lanza un mensaje de error
     * y un {@link RuntimeException}.
     * @param nacimiento {@link String}
     */
    public static void isMayorDeEdad(String nacimiento) {
        LocalDate now = LocalDate.now();
        LocalDate dataIn = LocalDate.parse(nacimiento);

        if (Period.between(dataIn, now).getYears() < 18) {
            JOptionPane.showMessageDialog(null, "La persona debe de ser mayor de edad.");
            throw new RuntimeException("Menor de edad");
        }
    }

    /**
     * Valida que la cadena ingresada sean solo números, de lo contrario lanza un mensaje de
     * error y un {@link RuntimeException}.
     * @param cadena {@link String}
     */
    public static void esNumero(String cadena) {
        if (!cadena.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Solo números en el telefono");
            throw new RuntimeException("Telefono incorrecto");
        }
    }
}
