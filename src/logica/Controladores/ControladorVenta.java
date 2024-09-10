/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.util.ArrayList;
import logica.Clases.Articulo;
import logica.Clases.Venta;
import logica.Interfaces.IControladorVenta;
import logica.servicios.LineasServicio;
import logica.servicios.VentasServicios;

/**
 *
 * @author n1c0l
 */
public class ControladorVenta implements IControladorVenta {

    private VentasServicios ventasServicio;
    private LineasServicio servicioLinea;
    private static ControladorVenta instancia;

    private ControladorVenta() {
        this.ventasServicio = new VentasServicios();
    }

    public static ControladorVenta getInstance() {
        if (instancia == null) {
            instancia = new ControladorVenta();
        }

        return instancia;
    }

    public ArrayList<Articulo> obtenerArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>(); //LLAMAR AL SERVICIO DE ARTICULO PARA OBTENER
        return articulos;
    }

    public void confirmarCompra() {

    }

    public void agregarArticuloCarrito() {

    }

    public void buscar(String atributo, String datoBuscar) {

    }

    public void eliminarArticulo(int sku) {

    }

    public ArrayList<Venta> obtenerVenta() {
        return ventasServicio.getVentas();  //HACER ESTO EN OBTENER ARTICULO
    }

    public boolean agregarVenta(Venta venta) {
        return ventasServicio.agregarVenta(venta);
    }

    public void listarVentas(int numeroVenta) {

    }

    public void seleccionarVenta(Venta venta) {

    }

    public void confirmarModificacion() {

    }

    public void cancelarModificacion() {

    }

    public boolean eliminarVenta(int idVenta) {
        return this.ventasServicio.eliminarVenta(idVenta);
    }

    public boolean eliminarLineaVenta(int idLineaVenta) {
        return this.servicioLinea.eliminarLineaVenta(idLineaVenta);
    }

    public void cancelarProceso() {

    }

    public void modificarDatosVentas(Venta venta) 
    {
        ventasServicio.modificaDatosVenta(venta);
    }

}
