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
            PreparedStatement status = conexion.prepareStatement("UPDATE `direccion` SET `calle` = ?, `numero_direccion` = ?, `departamento` = ?, `localidad` = ?, `id_proveedor_fk` = ? WHERE `direccion`.`id_direccion` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, direccion.getCalle());
            status.setObject(2, direccion.getNumeroPuerta());
            status.setObject(3, direccion.getDepartamento());
            status.setObject(4, direccion.getLocalidad());
            status.setObject(5, direccion.getProveedor().getId());
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

    public boolean agregarDireccion(Direccion direccion) throws Exception {
        try {

            if (verificarExistencia(direccion)) {
                throw new Exception("Ya existe el proveedor con la direccion y localidad ingresada");
            }

            PreparedStatement status = conexion.prepareStatement(
                    "INSERT INTO `direccion` (`id_direccion`, `calle`, `numero_direccion`, `departamento`, `localidad`, `id_proveedor_fk`) VALUES (?, ?, ?, ?, ?, ?); ");
            status.setObject(1, null);
            status.setObject(2, direccion.getCalle());
            status.setObject(3, direccion.getNumeroPuerta());
            status.setObject(4, direccion.getDepartamento());
            status.setObject(5, direccion.getLocalidad());
            status.setObject(6, direccion.getProveedor().getId());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    private boolean verificarExistencia(Direccion direccion) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM `direccion`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id_proveedor = rs.getInt("id_proveedor_fk");
                String departamento = rs.getString("departamento");
                String localidad = rs.getString("localidad");

                if (direccion.getDepartamento().trim().equals(departamento) && direccion.getLocalidad().trim().equals(localidad) && direccion.getProveedor().getId() == id_proveedor) {
                    return true;
                }

            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
