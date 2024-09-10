/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Fabricante;

public class FabricantesServicios {

    public FabricantesServicios() {

    }

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Fabricante> getFabricante() {
        ArrayList<Fabricante> fabricantes = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM fabricante");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFabricante = rs.getInt("id_fabricante");
                String nombre = rs.getString("nombre_fabricante");
                String correro = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Fabricante fabricante = new Fabricante(idFabricante, nombre, correro, telefono, updateDate, createDate);
                fabricantes.add(fabricante);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fabricantes;
    }

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

    public boolean eliminarFabricante(int idFabricante) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM fabricante WHERE id_fabricante = ?");

            status.setObject(1, idFabricante);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Fabricante eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el fabricante con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el fabricante: " + e.getMessage());
            return false;
        }
    }
}
