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
 *
 * @author amirz
 */
public class RegistroSolicitante implements ActionListener {
    
    private Aplicacion mediador;
    private VistaRegistroSolicitante vista;
    private SolicitanteGestor gestorSolicitante;
    
    public RegistroSolicitante(VistaRegistroSolicitante vista, SolicitanteGestor gestorSolicitante, Aplicacion mediador) {
        this.vista = vista;
        this.gestorSolicitante = gestorSolicitante;
        this.mediador = mediador;
        
        this.vista.btnRegistrarSolicitante.addActionListener(this);
    }

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
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
}