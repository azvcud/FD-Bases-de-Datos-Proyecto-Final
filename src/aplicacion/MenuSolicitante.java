/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.ServicioGestor;
import gestor.SolicitanteGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import negocio.Servicio;
import negocio.Solicitante;
import presentacion.MenuPrincipalSolicitante;
import util.RHException;

/**
 *
 * @author amirz
 */
public class MenuSolicitante implements ActionListener, MouseListener {
    private Aplicacion mediador;
    private MenuPrincipalSolicitante vistaMenu;
    
    //Gestor
    private ServicioGestor gestorServicio;
    private SolicitanteGestor gestorSolicitante;
    
    private Solicitante sesionSolicitante;
    List<Servicio> servicios = new ArrayList<>();

    public MenuSolicitante(Aplicacion mediador, MenuPrincipalSolicitante vistaMenu, ServicioGestor gestorServicio, SolicitanteGestor gestorSolicitante) {
        this.mediador = mediador;
        this.vistaMenu = vistaMenu;
        this.gestorServicio = gestorServicio;
        this.gestorSolicitante = gestorSolicitante;
        
        this.vistaMenu.btnCerrarSesion.addActionListener(this);
        this.vistaMenu.btnAgregarServicio.addActionListener(this);
        
        this.vistaMenu.tablaSolicitante.addMouseListener(this);
    }

    public void cargarInformacion() throws RHException {
        sesionSolicitante = gestorSolicitante.buscarSolicitante(mediador.getIdSesion());
        vistaMenu.nombreSolicitante.setText(sesionSolicitante.getN_primerNombre());
        vistaMenu.documentoSolicitante.setText(Long.toString(sesionSolicitante.getK_numeroDocumento()));
        vistaMenu.sexo.setText(sesionSolicitante.getN_sexo());
    }
    
    public void cargarServicios() throws RHException {
        servicios=gestorServicio.buscarServiciosPorDocumentoSolicitante(mediador.getIdSesion());
        
        
        DefaultTableModel modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Numero de Servicio"); 
        modelo1.addColumn("Tipo de Servicio"); 
        modelo1.addColumn("Fecha"); 
        modelo1.addColumn("Costo Total"); 
        
        vistaMenu.tablaSolicitante.setModel(modelo1);
        
        for(int i=0;i<servicios.size();i++){
            modelo1.addRow(new Object[]{servicios.get(i).getK_numeroDeServicio(),servicios.get(i).getN_tipoDeServicio()
                    ,servicios.get(i).getF_fecha(),servicios.get(i).getV_costoTotal()});

        }
        
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int columnaSeleccionada = vistaMenu.tablaSolicitante.getSelectedColumn();
        
        if(columnaSeleccionada == 0) {
            int filaSeleccionada = vistaMenu.tablaSolicitante.rowAtPoint(e.getPoint());
            Object textoCelda = vistaMenu.tablaSolicitante.getValueAt(filaSeleccionada, columnaSeleccionada);
            
            long valorCelda = Long.valueOf(textoCelda.toString());
            mediador.setIdServicio(valorCelda);
            mediador.notificar(this, "Ver detalles");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
