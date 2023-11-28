/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.VistaRegistroServicio;
import util.RHException;

/**
 *
 * @author Marti
 */
public class RegistroServicio implements ActionListener{
    private Aplicacion mediador;
    private VistaRegistroServicio vista;
    private ServicioGestor gestorServicio;

    public RegistroServicio(VistaRegistroServicio vista, ServicioGestor gestorServicio, Aplicacion mediador) {
        this.vista = vista;
        this.gestorServicio = gestorServicio;
        this.mediador = mediador;
        this.vista.btRegistrarServicio.addActionListener(this);
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btRegistrarServicio){
            int k_numeroDeServicio = Integer.parseInt(vista.txNumeroServicio.getText());
            String n_tipoDeServicio = ((String)vista.cbTipoServicio.getSelectedItem());
            int q_cantidadDeTrayectos = Integer.parseInt(vista.txCantidadTrayectos.getText());
            int k_idCiudad = 0;
            
            switch (((String)vista.cbCiudad.getSelectedItem())){
                case "Bogota": {
                    k_idCiudad = 1;
                    break;
                }case "Cali": {
                    k_idCiudad = 7;
                    break;
                }
            }
            int k_numeroDocumentoS = Integer.parseInt(vista.txIdSolicitante.getText());
            String k_tipoDocumentoS = ((String)vista.cbTipoIdSolicitante.getSelectedItem());
            
            try {
                gestorServicio.registrarServicio(k_numeroDeServicio, n_tipoDeServicio, q_cantidadDeTrayectos, k_idCiudad, k_numeroDocumentoS, k_tipoDocumentoS);
            } catch (RHException ex) {
                Logger.getLogger(RegistroServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
