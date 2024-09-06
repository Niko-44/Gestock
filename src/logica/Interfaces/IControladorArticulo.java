/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Articulo;
import logica.Clases.Categoria;
import logica.Clases.Fabricante;


public interface IControladorArticulo {


    public abstract void ingresarDatosArticulo(Articulo articulo);

    public abstract void confirmarAgregadoArticulo();

    public abstract void cancelarAgregadoArticulo();

    public abstract void ingresarDatosFabricante();

    public abstract void confirmarAgregadoFabricante();

    public abstract void cancelarAgregadoFabricante();

    public abstract void ingresarDatosCategoria();  

    public abstract void cancelarAgregadoCategoria();

    public abstract void confirmarAgregadoCategoria();

    public abstract ArrayList<Articulo> obtenerArticulos();  

    public abstract void seleccionarArticulo(int id);

    public abstract void eliminarArticulo(int id);

    public abstract void cancelarProceso();

    public abstract ArrayList<Fabricante> obtenerFabricantes(); 

    public abstract void seleccionarFabricante(int idFabricante);

    public abstract void eliminarFabricante(int idFabricante);

    public abstract ArrayList<Categoria> obtenerCategorias();  

    public abstract void seleccionarCategoria(int idCategoria);

    public abstract void eliminarCategoria(int idCategoria);

    public abstract void modificaDatosArticulo(int id);  

    public abstract void confirmarModificacion();

    public abstract void cancelarModificacion();

    public abstract void modificaDatosFabricante();  

    public abstract void modificaDatosCategoria(); 

    public abstract ArrayList<Categoria> buscar(String nombre, String dato);  

    public abstract ArrayList<Articulo> buscarPorNombre(String nombre);  

    public abstract ArrayList<Articulo> listarArticulos();  

    public abstract ArrayList<Categoria> listarCategorias(); 

    public abstract ArrayList<Categoria> listarFabricante(); 

}
