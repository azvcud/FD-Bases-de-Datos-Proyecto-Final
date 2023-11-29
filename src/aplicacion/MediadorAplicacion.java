/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.ActividadGestor;
import gestor.CiudadGestor;
import gestor.EstadoGestor;
import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import gestor.SolicitanteGestor;
import gestor.TarifaGestor;
import javax.swing.JOptionPane;
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
    private RegistroServicio registroServicio; //Oyente de vista RegServicios
    
    //Las vistas
    private VistaInicioSesion vistaInicioSesion;
    private VistaRegistroMensajero vistaRegistroMensajero;
    private VistaRegistroSolicitante vistaRegistroSolicitante;
    private VistaRegistroServicio vistaRegistroServicio; //Vista para registro de servicios
    
    //Gestores
    private MensajeroGestor gestorMensajero;
    private SolicitanteGestor gestorSolicitante;
    private ServicioGestor gestorServicio; //Gestor de servicios
    private CiudadGestor gestorCiudad;
    private TarifaGestor gestorTarifa;
    private EstadoGestor gestorEstado;
    private ActividadGestor gestorActividad;
    
    /**
     * Construtor de la clase MediadorAplicación
     * Inicializa las instancias de las vistas, gestores y oyentes necesarios para la aplicación.
     */
    public MediadorAplicacion() {
        //Instancias de las vistas
        vistaInicioSesion = new VistaInicioSesion();
        vistaRegistroMensajero = new VistaRegistroMensajero();
        vistaRegistroSolicitante = new VistaRegistroSolicitante();
        vistaRegistroServicio = new VistaRegistroServicio();
        
        //Instancias de los gestores
        gestorMensajero = new MensajeroGestor();
        gestorSolicitante = new SolicitanteGestor();
        gestorServicio = new ServicioGestor();
        gestorCiudad = new CiudadGestor();
        gestorTarifa = new TarifaGestor();
        gestorActividad = new ActividadGestor();
        gestorEstado = new EstadoGestor();
        
        
        //Instancias de los oyentes
        inicioSesion = new InicioSesion(vistaInicioSesion, gestorSolicitante, gestorMensajero, this);
        registroMensajero = new RegistroMensajero(vistaRegistroMensajero, gestorMensajero, this);
        registroSolicitante = new RegistroSolicitante(vistaRegistroSolicitante, gestorSolicitante, this);
        registroServicio = new RegistroServicio(vistaRegistroServicio, gestorServicio, gestorCiudad, gestorTarifa, gestorActividad, gestorEstado, this);  
        
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
                    
                // Caso para acceder a registro de servicios
                case "Registrar servicio":
                    inicioSesion.desplegar(false);
                    registroServicio.desplegar(true);
                default:
                    break;
            }
        } 
        if(aplicacion instanceof RegistroMensajero){
            switch(mensaje) {
                case "Regresar a inicio":
                    registroMensajero.desplegar(false);
                    inicioSesion.desplegar(true);
                    break;
                default:
                    break;
            }
        }
        if(aplicacion instanceof RegistroSolicitante){
            switch(mensaje) {
                case "Regresar a inicio":
                    registroSolicitante.desplegar(false);
                    inicioSesion.desplegar(true);
                    break;
                default:
                    break;
            }
        }
        if(aplicacion instanceof RegistroServicio) {
            switch(mensaje) {
                case "Servicio registrado":
                    JOptionPane.showMessageDialog(null, "Servicio registrado correctamente", "Registro servicio", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    } 
}
