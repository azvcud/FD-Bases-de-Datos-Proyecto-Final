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
 * Clase TarifaGestor que gestiona las operaciones relacionadas con la Tarifa y su persistencia en la base de datos.
 * @author David
 */
public class TarifaGestor {
    private TarifaDAO tarifaDAO;    //Objeto TarifaDAO para interactuar con la base de datos y operaciones relacionadas con la Tarifa.
    private Tarifa tarifa;          //Objeto Tarifa para manipulación y registro de datos de Tarifa.
    
    /**
     * Constructo de la clase TarifaGestor.
     * Inicialización de un objeto TarifaDAO para aceder a la capa de accedo de datos.
     */
    public TarifaGestor() {
        tarifaDAO = new TarifaDAO();
       
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
    
     public void registrarTarifa(int k_indiceTarifa, int v_tarEnvioDocumento, int  v_tarPagoFactura, int v_tarEnPaqPequeno, 
             int v_tarEnPaqMediano, int v_tarEnPaqGrande, int  k_idCiudad ) throws RHException {
      // Crea un objeto Tarifa con los datos proporcionados
      tarifa = new Tarifa();
      
      // Configura los atributos de la Tarifa
      tarifa.setK_indiceTarifa(k_indiceTarifa);
      tarifa.setV_tarEnvioDocumento(v_tarEnvioDocumento);
      tarifa.setV_tarPagoFactura(v_tarPagoFactura);
      tarifa.setV_tarEnPaqPequeño(v_tarEnPaqPequeno);
      tarifa.setV_tarEnPaqMediano(v_tarEnPaqMediano);
      tarifa.setV_tarEnPaqGrande(v_tarEnPaqGrande);
      tarifa.setK_idCiudad(k_idCiudad);
   
      // Registra la Tarifa en la base de datos utilizando el objeto TarifaDAO
      tarifaDAO.registrarTarifa(tarifa);
    }

    // Getters y setter para acceder y modificar TarifaDAO y Tarifa
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
