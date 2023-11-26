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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
}