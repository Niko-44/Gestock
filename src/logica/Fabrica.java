
package logica;

import logica.Controladores.ControladorArticulo;
import logica.Controladores.ControladorEmpleado;
import logica.Controladores.ControladorProveedor;
import logica.Controladores.ControladorVenta;
import logica.Interfaces.IControladorArticulo;
import logica.Interfaces.IControladorEmpleado;
import logica.Interfaces.IControladorProveedor;
import logica.Interfaces.IControladorVenta;

public class Fabrica {
    private static Fabrica instancia;
    private static IControladorArticulo ControladorA;
    private static IControladorEmpleado ControladorE;
    private static IControladorProveedor ControladorP;
    private static IControladorVenta ControladorV;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }
    
     public IControladorArticulo getIControladorArticulo() {
       
        return ControladorA; 
     }

    public IControladorEmpleado getIControladoreEmpleado() {
        
        return ControladorE; 
    }

    public IControladorProveedor getIControladorProveedor() {
        
        return ControladorP; 
    }
    
    public IControladorVenta getIControladoreVenta() {
        
        return ControladorV; 
    }

    private Fabrica() {
        ControladorV = ControladorVenta.getInstance();
        ControladorP = ControladorProveedor.getInstance();
        ControladorE = ControladorEmpleado.getInstance();
        ControladorA = ControladorArticulo.getInstance();
    }
    
}
