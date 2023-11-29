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

/**
 * Esta clase encapsula el acceso a la base de datos para la Tarifa
 * @author Soky
 */
public class TarifaDAO {
    /*
     * Constructor de la clase
     */
    public TarifaDAO(){
  
    }
    
    /**
     * Registra una nueva Tarifa en la base de datos.
     * @param tarifa Tarifa a insetar en la base de datos.
     * @throws RHException 
     */ 
    public void registrarTarifa(Tarifa tarifa) throws RHException {
      try {
        //Prepara la inserción de una Tarifa en la base de datos        
        String strSQL = "INSERT INTO tarifa (k_indiceTarifa, v_tarEnvioDocumento, v_tarPagoFactura, v_tarEnPaqPequeno,"
                + " v_tarEnPaqMediano, v_tarEnPaqGrande, k_idCiudad  ) VALUES(?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar la inserción de la Tarifa en la base de datos.
        prepStmt.setInt(1, tarifa.getK_indiceTarifa()); 
        prepStmt.setInt(2, tarifa.getV_tarEnvioDocumento()); 
        prepStmt.setInt(3, tarifa.getV_tarPagoFactura()); 
        prepStmt.setInt(4, tarifa.getV_tarEnPaqPequeño()); 
        prepStmt.setInt(5, tarifa.getV_tarEnPaqMediano());   
        prepStmt.setInt(6, tarifa.getV_tarEnPaqGrande()); 
        prepStmt.setInt(7, tarifa.getK_idCiudad());   

        // Ejecuta la inserción de la nueva tarifa y el commit en la base de datos.
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de ocurrir un error en la creación de la Tarifa realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo insertar la Tarifa.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "Tarifa DAO", "No pudo crear la tarifa"+ e.getMessage());
      }  finally {
          // Libera la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
    public int regresarTarifaPorCiudad(int k_idCiudad, String tarifa) throws RHException {
        int valorTarifa = 0;
      try {
        String tipoTarifa = "";
        switch (tarifa){
            case "Envio documento": {
                tipoTarifa = "v_tarEnvioDocumento";
                break;
            }
            case "Paquete pequeno": {
                tipoTarifa = "v_tarEnPaqPequeno";
                break;
            }
            case "Paquete mediano": {
                tipoTarifa = "v_tarEnPaqMediano";
                break;
            }
            case "Paquete grande": {
                tipoTarifa = "v_tarEnPaqGrande";
                break;
            }
            case "Pagar factura": {
                tipoTarifa = "v_tarPagoFactura";
                break;
            }
        }
        //Prepara la inserción de una Tarifa en la base de datos        
        String strSQL = "SELECT+"+tipoTarifa+" FROM tarifa WHERE k_idCiudad = ?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar la inserción de la Tarifa en la base de datos.
        prepStmt.setInt(1, k_idCiudad);  

        // Ejecuta la inserción de la nueva tarifa y el commit en la base de datos.
        ResultSet resulset = prepStmt.executeQuery();
        
        if (resulset.next()){
            return resulset.getInt(tipoTarifa);
        }
        
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de ocurrir un error en la creación de la Tarifa realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo insertar la Tarifa.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "Tarifa DAO", "No pudo hallar la tarifa"+ e.getMessage());
      }  finally {
          // Libera la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      return valorTarifa;
    }
    
 }