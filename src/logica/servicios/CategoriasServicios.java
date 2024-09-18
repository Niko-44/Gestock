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
import javax.swing.JOptionPane;
import logica.Clases.Articulo;
import logica.Clases.Categoria;

public class CategoriasServicios {

    public CategoriasServicios() {

    }
    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Categoria> getCategorias() {
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
                  JOptionPane.showMessageDialog(null, "La categoría se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La categoría no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
        // Mostrar el error en una ventana de diálogo
        System.err.println("Error al actualizar la categoria: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al actualizar la categoria:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public boolean agregarCategoria(Categoria categoria) throws Exception {
        try {

            

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`, `descripcion`) VALUES (?, ?, ?);");
            status.setObject(1, null);
            status.setObject(2, categoria.getNombre());
            status.setObject(3, categoria.getDescripcion());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.err.println("Error al agregar la categoria: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar la categoria:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    

    public ArrayList<Categoria> buscarCategoria(String nombre, String datoABuscar) {
          ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT id_categoria,nombre_categoria,descripcion from categoria Where CATEGORIA." + datoABuscar + " like '%" + nombre + "%';");
//            ps.setObject(1,atributo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int idCategoria = rs.getInt("id_categoria");
                String nombre_categoria = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");

                Categoria categoria = new Categoria(idCategoria, nombre_categoria, descripcion);
                categorias.add(categoria);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorias;
    }
}
