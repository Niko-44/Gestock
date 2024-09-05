/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import logica.Clases.DtProveedor;
import logica.Clases.DtDireccion;

/**
 *
 * @author Cristian
 */
public interface IControladorProveedor {

    public abstract void ingresarDatosProveedor(DtProveedor datos);

    public abstract void confirmarAgregadoProveedor();

    public abstract void cancelarAgregadoProveedor();

    public abstract void ingresarDatosDireccion(DtDireccion datos);

    public abstract void cancelarAgregadoDireccion();

    public abstract void confirmarAgregadoDireccion();

    public abstract ArrayList<DtProveedor> obtenerProveedores();

    public abstract void seleccionarProveedor(DtProveedor proveedor);

    public abstract void eliminarProveedor(int idProveedor);

    public abstract void cancelarProceso();

    public abstract ArrayList<DtDireccion> obtenerDirecciones();

    public abstract void seleccionarDireccion(DtDireccion direccion);

    public abstract void eliminarDireccion(int idDireccion);

    public abstract ArrayList<DtProveedor> obtenerProveedor();

    public abstract void modificarDatosProveedor(DtProveedor idProveedor);

    public abstract void confirmarModificacion();

    public abstract void cancelarModificacion();

    public abstract ArrayList<DtDireccion> obtenerDireccion();

    public abstract void administradorModificaDireccion(DtDireccion idDireccion);

    public abstract void buscarPorNombre(String nombre);

    public abstract ArrayList<DtProveedor> listarProveedores();

}
