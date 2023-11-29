/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.SolicitanteGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import negocio.Mensajero;
import negocio.Solicitante;
import presentacion.VistaInicioSesion;
import util.RHException;

/**
 * Clase que muestra la vista de inicio en la que se ven las opciones para ingresar a la aplicación
 * @author amirz
 */
public class InicioSesion implements ActionListener {
    
    private Aplicacion mediador;        // Instancia del mediador de la aplicación
    private VistaInicioSesion vista;    // Vista para el inicio de sesión
    
    //Gestor
    private MensajeroGestor gestorMensajero;
    private SolicitanteGestor gestorSolicitante;
    
    private Solicitante solicitante;
    private Mensajero mensajero;
    
    
    /**
     * Constructor de la clase InicioSesion.
     * Asocia la vista de inicio de sesión y el mediador.
     * Asigna oyentes a los botones de la interfaz.
     * 
     * @param vista     VistaInicioSesion asociada al inicio de sesión.
     * @param mediador  Aplicacion que actúa como mediador entre componentes.
     */
    //Pueden modificar el constructor en caso de que necesite uno o más gestores
    public InicioSesion(VistaInicioSesion vista, SolicitanteGestor gestorSolicitante, MensajeroGestor gestorMensajero, Aplicacion mediador) {
        this.vista = vista;
        this.mediador = mediador;
        this.gestorSolicitante = gestorSolicitante;
        this.gestorMensajero = gestorMensajero;
        
        // Asigna este objeto como ActionListener de los botones de la vista
        this.vista.btnInicioMensajero.addActionListener(this);
        this.vista.btnInicioSolicitante.addActionListener(this);
        this.vista.btnRegistroMensajero.addActionListener(this);
        this.vista.btnRegistroSolicitante.addActionListener(this);
    }

    /**
     *  Maneja los eventos de acción generados por la interfaz gráfica.
     *  Notifica al mediador según el botón presionado para registrar un mensajero o un solicitante.
     * 
     * @param e Evento de acción generado.
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistroMensajero) { mediador.notificar(this, "Registrar mensajero"); }
        if (e.getSource() == vista.btnRegistroSolicitante) { mediador.notificar(this, "Registrar solicitante"); }
        if (e.getSource() == vista.btnInicioMensajero) { iniciarSesionMensajero(); } 
        if (e.getSource() == vista.btnInicioSolicitante) {iniciarSesionSolicitane(); } 
    }

    /**
     * Muestra o cierra la ventana de inicio de sesión según el estado recibido.
     * 
     * @param estado Indica si se debe mostrar (true) o cerrar (false) la ventana.
     */
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
    
    
    public void iniciarSesionSolicitane(){
        // Muestra un cuadro de diálogo de entrada de texto
        String textoIngresado = JOptionPane.showInputDialog("Inserte su id:");
        
        
        try { 
             // Verifica el id del usuario
            if (gestorSolicitante.existeSolicitante(Long.parseLong(textoIngresado))==true){
                // Poner acá lo que pasa cuando el usuario existe
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso ID: " + textoIngresado);
                
                mediador.setIdSesion(Long.parseLong(textoIngresado));
                mediador.notificar(this, "Inicio de solicitante");
            }else {
                // Lo que pasa cuando el usuario no existe
                JOptionPane.showMessageDialog(null, "ERROR: Usuario no existe");
            }
        
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);          
        }   
    }   
    
     public void iniciarSesionMensajero(){
        // Muestra un cuadro de diálogo de entrada de texto
        String textoIngresado = JOptionPane.showInputDialog("Inserte su id:");
        
         
        try { 
             // Verifica el id del usuario
            if (gestorMensajero.existeMensajero(Long.parseLong(textoIngresado))==true){
                // Poner acá lo que pasa cuando el usuario existe
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso ID: " + textoIngresado);
                
                mediador.setIdSesion(Long.parseLong(textoIngresado));
                mediador.notificar(this, "Inicio de mensajero");
            }else {
                // Lo que pasa cuando el usuario no existe
                JOptionPane.showMessageDialog(null, "ERROR: Usuario no existe");
            }
        
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);          
        }   
    }   
    
    
    
}
