/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Clases.Articulo;
import logica.Clases.Linea;
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
        this.servicioLinea = new LineasServicio();
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

    public ArrayList<Venta> buscarVenta(String atributo, String datoBuscar, int id_venta) {
        return ventasServicio.buscarVenta(datoBuscar, atributo, id_venta);
    }

    public ArrayList<Linea> buscarLinea(String atributo, String datoBuscar, int id_venta) {
        return servicioLinea.buscarLinea(datoBuscar, atributo, id_venta);
    }

    public void eliminarArticulo(int sku) {

    }

    public ArrayList<Venta> obtenerVenta() {
        return ventasServicio.getVentas();  //HACER ESTO EN OBTENER ARTICULO
    }

    public boolean agregarVenta(Venta venta) {
        return ventasServicio.agregarVenta(venta);
    }

    public boolean agregarLineaVenta(Linea linea) {
        try {
            return servicioLinea.agregarLinea(linea);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

    public void modificarDatosVentas(Venta venta) {
        ventasServicio.modificaDatosVenta(venta);
    }

    public void modificarDatosLinea(Linea linea) {
        servicioLinea.modificaDatosLinea(linea);
    }

    public ArrayList<Linea> obtenerLineasVenta(int id_venta) {
        return servicioLinea.getLineasVenta(id_venta);
    }

}
