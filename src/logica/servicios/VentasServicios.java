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
import java.util.Date;
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
                
                int id = rs.getInt("id_venta");
                Date fecha_venta = rs.getDate("fecha_venta");
                String estado = rs.getString("estado");
                int id_empleado = rs.getInt("id_empleado_fk");
                
                Venta venta = new Venta(id, fecha_venta, Venta.EstadoVenta.valueOf(estado), id_empleado);
                resultado.add(venta);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    
    public boolean agregarVenta(Venta venta)
    {
        try {
            System.out.println(venta.getId_empleado());
            
            PreparedStatement status = conexion.prepareStatement("INSERT INTO `venta` (`id_venta`, `fecha_venta`, `estado`, `id_empleado_fk`) VALUES (?, ?, ?, ?)");
            status.setObject(1, 0);
            status.setObject(2, venta.getFechaVenta());
            status.setObject(3, venta.getEstado().name());
            status.setObject(4, venta.getId_empleado());
            
            
            int rs = status.executeUpdate();
            
            return true;
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
