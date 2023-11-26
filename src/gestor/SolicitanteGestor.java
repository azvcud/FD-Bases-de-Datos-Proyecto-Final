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
 * Clase SolicitanteGestor que gestiona operaciones relacionadas con el Solicitante del Servicio y su persistencia en la base de datos
 * @author David
 */
public class SolicitanteGestor {
    private SolicitanteDAO solicitanteDAO;  //Objeto SolicitanteDAO para interarctuar con la base de datos y operaciones relacionadas con el Servicio.
    private Solicitante solicitante;        //Objeto Solicitante para manipulacion y registro de datos de Solicitante.
    
    /**
     * Constructor de la clase SolicitanteGestor.
     * Inicializa un objeto SolicitanteDAO para acceder a la base de datos.
     */
    
    public SolicitanteGestor() {
        solicitanteDAO = new SolicitanteDAO();
       
    }
    
    /**
     * Registra un nuevo Solicitante en la base de datos con los parámetros proporcionados.
     * 
     * @param k_numeroDocumento     Número de documento del Solicitante.
     * @param k_tipodocumento       Tipo de documento del Solicitante.
     * @param n_primerNombre        Primer nombre del Solicitante.
     * @param n_segundonombre       Segundo nombre del Solicitante.
     * @param n_primerapellido      Primer apellido del Solicitante.
     * @param n_segundoapellido     Segundo apellido del Solicitante.
     * @param n_sexo                Sexo del Solicitante.
     * @param q_telefono            Número de telefono de contacto del Solicitante.
     * @param n_correoelectronico   Correo electronico de contacto del Solicitante.
     * @param n_direccion           Dirección de residencia del Solicitante.
     * @throws RHException          Excepción en caso de ocurrir un error al insertar un Solicitante en la base de datos.
     */
    
     public void registrarSolicitante(int k_numeroDocumento,String k_tipodocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion) throws RHException {
      // Crea un objeto Solicitante con los datos proporcionados
      solicitante = new Solicitante();
      
      // Configura los atributos del Solicitante
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

      // Registra el Solicitante en la base de datos usanto el objeto SolicitanteDAO.
      solicitanteDAO.registrarSolicitante(solicitante);
    }
     
     
    public void actualizarDatos(int k_numeroDocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion) throws RHException {
      solicitanteDAO.modificarSolicitante(k_numeroDocumento, n_primerNombre, n_segundonombre, n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico, n_direccion);
    }
    
    public void eliminarSolicitante(int k_numeroDocumento) throws RHException {
      solicitanteDAO.eliminarSolicitante(k_numeroDocumento);
    }
    
        

    // Getter y setters para acceder y modificar SolicitanteDAO y Solicitante
    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }
    
    
}
