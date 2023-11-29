/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.EstadoDAO;
import datos.SolicitanteDAO;
import datos.TarifaDAO;
import java.util.HashSet;
import java.util.Set;
import negocio.Estado;
import negocio.Solicitante;
import negocio.Tarifa;
import util.RHException;


/**
 * Clase TarifaGestor que gestiona las operaciones relacionadas con la Tarifa y su persistencia en la base de datos.
 * @author David
 */
public class EstadoGestor {
    private EstadoDAO estadoDAO;    //Objeto TarifaDAO para interactuar con la base de datos y operaciones relacionadas con la Tarifa.
    private Estado estado;          //Objeto Tarifa para manipulación y registro de datos de Tarifa.
    
    /**
     * Constructo de la clase TarifaGestor.
     * Inicialización de un objeto TarifaDAO para aceder a la capa de accedo de datos.
     */
    public EstadoGestor() {
        estadoDAO = new EstadoDAO();
       
    }
    
    /**
     * Registra una nueva Tarifa en la base de datos con los parametros proporcionados
     * 
     * @param k_indiceTarifa        Número identificador de la Tarifa.
     * @param v_tarEnvioDocumento   Valor de la Tarifa de un envío de Documento.
     * @param v_tarPagoFactura      Valor de la Tarifa de un pado de Factura.
     * @param v_tarEnPaqPequeno     Valor de la Tarifa de un envío de un paquete Pequeño.
     * @param v_tarEnPaqMediano     Valor de la Tarifa de un envío de un paquete Mediano.
     * @param v_tarEnPaqGrande      Valor de la Tarifa de un envío de un paquete Grande.
     * @param k_idCiudad            Número identificador de la ciudad.
     * @throws RHException          Excepción en caso de que ocurra un error al registrar la Tarifa en la base de datos.
     */
    
     public void registrarEstado(int k_idEstado, String n_estadoRegistrado,  String n_comentario, 
             int k_numeroDeServicio ) throws RHException {
      // Crea un objeto Tarifa con los datos proporcionados
      estado = new Estado();
      
      // Configura los atributos de la Tarifa
      estado.setK_idEstado(k_idEstado);
      estado.setN_estadoRegistrado(n_estadoRegistrado);
      estado.setN_comentario(n_comentario);
      estado.setK_numeroDeServicio(k_numeroDeServicio);
      
   
      // Registra la Tarifa en la base de datos utilizando el objeto TarifaDAO
      estadoDAO.registrarEstado(estado);
    }
     
    public Estado buscarEstado(int k_idEstado)throws RHException{
        Estado estado;
        estado =estadoDAO.buscarEstado(k_idEstado);
        return estado;
    }
     
     

    // Getters y setter para acceder y modificar TarifaDAO y Tarifa

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
