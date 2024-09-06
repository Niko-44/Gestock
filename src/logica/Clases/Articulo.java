/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.util.Date;


public class Articulo {

    private int id;
    private String descripcion;
    private String nombre;
    private int stock;
    private float precio;
    private int sku;
    private Date createDate;
    private Date updateDate;
    private float peso;

    public Articulo(int id, String descripcion, String nombre, int stock, float precio, int sku, Date createDate, Date updateDate, float peso) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.sku = sku;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.peso = peso;
    }
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public float getPrecio() {
        return precio;
    }

    public int getSku() {
        return sku;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public float getPeso() {
        return peso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
