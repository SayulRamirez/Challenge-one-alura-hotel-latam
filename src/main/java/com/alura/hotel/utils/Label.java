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
}
