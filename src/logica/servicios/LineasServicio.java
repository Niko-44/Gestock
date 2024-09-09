/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LineasServicio {

    public LineasServicio() {
    }

    private Connection conexion = new ConexionDB().getConexion();

    public boolean eliminarLineaVenta(int idLineaVenta) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM linea WHERE id_linea = ?");

            status.setObject(1, idLineaVenta);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Linea de venta eliminada exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró la linea de venta con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la linea de venta: " + e.getMessage());
            return false;
        }
    }
}
