package com.alura.hotel.utils;

import javax.swing.*;
import java.awt.*;

public class Label {

    public static JLabel addLabel(String content, int x, int y, int width, int height) {
        JLabel label = new JLabel(content);
        label.setBounds(x, y, width, height);
        label.setForeground(SystemColor.textInactiveText);
        label.setFont(new Font("Roboto Black", Font.PLAIN, 19));

        return label;
    }

    public static JLabel addLogo(int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        Load.image(label, "/imagenes/Ha-100px.png");

        return label;
    }

    public static JLabel addLabelToPanel(String content, int width, int height) {
        JLabel label = new JLabel(content);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 0, width, height);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Roboto", Font.PLAIN, 18));

        return label;
    }

    public static JLabel addLabelExit(int width, int height) {
        JLabel label = new JLabel("X");
        label.setBounds(0, 0, width, height);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Roboto", Font.PLAIN, 18));

        return label;
    }
}
