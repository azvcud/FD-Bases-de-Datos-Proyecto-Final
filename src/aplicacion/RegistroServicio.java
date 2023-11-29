/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.ActividadGestor;
import gestor.CiudadGestor;
import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import gestor.TarifaGestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    private CiudadGestor gestorCiudad;
    private TarifaGestor gestorTarifa;
    private ActividadGestor gestorActividad;
    private DefaultTableModel modelo;

    public RegistroServicio(VistaRegistroServicio vista, ServicioGestor gestorServicio, CiudadGestor gestorCiudad, TarifaGestor gestorTarifa
            , ActividadGestor gestorActividad
            , Aplicacion mediador) 
    {
        this.vista = vista;
        this.gestorServicio = gestorServicio;
        this.gestorCiudad = gestorCiudad;
        this.gestorTarifa = gestorTarifa;
        this.gestorActividad = gestorActividad;
        this.mediador = mediador;
        
        this.vista.btnAgregarActividad.addActionListener(this);
        this.vista.btRegistrarServicio.addActionListener(this);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Número de trayecto");
        modelo.addColumn("Descripción");
        modelo.addColumn("Dirección");
        vista.tablaActividades.setModel(modelo);
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
            int numero_Filas = vista.tablaActividades.getRowCount();
            
            int k_numeroDeTrayecto = 0;
            String n_descripcion = "";
            String n_direccion = "";
            
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
            
            float v_costoTotal = 45000f;
            
            try {
                gestorServicio.registrarServicio(k_numeroDeServicio, n_tipoDeServicio, q_cantidadDeTrayectos, v_costoTotal, k_idCiudad, k_numeroDocumentoS, k_tipoDocumentoS);
                
                for(int i = 0; i < numero_Filas; i++) {
                    k_numeroDeTrayecto = (int) vista.tablaActividades.getValueAt(i, 0);
                    n_descripcion = (String) vista.tablaActividades.getValueAt(i, 1);
                    n_direccion = (String) vista.tablaActividades.getValueAt(i, 2);
                    
                    gestorActividad.registrarActividad(k_numeroDeTrayecto, n_descripcion, n_direccion, k_numeroDeServicio);
                }
                
            } catch (RHException ex) {
                Logger.getLogger(RegistroServicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mediador.notificar(this, "Servicio registrado");
        }
        
        if(e.getSource() == vista.btnAgregarActividad) {
            modelo.addRow(new Object[]{vista.tablaActividades.getRowCount() + 1,"",""});
            vista.tablaActividades.setModel(modelo);
        }
    }
}
