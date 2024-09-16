/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Articulo;
import logica.Clases.Linea;
import logica.Clases.Venta;

/**
 *
 * @author n1c0l
 */
public interface IControladorVenta {
    public abstract ArrayList<Articulo> obtenerArticulos();

    public abstract void confirmarCompra();

    public abstract void agregarArticuloCarrito();

    public abstract ArrayList<Venta> buscarVenta(String atributo, String datoBuscar);
    public abstract ArrayList<Linea> buscarLinea(String atributo, String datoBuscar, int id_venta);

    public abstract void eliminarArticulo(int sku);

    public abstract ArrayList<Venta> obtenerVenta();
    
    public abstract boolean agregarVenta(Venta venta);

    public abstract void listarVentas(int numeroVenta);
    
    public abstract void seleccionarVenta(Venta venta);
    
    public abstract void confirmarModificacion();
    
    public abstract void cancelarModificacion();
    
    public abstract boolean eliminarVenta(int idVenta);
    
    public abstract boolean eliminarLineaVenta(int idVenta);
    
    public abstract void cancelarProceso();
    
    public abstract void modificarDatosVentas(Venta venta);
    
    public abstract ArrayList<Linea> obtenerLineasVenta(int id_venta);
}
