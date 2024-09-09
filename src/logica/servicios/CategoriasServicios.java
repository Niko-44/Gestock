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

    public ArrayList<Categoria> getCategorias() throws SQLException {
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre");
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
}
