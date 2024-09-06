/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.util.Date;

/**
 *
 * @author n1c0l
 */
public class Venta {
    public enum EstadoVenta {
        PENDIENTE,
        CANCELADO,
        ENTREGADO
    }
    
    private int id;
    private Date fechaVenta;

    public Venta() {
        
    }

    public Venta(int id, Date fechaVenta) {
        this.id = id; 
        this.fechaVenta = fechaVenta;
    }

    public int getId() {
        return id;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
}
