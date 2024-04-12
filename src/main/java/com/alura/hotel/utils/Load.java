package com.alura.hotel.utils;

import com.alura.hotel.view.MainMenu;

import javax.swing.*;
import java.util.Objects;

public class Load {

    public static void image(JLabel label, String location) {
        try {
            label.setIcon(new ImageIcon(Objects.requireNonNull(MainMenu.class.getResource(location))));
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null,"No se pudo encontrar la imagen en la ruta: " + "/imagenes/menu-img.png");
            throw new RuntimeException(e.getMessage());
        }
    }
}
