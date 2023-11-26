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
 * Clase PagoServicioGestor que gestiona las operaciones de Pagos de Servicio y su persistencia en la base de datos.
 * @author David
 */
public class PagoServicioGestor {
    private PagoServicioDAO pagoServicioDAO; //Objeto PagoServicioDAO encargado de interactuar con la base de datos y las operaciones relacionadas con PagoServicio.
    private PagoServicio pagoServicio;       //Objeto PagoServicio para manipulación y registro de datos de pago de servicio.
    
    /**
     * Constructor de la clase PagoServicioGestor.
     * Inicializa un Objeto PagoServicioDAO para acceder a la capa de acceso a datos.
     */
    
    public PagoServicioGestor() {
        pagoServicioDAO = new PagoServicioDAO();
       
    }
    
    /**
     * Registra un nuevo Pago de Servicio en la base de datos con los parámetros proporcionados.
     *
     * @param k_referenciaPago      Referencia del Pago del Servicio.
     * @param n_tipoPago            Tipo de Pago del Servicio.
     * @param q_valor               Valor del Pago del Servicio.
     * @param n_estado              Estado del Pago del Servicio.
     * @param k_numeroDeServicio    Número de Servicio asociado al Pago.
     * @throws RHException          Exepción por si ocurre un error al registrar el Pago de Servicio.
     */
    
     public void registrarPagoServicio(int k_referenciaPago, String n_tipoPago, int q_valor,
            String n_estado, int k_numeroDeServicio ) throws RHException {
      // Crea un objeto PagoServicio con los datos proporcionados
      pagoServicio = new PagoServicio();
      
      // Configura los atributos de PagoServicio
      pagoServicio.setK_referenciaPago(n_tipoPago);
      pagoServicio.setN_tipoPago(n_tipoPago);
      pagoServicio.setQ_valor(q_valor);
      pagoServicio.setN_estado(n_estado);
      pagoServicio.setK_numeroDeServicio(k_numeroDeServicio);
         
      // Registro del Pago de Servicio en la base de datos usando el objeo PagoServicioDAO.

      pagoServicioDAO.registrarPagoServicio(pagoServicio);
    }

    //Getters y setters para acceder y modificar PagoServicioDAO y PagoServicio.
     
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
