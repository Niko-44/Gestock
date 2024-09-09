/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author n1c0l
 */
public class Direccion {

    private int id;
    private String calle;
    private int numeroPuerta;
    private String localidad;
    private String departamento;
    private int id_proveedor_fk;

    public Direccion() {
    }

    public Direccion(int id, String calle, int numeroPuerta, String localidad, String departamento, int id_proveedor_fk) {
        this.id = id;
        this.calle = calle;
        this.numeroPuerta = numeroPuerta;
        this.localidad = localidad;
        this.departamento = departamento;
        this.id_proveedor_fk = id_proveedor_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroPuerta() {
        return numeroPuerta;
    }

    public void setNumeroPuerta(int numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public int getId_proveedor_fk() {
        return id_proveedor_fk;
    }
    public void setId_proveedor_fk(int id_proveedor_fk) {
        this.id_proveedor_fk = id_proveedor_fk;
    }
}
