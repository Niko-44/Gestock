/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author n1c0l
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Proveedor {

    private int id;
    private String nombre;
    private String telefonos;
    private String email;
    private Date updateDate;
    private Date createDate;

    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String telefonos, String email, Date updateDate, Date createDate) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
