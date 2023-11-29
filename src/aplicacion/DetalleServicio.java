/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.SolicitanteGestor;
import presentacion.VistaDetalleServicio;

/**
 *
 * @author amirz
 */
public class DetalleServicio {
    private VistaDetalleServicio vista;
    
    private SolicitanteGestor gestorSolicitante;
    private MensajeroGestor gestorMensajero;
    
    private Aplicacion mediador;

    public DetalleServicio(VistaDetalleServicio vista, SolicitanteGestor gestorSolicitante, MensajeroGestor gestorMensajero, Aplicacion mediador) {
        this.vista = vista;
        this.gestorSolicitante = gestorSolicitante;
        this.gestorMensajero = gestorMensajero;
        this.mediador = mediador;
    }
    
    public void cargarInformacion() {
        
    }
}
