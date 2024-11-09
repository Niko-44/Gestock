/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Clases.Empleado;
import logica.Clases.Fabricante;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author n1c0l
 */
public class EmpleadosServicios {

    public EmpleadosServicios() {

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

                byte[] fotoPerfil = rs.getBytes("foto");

                Empleado empleado = new Empleado(idEmpleado, nombre, apellido, cedula, nombreUsuario, email, contraseña, Empleado.ROLEMPLEADO.valueOf(rolEmpleado), fotoPerfil);
                empleados.add(empleado);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleados;
    }

    public void modificaDatosEmpleado(Empleado empleado, boolean mostrarDialogos) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `empleado` SET `nombre` = ?, `apellido` = ?, `cedula` = ?, `nombre_usuario` = ?, `email` = ?, `contraseña` = ?, `rol` = ?, `foto` = ?  WHERE `empleado`.`id_empleado` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, empleado.getNombre());
            status.setObject(2, empleado.getApellido());
            status.setObject(3, empleado.getCedula());
            status.setObject(4, empleado.getNombreUsuario());
            status.setObject(5, empleado.getEmail());
            status.setObject(6, empleado.getContraseña());
            status.setObject(7, empleado.getRol().toString());
            status.setObject(9, empleado.getId());

            if (empleado.getFotoPerfil() != null) {
                status.setBytes(8, empleado.getFotoPerfil());
            } else {
                status.setNull(8, java.sql.Types.BLOB); // Si no hay foto, se establece como NULL
            }

            int filasAfectadas = status.executeUpdate();

            if (mostrarDialogos) {
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "El empleado se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El empleado no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException e) {
            // Mostrar el error en una ventana de diálogo
            System.err.println("Error al actualizar el empleado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean eliminarEmpleado(int idEmpleado) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM empleado WHERE id_empleado = ?");

            status.setObject(1, idEmpleado);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Empleado eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el empleado con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
            return false;
        }
    }

    public boolean agregarEmpleado(Empleado empleado) throws Exception {
        try {

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `empleado` (`id_empleado`, `nombre`, `apellido`, `cedula`, `nombre_usuario`, `email`, `contraseña`, `rol`) VALUES (?, ?, ?, ?, ?, ?, ?, ?); ");
            status.setObject(1, null);
            status.setObject(2, empleado.getNombre());
            status.setObject(3, empleado.getApellido());
            status.setObject(4, empleado.getCedula());
            status.setObject(5, empleado.getNombreUsuario());
            status.setObject(6, empleado.getEmail());
            status.setObject(7, empleado.getContraseña());
            status.setObject(8, empleado.getRol().toString());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.err.println("Error al agregar el empleado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar el empleado:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public ArrayList<Empleado> BuscarEmpleado(String datoABuscar, String atributo) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        if (atributo == "Nombre Usuario") {
            atributo = "nombre_usuario";
        }
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleado where LOWER(" + atributo + ") like LOWER('%" + datoABuscar + "%');");
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

                byte[] fotoPerfil = rs.getBytes("foto");

                Empleado empleado = new Empleado(idEmpleado, nombre, apellido, cedula, nombreUsuario, email, contraseña, Empleado.ROLEMPLEADO.valueOf(rolEmpleado), fotoPerfil);
                empleados.add(empleado);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleados;
    }

    public String hashedPassword(String username) {
        String hashedPassword = null;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleado WHERE nombre_usuario = ?");

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                hashedPassword = rs.getString("contraseña");
                System.out.println("Hash recuperado para el usuario " + username + ": " + hashedPassword); // Verifica el valor del hash
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return hashedPassword;
    }

    public boolean validateCredential(String username, String password) {
        String storedHash = hashedPassword(username);

        if (storedHash == null || storedHash.isEmpty()) {
            System.out.println("No se encontró un hash válido para el usuario: " + username);
            return false;
        }

        try {
            boolean valid = BCrypt.checkpw(password, storedHash);
            return valid;
        } catch (IllegalArgumentException e) {
            System.err.println("Error de BCrypt: " + e.getMessage());
            return false;
        }
    }

    public void modificarPerfil(Empleado empleado) {
        String fotoCondicion = ", `foto` = ?";
        if (empleado.getFotoPerfil() == null) {
            fotoCondicion = "";
        }
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `empleado` SET `nombre` = ?, `apellido` = ?, `email` = ?" + fotoCondicion + "WHERE `empleado`.`nombre_usuario` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, empleado.getNombre());
            status.setObject(2, empleado.getApellido());

            status.setObject(3, empleado.getEmail());

            if (empleado.getFotoPerfil() != null) {
                status.setBytes(4, empleado.getFotoPerfil());
            }
            if (empleado.getFotoPerfil() == null) {
                status.setObject(4, empleado.getNombreUsuario());
            } else {
                status.setObject(5, empleado.getNombreUsuario());
            }
            int filasAfectadas = status.executeUpdate();

        } catch (SQLException e) {
            // Mostrar el error en una ventana de diálogo
            System.err.println("Error al actualizar el empleado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
