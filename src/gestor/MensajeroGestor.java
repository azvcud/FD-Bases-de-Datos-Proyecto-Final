/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.MensajeroDAO;
import java.util.HashSet;
import java.util.Set;
import negocio.Mensajero;
import negocio.Solicitante;
import util.RHException;


/**
 * Clase MensajeroGestor que gestiona operaciones relacionadas con el Mensajero y su persistencia en la base de datos.
 * @author David
 */
public class MensajeroGestor {
    private MensajeroDAO mensajeroDAO;  //Objeto MensajeroDAO para interactuar con la base de datos y operaciones relacionadas con el Mensajero
    private Mensajero mensajero;        // Objeto Mensajero para manipulación y registro de datos
    
    /**
     * Constructor de la clase MensajeroGestor.
     * Inicializa un objeto MensajeroGestor para accerder a la capa accedo a datos.
     */
    
    public MensajeroGestor() {
        mensajeroDAO = new MensajeroDAO();
       
    }
    
    /**
     * Registra un nuevo Mensajero en la base de datos con los parametros proporcionados.
     * 
     * @param k_numeroDocumento     Número de documento del Mensajero.
     * @param k_tipodocumento       Tipo de documento de identificación del Mensajero.
     * @param n_primerNombre        Primer nombre del Mensajero.
     * @param n_segundonombre       Segundo nombre del Mensajero.
     * @param n_primerapellido      Primer apellido del Mensajero.
     * @param n_segundoapellido     Segundo apellido del Mensajero.
     * @param n_sexo                Sexo del Mensajero.
     * @param q_telefono            Telefono de contacto del Mensajero.
     * @param n_correoelectronico   Correo electronico de contacto del Mensajero.
     * @param n_direccion           Dirección de residencía del Mensajero.
     * @param n_nacionalidad        Nacionalidad del Mensajero.
     * @param q_seguridadsocial     Número de seguridad social del Mensajero.
     * @param n_mediodeservicio     Tipos de servicios que puede Realizar el Mensajero.
     * @param n_mediodetransporte   Medio de trasnporte para realizar servicios del Mensajero.
     * @param n_matricula           Número de la matricula del vehiculo de transporte.
     * @param n_marca               Marca del vehiculó de transporte
     * @param v_pago                Valor del pago a realizar al Mensajero.
     * @param v_calificacion        Valor de la calificación promedio del Mensajero.
     * @throws RHException          Excepción por si ocurre algún error al momento de insertar los datos del Mensajero.
     */
    
     public void registrarMensajero(int k_numeroDocumento,String k_tipodocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion,
             String n_nacionalidad, String q_seguridadsocial, String n_mediodeservicio, String n_mediodetransporte,
             String n_matricula, String n_marca, double v_pago, double v_calificacion) throws RHException {
      // Crea un objeto Mensajero con los datos proporcionados
      mensajero = new Mensajero();
      
      // Configura los atributos del Servicio
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
         
      // Registra al Mensajero en la base de datos usando al objeto MensajeroDAO
      mensajeroDAO.registrarMensajero(mensajero);
    }
     
     
    public Mensajero buscarmensajero(int k_numeroDocumento)throws RHException{
        Mensajero mensajero;
        mensajero =mensajeroDAO.buscarMensajero(k_numeroDocumento);
        return mensajero;
    } 
       

    // Getters y setters para acceder y modificar MensajeroDAO y Mensajero
   
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
