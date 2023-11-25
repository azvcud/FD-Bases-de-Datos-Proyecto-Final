/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.SolicitanteDAO;
import datos.TarifaDAO;
import java.util.HashSet;
import java.util.Set;
import negocio.Solicitante;
import negocio.Tarifa;
import util.RHException;


/**
 *
 * @author David
 */
public class TarifaGestor {
    private TarifaDAO tarifaDAO;
    private Tarifa tarifa;
    
    public TarifaGestor() {
        tarifaDAO = new TarifaDAO();
       
    }
    
     public void registrarTarifa(int k_indiceTarifa, int v_tarEnvioDocumento, int  v_tarPagoFactura, int v_tarEnPaqPequeno, 
             int v_tarEnPaqMediano, int v_tarEnPaqGrande, int  k_idCiudad ) throws RHException {
      tarifa = new Tarifa();
      tarifa.setK_indiceTarifa(k_indiceTarifa);
      tarifa.setV_tarEnvioDocumento(v_tarEnvioDocumento);
      tarifa.setV_tarPagoFactura(v_tarPagoFactura);
      tarifa.setV_tarEnPaqPequeño(v_tarEnPaqPequeno);
      tarifa.setV_tarEnPaqMediano(v_tarEnPaqMediano);
      tarifa.setV_tarEnPaqGrande(v_tarEnPaqGrande);
      tarifa.setK_idCiudad(k_idCiudad);
   

      tarifaDAO.registrarTarifa(tarifa);
    }

    public TarifaDAO getTarifaDAO() {
        return tarifaDAO;
    }

    public void setTarifaDAO(TarifaDAO tarifaDAO) {
        this.tarifaDAO = tarifaDAO;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

   
    
    
    
    
    
}
