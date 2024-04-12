package com.alura.hotel.utils;

import com.alura.hotel.view.MainMenu;
import com.alura.hotel.view.RegistroHuesped;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.Objects;

public class Load {

    public static void image(JLabel label, String location) {
        try {
            label.setIcon(new ImageIcon(Objects.requireNonNull(MainMenu.class.getResource(location))));
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null,"No se pudo encontrar la imagen en la ruta: " + location);
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void image(JDateChooser field, String location) {
        try {
            field.getCalendarButton().setIcon(new ImageIcon(Objects.requireNonNull(RegistroHuesped.class.getResource(location))));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,"No se pudo encontrar la imagen en la ruta: " + location);
            throw new RuntimeException(e.getMessage());
        }
    }
}
