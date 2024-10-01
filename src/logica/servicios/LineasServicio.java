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
import logica.Clases.Venta;

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
    
      public void modificaDatosLinea(Linea linea) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `linea` SET `cantidad_vendida` = ?, `precio_venta` = ?, `id_articulo_fk` = ? WHERE `linea`.`id_linea` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, linea.getCantidad());
            status.setObject(2, linea.getPrecioVenta());
            status.setObject(3, linea.getArticulo().getId());
            status.setObject(4, linea.getIdLinea());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Linea actualizada exitosamente.");
            } else {
                System.out.println("No se encontró La Linea con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Linea: " + e.getMessage());
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
                linea.setPrecioVenta(rs.getFloat("precio_venta"));
                linea.setArticulo(articulo);
                linea.setIdLinea(rs.getInt("id_linea"));
               

                resultado.add(linea);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }

    public ArrayList<Linea> buscarLinea(String datoABuscar, String atributo, int id_venta) {
        ArrayList<Linea> lineas = new ArrayList<>();
        String sql;

        try {

            switch (atributo) {
                case "Precio":
                    atributo = "precio_venta";
                    sql = "SELECT * FROM linea JOIN articulo ON linea.id_articulo_fk = articulo.id_articulo WHERE linea." + atributo + " LIKE '%" + datoABuscar + "%' and linea.id_venta_fk = " + id_venta;
                    break;

                case "Cantidad":
                    atributo = "cantidad_vendida";
                    sql = "SELECT * FROM linea JOIN articulo ON linea.id_articulo_fk = articulo.id_articulo WHERE linea." + atributo + "=" + datoABuscar + " and linea.id_venta_fk = " + id_venta;
                    break;

                case "Articulo":
                    sql = "SELECT * FROM linea JOIN articulo ON linea.id_articulo_fk = articulo.id_articulo WHERE articulo.nombre" + " LIKE '%" + datoABuscar + "%'" + " and linea.id_venta_fk = " + id_venta;
                    break;

                default:
                    sql = "SELECT * FROM linea JOIN articulo ON linea.id_articulo_fk = articulo.id_articulo WHERE linea." + atributo + " LIKE '%" + datoABuscar + "%'" + " and linea.id_venta_fk = " + id_venta;
            }

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Articulo articulo = new Articulo();
                articulo.setId(rs.getInt("id_articulo_fk"));
                articulo.setNombre(rs.getString("nombre"));

                int idLinea = rs.getInt("id_linea");
                int cantidad = rs.getInt("cantidad_vendida");
                float precio_venta = rs.getFloat("precio_venta");

                Linea linea = new Linea();
                linea.setIdLinea(idLinea);
                linea.setCantidad(cantidad);
                linea.setPrecioVenta(precio_venta);
                linea.setArticulo(articulo);

                lineas.add(linea);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lineas;
    }
}
