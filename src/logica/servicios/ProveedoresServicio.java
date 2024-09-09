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
import logica.Clases.Proveedor;

/**
 *
 * @author Vignolo
 */
public class ProveedoresServicio {
    
    public ProveedoresServicio() {
        
    }
    
    private Connection conexion = new ConexionDB().getConexion();
    
    public ArrayList<Proveedor> getProveedor() throws SQLException {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        ArrayList<String> telefonos = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM proveedor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProveedor = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");
                try {
                    PreparedStatement ps2 = conexion.prepareStatement("SELECT T.numero_telefono\n"
                            + "FROM PROVEEDOR P\n"
                            + "JOIN PROVEEDOR_TELEFONO PT ON P.id_proveedor = PT.id_proveedor_fk\n"
                            + "JOIN TELEFONO T ON PT.id_telefono_fk = T.id_telefono\n"
                            + "WHERE P.id_proveedor =" + idProveedor + ";");
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs.next()) {
                        String telefono = rs2.getString("numero_telefono");
                        
                        telefonos.add(telefono);
                    }
                    rs2.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                Proveedor proveedor = new Proveedor(idProveedor, nombre, telefonos, email, updateDate, createDate);
                proveedores.add(proveedor);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }
}
