/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.ServicioDAO;
import datos.SolicitanteDAO;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import negocio.Servicio;
import negocio.Solicitante;
import util.RHException;


/**
 *
 * @author David
 */
public class ServicioGestor {
    private ServicioDAO servicioDAO;
    private Servicio servicio;
    
    public ServicioGestor() {
        servicioDAO = new ServicioDAO();
       
    }
    
     public void registrarServicio(int k_numeroDeServicio,String n_tipoDeServicio, String f_horaDeInicio, String f_fecha, double q_calificacion,
             int q_cantidadDeTrayectos, int k_numeroDocumentoM, String k_tipoDocumentoM, int k_idCiudad, int k_numeroDocumentoS, String k_tipoDocumentoS ) throws RHException {
      servicio = new Servicio();
      
      servicio.setK_numeroDeServicio(k_numeroDeServicio);
      servicio.setN_tipoDeServicio(n_tipoDeServicio);
      servicio.setF_horaDeInicio(f_horaDeInicio);
      servicio.setF_fecha(f_fecha);
      servicio.setQ_calificacion(q_calificacion);
      servicio.setQ_cantidadDeTrayectos(q_cantidadDeTrayectos);
      servicio.setK_numeroDocumentoM(k_numeroDocumentoM);        
      servicio.setK_tipoDocumentoM(k_tipoDocumentoM);
      servicio.setK_idCiudad(k_idCiudad);
      servicio.setK_numeroDocumentoS(k_numeroDocumentoS);        
      servicio.setK_tipoDocumentoS(k_tipoDocumentoS);
      

      servicioDAO.registrarServicio(servicio);
    }

    public ServicioDAO getServicioDAO() {
        return servicioDAO;
    }

    public void setServicioDAO(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

   
    
    
    
    
    
}
