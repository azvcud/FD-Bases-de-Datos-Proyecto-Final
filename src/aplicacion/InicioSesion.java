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
    
    private Aplicacion mediador;
    private VistaInicioSesion vista;
    //Gestor
    
    //Pueden modificar el constructor en caso de que necesite uno o más gestores
    public InicioSesion(VistaInicioSesion vista, Aplicacion mediador) {
        this.vista = vista;
        this.mediador = mediador;
        
        this.vista.btnInicioMensajero.addActionListener(this);
        this.vista.btnInicioSolicitante.addActionListener(this);
        this.vista.btnRegistroMensajero.addActionListener(this);
        this.vista.btnRegistroSolicitante.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistroMensajero) { mediador.notificar(this, "Registrar mensajero"); }
        if (e.getSource() == vista.btnRegistroSolicitante) { mediador.notificar(this, "Registrar solicitante"); }
    }

    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
    
}
