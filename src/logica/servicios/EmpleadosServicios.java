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
                String nombreUsuario = rs.getString("nombre_usuario");
                String contraseña = rs.getString("contraseña");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cedula = rs.getInt("cedula");
                String rolEmpleado = rs.getString("rol");

                Empleado empleado = new Empleado(idEmpleado, nombreUsuario, contraseña, nombre, apellido, cedula, Empleado.ROLEMPLEADO.valueOf(rolEmpleado));
                empleados.add(empleado);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleados;
    }
}
