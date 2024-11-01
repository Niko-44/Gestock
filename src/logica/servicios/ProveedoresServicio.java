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
import logica.Clases.Direccion;
import logica.Clases.Empleado;
import logica.Clases.Fabricante;
import logica.Clases.Ingresa;
import logica.Clases.Proveedor;

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

    public ArrayList<Proveedor> getProveedor() throws SQLException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM proveedor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Proveedor proveedor = new Proveedor(idProveedor, nombre, telefono, email, updateDate, createDate);
                proveedores.add(proveedor);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    public void modificaDatosproveedor(Proveedor proveedor) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `proveedor` SET `nombre_proveedor` = ?, `email` = ?, `telefono` = ?, `update_date` = ?, `create_date` = ? WHERE `proveedor`.`id_proveedor` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, proveedor.getNombre());
            status.setObject(2, proveedor.getEmail());
            status.setObject(3, proveedor.getTelefonos());
            status.setObject(4, proveedor.getUpdateDate());
            status.setObject(5, proveedor.getCreateDate());
            status.setObject(6, proveedor.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
               JOptionPane.showMessageDialog(null, "El proveedor se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El proveedor no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
        // Mostrar el error en una ventana de diálogo
        System.err.println("Error al actualizar el proveedor: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    public boolean agregarProveedor(Proveedor proveedor) throws Exception {
        try {

           

            PreparedStatement status = conexion.prepareStatement(
                    "INSERT INTO `proveedor` (`id_proveedor`, `nombre_proveedor`, `email`, `telefono`, `update_date`, `create_date`) VALUES (?, ?, ?, ?, ?, ?); ");
            status.setObject(1, null);
            status.setObject(2, proveedor.getNombre());
            status.setObject(3, proveedor.getEmail());
            status.setObject(4, proveedor.getTelefonos());
            status.setObject(5, proveedor.getUpdateDate());
            status.setObject(6, proveedor.getCreateDate());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException e) {
            
            System.err.println("Error al agregar el proveedor: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar el proveedor:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public ArrayList<Proveedor> buscarProveedor(String atributo, String dato) {

        ArrayList<Proveedor> proveedores = new ArrayList<>();

        if (atributo.equals("Nombre")) {
            atributo = "nombre_proveedor";
        }

        if (atributo.equals("Teléfono")) {
            atributo = "telefono";
        }
        
        if(atributo.equals("Correo"))
        {
            atributo = "email";
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM proveedor WHERE LOWER(proveedor." + atributo + ") like (LOWER('%" + dato + "%'));");
//            ps.setObject(1,atributo); //                    SELECT * FROM proveedor WHERE LOWER(proveedor.nombre_proveedor) like (LOWER('%distribuidora%'));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Proveedor proveedor = new Proveedor(idProveedor, nombre, telefono, email, updateDate, createDate);
                proveedores.add(proveedor);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;

    }


}
