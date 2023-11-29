/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.SolicitanteGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import presentacion.VistaRegistroSolicitante;
import util.RHException;

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
        
        this.vista.btnRegistrarSolicitante.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        
    }

    /**
     * Maneja los eventos de acción generados por la interfaz gráfica.
     * 
     * @param e Evento de acción generado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistrarSolicitante) {
            try{
                long numId = Integer.parseInt(vista.tfNumeroDocumento.getText());
                String tipoId = vista.tfTipoDocumento.getText();
                String[] nombreComp = {vista.tfPrimerNombre.getText(),
                                    vista.tfSegundoNombre.getText(),
                                    vista.tfPrimerApellido.getText(),
                                    vista.tfSegundoApellido.getText()};

                String sexo = (String)vista.cbSexo.getSelectedItem();
                long telefono = Long.parseLong(vista.tfTelefono.getText());
                String correo = vista.tfCorreoElectronico.getText(); 
                String direccion = vista.tfDireccion.getText();
                
                
                gestorSolicitante.registrarSolicitante(numId,
                        tipoId,
                        nombreComp[0],
                        nombreComp[1],
                        nombreComp[2],
                        nombreComp[3],
                        sexo,
                        telefono,
                        correo,
                        direccion);
                JOptionPane.showMessageDialog(vista, "Solicitante registrado correctamente", "Solicitante mensajero", JOptionPane.INFORMATION_MESSAGE);
                mediador.notificar(this, "Regresar a inicio");
            }catch (RHException ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error al registrar", JOptionPane.ERROR_MESSAGE);
            }
            catch(NumberFormatException nEx){
                JOptionPane.showMessageDialog(vista, "Ni Telefono ni Número de documento\npueden ser valores nulos.","Error al registrar", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == vista.btnCancelar) { mediador.notificar(this, "Regresar a inicio"); }
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