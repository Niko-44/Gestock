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
public class DireccionesServicios {
        private Connection conexion = new ConexionDB().getConexion();
        
         public DireccionesServicios() {
    }

    public boolean eliminarDireccion(int idDireccion) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM direccion WHERE id_direccion = ?");

            status.setObject(1, idDireccion);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Direccion eliminada exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró la dirección con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la direccion: " + e.getMessage());
            return false;
        }
    }
    
}
