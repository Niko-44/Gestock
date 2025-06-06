/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.Clases.Articulo;
import logica.Clases.Linea;
import logica.Clases.Venta;

/**
 *
 * @author n1c0l
 */
public interface IControladorVenta {
    public abstract ArrayList<Articulo> obtenerArticulos();

    public abstract Venta getUltimaVenta();
    
    public abstract void confirmarCompra();
    
    public abstract List<Object[]> getMasVendido();

    public abstract void agregarArticuloCarrito();

    public abstract ArrayList<Venta> buscarVenta(String atributo, String datoBuscar, int id_venta);
    public abstract ArrayList<Linea> buscarLinea(String atributo, String datoBuscar, int id_venta);

    public abstract void eliminarArticulo(int sku);

    public abstract ArrayList<Venta> obtenerVenta();
    
    public abstract boolean agregarVenta(Venta venta);
    public abstract boolean agregarLineaVenta(Linea linea);

    public abstract void listarVentas(int numeroVenta);
    
    public abstract void seleccionarVenta(Venta venta);
    
    public abstract void confirmarModificacion();
    
    public abstract void cancelarModificacion();
    
    public abstract boolean eliminarVenta(int idVenta);
    
    public abstract boolean eliminarLineaVenta(int idVenta);
    
    public abstract void cancelarProceso();
    
    public abstract void modificarDatosVentas(Venta venta);
    public abstract void modificarDatosLinea(Linea linea);
    
    public abstract ArrayList<Linea> obtenerLineasVenta(int id_venta);
}
