/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Clases.Categoria;



public class CategoriasServicios {

   private Connection conexion = new ConexionDB().getConexion();
   
   public void modificaDatosCategoria(Categoria categoria)
   {
       try{
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
}
