/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import negocio.Servicio;
import negocio.Solicitante;
import util.RHException;
import util.ServiceLocator;

/**
 * Esta clase encapsula el acceso a la base de datos de la entidad Servicio
 * @author Soky
 */
public class ServicioDAO {
    /*
     * Constructor de la clase
     */
    public ServicioDAO(){
  
    }
    
    /**
     * Registra un nuevo Servicio en la base de datos.
     * @param servicio Objeto Servicio a insertar en la base de datos.
     * @throws RHException 
     */ 
    public void registrarServicio(Servicio servicio) throws RHException {
      try {
        //Prepara la insercion de un nuevo Servicio en la base de datos      
        String strSQL = "INSERT INTO servicio (k_numeroDeServicio, n_tipoDeServicio, f_horaDeInicio, f_fecha,"
                + " q_cantidadDeTrayectos, k_idCiudad,k_numeroDocumentoS, k_tipoDocumentoS ) VALUES(?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar el Servicio
        prepStmt.setInt(1, servicio.getK_numeroDeServicio()); 
        prepStmt.setString(2, servicio.getN_tipoDeServicio());
        Date FyH = new Date();
        prepStmt.setTime(3, new Time(FyH.getHours(),FyH.getMinutes(),FyH.getSeconds())); 
        prepStmt.setDate(4, new java.sql.Date(FyH.getYear(),FyH.getMonth(),FyH.getDay())); 
        prepStmt.setDouble(5, servicio.getQ_calificacion()); 
        prepStmt.setInt(6, servicio.getK_idCiudad());
        prepStmt.setInt(7, servicio.getK_numeroDocumentoS());
        prepStmt.setString(8, servicio.getK_tipoDocumentoS());
       
        // Ejecuta el registro del Servicio y realiza el commit en la base de datos
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          //En caso de error enla inserción del Servicio realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo hacer el registro del Servicio.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "ServicioDAO", "No pudo crear el servicio"+ e.getMessage());
      }  finally {
          //Libera la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }