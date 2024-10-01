/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Empleado empleado;
    private String total;

    public Venta() {
        
    }
    
    public Venta(int id, Date fechaVenta, EstadoVenta estado, Empleado empleado) {
        this.id = id; 
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.empleado = empleado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
    // Método para obtener la fecha en el formato deseado
    public String getFechaFormateada() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fechaVenta);
    }

    // Método para establecer la fecha desde una cadena en formato específico
    public void setFechaDesdeCadena(String fechaCadena) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.fechaVenta = formateador.parse(fechaCadena);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    
}
