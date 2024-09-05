/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author Cristian
 */
import java.util.ArrayList;
import java.util.Date;

public class DtProveedor {

    private int id;
    private String nombre;
    private ArrayList<String> telefonos;
    private String email;
    private Date updateDate;
    private Date createDate;

    public DtProveedor() {
    }

    public DtProveedor(int id, String nombre, ArrayList<String> telefonos, String email, Date updateDate, Date createDate) {
        this.id = id;
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.email = email;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public String getEmail() {
        return email;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
