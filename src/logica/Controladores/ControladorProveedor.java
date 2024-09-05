/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

//import java.util.Map;
import java.util.ArrayList;
import logica.Clases.DtDireccion;
import logica.Clases.DtProveedor;
import logica.Interfaces.IControladorProveedor;
import logica.servicios.ProveedoresServicio;

/**
 *
 * @author n1c0l
 */
public class ControladorProveedor implements IControladorProveedor {

    //private Map<String, Usuario> Usuarios;
    private ProveedoresServicio servicioProveedores;
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

    public void ingresarDatosProveedor(DtProveedor datos) {

    }

    public void confirmarAgregadoProveedor() {

    }

    public void cancelarAgregadoProveedor() {

    }

    public void ingresarDatosDireccion(DtDireccion datos) {

    }

    public void cancelarAgregadoDireccion() {
    }

    public void confirmarAgregadoDireccion() {

    }

    public ArrayList<DtProveedor> obtenerProveedores() {

        ArrayList<DtProveedor> DtProveedor = null;
        return DtProveedor;

    }

    public void seleccionarProveedor(DtProveedor proveedor) {

    }

    public void eliminarProveedor(int idProveedor) {

    }

    public void cancelarProceso() {

    }

    public ArrayList<DtDireccion> obtenerDirecciones() {

        ArrayList<DtDireccion> DtDireccion = null;
        return DtDireccion;

    }

    public void seleccionarDireccion(DtDireccion direccion) {

    }

    public void eliminarDireccion(int idDireccion) {

    }

    public ArrayList<DtProveedor> obtenerProveedor() {
        ArrayList<DtProveedor> DtProveedor = null;
        return DtProveedor;
    }

    public void modificarDatosProveedor(DtProveedor idProveedor) {

    }

    public void confirmarModificacion() {

    }

    public void cancelarModificacion() {

    }

    public ArrayList<DtDireccion> obtenerDireccion() {

        ArrayList<DtDireccion> DtDireccion = null;
        return DtDireccion;
    }

    public void administradorModificaDireccion(DtDireccion idDireccion) {

    }

    public void buscarPorNombre(String nombre) {

    }

    public ArrayList<DtProveedor> listarProveedores() {

        ArrayList<DtProveedor> DtProveedor = null;
        return DtProveedor;

    }
}
