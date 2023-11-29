/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.ServicioGestor;
import gestor.SolicitanteGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Solicitante;
import presentacion.MenuPrincipalSolicitante;
import util.RHException;

/**
 *
 * @author amirz
 */
public class MenuSolicitante implements ActionListener {
    private Aplicacion mediador;
    private MenuPrincipalSolicitante vistaMenu;
    
    //Gestor
    private ServicioGestor gestorServicio;
    private SolicitanteGestor gestorSolicitante;
    
    private Solicitante sesionSolicitante;

    public MenuSolicitante(Aplicacion mediador, MenuPrincipalSolicitante vistaMenu, ServicioGestor gestorServicio, SolicitanteGestor gestorSolicitante) {
        this.mediador = mediador;
        this.vistaMenu = vistaMenu;
        this.gestorServicio = gestorServicio;
        this.gestorSolicitante = gestorSolicitante;
        
        this.vistaMenu.btnCerrarSesion.addActionListener(this);
        this.vistaMenu.btnAgregarServicio.addActionListener(this);
    }

    public void cargarInformacion() throws RHException {
        sesionSolicitante = gestorSolicitante.buscarSolicitante(mediador.getIdSesion());
        vistaMenu.nombreSolicitante.setText(sesionSolicitante.getN_primerNombre());
        vistaMenu.documentoSolicitante.setText(Long.toString(sesionSolicitante.getK_numeroDocumento()));
        vistaMenu.sexo.setText(sesionSolicitante.getN_sexo());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnCerrarSesion) { mediador.notificar(this, "Cierre de sesión");}
        if(e.getSource() == vistaMenu.btnAgregarServicio) { mediador.notificar(this, "Registrar servicio"); }
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vistaMenu.setVisible(estado); }
        else        { vistaMenu.dispose(); }
    }
}
