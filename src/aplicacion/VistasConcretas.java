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
public class VistasConcretas implements MediadorVistas {
    
    private InicioSesion inicio_sesion;
    
    private VistaRegistroMensajero vista_registro_mensajero;
    private VistaInicioSesion vista_inicio_sesion;
    
    public VistasConcretas() {
        vista_inicio_sesion = new VistaInicioSesion();
        vista_registro_mensajero = new VistaRegistroMensajero();
        
        inicio_sesion = new InicioSesion(vista_inicio_sesion, this);
        
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
                    vista_registro_mensajero.setVisible(true);
                    break;
                default:
                    break;
            }
        }
    }
}
