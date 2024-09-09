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
import logica.Clases.Empleado;
import logica.Clases.Fabricante;

/**
 *
 * @author n1c0l
 */
public class EmpleadosServicios {
    
    public EmpleadosServicios(){
        
    }
    
    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Empleado> getEmpleado() throws SQLException {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleado");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                int idEmpleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cedula = rs.getInt("cedula");
                String nombreUsuario = rs.getString("nombre_usuario");
                String email = rs.getString("email");
                String contraseña = rs.getString("contraseña");
                String rolEmpleado = rs.getString("rol");

                Empleado empleado = new Empleado(idEmpleado,nombre,apellido,cedula,nombreUsuario,email,contraseña,Empleado.ROLEMPLEADO.valueOf(rolEmpleado));
                empleados.add(empleado);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleados;
    }
    
     public void modificaDatosEmpleado(Empleado empleado) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `empleado` SET `nombre` = ?, `apellido` = ?, `cedula` = ?, `nombre_usuario` = ?, `email` = ?, `contraseña` = ?, `rol` = ? WHERE `empleado`.`id_empleado` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, empleado.getNombre());
            status.setObject(2, empleado.getApellido());
            status.setObject(3, empleado.getCedula());
            status.setObject(4, empleado.getNombreUsuario());
            status.setObject(5, empleado.getEmail());
            status.setObject(6, empleado.getContraseña());
            status.setObject(7, empleado.getRol());
            status.setObject(8, empleado.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Empleado actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el Empleado con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Empleado: " + e.getMessage());
        }
    }
}
