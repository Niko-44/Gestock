/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import logica.Clases.Empleado;
import java.util.ArrayList;

public interface IControladorEmpleado {

    
    public abstract Empleado iniciarSesion(String nombreUsuario, String contraseña);
    public abstract void modificaDatosEmpleado(Empleado empleado);
    public abstract ArrayList<Empleado> listarEmpleadoPorBusqueda(String busqueda);
    public abstract ArrayList<Empleado> listarEmpleado();
    
    public abstract boolean agregarEmpleado(Empleado empleado);
    
    public abstract ArrayList<Empleado> obtenerEmpleado();
    public abstract void seleccionarEmpleado(Empleado empleado);
    public abstract boolean eliminarEmpleado(int idEmpleado);
    public abstract void cancelarProceso();
    public abstract void confirmarModificacion();
    public abstract void cancelarModificacion();
    public abstract ArrayList<Empleado> buscarEmpleado(String datoBuscar, String atributo);
    public abstract boolean validateCredential(String username, String password);
}