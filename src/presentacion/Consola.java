/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import aplicacion.MediadorVistas;
import aplicacion.VistasConcretas;
import gestor.CiudadGestor;
import gestor.MensajeroGestor;
import gestor.PagoServicioGestor;
import gestor.ServicioGestor;
import gestor.SolicitanteGestor;
import gestor.TarifaGestor;
import javax.swing.JOptionPane;
import util.RHException;

/**
 * Clase que representa la aplicación principal.
 * @author amirz
 */
public class Consola {
     
    /**
     * Metodo principal de la aplicación.
     * @param args 
     */
    public  static void main(String[] args) {
        
        SolicitanteGestor sg;
        sg = new SolicitanteGestor();
        MensajeroGestor mg;
        mg = new MensajeroGestor();
        CiudadGestor cg;
        cg = new CiudadGestor();
        TarifaGestor tg;
        tg = new TarifaGestor();
        ServicioGestor serg;
        serg = new ServicioGestor();
        PagoServicioGestor serpagoges;
        serpagoges = new PagoServicioGestor();
        
        MediadorVistas aplicacion = new VistasConcretas();
         
       /*  //Prueba de insersion en Solicitante     
        try { 
              System.out.println("Prueba");
              sg.registrarSolicitante(601, "CC","Pedro", "Roberto", "Perez", "rodriguez", "hombre",123,"casagmaiil.com", "casa" );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
          }          */
        
       /* //Prueba de insersion en Mensajero    
        try { 
              System.out.println("Prueba");
              mg.registrarMensajero(437, "CC","carlor", "", "Peligro", "Rojas", "hombre",1323,"trabajadorgmaiil.com", "el barrio", "Colombiano", "", "Bicicleta", "bici", "abc123", "renauld",  2.9, 3 );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
          }       */  
        /* //Prueba de insersion en Ciudad    
        try { 
              System.out.println("Prueba");
              cg.registrarCiudad(1,"Bogota", 3400,0.3 );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
          }         */
        
        
        /* //Prueba de insersion en Tarifa    
        try { 
              System.out.println("PruebaTarifa");
              tg.registrarTarifa(1,3000,4000,5000,6000,7000,1 );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
          }   */    
        
         //Prueba de insersion en Servicio  
        /*
        try { 
              System.out.println("PruebaServicio");
              
              serg.registrarServicio(34,"ds","12:00:00","2023-11-02",3,1,437,"CC",1,601,"CC" );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
         }         
        
         //Prueba de insersion en PagoServicio    
        try { 
              System.out.println("PruebaPagoServicio");
              
              serpagoges.registrarPagoServicio(999,"Efectivo", 6000, "0", 34 );
              JOptionPane.showMessageDialog(null,  "Registro Incluido Exitosamente", null, JOptionPane.INFORMATION_MESSAGE);
          } catch (RHException f) {
              JOptionPane.showMessageDialog(null, f, "Error", JOptionPane.ERROR_MESSAGE);
              
         }
         */
         
        
        
      }

}
      

