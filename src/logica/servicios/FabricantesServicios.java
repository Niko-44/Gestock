/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Clases.Fabricante;

public class FabricantesServicios {

    private Connection conexion = new ConexionDB().getConexion();

    public void modificaDatosFabricante(Fabricante fabricante) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `fabricante` SET `nombre_fabricante` = ?, `telefono` = ?, `email` = ?, `update_date` = ?, `create_date` = ? WHERE `fabricante`.`id_fabricante` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, fabricante.getNombre());
            status.setObject(2, fabricante.getTelefono());
            status.setObject(3, fabricante.getCorreo());
            status.setObject(4, fabricante.getUpdateDate());
            status.setObject(5, fabricante.getCreateDate());
            status.setObject(6, fabricante.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Fabricante actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el fabricante con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el fabricante: " + e.getMessage());
        }
    }
}

