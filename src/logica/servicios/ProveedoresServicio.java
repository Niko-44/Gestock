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
}
