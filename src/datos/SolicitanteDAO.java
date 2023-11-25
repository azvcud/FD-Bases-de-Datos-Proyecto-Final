/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import negocio.Solicitante;

import util.RHException;
import util.ServiceLocator;


public class SolicitanteDAO {
    /*
     * Constructor de la clase
     */
    public SolicitanteDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarSolicitante(Solicitante solicitante) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO solicitante (k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                + " n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, solicitante.getK_numeroDocumento()); 
        prepStmt.setString(2, solicitante.getK_tipoDocumento()); 
        prepStmt.setString(3, solicitante.getN_primerNombre()); 
        prepStmt.setString(4, solicitante.getN_segundoNombre()); 
        prepStmt.setString(5, solicitante.getN_primerApellido());   
        prepStmt.setString(6, solicitante.getN_segundoApellido()); 
        prepStmt.setString(7, solicitante.getN_sexo());   
        prepStmt.setInt(8, solicitante.getQ_telefono());
        prepStmt.setString(9, solicitante.getN_correoElectronico());   
        prepStmt.setString(10, solicitante.getN_direccion());  
       
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           ServiceLocator.getInstance().rollback();
           throw new RHException( "SolicitanteDAO", "No pudo crear el solicitante"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }


