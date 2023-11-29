/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.ServicioDAO;
import datos.SolicitanteDAO;
import datos.TarifaDAO;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import negocio.Servicio;
import negocio.Solicitante;
import util.RHException;


/**
 * Clase ServicioGestor para gestionar operaciones relacionadas con el Servicio.
 * @author David
 */
public class ServicioGestor {
    private ServicioDAO servicioDAO;    //Objeto ServicioDAO para interactuar con la base de datos y las operaciones relacionadas con el Servicio.
    private TarifaDAO tarifaDAO;
    private Servicio servicio;          //Objeto Servicio para manipulación y registro en la base de datos de Servicio.
    
    /**
     * Constructor de la claseServicioGestor.
     * Inicializa un objeto ServicioDAO para acceder a la base de datos.
     */
    
    public ServicioGestor() {
        servicioDAO = new ServicioDAO();
    }
    
    /**
     * Registra un nuevo Servicio en la base de datos con los parametros proporcionados
     * 
     * @param k_numeroDeServicio    Número del Servicio.
     * @param n_tipoDeServicio      Tipo del Servicio.
     * @param f_horaDeInicio        Hora de inicio del Servicio.
     * @param f_fecha               Fecha del Servicio.
     * @param q_calificacion        Calificación del Servicio.
     * @param q_cantidadDeTrayectos Cantidad de trayectos necesarios para realizar el Servicio.
     * @param k_numeroDocumentoM    Número de Documento del Mensajero que realizara el Servicio.
     * @param k_tipoDocumentoM      Tipo de Documento del Mensajero que realizara el Servicio.
     * @param k_idCiudad            Id de la Ciudad en la que se realizara el Servicio.
     * @param k_numeroDocumentoS    Numero de Documento del Socilitante del Servicio.
     * @param k_tipoDocumentoS      Tipo de Documento del Solicitante del Servicio.
     * @throws RHException          Excepción en caso de que ocurra un error al momento de registrar el Servicio.
     */
     public void registrarServicio(int k_numeroDeServicio, String n_tipoDeServicio, 
             int q_cantidadDeTrayectos, float v_costoTotal, int k_idCiudad, int k_numeroDocumentoS, String k_tipoDocumentoS ) throws RHException {
      // Crea un objeto Servicio con los datos proporcionados
      servicio = new Servicio();
      
      
      // Configura los atributos de Servicio
      servicio.setK_numeroDeServicio(k_numeroDeServicio);
      servicio.setN_tipoDeServicio(n_tipoDeServicio);
      servicio.setQ_cantidadDeTrayectos(q_cantidadDeTrayectos);
      servicio.setV_costoTotal(v_costoTotal);
      servicio.setK_idCiudad(k_idCiudad);
      servicio.setK_numeroDocumentoS(k_numeroDocumentoS);        
      servicio.setK_tipoDocumentoS(k_tipoDocumentoS);
      
      // Registro del Servicio en la base de datos usando el objeto ServicioDAO
      servicioDAO.registrarServicio(servicio);
    }
     
     
    public List<Servicio> buscarServiciosPorDocumento(long k_numeroDocumento) throws RHException {
        List<Servicio> servicios = new ArrayList<>();
        
        servicios=servicioDAO.buscarServiciosPorDocumento(k_numeroDocumento);
        return servicios;
    }    
    //Getters y setter para acceder y modificar ServicioDAO y Servicio
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
