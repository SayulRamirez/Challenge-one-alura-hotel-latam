package com.alura.hotel.utils;

import javax.swing.*;
import java.awt.*;

public class Panel {

    public static JPanel addPanel(String content, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(12, 138, 199));
        panel.setBounds(x, y, width, height);
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(Label.addLabelToPanel(content, width, height));

        return panel;
    }
}
