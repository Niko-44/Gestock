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
import javax.swing.JOptionPane;
import logica.Clases.Categoria;
import logica.Clases.Fabricante;

public class FabricantesServicios {

    public FabricantesServicios() {

    }

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Fabricante> getFabricante() {
        ArrayList<Fabricante> fabricantes = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM fabricante LIMIT 6");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFabricante = rs.getInt("id_fabricante");
                String nombre = rs.getString("nombre_fabricante");
                String correro = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Fabricante fabricante = new Fabricante(idFabricante, nombre, telefono, correro, updateDate, createDate);
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
                JOptionPane.showMessageDialog(null, "El fabricante se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El fabricante no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
        // Mostrar el error en una ventana de diálogo
        System.err.println("Error al actualizar el fabricante: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al actualizar el fabricante:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public boolean agregarFabricante(Fabricante fabricante) throws Exception {
        try {

           

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `fabricante` (`id_fabricante`, `nombre_fabricante`, `telefono`, `email`, `update_date`, `create_date`) VALUES (?, ?, ?, ?, ?, ?);");
            status.setObject(1, null);
            status.setObject(2, fabricante.getNombre());
            status.setObject(3, fabricante.getTelefono());
            status.setObject(4, fabricante.getCorreo());
            status.setObject(5, fabricante.getUpdateDate());
            status.setObject(6, fabricante.getCreateDate());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Error al agregar el fabricante: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar el fabricante:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

   

    public ArrayList<Fabricante> buscarFabricante(String nombre, String datoABuscar) {
        ArrayList<Fabricante> fabricantes = new ArrayList<>();
        
       if (nombre.equals("Nombre")) {
            nombre = "nombre_fabricante";
        }

        if (nombre.equals("Teléfono") || nombre.equals("Telefono") ) {
            nombre = "telefono";
        }
        
        if(nombre.equals("Email"))
        {
            nombre = "email";
        }
        
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * from fabricante Where LOWER(FABRICANTE." + nombre + ") like LOWER('%" + datoABuscar + "%');");
//            ps.setObject(1,atributo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idFabricante = rs.getInt("id_fabricante");
                String nombre_fabricante = rs.getString("nombre_fabricante");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                Date update_date = rs.getDate("update_date");
                Date create_date = rs.getDate("create_date");

                Fabricante fabricante = new Fabricante(idFabricante, nombre_fabricante, telefono, email, update_date, create_date);
                fabricantes.add(fabricante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fabricantes;
    }
}
