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


public class CiudadDAO {
    /*
     * Constructor de la clase
     */
    public CiudadDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarCiudad(Ciudad ciudad) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO ciudad (k_idciudad, n_nombreciudad, v_tarifaportrayecto, v_porcentajecomision) VALUES(?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, ciudad.getK_idCiudad()); 
        prepStmt.setString(2, ciudad.getN_nombreCiudad()); 
        prepStmt.setDouble(3, ciudad.getV_tarifaPorTrayecto()); 
        prepStmt.setDouble(4, ciudad.getV_porcentajeComision()); 
        
       
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           ServiceLocator.getInstance().rollback();
           throw new RHException( "CiudadDAO", "No pudo crear el solicitante"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }


