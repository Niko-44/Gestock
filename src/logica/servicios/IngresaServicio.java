/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import logica.Clases.Articulo;
import logica.Clases.Ingresa;
import logica.Clases.Proveedor;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Clases.Fabricante;

/**
 *
 * @author n1c0l
 */
public class IngresaServicio {

    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<Ingresa> getIngresa() {
        ArrayList<Ingresa> resultado = new ArrayList<>();
        try {
            String query = "SELECT I.id_ingresa,i.fecha_ingreso,i.cantidad,i.lote,i.precio_compra,p.nombre_proveedor,a.nombre AS nombre_articulo,p.id_proveedor,a.id_articulo FROM INGRESA I JOIN ARTICULO A ON I.id_articulo_fk = A.id_articulo JOIN PROVEEDOR P ON I.id_proveedor_fk = P.id_proveedor ORDER BY id_ingresa ASC;";

            PreparedStatement status = conexion.prepareStatement(query);
            ResultSet rs = status.executeQuery();

            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setNombre(rs.getString("nombre_articulo"));
                articulo.setId(rs.getInt("id_articulo"));

                Proveedor proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                proveedor.setId(rs.getInt("id_proveedor"));

                Ingresa ingresa = new Ingresa(
                        rs.getInt("id_ingresa"),
                        rs.getDate("fecha_ingreso"),
                        rs.getInt("cantidad"),
                        rs.getInt("lote"),
                        rs.getFloat("precio_compra"),
                        proveedor,
                        articulo
                );

                resultado.add(ingresa);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public void modificaDatosIngresa(Ingresa ingresa) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `ingresa` SET `fecha_ingreso` = ?, `cantidad` = ?, `lote` = ?, `precio_compra` = ?, `id_proveedor_fk` = ?, `id_articulo_fk` = ? WHERE `ingresa`.`id_ingresa` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, ingresa.getFechaIngreso());
            status.setObject(2, ingresa.getCantidad());
            status.setObject(3, ingresa.getLote());
            status.setObject(4, ingresa.getPrecioCompra());
            status.setObject(5, ingresa.getProveedor().getId());
            status.setObject(6, ingresa.getArticulo().getId());
            status.setObject(7, ingresa.getIdIngresa());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El registro de ingreso se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                 JOptionPane.showMessageDialog(null, "El registro de ingreso no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException e) {
        // Mostrar el error en una ventana de diálogo
        System.err.println("Error al actualizar el ingreso: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al actualizar el ingreso:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    public boolean eliminarIngresa(int idIngresa) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM ingresa WHERE id_ingresa = ?");

            status.setObject(1, idIngresa);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Ingreso eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el ingreso con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean agregarIngreso(Ingresa ingresa) throws Exception {
        try {

            PreparedStatement status = conexion.prepareStatement(
                    "INSERT INTO `ingresa` (`id_ingresa`, `fecha_ingreso`, `cantidad`, `lote`, `precio_compra`, `id_proveedor_fk`, `id_articulo_fk`) VALUES (?, ?, ?, ?, ?, ?, ?);");
            status.setObject(1, null);
            status.setObject(2, ingresa.getFechaIngreso());
            status.setObject(3, ingresa.getCantidad());
            status.setObject(4, ingresa.getLote());
            status.setObject(5, ingresa.getPrecioCompra());
            status.setObject(6, ingresa.getProveedor().getId());
            status.setObject(7, ingresa.getArticulo().getId());

            int rs = status.executeUpdate();

            return true;

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Ingresa> buscarIngresa(String atributo, String dato) {
        ArrayList<Ingresa> resultado = new ArrayList<>();

        if (atributo == "Fecha Ingreso") {
            atributo = "fecha_ingreso";
        }

        if (atributo == "Precio Compra") {
            atributo = "precio_compra";
        }

        try {
            String query = null;
            if (atributo == "Articulo") {
                atributo = "nombre";
                query = "SELECT I.id_ingresa,i.fecha_ingreso,i.cantidad,i.lote,i.precio_compra,p.nombre_proveedor,a.nombre AS nombre_articulo,p.id_proveedor,a.id_articulo FROM INGRESA I JOIN ARTICULO A ON I.id_articulo_fk = A.id_articulo JOIN PROVEEDOR P ON I.id_proveedor_fk = P.id_proveedor WHERE LOWER(a." + atributo + ") like LOWER('%" + dato + "%');";

            } else if (atributo == "Proveedor") {
                atributo = "nombre_proveedor";
                query = "SELECT I.id_ingresa,i.fecha_ingreso,i.cantidad,i.lote,i.precio_compra,p.nombre_proveedor,a.nombre AS nombre_articulo,p.id_proveedor,a.id_articulo FROM INGRESA I JOIN ARTICULO A ON I.id_articulo_fk = A.id_articulo JOIN PROVEEDOR P ON I.id_proveedor_fk = P.id_proveedor WHERE LOWER(p." + atributo + ") like LOWER('%" + dato + "%');";

            } else {
                query = "SELECT I.id_ingresa,i.fecha_ingreso,i.cantidad,i.lote,i.precio_compra,p.nombre_proveedor,a.nombre AS nombre_articulo,p.id_proveedor,a.id_articulo FROM INGRESA I JOIN ARTICULO A ON I.id_articulo_fk = A.id_articulo JOIN PROVEEDOR P ON I.id_proveedor_fk = P.id_proveedor WHERE LOWER(i." + atributo + ") like LOWER('%" + dato + "%');";
            }
            PreparedStatement status = conexion.prepareStatement(query);
            ResultSet rs = status.executeQuery();

            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setNombre(rs.getString("nombre_articulo"));
                articulo.setId(rs.getInt("id_articulo"));

                Proveedor proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                proveedor.setId(rs.getInt("id_proveedor"));

                Ingresa ingresa = new Ingresa(
                        rs.getInt("id_ingresa"),
                        rs.getDate("fecha_ingreso"),
                        rs.getInt("cantidad"),
                        rs.getInt("lote"),
                        rs.getFloat("precio_compra"),
                        proveedor,
                        articulo
                );

                resultado.add(ingresa);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;

    }

}
