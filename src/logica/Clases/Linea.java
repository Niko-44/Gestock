/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author n1c0l
 */
public class Linea {

    private int idLinea;
    private float precioVenta;
    private int cantidad;
    private Articulo articulo;
    private Venta venta;
    
    public Linea() {
    }
    
    public Linea(int idLinea , int cantidad, float precioVenta, Articulo articulo, Venta venta) {
        this.idLinea = idLinea;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.articulo = articulo;
        this.venta = venta;
    }

    public int getIdLinea() {
        return idLinea;
    }
    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public Articulo getArticulo() {
        return articulo;
    }
    public Venta getVenta() {
        return venta;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
}
