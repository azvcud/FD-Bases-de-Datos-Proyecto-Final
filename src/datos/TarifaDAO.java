/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Tarifa;

import util.RHException;
import util.ServiceLocator;


public class TarifaDAO {
    /*
     * Constructor de la clase
     */
    public TarifaDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    
     
    public void registrarTarifa(Tarifa tarifa) throws RHException {
      try {
          
        
       
        String strSQL = "INSERT INTO tarifa (k_indiceTarifa, v_tarEnvioDocumento, v_tarPagoFactura, v_tarEnPaqPequeno,"
                + " v_tarEnPaqMediano, v_tarEnPaqGrande, k_idCiudad  ) VALUES(?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, tarifa.getK_indiceTarifa()); 
        prepStmt.setInt(2, tarifa.getV_tarEnvioDocumento()); 
        prepStmt.setInt(3, tarifa.getV_tarPagoFactura()); 
        prepStmt.setInt(4, tarifa.getV_tarEnPaqPequeño()); 
        prepStmt.setInt(5, tarifa.getV_tarEnPaqMediano());   
        prepStmt.setInt(6, tarifa.getV_tarEnPaqGrande()); 
        prepStmt.setInt(7, tarifa.getK_idCiudad());   

       
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


