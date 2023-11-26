/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import presentacion.*;

/**
 *
 * @author amirz
 */
public class MediadorAplicacion implements Aplicacion {
    
    private InicioSesion inicio_sesion;
    private RegistroMensajero registro_mensajero;
    
    private VistaRegistroMensajero vista_registro_mensajero;
    private VistaInicioSesion vista_inicio_sesion;
    
    public MediadorAplicacion() {
        vista_inicio_sesion = new VistaInicioSesion();
        vista_registro_mensajero = new VistaRegistroMensajero();
        
        inicio_sesion = new InicioSesion(vista_inicio_sesion, this);
        registro_mensajero = new RegistroMensajero(vista_registro_mensajero, this);
        
        iniciar();
    } 
    
    public void iniciar() {
        inicio_sesion.desplegar(true);
    }
    
    
    @Override
    public void notificar(Object aplicacion, String mensaje) {
        if(aplicacion instanceof InicioSesion) {
            switch(mensaje) {
                case "Registrar mensajero":
                    inicio_sesion.desplegar(false);
                    registro_mensajero.desplegar(true);
                    break;
                default:
                    break;
            }
        }
    }
}
