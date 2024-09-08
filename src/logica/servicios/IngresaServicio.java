/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author n1c0l
 */
public class IngresaServicio {
      private Connection conexion = new ConexionDB().getConexion();
        
         public IngresaServicio() {
    }

    public boolean eliminarIngresa(int idIngresa) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM ingresa WHERE id_ingresa = ?");

            status.setObject(1, idIngresa);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Ingreso eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el ingreso con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ingreso: " + e.getMessage());
            return false;
        }
    }
}
