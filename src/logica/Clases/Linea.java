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
    private Proveedor proveedor;
    
    public Linea() {
    }
    
    public Linea(int idLinea ,float precioVenta, int cantidad, Articulo articulo, Proveedor proveedor) {
        this.idLinea = idLinea;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.proveedor = proveedor;
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
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
}
