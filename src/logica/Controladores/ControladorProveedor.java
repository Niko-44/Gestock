/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

//import java.util.Map;
import java.util.ArrayList;
import logica.Clases.Direccion;
import logica.Clases.Proveedor;
import logica.Interfaces.IControladorProveedor;
import logica.servicios.DireccionesServicios;
import logica.servicios.ProveedoresServicio;

/**
 *
 * @author n1c0l
 */
public class ControladorProveedor implements IControladorProveedor {

    //private Map<String, Usuario> Usuarios;
    private ProveedoresServicio servicioProveedores;
    private DireccionesServicios servicioDirecciones;
    private static ControladorProveedor instancia;

    public ControladorProveedor() {
        this.servicioProveedores = new ProveedoresServicio();
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

    public ArrayList<Direccion> obtenerDirecciones() {

        ArrayList<Direccion> DtDireccion = null;
        return DtDireccion;

    }

    public void seleccionarDireccion(Direccion direccion) {

    }

    public boolean eliminarDireccion(int idDireccion) {
         return this.servicioDirecciones.eliminarDireccion(idDireccion);
    }

    public ArrayList<Proveedor> obtenerProveedor() {
        ArrayList<Proveedor> DtProveedor = null;
        return DtProveedor;
    }

    public void modificarDatosProveedor(Proveedor idProveedor) {

    }

    public void confirmarModificacion() {

    }

    public void cancelarModificacion() {

    }

    public ArrayList<Direccion> obtenerDireccion() {

        ArrayList<Direccion> DtDireccion = null;
        return DtDireccion;
    }

    public void administradorModificaDireccion(Direccion idDireccion) {

    }

    public void buscarPorNombre(String nombre) {

    }

    public ArrayList<Proveedor> listarProveedores() {

        ArrayList<Proveedor> DtProveedor = null;
        return DtProveedor;

    }
}
