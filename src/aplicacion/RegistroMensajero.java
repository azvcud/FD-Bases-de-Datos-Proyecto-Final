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
 *
 * @author amirz
 */
public class RegistroMensajero implements ActionListener {
    
    private Aplicacion mediador;
    private VistaRegistroMensajero vista;
    private MensajeroGestor gestorMensajero;

    public RegistroMensajero(VistaRegistroMensajero vista, MensajeroGestor gestorMensajero, Aplicacion mediador) {
        this.vista = vista;
        this.gestorMensajero = gestorMensajero;
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
