/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Clases.Venta;


public class VentasServicios {

    public VentasServicios() {
    }

    private Connection conexion = new ConexionDB().getConexion();
    
    public ArrayList<Venta> getVentas() {
        ArrayList<Venta> resultado = new ArrayList<Venta>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM venta");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.add(new Venta(rs.getInt("id_venta"), rs.getDate("fecha_venta")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
}
