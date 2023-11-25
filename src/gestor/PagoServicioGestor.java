/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.PagoServicioDAO;
import datos.SolicitanteDAO;
import datos.TarifaDAO;
import java.util.HashSet;
import java.util.Set;
import negocio.PagoServicio;
import negocio.Solicitante;
import negocio.Tarifa;
import util.RHException;


/**
 *
 * @author David
 */
public class PagoServicioGestor {
    private PagoServicioDAO pagoServicioDAO;
    private PagoServicio pagoServicio;
    
    public PagoServicioGestor() {
        pagoServicioDAO = new PagoServicioDAO();
       
    }
    
     public void registrarPagoServicio(int k_referenciaPago, String n_tipoPago, int q_valor,
            String n_estado, int k_numeroDeServicio ) throws RHException {
      pagoServicio = new PagoServicio();
      pagoServicio.setK_referenciaPago(n_tipoPago);
      pagoServicio.setN_tipoPago(n_tipoPago);
      pagoServicio.setQ_valor(q_valor);
      pagoServicio.setN_estado(n_estado);
      pagoServicio.setK_numeroDeServicio(k_numeroDeServicio);
         
         
   

      pagoServicioDAO.registrarPagoServicio(pagoServicio);
    }

    public PagoServicioDAO getPagoServicioDAO() {
        return pagoServicioDAO;
    }

    public void setPagoServicioDAO(PagoServicioDAO pagoServicioDAO) {
        this.pagoServicioDAO = pagoServicioDAO;
    }

    public PagoServicio getPagoServicio() {
        return pagoServicio;
    }

    public void setPagoServicio(PagoServicio pagoServicio) {
        this.pagoServicio = pagoServicio;
    }


   
    
    
    
    
    
}
