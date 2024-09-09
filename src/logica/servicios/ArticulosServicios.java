/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Clases.Articulo;


public class ArticulosServicios {
    
   private Connection conexion = new ConexionDB().getConexion();
    
   public  void modificaDatosArticulo(Articulo articulo)
   {
    try{
            PreparedStatement status = conexion.prepareStatement("UPDATE `articulo` SET `sku` = ?, `nombre` = ?, `descripcion` = ?, `stock` = ?, `precio` = ?, `peso` = ?, `update_date` = ?, `create_date` = ?, `id_categoria_fk` = ? WHERE `articulo`.`id_articulo` = ?;");

            // Nuevos valores para actualizar
           
            status.setObject(1, articulo.getSku());
            status.setObject(2, articulo.getNombre());
            status.setObject(3, articulo.getDescripcion());
            status.setObject(4, articulo.getStock());
            status.setObject(5, articulo.getPrecio());
            status.setObject(6, articulo.getPeso());
            status.setObject(7, articulo.getUpdateDate());
            status.setObject(8, articulo.getCreateDate());
            status.setObject(9, articulo.getId_categoria());
            status.setObject(10, articulo.getId());
            


            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el usuario con los datos proporcionados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        } 
   }
    
    
    
}
