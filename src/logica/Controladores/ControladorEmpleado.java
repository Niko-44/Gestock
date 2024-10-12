/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Clases.Empleado;
import logica.Interfaces.IControladorEmpleado;
import logica.servicios.EmpleadosServicios;

public class ControladorEmpleado implements IControladorEmpleado {

    private EmpleadosServicios servicioEmpleado;

    private static ControladorEmpleado instancia;

    public static ControladorEmpleado getInstance() {
        if (instancia == null) {
            instancia = new ControladorEmpleado();
        }
        return instancia;
    }

    private ControladorEmpleado() {
        this.servicioEmpleado = new EmpleadosServicios();
    }

    public Empleado iniciarSesion(String nombreUsuario, String contraseña) {

        return null;

    }

    public void modificaDatosEmpleado(Empleado empleado, boolean mostrarDialogos) {
        servicioEmpleado.modificaDatosEmpleado(empleado, mostrarDialogos);
    }

    public ArrayList<Empleado> listarEmpleadoPorBusqueda(String busqueda) {

        return null;

    }

    public ArrayList<Empleado> listarEmpleado() {

        return null;

    }

    public boolean agregarEmpleado(Empleado empleado) {
        try {
            return servicioEmpleado.agregarEmpleado(empleado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Empleado> obtenerEmpleado() {

        ArrayList<Empleado> Empleados = null;
        try {
            Empleados = servicioEmpleado.getEmpleado();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Empleados;

    }

    public void seleccionarEmpleado(Empleado empleado) {

    }

    public boolean eliminarEmpleado(int idEmpleado) {
        return this.servicioEmpleado.eliminarEmpleado(idEmpleado);
    }

    public void cancelarProceso() {

    }

    public void confirmarModificacion() {

    }

    public void cancelarModificacion() {

    }

    public ArrayList<Empleado> buscarEmpleado(String datoBuscar, String atributo) {
        return servicioEmpleado.BuscarEmpleado(datoBuscar, atributo);
    }

    public boolean validateCredential(String username, String password) {
        return servicioEmpleado.validateCredential(username, password);
    }

}
