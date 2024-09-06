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

    private float precioVenta;
    private int cantidad;
    
    public Linea() {
    }
    
    public Linea(float precioVenta, int cantidad) {
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
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
    
    
}
