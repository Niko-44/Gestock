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

import logica.Clases.Direccion;
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
    }

    public static ControladorProveedor getInstance() {
        if (instancia == null) {
            instancia = new ControladorProveedor();
        }
        return instancia;
    }

    public void ingresarDatosProveedor(Proveedor datos) {
        
    }

    public void confirmarAgregadoProveedor() {

    }

    public void cancelarAgregadoProveedor() {

    }

    public void ingresarDatosDireccion(Direccion datos) {

    }

    public void cancelarAgregadoDireccion() {
    }

    public void confirmarAgregadoDireccion() {

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

    public void modificarDatosProveedor(Proveedor idProveedor) {

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

    public void administradorModificaDireccion(Direccion idDireccion) {

    }

    public void buscarPorNombre(String nombre) {

    }

    public ArrayList<Proveedor> listarProveedores() {

        ArrayList<Proveedor> DtProveedor = null;
        return DtProveedor;

    }
    
    public boolean eliminarIngresa(int idIngresa)
    {
        return this.servicioIngresa.eliminarIngresa(idIngresa);
    }
}
