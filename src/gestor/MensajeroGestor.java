/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.MensajeroDAO;
import java.util.HashSet;
import java.util.Set;
import negocio.Mensajero;
import util.RHException;


/**
 *
 * @author David
 */
public class MensajeroGestor {
    private MensajeroDAO mensajeroDAO;
    private Mensajero mensajero;
    
    public MensajeroGestor() {
        mensajeroDAO = new MensajeroDAO();
       
    }
    
     public void registrarMensajero(int k_numeroDocumento,String k_tipodocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion,
             String n_nacionalidad, String q_seguridadsocial, String n_mediodeservicio, String n_mediodetransporte,
             String n_matricula, String n_marca, double v_pago, double v_calificacion) throws RHException {
      mensajero = new Mensajero();
      
      mensajero.setK_numeroDocumento(k_numeroDocumento);
      mensajero.setK_tipoDocumento(k_tipodocumento);
      mensajero.setN_primerNombre(n_primerNombre);
      mensajero.setN_segundoNombre(n_segundonombre);
      mensajero.setN_primerApellido(n_primerapellido);
      mensajero.setN_segundoApellido(n_segundoapellido);
      mensajero.setN_sexo(n_sexo);
      mensajero.setQ_telefono(q_telefono);
      mensajero.setN_correoElectronico(n_correoelectronico);
      mensajero.setN_direccion(n_direccion);
      mensajero.setN_nacionalidad(n_nacionalidad);
      mensajero.setQ_seguridadSocial(q_telefono);
      mensajero.setM_medioDeServicio(n_mediodeservicio);
      mensajero.setM_medioDeTransporte(n_mediodetransporte);
      mensajero.setM_matricula(n_matricula);
      mensajero.setM_marca(n_marca);
      mensajero.setV_pago(v_pago);
      mensajero.setV_calificacion(v_calificacion);
         
      mensajeroDAO.registrarMensajero(mensajero);
    }

    public MensajeroDAO getMensajeroDAO() {
        return mensajeroDAO;
    }

    public void setMensajeroDAO(MensajeroDAO mensajeroDAO) {
        this.mensajeroDAO = mensajeroDAO;
    }

    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }

   
    
    
    
    
}
