/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.SolicitanteDAO;
import java.util.HashSet;
import negocio.Solicitante;
import util.RHException;


/**
 *
 * @author David
 */
public class SolicitanteGestor {
    private SolicitanteDAO solicitanteDAO;
    private Solicitante solicitante;
    
    public SolicitanteGestor() {
        solicitanteDAO = new SolicitanteDAO();
       
    }
    
     public void registrarSolicitante(int k_numeroDocumento,String k_tipodocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion) throws RHException {
      solicitante = new Solicitante();
      
      solicitante.setK_numeroDocumento(k_numeroDocumento);
      solicitante.setK_tipoDocumento(k_tipodocumento);
      solicitante.setN_primerNombre(n_primerNombre);
      solicitante.setN_segundoNombre(n_segundonombre);
      solicitante.setN_primerApellido(n_primerapellido);
      solicitante.setN_segundoApellido(n_segundoapellido);
      solicitante.setN_sexo(n_sexo);
      solicitante.setQ_telefono(q_telefono);
      solicitante.setN_correoElectronico(n_correoelectronico);
      solicitante.setN_direccion(n_direccion);

      solicitanteDAO.registrarSolicitante(solicitante);
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }
    
    
    
    
    
}
