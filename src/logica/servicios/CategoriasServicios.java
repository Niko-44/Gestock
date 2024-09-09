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
import logica.Clases.Categoria;

public class CategoriasServicios {

    public CategoriasServicios() {

    }
    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Categoria> getCategorias(){
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");

                Categoria categoria = new Categoria(idCategoria, nombre, descripcion);
                categorias.add(categoria);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorias;
    }

    public void modificaDatosCategoria(Categoria categoria) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `categoria` SET `nombre_categoria` = ?, `descripcion` = ? WHERE `categoria`.`id_categoria` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, categoria.getNombre());
            status.setObject(2, categoria.getDescripcion());
            status.setObject(3, categoria.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Categoria actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la categoria con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar La categoria: " + e.getMessage());
        }
    }
    
    public boolean eliminarCategoria(int idCategoria) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");

            status.setObject(1, idCategoria);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Categoría eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró la categoría con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoría: " + e.getMessage());
            return false;
        }
    }
}
