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
    
   private Connection conexion = new ConexionDB().getConexion();
    
    public void ingresarDatosArticulo(Articulo articulo) throws Exception {
      try{
              
            PreparedStatement status =conexion.prepareStatement("INSERT INTO articulo (id_articulo, sku, nombre, descripcion, stock, precio, peso, update_Date, create_Date, id_categoria_fk) VALUES (?,?,?,?,?,?,?,?,?,?)");
            status.setString(1, String.valueOf(articulo.getId()));
            status.setString(2, String.valueOf(articulo.getSku()));
            status.setString(3, articulo.getNombre());
            status.setString(4, articulo.getDescripcion());
            status.setString(5, String.valueOf(articulo.getStock()));
            status.setString(6, String.valueOf(articulo.getPrecio()));
            status.setString(7, String.valueOf(articulo.getPeso()));
            status.setString(8, null);
            status.setString(9, null);
            status.setString(10, String.valueOf(articulo.getId_categoria()));
           
            
            int filasInsertadas = status.executeUpdate();
                    
            if(filasInsertadas > 0)
            {
                System.out.print("Nuevo usuario creado.");
            }
            
        } catch(SQLException ex){
        ex.printStackTrace();
        throw new Exception ("No se pudo insertar el usuario, algo saió mal");
        }
    }

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
                int idCategoriaFk = rs.getInt("id_categoria_fk");

                Articulo articulo = new Articulo(idArticulo, descripcion, nombre, stock, precio, sku, createDate, updateDate, peso, idCategoriaFk);
                articulos.add(articulo);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
}
