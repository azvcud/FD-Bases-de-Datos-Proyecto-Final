/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import negocio.Mensajero;
import negocio.Servicio;
import presentacion.MenuPrincipalMensajero;
import util.RHException;

/**
 *
 * @author amirz
 */
public class MenuMensajero implements ActionListener, MouseListener {
    private Aplicacion mediador;
    private MenuPrincipalMensajero vistaMenu;
    
    private ServicioGestor gestorServicio;
    private MensajeroGestor gestorMensajero;
    
    private Mensajero sesionMensajero;
    List<Servicio> servicios = new ArrayList<>();

    public MenuMensajero(Aplicacion mediador, MenuPrincipalMensajero vistaMenu, ServicioGestor gestorServicio, MensajeroGestor gestorMensajero) {
        this.mediador = mediador;
        this.vistaMenu = vistaMenu;
        this.gestorServicio = gestorServicio;
        this.gestorMensajero = gestorMensajero;
        
        this.vistaMenu.btnCerrarSesion.addActionListener(this);
        this.vistaMenu.btnAceptarServicio.addActionListener(this);
        
        this.vistaMenu.tablaMensajero.addMouseListener(this);
    }

    public void cargarInformacion() throws RHException {
        sesionMensajero = gestorMensajero.buscarMensajero(mediador.getIdSesion());
        vistaMenu.nombreMensajero.setText(sesionMensajero.getN_primerNombre());
        vistaMenu.documentoMensajero.setText(Long.toString(sesionMensajero.getK_numeroDocumento()));
        vistaMenu.medioServicio.setText(sesionMensajero.getM_medioDeServicio());
        vistaMenu.medioTransporte.setText(sesionMensajero.getM_medioDeTransporte());
        vistaMenu.sexo.setText(sesionMensajero.getN_sexo());
    }
    
    
    public void cargarServicios() throws RHException {
        sesionMensajero = gestorMensajero.buscarMensajero(mediador.getIdSesion());
        vistaMenu.nombreMensajero.setText(sesionMensajero.getN_primerNombre());
        vistaMenu.documentoMensajero.setText(Long.toString(sesionMensajero.getK_numeroDocumento()));
        vistaMenu.sexo.setText(sesionMensajero.getN_sexo());
        servicios=gestorServicio.buscarServiciosPorDocumentoMensajero(sesionMensajero.getM_medioDeServicio());
        DefaultTableModel modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Numero de Servicio"); 
        modelo1.addColumn("Tipo de Servicio"); 
        modelo1.addColumn("Fecha"); 
        modelo1.addColumn("Costo Total"); 
        
        ;
        
        vistaMenu.tablaMensajero.setModel(modelo1);
        
        for(int i=0;i<servicios.size();i++){
            modelo1.addRow(new Object[]{servicios.get(i).getK_numeroDeServicio(),servicios.get(i).getN_tipoDeServicio()
                    ,servicios.get(i).getF_fecha(),servicios.get(i).getV_costoTotal()});

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnCerrarSesion) { mediador.notificar(this, "Cierre de sesión");}
        if(e.getSource() == vistaMenu.btnAceptarServicio) { 
           int fila= vistaMenu.tablaMensajero.getSelectedRow();
           try {  
           gestorServicio.añadirMensajero(servicios.get(fila).getK_numeroDeServicio(), 
                 sesionMensajero.getK_numeroDocumento(), sesionMensajero.getK_tipoDocumento());
                 mediador.notificar(this, "Servicio aceptado");
            } catch (RHException f) {
             JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
           }   
         }
    }
  
    public void desplegar(boolean estado) {
        if(estado)  { vistaMenu.setVisible(estado); }
        else        { vistaMenu.dispose(); }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int columnaSeleccionada = vistaMenu.tablaMensajero.getSelectedColumn();
        
        if(columnaSeleccionada == 0) {
            int filaSeleccionada = vistaMenu.tablaMensajero.rowAtPoint(e.getPoint());
            Object textoCelda = vistaMenu.tablaMensajero.getValueAt(filaSeleccionada, columnaSeleccionada);
            
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
