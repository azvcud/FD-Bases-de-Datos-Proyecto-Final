/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import gestor.ActividadGestor;
import gestor.MensajeroGestor;
import gestor.ServicioGestor;
import gestor.SolicitanteGestor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import negocio.Actividad;
import presentacion.VistaDetalleServicio;
import util.RHException;

/**
 *
 * @author amirz
 */
public class DetalleServicio {
    private VistaDetalleServicio vista;
    
    private ServicioGestor gestorServicio;
    private ActividadGestor gestorActividad;
    
    private Aplicacion mediador;

    public DetalleServicio(VistaDetalleServicio vista, ServicioGestor gestorServicio, ActividadGestor gestorActividad, Aplicacion mediador) {
        this.vista = vista;
        this.gestorServicio = gestorServicio;
        this.gestorActividad = gestorActividad;
        this.mediador = mediador;
        
        this.vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    public void cargarInformacion() throws RHException {
        Object[] datosMensajero = gestorServicio.mensajeroSolicitante(mediador.getIdServicio());
        ArrayList<Object> datosSolicitante = gestorServicio.servicioSolicitante(mediador.getIdServicio());
        ArrayList<Actividad> datosActividad = gestorActividad.listaActividades(mediador.getIdServicio());
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Descripción");
        modelo.addColumn("Dirección");
        
        for(Actividad actividad: datosActividad) {
            modelo.addRow(new Object[] {
                actividad.getN_descripcion(),
                actividad.getN_direccion()
            });
        }
        
        vista.tablaDetalles.setModel(modelo);
        
        vista.nombreSolicitante.setText(datosSolicitante.get(1).toString());
        vista.documentoSolicitante.setText(datosSolicitante.get(0).toString());
        vista.horaInicio.setText((String) datosSolicitante.get(2).toString());
        vista.fechaServicio.setText((String) datosSolicitante.get(3).toString());
        vista.tipoServicio.setText((String) datosSolicitante.get(4).toString());
        vista.estadoServicio.setText((String) datosSolicitante.get(5).toString());
        vista.costoTotal.setText((String) datosSolicitante.get(6).toString());
        
        vista.nombreMensajero.setText(datosMensajero[0].toString());
        vista.medioTransporte.setText(datosMensajero[1].toString());
        vista.placa.setText(datosMensajero[2].toString());
    }
    
    public void desplegar(boolean estado) {
        if(estado)  { vista.setVisible(estado); }
        else        { vista.dispose(); }
    }
}
