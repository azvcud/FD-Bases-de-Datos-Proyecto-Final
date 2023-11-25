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
 *
 * @author David
 */
public class CiudadGestor {
    private CiudadDAO ciudadDAO;
    private Ciudad ciudad;
    
    public CiudadGestor() {
        ciudadDAO = new CiudadDAO();
       
    }
    
     public void registrarCiudad(int k_idCiudad,String n_nombreCiudad, double v_tarifaPorTrayecto, double v_porcentajeComision) throws RHException {
      ciudad = new Ciudad();
      
      ciudad.setK_idCiudad(k_idCiudad);
      ciudad.setN_nombreCiudad(n_nombreCiudad);
      ciudad.setV_tarifaPorTrayecto(v_tarifaPorTrayecto);
      ciudad.setV_porcentajeComision(v_porcentajeComision);
  

      ciudadDAO.registrarCiudad(ciudad);
    }

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
