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
        Pendiente,
        Cancelada,
        Completada
    }
    
    private int id;
    private Date fechaVenta;
    private EstadoVenta estado;
    private int id_empleado;

    public Venta() {
        
    }
    
    public Venta(int id, Date fechaVenta, EstadoVenta estado, int id_empleado) {
        this.id = id; 
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.id_empleado = id_empleado;
    }
    

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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
