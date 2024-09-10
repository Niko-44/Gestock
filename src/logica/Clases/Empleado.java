/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private int cedula;
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private ROLEMPLEADO rol;

    public enum ROLEMPLEADO {
        admin,
        vendedor
    }

    // Constructor
    public Empleado(){
        
    }
    
    public Empleado(int id, String nombre, String apellido, int cedula, String nombreUsuario, String email, String contraseña, ROLEMPLEADO rol) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula=cedula;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
        this.rol = rol;
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public ROLEMPLEADO getRol() {
        return rol;
    }

    public void setRol(ROLEMPLEADO rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
