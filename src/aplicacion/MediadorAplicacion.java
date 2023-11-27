/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.SolicitanteGestor;
import presentacion.*;

/**
 * Implementación de la interfaz Aplicacion que actúa como mediador principal de la aplicación.
 * Gestiona las vistas, oyentes y gestores para la funcionalidad de inicio de sesión y registro de usuarios.
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
    
    /**
     * Construtor de la clase MediadorAplicación
     * Inicializa las instancias de las vistas, gestores y oyentes necesarios para la aplicación.
     */
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
    
    /**
     * Inicia la aplicación mostrando la vista de inicio de sesión.
     */
    public void iniciar() {
        inicioSesion.desplegar(true);
    }
    
    /**
     * Método de notificación para cambiar entre vistas según el mensaje recibido.
     * @param aplicacion    Objeto que envía la notificación.
     * @param mensaje       Mensaje recibido para cambiar entre vistas.
     */
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
