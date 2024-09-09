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
import logica.Clases.Fabricante;




public class FabricantesServicios {

   public FabricantesServicios(){
       
   }
   
   private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Fabricante> getFabricante() throws SQLException {
        ArrayList<Fabricante> fabricantes = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM fabricante");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                int idFabricante = rs.getInt("id_fabricante");
                String nombre = rs.getString("nombre_fabricante");
                String correro = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                Fabricante fabricante = new Fabricante(idFabricante, nombre, correro, telefono, updateDate, createDate);
                fabricantes.add(fabricante);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fabricantes;
    }
}
