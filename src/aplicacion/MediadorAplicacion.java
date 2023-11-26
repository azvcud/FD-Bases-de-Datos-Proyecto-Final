/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.SolicitanteGestor;
import presentacion.*;

/**
 *
 * @author amirz
 */
public class MediadorAplicacion implements Aplicacion {
    
    //Los oyentes para las vistas
    private InicioSesion inicioSesion;
    private RegistroMensajero registroMensajero;
    private RegistroSolicitante registroSolicitante;
    
    //Las vistas
    private VistaInicioSesion vistaInicioSesion;
    private VistaRegistroMensajero vistaRegistroMensajero;
    private VistaRegistroSolicitante vistaRegistroSolicitante;
    
    //Gestores
    private MensajeroGestor gestorMensajero;
    private SolicitanteGestor gestorSolicitante;
    
    public MediadorAplicacion() {
        //Instancias de las vistas
        vistaInicioSesion = new VistaInicioSesion();
        vistaRegistroMensajero = new VistaRegistroMensajero();
        vistaRegistroSolicitante = new VistaRegistroSolicitante();
        
        //Instancias de los gestores
        gestorMensajero = new MensajeroGestor();
        gestorSolicitante = new SolicitanteGestor();
        
        
        //Instancias de los oyentes
        inicioSesion = new InicioSesion(vistaInicioSesion, this);
        registroMensajero = new RegistroMensajero(vistaRegistroMensajero, gestorMensajero, this);
        registroSolicitante = new RegistroSolicitante(vistaRegistroSolicitante, gestorSolicitante, this);
        
        iniciar();
    } 
    
    public void iniciar() {
        inicioSesion.desplegar(true);
    }
    
    
    @Override
    public void notificar(Object aplicacion, String mensaje) {
        if(aplicacion instanceof InicioSesion) {
            switch(mensaje) {
                case "Registrar mensajero":
                    inicioSesion.desplegar(false);
                    registroMensajero.desplegar(true);
                    break;
                case "Registrar solicitante":
                    inicioSesion.desplegar(false);
                    registroSolicitante.desplegar(true);
                    break;
                default:
                    break;
            }
        }
    }
}
