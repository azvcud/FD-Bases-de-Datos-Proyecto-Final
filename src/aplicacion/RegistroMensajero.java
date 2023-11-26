/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

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

    public RegistroMensajero(VistaRegistroMensajero vista, Aplicacion mediador) {
        this.vista = vista;
        this.mediador = mediador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void desplegar(boolean estado) {
        vista.setVisible(estado);
    }
}
