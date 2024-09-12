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
import logica.Clases.Articulo;
import logica.Clases.Linea;

public class LineasServicio {

    public LineasServicio() {
    }

    private Connection conexion = new ConexionDB().getConexion();

    public boolean eliminarLineaVenta(int idLineaVenta) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM linea WHERE id_linea = ?");

            status.setObject(1, idLineaVenta);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Linea de venta eliminada exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró la linea de venta con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la linea de venta: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Linea> getLineasVenta(int id_venta) {
        ArrayList<Linea> resultado = new ArrayList<Linea>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT L.id_linea, A.nombre, L.cantidad_vendida, L.precio_venta\n"
                    + "FROM linea AS L\n"
                    + "INNER JOIN articulo AS A ON L.id_articulo_fk = A.id_articulo\n"
                    + "INNER JOIN venta AS V ON L.id_venta_fk = V.id_venta\n"
                    + "WHERE V.id_venta = ?;");
            
            status.setObject(1, id_venta);
            
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                
                Articulo articulo = new Articulo();
                articulo.setNombre(rs.getString("nombre"));
                
                Linea linea = new Linea();

                linea.setCantidad(rs.getInt("cantidad_vendida"));
                linea.setPrecioVenta(rs.getInt("precio_venta"));
                linea.setArticulo(articulo);
                linea.setIdLinea(rs.getInt("id_linea"));
                
                
                resultado.add(linea);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
}
