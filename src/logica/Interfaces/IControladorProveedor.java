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
import logica.Clases.Proveedor;
import logica.Clases.Direccion;

/**
 *
 * @author Cristian
 */
public interface IControladorProveedor {

    public abstract void ingresarDatosProveedor(Proveedor datos);

    public abstract void confirmarAgregadoProveedor();

    public abstract void cancelarAgregadoProveedor();

    public abstract void ingresarDatosDireccion(Direccion datos);

    public abstract void cancelarAgregadoDireccion();

    public abstract void confirmarAgregadoDireccion();

    public abstract ArrayList<Proveedor> obtenerProveedores();

    public abstract void seleccionarProveedor(Proveedor proveedor);

    public abstract void eliminarProveedor(int idProveedor);

    public abstract void cancelarProceso();

    public abstract ArrayList<Direccion> obtenerDirecciones();

    public abstract void seleccionarDireccion(Direccion direccion);

    public abstract void eliminarDireccion(int idDireccion);

    public abstract ArrayList<Proveedor> obtenerProveedor();

    public abstract void modificarDatosProveedor(Proveedor idProveedor);

    public abstract void confirmarModificacion();

    public abstract void cancelarModificacion();

    public abstract ArrayList<Direccion> obtenerDireccion();

    public abstract void administradorModificaDireccion(Direccion idDireccion);

    public abstract void buscarPorNombre(String nombre);

    public abstract ArrayList<Proveedor> listarProveedores();

}
