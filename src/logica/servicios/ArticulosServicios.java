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
import logica.Clases.Fabricante;
import logica.Clases.Proveedor;

public class ArticulosServicios {

    private Connection conexion = new ConexionDB().getConexion();

    public void modificaDatosArticulo(Articulo articulo) {
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE `articulo` SET `sku` = ?, `nombre` = ?, `descripcion` = ?, `stock` = ?, `precio` = ?, `peso` = ?, `foto` = ? , `update_date` = ?, `create_date` = ?, `id_categoria_fk`= ? WHERE `articulo`.`id_articulo` = ?;");

            // Nuevos valores para actualizar
            status.setObject(1, articulo.getSku());
            status.setObject(2, articulo.getNombre());
            status.setObject(3, articulo.getDescripcion());
            status.setObject(4, articulo.getStock());
            status.setObject(5, articulo.getPrecio());
            status.setObject(6, articulo.getPeso());
            status.setObject(7, articulo.getFotoProducto());
            status.setObject(8, articulo.getUpdateDate());
            status.setObject(9, articulo.getCreateDate());
            status.setObject(10, articulo.getCategoria().getId());
            status.setObject(11, articulo.getId());

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El artículo se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El artículo no se ha actualizado correctamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el artículo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar el artículo:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean agregarArticulo(Articulo articulo) throws Exception {
        try {

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `articulo` (`id_articulo`, `sku`, `nombre`, `descripcion`, `stock`, `precio`, `peso`, `foto`, `update_date`, `create_date`, `id_categoria_fk`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            status.setObject(1, null);
            status.setObject(2, articulo.getSku());
            status.setObject(3, articulo.getNombre());
            status.setObject(4, articulo.getDescripcion());
            status.setObject(5, articulo.getStock());
            status.setObject(6, articulo.getPrecio());
            status.setObject(7, articulo.getPeso());
            status.setObject(8, articulo.getFotoProducto());
            status.setObject(9, articulo.getUpdateDate());
            status.setObject(10, articulo.getCreateDate());
            status.setObject(11, articulo.getCategoria().getId());

            int rs = status.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el artículo:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return false;
    }

    public int obtenerUltimoArticulo() {
        try {

            PreparedStatement status = conexion.prepareStatement("SELECT id_articulo FROM `articulo` ORDER BY id_articulo DESC LIMIT 1");
            ResultSet rs = status.executeQuery();
            int idArticulo = 0;

            while (rs.next()) {
                idArticulo = rs.getInt("id_articulo");
            }

            rs.close();
            return idArticulo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el artículo:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        return 0;
    }

    public void agregarFabrica(Articulo articulo) {
        try {
            int idArticulo = obtenerUltimoArticulo();

            PreparedStatement status = conexion.prepareStatement("INSERT INTO `fabrica` (`id_fabrica`, `id_articulo_fk`, `id_fabricante_fk`) VALUES (?, ?, ?);");
            status.setObject(1, null);
            status.setObject(2, idArticulo);
            status.setObject(3, articulo.getFabricante().getId());

            int rs = status.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el artículo:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public ArrayList<Articulo> getArticulos(int limite) {
        ArrayList<Articulo> articulos = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(
                    "SELECT ARTICULO.*, CATEGORIA.nombre_categoria, "
                    + "(SELECT GROUP_CONCAT(F.nombre_fabricante SEPARATOR ', ') FROM fabricante AS F "
                    + " JOIN FABRICA AS FA ON F.id_fabricante = FA.id_fabricante_fk "
                    + " WHERE FA.id_articulo_fk = ARTICULO.id_articulo) AS nombre_fabricante, "
                    + "IFNULL(\n"
                    + "        (SELECT GROUP_CONCAT(P.nombre_proveedor SEPARATOR ', ') \n"
                    + "         FROM proveedor AS P \n"
                    + "         JOIN ingresa AS i ON P.id_proveedor = i.id_proveedor_fk \n"
                    + "         WHERE i.id_articulo_fk = ARTICULO.id_articulo), \n"
                    + "        'no asignado'\n"
                    + "    ) AS nombre_proveedor  "
                    + "FROM ARTICULO "
                    + "JOIN CATEGORIA ON ARTICULO.id_categoria_fk = CATEGORIA.id_categoria LIMIT " + limite + ";");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setNombre(rs.getString("nombre_fabricante"));
                Proveedor proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria_fk"));
                categoria.setNombre(rs.getString("nombre_categoria"));

                int idArticulo = rs.getInt("id_articulo");
                long sku = rs.getLong("sku");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                float precio = rs.getFloat("precio");
                float peso = rs.getFloat("peso");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                byte[] fotoProducto = rs.getBytes("foto");

                Articulo articulo = new Articulo(idArticulo, sku, nombre, descripcion, stock, precio, peso, updateDate, createDate, categoria, fotoProducto);
                articulo.setFabricante(fabricante);
                articulo.setProveedor(proveedor);
                articulos.add(articulo);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }

    public boolean eliminarArticulo(int idArticulo) {
        try {
            PreparedStatement status = conexion.prepareStatement("DELETE FROM articulo WHERE id_articulo = ?");

            status.setObject(1, idArticulo);

            int filasAfectadas = status.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Artículo eliminado exitosamente.");
                return true;
            } else {
                System.out.println("No se encontró el artículo con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el artículo: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Articulo> BuscarArticulo(String datoABuscar, String atributo) {
        ArrayList<Articulo> articulos = new ArrayList<>();

        if (atributo == "Nombre") {
            atributo = "nombre";
        }

        if (atributo.equals("Categoria")) {
            atributo = "nombre_categoria";
        }

        if (atributo == "Descripcion") {
            atributo = "descripcion";
        }

        if (atributo == "SKU") {
            atributo = "sku";
        }

        try {
            String sql = "SELECT ARTICULO.*, CATEGORIA.nombre_categoria, \n"
                    + "	(SELECT GROUP_CONCAT(F.nombre_fabricante SEPARATOR ', ') FROM fabricante as F \n"
                    + "		JOIN FABRICA AS FA on F.id_fabricante = FA.id_fabricante_fk \n"
                    + "		WHERE FA.id_articulo_fk = articulo.id_articulo) as nombre_fabricante ,\n"
                    + "IFNULL(\n"
                    + "        (SELECT GROUP_CONCAT(P.nombre_proveedor SEPARATOR ', ') \n"
                    + "         FROM proveedor AS P \n"
                    + "         JOIN ingresa AS i ON P.id_proveedor = i.id_proveedor_fk \n"
                    + "         WHERE i.id_articulo_fk = ARTICULO.id_articulo), \n"
                    + "        'no asignado'\n"
                    + "    ) AS nombre_proveedor  "
                    + "FROM ARTICULO JOIN CATEGORIA ON ARTICULO.id_categoria_fk = CATEGORIA.id_categoria Where LOWER(ARTICULO."+ atributo + ") like LOWER('%" + datoABuscar + "%')";

            if (atributo.equals("sku")) {
                sql = "SELECT ARTICULO.*, CATEGORIA.nombre_categoria, (SELECT F.nombre_fabricante FROM fabricante as F JOIN FABRICA AS FA on F.id_fabricante = FA.id_fabricante_fk WHERE FA.id_articulo_fk = articulo.id_articulo) as nombre_fabricante,"
                        + "IFNULL("
                        + "        (SELECT GROUP_CONCAT(P.nombre_proveedor SEPARATOR ', ') "
                        + "         FROM proveedor AS P "
                        + "         JOIN ingresa AS i ON P.id_proveedor = i.id_proveedor_fk "
                        + "         WHERE i.id_articulo_fk = ARTICULO.id_articulo), "
                        + "        'no asignado'"
                        + "    ) AS nombre_proveedor "
                        + "FROM ARTICULO JOIN CATEGORIA ON ARTICULO.id_categoria_fk = CATEGORIA.id_categoria Where ARTICULO.sku = " + datoABuscar + "";
            }
            if (atributo.equals("nombre_categoria")) {
                sql = "SELECT ARTICULO.*, CATEGORIA.nombre_categoria, \n"
                    + "	(SELECT GROUP_CONCAT(F.nombre_fabricante SEPARATOR ', ') FROM fabricante as F \n"
                    + "		JOIN FABRICA AS FA on F.id_fabricante = FA.id_fabricante_fk \n"
                    + "		WHERE FA.id_articulo_fk = articulo.id_articulo) as nombre_fabricante ,\n"
                    + "IFNULL(\n"
                    + "        (SELECT GROUP_CONCAT(P.nombre_proveedor SEPARATOR ', ') \n"
                    + "         FROM proveedor AS P \n"
                    + "         JOIN ingresa AS i ON P.id_proveedor = i.id_proveedor_fk \n"
                    + "         WHERE i.id_articulo_fk = ARTICULO.id_articulo), \n"
                    + "        'no asignado'\n"
                    + "    ) AS nombre_proveedor  "
                    + "FROM ARTICULO JOIN CATEGORIA ON ARTICULO.id_categoria_fk = CATEGORIA.id_categoria Where LOWER(CATEGORIA."+ atributo + ") like LOWER('%" + datoABuscar + "%')";
            }
            
            

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

             while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setNombre(rs.getString("nombre_fabricante"));
                Proveedor proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id_categoria_fk"));
                categoria.setNombre(rs.getString("nombre_categoria"));

                int idArticulo = rs.getInt("id_articulo");
                long sku = rs.getLong("sku");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                float precio = rs.getFloat("precio");
                float peso = rs.getFloat("peso");
                Date updateDate = rs.getDate("update_date");
                Date createDate = rs.getDate("create_date");

                byte[] fotoProducto = rs.getBytes("foto");

                Articulo articulo = new Articulo(idArticulo, sku, nombre, descripcion, stock, precio, peso, updateDate, createDate, categoria, fotoProducto);
                articulo.setFabricante(fabricante);
                articulo.setProveedor(proveedor);
                articulos.add(articulo);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return articulos;
    }
}
