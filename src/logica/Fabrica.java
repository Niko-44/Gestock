
package logica;

import logica.Controladores.ControladorArticulo;
import logica.Interfaces.IControladorArticulo;

public class Fabrica {
    private static Fabrica instancia;
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }
    
     public IControladorArticulo getIControladorUsuario() {
        IControladorArticulo ControladorU = ControladorArticulo.getInstance();
        return ControladorU; //To change body of generated methods, choose Tools | Templates.
    }

    private Fabrica() {
    }
    
}
