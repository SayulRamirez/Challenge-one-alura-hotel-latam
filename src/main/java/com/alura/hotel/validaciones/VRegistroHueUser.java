package com.alura.hotel.validaciones;

public class VRegistroHueUser {

    public static boolean validarCampos(String nombre, String apellido, String fecha, String tel) {
        if(nombre.isBlank() || apellido.isBlank() || fecha.isBlank() || tel.isBlank()) {
            return true;
        } else {
            return false;
        }
    }
}
