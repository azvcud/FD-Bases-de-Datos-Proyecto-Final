/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Servicio;


import negocio.Solicitante;

import util.RHException;
import util.ServiceLocator;


public class ServicioDAO {
    /*
     * Constructor de la clase
     */
    public ServicioDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarServicio(Servicio servicio) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO servicio (k_numeroDeServicio, n_tipoDeServicio, f_horaDeInicio, f_fecha, q_calificacion, "
                + " q_cantidadDeTrayectos, k_numeroDocumentoM, k_tipoDocumentoM, k_idCiudad,k_numeroDocumentoS, k_tipoDocumentoS ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        
        prepStmt.setInt(1, servicio.getK_numeroDeServicio()); 
        prepStmt.setString(2, servicio.getN_tipoDeServicio()); 
        prepStmt.setTime(3, java.sql.Time.valueOf(servicio.getF_horaDeInicio())); 
        prepStmt.setDate(4, java.sql.Date.valueOf(servicio.getF_fecha())); 
        prepStmt.setDouble(5, servicio.getQ_calificacion()); 
        prepStmt.setInt(6, servicio.getQ_cantidadDeTrayectos());   
        prepStmt.setInt(7, servicio.getK_numeroDocumentoM());
        prepStmt.setString(8, servicio.getK_tipoDocumentoM());
        prepStmt.setInt(9, servicio.getK_idCiudad());
        prepStmt.setInt(10, servicio.getK_numeroDocumentoS());
        prepStmt.setString(11, servicio.getK_tipoDocumentoS());
       
       
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           ServiceLocator.getInstance().rollback();
           throw new RHException( "ServicioDAO", "No pudo crear el servicio"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }


