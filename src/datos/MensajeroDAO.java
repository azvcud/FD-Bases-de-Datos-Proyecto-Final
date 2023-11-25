/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Mensajero;


import negocio.Solicitante;

import util.RHException;
import util.ServiceLocator;


public class MensajeroDAO {
    /*
     * Constructor de la clase
     */
    public MensajeroDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarMensajero(Mensajero mensajero) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO mensajero (k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                + " n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion,"
                + " n_nacionalidad, q_seguridadsocial, n_mediodeservicio, n_mediodetransporte,"
                + " n_matricula, n_marca, v_pago, v_calificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, mensajero.getK_numeroDocumento()); 
        prepStmt.setString(2, mensajero.getK_tipoDocumento()); 
        prepStmt.setString(3, mensajero.getN_primerNombre()); 
        prepStmt.setString(4, mensajero.getN_segundoNombre()); 
        prepStmt.setString(5, mensajero.getN_primerApellido());   
        prepStmt.setString(6, mensajero.getN_segundoApellido()); 
        prepStmt.setString(7, mensajero.getN_sexo());   
        prepStmt.setInt(8, mensajero.getQ_telefono());
        prepStmt.setString(9, mensajero.getN_correoElectronico());   
        prepStmt.setString(10, mensajero.getN_direccion());  
        prepStmt.setString(11, mensajero.getN_nacionalidad()); 
        prepStmt.setInt(12, mensajero.getQ_seguridadSocial()); 
        prepStmt.setString(13, mensajero.getM_medioDeServicio()); 
        prepStmt.setString(14, mensajero.getM_medioDeTransporte()); 
        prepStmt.setString(15, mensajero.getM_matricula());   
        prepStmt.setString(16, mensajero.getM_marca()); 
        prepStmt.setDouble(17, mensajero.getV_pago());   
        prepStmt.setDouble(18, mensajero.getV_calificacion());
       
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           ServiceLocator.getInstance().rollback();
           throw new RHException( "MensajeroDAO", "No pudo crear el mensajero"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }


