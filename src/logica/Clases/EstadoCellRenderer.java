/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class EstadoCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String estado = value.toString(); // Obtén el valor de la columna "estado"

        if ("Completada".equals(estado)) {
            setBackground(Color.GREEN);
        } else if ("Pendiente".equals(estado)) {
            setBackground(Color.ORANGE);
        } else if ("Cancelada".equals(estado)) {
            setBackground(Color.RED);
        }

        return this;
    }
}


