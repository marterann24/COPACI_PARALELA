/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author WorkStation
 */
class ColorCellRenderer extends DefaultTableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Color)
        {
            Color color = (Color) value;
            setBackground(color); // Fondo con el color
            setText(""); // Opcional: oculta texto, solo muestra color
            setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para visibilidad
        } else
        {
            setBackground(table.getBackground());
            setText(value != null ? value.toString() : "");
        }
        return c;
    }
}
