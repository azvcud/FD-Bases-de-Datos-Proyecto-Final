/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import presentacion.VistaRegistroMensajero;
import util.RHException;

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
        
        this.vista.btnRegistrarMensajero.addActionListener(this);
    }

    /**
     * Maneja los eventos de acción generados por la interfaz gráfica.
     * 
     * @param e Evento de acción generado.
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistrarMensajero) {
            try{
                long numId = Integer.parseInt(vista.tfNumeroDocumento.getText());
                String tipoId = (String)vista.cbTipoDocumento.getSelectedItem();
                String[] nombreComp = {vista.tfPrimerNombre.getText(),
                                    vista.tfSegundoNombre.getText(),
                                    vista.tfPrimerApellido.getText(),
                                    vista.tfSegundoApellido.getText()};

                String sexo = (String)vista.cbSexo.getSelectedItem();
                long telefono = Long.parseLong(vista.tfTelefono.getText());
                String correo = vista.tfCorreoElectronico.getText(); 
                String direccion = vista.tfDireccion.getText();
                String nacionalidad = vista.tfNacionalidad.getText();
                boolean segSocial = false;

                if (vista.cbSeguridadSocial.getSelectedIndex() == 0){
                    segSocial = true;
                }else{
                    segSocial = false;
                }

                String medServicio = (String)vista.cbMedioServicio.getSelectedItem();
                String medTransporte = (String)vista.cbMedioTransporte.getSelectedItem();
                String matricula = vista.tfMatricula.getText();
                String marca = vista.tfMarca.getText();


                try {
                    gestorMensajero.registrarMensajero(numId,
                            tipoId,
                            nombreComp[0],
                            nombreComp[1],
                            nombreComp[2],
                            nombreComp[3],
                            sexo,
                            telefono,
                            correo,
                            direccion,
                            nacionalidad,
                            segSocial,
                            medServicio,
                            medTransporte,
                            matricula,
                            marca);
                    JOptionPane.showMessageDialog(vista, "Mensajero registrado correctamente", "Registro mensajero", JOptionPane.INFORMATION_MESSAGE);
                    mediador.notificar(this, "Regresar a inicio");
                } catch (RHException ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error al registrar", JOptionPane.ERROR_MESSAGE);
                } 
            }
            catch(NumberFormatException nEx){
                JOptionPane.showMessageDialog(vista, "Ni Telefono ni Número de documento\npueden ser valores nulos.","Error al registrar", JOptionPane.ERROR_MESSAGE);
            }
        }   
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
