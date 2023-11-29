/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.CiudadDAO;
import java.util.HashSet;
import negocio.Ciudad;
import negocio.Solicitante;
import util.RHException;


/**
 * Clase CiudadGestor que gestiona las operaciones relacionadas con la Ciudad y su persistencia en la base de datos.
 * @author David
 */
public class CiudadGestor {
    private CiudadDAO ciudadDAO; //Objeto para interactuar con la base de datos y operaciones relacionadas con la ciudad
    private Ciudad ciudad;       //Objeto Ciudad para manipulación y registro de datos
    
    /**
     * Constructor de la clase Ciudadgestor.
     * Inicializa un objeto CiudadDAO para acceder a la base de datos
     */
    public CiudadGestor() {
        ciudadDAO = new CiudadDAO();
       
    }
    
    /**
     * Registra una nueva Ciudad en la base de datos con los parámetros proporcionados.
     * 
     * @param k_idCiudad            Identificador de la Ciudad.
     * @param n_nombreCiudad        Nombre de la Ciudad
     * @param v_tarifaPorTrayecto   Valor de la Tarifa por trayecto de la Ciudad.
     * @param v_porcentajeComision  Valor del Prcentaje de comisión de la Ciudad.
     * @throws RHException          Excepción por si ocurre un error al registrar los datos de la Ciudad en la base de datos.
     */
    
     public void registrarCiudad(int k_idCiudad,String n_nombreCiudad, double v_tarifaPorTrayecto, double v_porcentajeComision) throws RHException {
      // Crea un objeto ciudad con los datos proporcionados
      ciudad = new Ciudad();
      
      // Configura los atributos de la Ciudad
      ciudad.setK_idCiudad(k_idCiudad);
      ciudad.setN_nombreCiudad(n_nombreCiudad);
      ciudad.setV_tarifaPorTrayecto(v_tarifaPorTrayecto);
      ciudad.setV_porcentajeComision(v_porcentajeComision);
  
      // Registro de la Ciudad en la base de datos usando el objeto CiudadDAO
      ciudadDAO.registrarCiudad(ciudad);
    }
     
    public int obtenerTarifaPorTrayecto(int k_idciudad) throws RHException{
        int tarifa=ciudadDAO.obtenerTarifaPorTrayecto(k_idciudad);
        return tarifa;
    }
     

    // Getters y setter para acceder y modificar CiudadDAO y Ciudad 
    public CiudadDAO getCiudadDAO() {
        return ciudadDAO;
    }

    public void setCiudadDAO(CiudadDAO ciudadDAO) {
        this.ciudadDAO = ciudadDAO;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

   
    
    
}
