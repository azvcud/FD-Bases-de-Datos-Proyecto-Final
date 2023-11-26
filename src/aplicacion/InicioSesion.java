/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.VistaInicioSesion;

/**
 *
 * @author amirz
 */
public class InicioSesion implements ActionListener {
    
    private MediadorVistas mediador;
    private VistaInicioSesion vista;
    
    public InicioSesion(VistaInicioSesion vista, MediadorVistas mediador) {
        this.vista = vista;
        this.mediador = mediador;
        
        this.vista.titulo.setText("Mensajería Urbana");
        this.vista.inicioMensajero.setText("Iniciar como mensajero");
        this.vista.inicioSolicitante.setText("Iniciar como solicitante");
        this.vista.registroSolicitante.setText("Registrar nuevo solicitante");
        this.vista.registroMensajero.setText("Registrar nuevo mensajero");
        
        this.vista.inicioMensajero.addActionListener(this);
        this.vista.inicioSolicitante.addActionListener(this);
        this.vista.registroMensajero.addActionListener(this);
        this.vista.registroSolicitante.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.registroMensajero) { mediador.notificar(this, "Registrar mensajero"); }
    }

    public void desplegar(boolean estado) {
        vista.setVisible(estado);
    }
    
}
