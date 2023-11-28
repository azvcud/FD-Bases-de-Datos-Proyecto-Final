/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.SolicitanteGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.VistaRegistroSolicitante;

/**
 * Clase encargada de gestionar el registro de un solicitante en la aplicación.
 * Implementa ActionListener para manejar eventos de interfaz gráfica.
 * 
 * Esta clase se encarga de la interacción entre la VistaRegistroSolicitante y el SolicitanteGestor.
 * 
 * @author amirz
 */
public class RegistroSolicitante implements ActionListener {
    
    private Aplicacion mediador;                    // Instancia del mediador de la aplicación
    private VistaRegistroSolicitante vista;         // Vista para el registro de solicitantes
    private SolicitanteGestor gestorSolicitante;    // Gestor de solicitantes
    
    /**
     * Constructor de la clase RegistroSolicitante.
     * 
     * @param vista                 VistaRegistroSolicitante asociada al registro de solicitantes.
     * @param gestorSolicitante     Gestor encargado de operaciones relacionadas con solicitantes.
     * @param mediador              Aplicacion que actúa como mediador para la interacción entre componentes.
     */
    
    public RegistroSolicitante(VistaRegistroSolicitante vista, SolicitanteGestor gestorSolicitante, Aplicacion mediador) {
        this.vista = vista;
        this.gestorSolicitante = gestorSolicitante;
        this.mediador = mediador;
    }

    /**
     * Maneja los eventos de acción generados por la interfaz gráfica.
     * 
     * @param e Evento de acción generado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Despliega la ventana de registro de solicitantes.
     * 
     * @param estado Indica si se debe mostrar (true) o cerrar (false) la ventana.
     */
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
}