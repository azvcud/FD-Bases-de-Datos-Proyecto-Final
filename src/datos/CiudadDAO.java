/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Ciudad;
import util.RHException;
import util.ServiceLocator;

/**
 * Esta clase encapcula el acceso a la base de datos para la Ciudad
 * @author Soky
 */

public class CiudadDAO {
    /*
     * Constructor de la clase
     */
    public CiudadDAO(){
  
    }
    
    /**
     * Registra una nueva Ciudad en la base de datos.
     * @param ciudad Objeto Ciudad a insertar en la base de datos.
     * @throws RHException 
     */ 
    public void registrarCiudad(Ciudad ciudad) throws RHException {
      try {
          
       // Prepara la inserción de una Ciudad en la base de datos. 
        String strSQL = "INSERT INTO ciudad (k_idciudad, n_nombreciudad, v_tarifaportrayecto, v_porcentajecomision) VALUES(?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar la Ciudad
        prepStmt.setInt(1, ciudad.getK_idCiudad()); 
        prepStmt.setString(2, ciudad.getN_nombreCiudad()); 
        prepStmt.setDouble(3, ciudad.getV_tarifaPorTrayecto()); 
        prepStmt.setDouble(4, ciudad.getV_porcentajeComision()); 
        
        // Ejecuta la inserción y realiza el commit en la base de datos
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de error en la creación de la Ciudad realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo insertar la Ciudad.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "CiudadDAO", "No pudo crear el solicitante"+ e.getMessage());
      }  finally {
          //finaliza la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }