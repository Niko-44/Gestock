/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.sql.SQLException;
//import java.util.Map;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import logica.Clases.Direccion;
import logica.Clases.Ingresa;
import logica.Clases.Proveedor;
import logica.Interfaces.IControladorProveedor;
import logica.servicios.DireccionesServicios;
import logica.servicios.IngresaServicio;
import logica.servicios.ProveedoresServicio;

/**
 *
 * @author n1c0l
 */
public class ControladorProveedor implements IControladorProveedor {

    private ProveedoresServicio servicioProveedores;
    private DireccionesServicios servicioDirecciones;
    private IngresaServicio servicioIngresa;
    private static ControladorProveedor instancia;

    private ControladorProveedor() {
        this.servicioProveedores = new ProveedoresServicio();
        this.servicioDirecciones = new DireccionesServicios();
        this.servicioIngresa = new IngresaServicio();
    }

    public static ControladorProveedor getInstance() {
        if (instancia == null) {
            instancia = new ControladorProveedor();
        }
        return instancia;
    }

    public boolean agregarProveedor(Proveedor proveedor) {
        try {
            return servicioProveedores.agregarProveedor(proveedor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarDireccion(Direccion direccion) {
        try {
            return servicioDirecciones.agregarDireccion(direccion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarIngreso(Ingresa ingresa) {
        try {
            return servicioIngresa.agregarIngreso(ingresa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminarProveedor(int idProveedor) {
        return this.servicioProveedores.eliminarProveedor(idProveedor);
    }

    public void seleccionarDireccion(Direccion direccion) {

    }

    public boolean eliminarDireccion(int idDireccion) {
        return this.servicioDirecciones.eliminarDireccion(idDireccion);
    }

    public ArrayList<Proveedor> obtenerProveedor() {

        ArrayList<Proveedor> proveedores = null;
        try {
            proveedores = servicioProveedores.getProveedor();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }

    public ArrayList<Ingresa> obtenerIngresa() {

        ArrayList<Ingresa> ingresa = null;
        try {

            ingresa = servicioIngresa.getIngresa();

        } catch (Exception e) {
            throw e;
        }
        return ingresa;
    }

    public void modificarDatosIngresa(Ingresa ingresa) {
        servicioIngresa.modificaDatosIngresa(ingresa);
    }

    public void modificarDatosProveedor(Proveedor proveedor) {
        servicioProveedores.modificaDatosproveedor(proveedor);
    }

    public void confirmarModificacion() {

    }

    public void cancelarModificacion() {

    }

    public ArrayList<Direccion> obtenerDireccion() {

        ArrayList<Direccion> direcciones = null;
        try {
            direcciones = servicioDirecciones.getDirecciones();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return direcciones;
    }

    public void administradorModificaDireccion(Direccion direccion) {
        servicioDirecciones.administradorModificaDireccion(direccion);
    }

    public void buscarPorNombre(String nombre) {

    }

    public ArrayList<Proveedor> listarProveedores() {

        ArrayList<Proveedor> DtProveedor = null;
        return DtProveedor;

    }

    public boolean eliminarIngresa(int idIngresa) {
        return this.servicioIngresa.eliminarIngresa(idIngresa);
    }
    
    public ArrayList<Ingresa> obtenerIngresosMercaderia(){
        
        return servicioIngresa.getIngresa();
    }
    
    public ArrayList<Proveedor> buscarProveedor(String nombre, String dato)
    {
        return servicioProveedores.buscarProveedor(nombre, dato);
    }

    public ArrayList<Direccion> buscarDireccion(String nombre, String dato)
    {
        return servicioDirecciones.buscarDireccion(nombre, dato);        
    }

    public ArrayList<Ingresa> buscarIngresa(String nombre, String dato)
    {
        return servicioIngresa.buscarIngresa(nombre, dato);    
    }
}
