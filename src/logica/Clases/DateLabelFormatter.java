/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
/**
 *
 * @author Cristian
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
    private static final long serialVersionUID = 1L;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parse(text); // Convierte el texto en un objeto Date
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value instanceof Calendar) {
            // Si el valor es una instancia de Calendar, obtenemos la fecha correspondiente
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime()); // Convertimos la fecha en texto
        } else if (value instanceof Date) {
            return dateFormatter.format((Date) value); // Si es Date, lo convertimos directamente a texto
        }
        return "";
    }
}
