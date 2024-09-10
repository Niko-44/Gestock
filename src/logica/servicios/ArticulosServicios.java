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
import logica.Clases.Articulo;
import logica.Clases.Categoria;

public class ArticulosServicios {

    private Connection conexion = new ConexionDB().getConexion();

    public void modificaDatosArticulo(Articulo articulo) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `articulo` SET `sku` = ?, `nombre` = ?, `descripcion` = ?, `stock` = ?, `precio` = ?, `peso` = ?, `update_date` = ?, `create_date` = ?, `id_categoria_fk`= ? WHERE `articulo`.`id_articulo` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, articulo.getSku());
            status.setObject(2, articulo.getNombre());
            status.setObject(3, articulo.getDescripcion());
            status.setObject(4, articulo.getStock());
            status.setObject(5, articulo.getPrecio());
            status.setObject(6, articulo.getPeso());
            status.setObject(7, articulo.getUpdateDate());
            status.setObject(8, articulo.getCreateDate());
            status.setObject(9, articulo.getCategoria().getId());
            status.setObject(10, articulo.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Articulo actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el articulo con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Articulo: " + e.getMessage());
        }
    }



    public ArrayList<Articulo> getArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT ARTICULO.*, CATEGORIA.nombre_categoria FROM ARTICULO JOIN CATEGORIA ON ARTICULO.id_categoria_fk = CATEGORIA.id_categoria;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria_fk"));
                categoria.setNombre(rs.getString("nombre_categoria"));
                
                int idArticulo = rs.getInt("id_articulo");
                int sku = rs.getInt("sku");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                float precio = rs.getFloat("precio");
                float peso = rs.getFloat("peso");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Articulo articulo = new Articulo(idArticulo, sku, nombre, descripcion, stock, precio, peso, updateDate, createDate, categoria);
                articulos.add(articulo);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
    
        public boolean eliminarArticulo(int idArticulo) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM articulo WHERE id_articulo = ?");

            status.setObject(1, idArticulo);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Artículo eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el artículo con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el artículo: " + e.getMessage());
            return false;
        }
    }
}
