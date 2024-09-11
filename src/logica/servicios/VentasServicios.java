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
import logica.Clases.Empleado;
import logica.Clases.Venta;


public class VentasServicios {

    public VentasServicios() {
    }

    private Connection conexion = new ConexionDB().getConexion();
    
    public ArrayList<Venta> getVentas() {
        ArrayList<Venta> resultado = new ArrayList<Venta>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT VENTA.*, EMPLEADO.nombre AS nombre_empleado, EMPLEADO.id_empleado FROM VENTA JOIN EMPLEADO ON VENTA.id_empleado_fk = EMPLEADO.id_empleado;");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                
                int id = rs.getInt("id_venta");
                Date fecha_venta = rs.getDate("fecha_venta");
                String estado = rs.getString("estado");
                
                Venta venta = new Venta(id, fecha_venta, Venta.EstadoVenta.valueOf(estado), empleado);
                resultado.add(venta);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    
    
      public void modificaDatosVenta(Venta venta) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `venta` SET `fecha_venta` = ?, `estado` = ?, `id_empleado_fk` = ? WHERE `venta`.`id_venta` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, venta.getFechaVenta());
            status.setObject(2, venta.getEstado().toString());
            status.setObject(3, venta.getEmpleado().getId());
            status.setObject(4, venta.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Venta actualizada exitosamente.");
            } else {
                System.out.println("No se encontró La venta con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la venta: " + e.getMessage());
        }
    }

    
    public boolean agregarVenta(Venta venta)
    {
        try {   
            
            PreparedStatement status = conexion.prepareStatement("INSERT INTO `venta` (`id_venta`, `fecha_venta`, `estado`, `id_empleado_fk`) VALUES (?, ?, ?, ?)");
            status.setObject(1, null);
            status.setObject(2, venta.getFechaVenta());
            status.setObject(3, venta.getEstado().name());
            status.setObject(4, venta.getEmpleado().getId());
            
            
            int rs = status.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
        public boolean eliminarVenta(int idVenta) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM venta WHERE id_venta = ?");

            status.setObject(1, idVenta);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Venta eliminada exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró la venta con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la venta: " + e.getMessage());
            return false;
        }
    }
}
