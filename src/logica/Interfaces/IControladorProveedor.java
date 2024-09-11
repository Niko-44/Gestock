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
import logica.Clases.Ingresa;

/**
 *
 * @author Cristian
 */
public interface IControladorProveedor {

    public abstract boolean agregarProveedor(Proveedor proveedor);

    public abstract void ingresarDatosDireccion(Direccion datos);

    public abstract void cancelarAgregadoDireccion();

    public abstract void confirmarAgregadoDireccion();

    public abstract boolean eliminarProveedor(int idProveedor);

    public abstract void seleccionarDireccion(Direccion direccion);

    public abstract boolean eliminarDireccion(int idDireccion);

    public abstract ArrayList<Proveedor> obtenerProveedor();

    public abstract void modificarDatosProveedor(Proveedor proveedor);

    public abstract void modificarDatosIngresa(Ingresa ingresa);

    public abstract void confirmarModificacion();

    public abstract void cancelarModificacion();

    public abstract ArrayList<Direccion> obtenerDireccion();

    public abstract void administradorModificaDireccion(Direccion direccion);

    public abstract void buscarPorNombre(String nombre);

    public abstract ArrayList<Proveedor> listarProveedores();

    public abstract boolean eliminarIngresa(int idIngresa);

    public abstract ArrayList<Ingresa> obtenerIngresa();

}
