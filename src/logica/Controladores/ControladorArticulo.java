/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Clases.Articulo;
import logica.Clases.Categoria;
import logica.Clases.Fabricante;
import logica.Interfaces.IControladorArticulo;
import logica.servicios.ArticulosServicios;
import logica.servicios.CategoriasServicios;
import logica.servicios.FabricantesServicios;

public class ControladorArticulo implements IControladorArticulo {

    private ArticulosServicios servicioArticulo;
    private CategoriasServicios servicioCategoria;
    private FabricantesServicios servicioFabricante;
    private static ControladorArticulo instancia;

    public ControladorArticulo() {
        this.servicioArticulo = new ArticulosServicios();
        this.servicioCategoria = new CategoriasServicios();
        this.servicioFabricante = new FabricantesServicios();
    }

    public static ControladorArticulo getInstance() {
        if (instancia == null) {
            instancia = new ControladorArticulo();
        }
        return instancia;
    }

    public boolean agregarArticulo(Articulo articulo) {
        try {
            return servicioArticulo.agregarArticulo(articulo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarFabricante(Fabricante fabricante) {
        try {
            return servicioFabricante.agregarFabricante(fabricante);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarCategoria(Categoria categoria) {
        try {
            return servicioCategoria.agregarCategoria(categoria);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ControladorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Articulo> obtenerArticulos() {
        return obtenerArticulos(10);
    }
    
    public ArrayList<Articulo> obtenerArticulos(int limite) {
        try {
            return servicioArticulo.getArticulos(limite);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void seleccionarArticulo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarArticulo(int idArticulo) {
        return servicioArticulo.eliminarArticulo(idArticulo);
    }

    @Override
    public void cancelarProceso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Fabricante> obtenerFabricantes() {
        try {
            return servicioFabricante.getFabricante();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void seleccionarFabricante(int idFabricante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarFabricante(int idFabricante) {
        return this.servicioFabricante.eliminarFabricante(idFabricante);
    }

    @Override
    public ArrayList<Categoria> obtenerCategorias() {
        return servicioCategoria.getCategorias();
    }

    @Override
    public void seleccionarCategoria(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarCategoria(int idCategoria) {
        return this.servicioCategoria.eliminarCategoria(idCategoria);
    }

    public void modificaDatosArticulo(Articulo articulo) {
        try {
            servicioArticulo.modificaDatosArticulo(articulo);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void confirmarModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cancelarModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void modificaDatosFabricante(Fabricante fabricante) {
        try {
            servicioFabricante.modificaDatosFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }

    }

    public void modificaDatosCategoria(Categoria categoria) {
        try {
            servicioCategoria.modificaDatosCategoria(categoria);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public ArrayList<Categoria> buscarCategoria(String nombre, String dato) {
       return servicioCategoria.buscarCategoria(nombre, dato);
    }
    

    public ArrayList<Articulo> buscarArticulo(String nombre, String dato){
        return servicioArticulo.BuscarArticulo(nombre, dato);
        
    }  
    
    public ArrayList<Fabricante> buscarFabricante(String atributo, String dato){
       return servicioFabricante.buscarFabricante(atributo, dato);
       
    }
   

    @Override
    public ArrayList<Articulo> listarArticulos() {
       return null;
    }

    @Override
    public ArrayList<Categoria> listarCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Categoria> listarFabricante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    public void agregarFabrica(Articulo articulo)
    {
        servicioArticulo.agregarFabrica(articulo);
    }
    
}
