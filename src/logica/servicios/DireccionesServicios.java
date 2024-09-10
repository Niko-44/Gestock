/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import logica.Clases.Direccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Clases.Empleado;
import logica.Clases.Proveedor;

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


    public ArrayList<Direccion> getDirecciones() throws SQLException {
        ArrayList<Direccion> direcciones = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT DIRECCION.*, PROVEEDOR.nombre_proveedor  FROM direccion JOIN PROVEEDOR ON id_proveedor_fk = PROVEEDOR.id_proveedor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id_proveedor_fk"));
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                
                int idDireccion = rs.getInt("id_direccion");
                String calle = rs.getString("calle");
                int nuemroPuerta = rs.getInt("numero_direccion");
                String localidad = rs.getString("localidad");
                String departamento = rs.getString("departamento");
                

                Direccion direccion = new Direccion(idDireccion, calle, nuemroPuerta, localidad, departamento, proveedor);
                direcciones.add(direccion);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return direcciones;
    }
    
    
      public void administradorModificaDireccion(Direccion direccion) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `direccion` SET `calle` = ?, `num_direccion` = ?, `departamento` = ?, `localidad` = ? `id_proveedor` = ? WHERE `direccion`.`id_direccion` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, direccion.getCalle());
            status.setObject(2, direccion.getNumeroPuerta());
            status.setObject(3, direccion.getDepartamento());
            status.setObject(4, direccion.getLocalidad());
            status.setObject(5, 1);
            status.setObject(6, direccion.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Direccion actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la Direccion con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la direccion: " + e.getMessage());
        }
    }
}
