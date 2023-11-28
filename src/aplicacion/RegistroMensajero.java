/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.VistaRegistroMensajero;

/**
 * Clase encargada de gestionar el registro de un mensajero en la aplicación.
 * Implementa ActionListener para manejar eventos de interfaz gráfica.
 * 
 * Esta clase se encarga de la interacción entre la VistaRegistroMensajero y el MensajeroGestor.
 * 
 * @author amirz
 */
public class RegistroMensajero implements ActionListener {
    
    private Aplicacion mediador;                //Instancia del mediado de la aplicación
    private VistaRegistroMensajero vista;       //Vista par el registro de Mensajeros
    private MensajeroGestor gestorMensajero;    // Gestor de mensajeros
 
    /**
     * Constructor de la clase RegistroMensajero.
     * @param vista             VistaRegistroMensajero asociada al registro de mensajeros.
     * @param gestorMensajero   Gestor encargado de operaciones relacionadas con mensajeros.
     * @param mediador          Aplicacion que actúa como mediador para la interacción entre componentes.
     */
    public RegistroMensajero(VistaRegistroMensajero vista, MensajeroGestor gestorMensajero, Aplicacion mediador) {
        this.vista = vista;
        this.gestorMensajero = gestorMensajero;
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
     * Despliega la ventana de registro de mensajeros.
     * 
     * @param estado Indica si se debe mostrar (true) o cerrar (false) la ventana.
     */
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
}
