/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ingresa {
    private int idIngresa;
    private Date fechaIngreso;
    private int cantidad;
    private int lote;
    private float precioCompra;
    private Proveedor proveedor ;
    private Articulo articulo ;

    public Ingresa() {
    }

    public Ingresa(int idIngresa, Date fechaIngreso, int cantidad, int lote, float precioCompra, Proveedor proveedor, Articulo articulo) { 
        this.idIngresa = idIngresa;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.lote = lote;
        this.precioCompra = precioCompra;
        this.proveedor = proveedor;
        this.articulo = articulo;

    }

    public int getIdIngresa() {
        return idIngresa;
    }
    public void setIdIngresa(int idIngresa) {
        this.idIngresa = idIngresa;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    // Método para obtener la fecha en el formato deseado
    public String getFechaFormateada() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(fechaIngreso);
    }
    // Método para establecer la fecha desde una cadena en formato específico
    public void setFechaDesdeCadena(String fechaCadena) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fechaIngreso = formateador.parse(fechaCadena);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


