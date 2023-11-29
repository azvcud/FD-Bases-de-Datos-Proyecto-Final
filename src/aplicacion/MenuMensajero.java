/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Mensajero;
import presentacion.MenuPrincipalMensajero;
import util.RHException;

/**
 *
 * @author amirz
 */
public class MenuMensajero implements ActionListener {
    private Aplicacion mediador;
    private MenuPrincipalMensajero vistaMenu;
    
    private ServicioGestor gestorServicio;
    private MensajeroGestor gestorMensajero;
    
    private Mensajero sesionMensajero;

    public MenuMensajero(Aplicacion mediador, MenuPrincipalMensajero vistaMenu, ServicioGestor gestorServicio, MensajeroGestor gestorMensajero) {
        this.mediador = mediador;
        this.vistaMenu = vistaMenu;
        this.gestorServicio = gestorServicio;
        this.gestorMensajero = gestorMensajero;
        
        this.vistaMenu.btnCerrarSesion.addActionListener(this);
    }

    public void cargarInformacion() throws RHException {
        sesionMensajero = gestorMensajero.buscarMensajero(mediador.getIdSesion());
        vistaMenu.nombreMensajero.setText(sesionMensajero.getN_primerNombre());
        vistaMenu.documentoMensajero.setText(Long.toString(sesionMensajero.getK_numeroDocumento()));
        vistaMenu.medioServicio.setText(sesionMensajero.getM_medioDeServicio());
        vistaMenu.medioTransporte.setText(sesionMensajero.getM_medioDeTransporte());
        vistaMenu.sexo.setText(sesionMensajero.getN_sexo());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnCerrarSesion) { mediador.notificar(this, "Cierre de sesión");}
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vistaMenu.setVisible(estado); }
        else        { vistaMenu.dispose(); }
    }
}
