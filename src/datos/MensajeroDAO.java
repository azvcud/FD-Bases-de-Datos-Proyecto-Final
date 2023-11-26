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

/**
 * Esta clase encapsula el acceso a la base de datos para el Mensajero
 * @author Soky
 */
public class MensajeroDAO {
    /*
     * Constructor de la clase
     */
    public MensajeroDAO(){
  
    }
    
    /**
     * Registra un nuevo mensajero en la base de datos.
     * @param mensajero Mensajero a intertar en la base de datos.
     * @throws RHException 
     */
    public void registrarMensajero(Mensajero mensajero) throws RHException {
      try {
        //Prepara la inserción de un Mensajero en la base de datos
        String strSQL = "INSERT INTO mensajero (k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                + " n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion,"
                + " n_nacionalidad, q_seguridadsocial, n_mediodeservicio, n_mediodetransporte,"
                + " n_matricula, n_marca, v_pago, v_calificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        //Establece los parametros para insertar el Mensajero
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
        // Ejecuta la inserción y realiza el commit de los datos
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de error en la creación del Mensajero realiza un rollback y lanza la excepción
          // RHExceptión mostranto de que no pudo registrar el Mensajero
           ServiceLocator.getInstance().rollback();
           throw new RHException( "MensajeroDAO", "No pudo crear el mensajero"+ e.getMessage());
      }  finally {
          // Finaliza la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }