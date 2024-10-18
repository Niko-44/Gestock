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
import logica.Clases.Articulo;
import logica.Clases.Empleado;
import logica.Clases.Linea;
import logica.Clases.Venta;

public class VentasServicios {

    public VentasServicios() {
    }

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Venta> getVentas() {
        ArrayList<Venta> resultado = new ArrayList<Venta>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT VENTA.*, E.nombre AS nombre_empleado, E.apellido, E.nombre_usuario, E.id_empleado,(SELECT FORMAT(SUM(L.cantidad_vendida * L.precio_venta), 2) FROM LINEA AS L WHERE L.id_venta_fk = VENTA.id_venta ) AS total_venta FROM VENTA JOIN EMPLEADO AS E ON VENTA.id_empleado_fk = E.id_empleado Order by fecha_venta desc;");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                empleado.setNombreUsuario(rs.getString("nombre_usuario"));
                empleado.setApellido(rs.getString("apellido"));

                int id = rs.getInt("id_venta");
                Date fecha_venta = rs.getDate("fecha_venta");
                String estado = rs.getString("estado");

                Venta venta = new Venta(id, fecha_venta, Venta.EstadoVenta.valueOf(estado), empleado);
                venta.setTotal(rs.getString("total_venta"));
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

    public boolean agregarVenta(Venta venta) {
        try {

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `venta` (`id_venta`, `fecha_venta`, `estado`, `id_empleado_fk`) VALUES (?, ?, ?, ?)");
            status.setObject(1, null);
            status.setObject(2, venta.getFechaVenta());
            status.setObject(3, venta.getEstado().name());
            status.setObject(4, venta.getEmpleado().getId());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la venta:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return false;
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
    
        public ArrayList<Venta> buscarVenta(String datoABuscar, String atributo, int id_venta) {
        ArrayList<Venta> ventas = new ArrayList<>();

        try {

            if (atributo.equals("Fecha")) {
                atributo = "fecha_venta";
            }

            if (atributo.equals("ID")) {
                atributo = "id_venta";
            }

            String sql = "SELECT VENTA.*, Empleado.nombre AS nombre_empleado, Empleado.apellido, Empleado.nombre_usuario, Empleado.id_empleado,(SELECT FORMAT(SUM(L.cantidad_vendida * L.precio_venta), 2) FROM LINEA AS L WHERE L.id_venta_fk = VENTA.id_venta ) AS total_venta FROM `venta` INNER JOIN empleado On empleado.id_empleado = venta.id_empleado_fk WHERE LOWER(venta." + atributo + ") like LOWER('%" + datoABuscar + "%') order by fecha_venta desc";
            if (atributo.equals("Empleado")) {

                sql = "SELECT VENTA.*, E.nombre AS nombre_empleado, E.apellido, E.nombre_usuario, E.id_empleado,(SELECT FORMAT(SUM(L.cantidad_vendida * L.precio_venta), 2) FROM LINEA AS L WHERE L.id_venta_fk = VENTA.id_venta ) AS total_venta FROM `venta` INNER JOIN empleado as E On E.id_empleado = venta.id_empleado_fk WHERE LOWER(CONCAT(E.id_empleado, ' ', E.nombre, ' ', E.apellido, ' ', E.nombre_usuario)) like LOWER('%" + datoABuscar + "%')order by fecha_venta desc";
            }
   PreparedStatement ps = conexion.prepareStatement(sql);
   
  ResultSet rs = ps.executeQuery();
  
    while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                empleado.setNombreUsuario(rs.getString("nombre_usuario"));
                empleado.setApellido(rs.getString("apellido"));
                
                 int id = rs.getInt("id_venta");
                Date fecha_venta = rs.getDate("fecha_venta");
                String estado = rs.getString("estado");
                
                 Venta venta = new Venta(id, fecha_venta, Venta.EstadoVenta.valueOf(estado), empleado);
                venta.setTotal(rs.getString("total_venta"));
                ventas.add(venta);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
             }
        return ventas;
         }

    public Venta getUltimaVenta() {
        Venta venta = null;
        try {
            PreparedStatement status = conexion.prepareStatement(
                    "SELECT VENTA.*, E.nombre AS nombre_empleado, E.apellido, E.nombre_usuario, E.id_empleado, "
                    + "(SELECT FORMAT(SUM(L.cantidad_vendida * L.precio_venta), 2) FROM LINEA AS L WHERE L.id_venta_fk = VENTA.id_venta ) AS total_venta "
                    + "FROM VENTA "
                    + "JOIN EMPLEADO AS E ON VENTA.id_empleado_fk = E.id_empleado "
                    + "ORDER BY VENTA.id_venta DESC LIMIT 1;"
            );
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                empleado.setNombreUsuario(rs.getString("nombre_usuario"));
                empleado.setApellido(rs.getString("apellido"));

                int id = rs.getInt("id_venta");
                Date fecha_venta = rs.getDate("fecha_venta");
                String estado = rs.getString("estado");

                venta = new Venta(id, fecha_venta, Venta.EstadoVenta.valueOf(estado), empleado);
                venta.setTotal(rs.getString("total_venta"));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return venta;
    }

}
