/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import logica.Clases.Articulo;
import logica.Clases.Ingresa;
import logica.Clases.Proveedor;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author n1c0l
 */
public class IngresaServicio {
    private Connection conexion = new ConexionDB().getConexion();

    public IngresaServicio() {
    }

    public ArrayList<Ingresa> getIngresa() {
        ArrayList<Ingresa> resultado = new ArrayList<>();
        try {
            String query = "SELECT A.nombre AS nombre_articulo, A.sku, I.cantidad, I.lote, I.precio_compra, I.fecha_ingreso, P.nombre_proveedor, I.id_ingresa " +
                           "FROM INGRESA I " +
                           "JOIN ARTICULO A ON I.id_articulo_fk = A.id_articulo " +
                           "JOIN PROVEEDOR P ON I.id_proveedor_fk = P.id_proveedor";
            
            PreparedStatement status = conexion.prepareStatement(query);
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setNombre(rs.getString("nombre_articulo"));
                articulo.setSku(rs.getInt("sku"));
                
                Proveedor proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                
                Ingresa ingresa = new Ingresa(
                    rs.getInt("id_ingresa"),
                    rs.getDate("fecha_ingreso"),
                    rs.getInt("cantidad"),
                    rs.getInt("lote"),
                    rs.getFloat("precio_compra"),
                    proveedor,
                    articulo
                );
                
                resultado.add(ingresa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean eliminarIngresa(int idIngresa) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM ingresa WHERE id_ingresa = ?");

            status.setObject(1, idIngresa);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Ingreso eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el ingreso con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ingreso: " + e.getMessage());
            return false;
        }
    }
}
