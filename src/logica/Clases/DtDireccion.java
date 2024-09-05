/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author Cristian
 */
public class DtDireccion {
    
    private int id;
    private String calle;
    private int numeroPuerta;
    private String localidad;
    private int departamento;

    public DtDireccion() {
    }

    public DtDireccion(int id, String calle, int numeroPuerta, String localidad, int departamento) {
        this.id = id;
        this.calle = calle;
        this.numeroPuerta = numeroPuerta;
        this.localidad = localidad;
        this.departamento = departamento;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumeroPuerta() {
        return numeroPuerta;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getDepartamento() {
        return departamento;
    }
}

