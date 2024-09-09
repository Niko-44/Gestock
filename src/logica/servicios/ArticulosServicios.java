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

public class ArticulosServicios {

    public ArticulosServicios() {

    }

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Articulo> getArticulos() throws SQLException {
        ArrayList<Articulo> articulos = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               int idArticulo = rs.getInt("id_articulo");
                int sku = rs.getInt("sku");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                float precio = rs.getFloat("precio");
                float peso = rs.getFloat("peso");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");
//            int idCategoriaFk = rs.getInt("id_categoria_fk");

                Articulo articulo = new Articulo(idArticulo, descripcion, nombre, stock, precio, sku, createDate, updateDate, peso);
                articulos.add(articulo);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
}
