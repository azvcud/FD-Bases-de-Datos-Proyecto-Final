/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.PagoServicio;


import util.RHException;
import util.ServiceLocator;


public class PagoServicioDAO {
    /*
     * Constructor de la clase
     */
    public PagoServicioDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarPagoServicio(PagoServicio pagoServicio) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO pagoservicio (k_referenciaPago, n_tipoPago, q_valor,"
                + " n_estado, k_numeroDeServicio) VALUES(?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setString(1, pagoServicio.getK_referenciaPago()); 
        prepStmt.setString(2, pagoServicio.getN_tipoPago()); 
        prepStmt.setInt(3, pagoServicio.getQ_valor()); 
        prepStmt.setString(4, pagoServicio.getN_estado()); 
        prepStmt.setInt(5, pagoServicio.getK_numeroDeServicio());   
     

       
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           ServiceLocator.getInstance().rollback();
           throw new RHException( "Tarifa DAO", "No pudo crear la tarifa"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }


