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
import logica.Clases.Direccion;

/**
 *
 * @author n1c0l
 */
public class DireccionesServicios {

    public DireccionesServicios() {

    }

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Direccion> getDirecciones() throws SQLException {
        ArrayList<Direccion> direcciones = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM direccion");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idDireccion = rs.getInt("id_direccion");
                String calle = rs.getString("calle");
                int nuemroPuerta = rs.getInt("nuemro_puerta");
                String localidad = rs.getString("localidad");
                String departamento = rs.getString("departamento");
//               int idPeoveedorFk = rs.getInt("id_proveedor_fk");

                Direccion direccion = new Direccion(idDireccion, calle, nuemroPuerta, localidad, departamento);
                direcciones.add(direccion);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return direcciones;
    }
}
