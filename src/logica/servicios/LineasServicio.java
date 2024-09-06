/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;

/**
 *
 * @author n1c0l
 */
public class LineasServicio {

    public LineasServicio() {
    }
    
    private Connection conexion = new ConexionDB().getConexion();
}
