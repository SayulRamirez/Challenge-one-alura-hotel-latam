package com.alura.hotel.utils;

import javax.swing.*;
import java.awt.*;

public class Separator {

    public static JSeparator addSeparator(int x, int y, int width, int height) {
        JSeparator separator = new JSeparator();
        separator.setBounds(x, y, width, height);
        separator.setForeground(new Color(12, 138, 199));
        separator.setBackground(new Color(12, 138, 199));

        return separator;
    }
}
