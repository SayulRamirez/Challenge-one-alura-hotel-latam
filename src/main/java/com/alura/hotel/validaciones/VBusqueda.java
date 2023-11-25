package com.alura.hotel.validaciones;

import javax.swing.*;

public class VBusqueda {

    /**
     * Valida que se haya seleccionado algun campo de la tabla.
     * Si no lo esta lanza un mensaje de error y una {@link RuntimeException}.
     * @param table {@link JTable}
     */
    public static void tieneFilaElegida(JTable table) {
        if (table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0){
            JOptionPane.showMessageDialog(null, "Por favor, elije un item");
            throw new RuntimeException("No hay item elejido");
        }
    }
}
