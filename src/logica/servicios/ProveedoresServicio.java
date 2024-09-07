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
 * @author Vignolo
 */
public class ProveedoresServicio {

    private Connection conexion = new ConexionDB().getConexion();

    public ProveedoresServicio() {
    }

    public boolean eliminarProveedor(int idProveedor) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM proveedor WHERE id_proveedor = ?");

            status.setObject(1, idProveedor);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Proveedor eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el proveedor con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
            return false;
        }
    }
}
