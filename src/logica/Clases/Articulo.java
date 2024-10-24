/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Articulo {

    private int id;
    private long sku;
    private String nombre;
    private String descripcion;
    private int stock;
    private float precio;
    private float peso;
    private Date createDate;
    private Date updateDate;
    private Categoria categoria;
    private Fabricante fabricante;
    private Proveedor proveedor;

    private byte[] fotoProducto; // Campo para la imagen de perfil

    public Articulo() {
    }

    public Articulo(int id, long sku, String nombre, String descripcion, int stock, float precio, float peso, Date createDate, Date updateDate, Categoria categoria, byte[] fotoProducto) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.peso = peso;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.categoria = categoria;
        
        this.fotoProducto = fotoProducto; // Asignar el campo
    }

    public byte[] getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(byte[] fotoProducto) {
        this.fotoProducto = fotoProducto;
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

    public long getSku() {
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

    public void setSku(long sku) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getFechaUpdateFormateada() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(updateDate);
    }

    public String getFechaCreadaFormateada() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(createDate);
    }

}
