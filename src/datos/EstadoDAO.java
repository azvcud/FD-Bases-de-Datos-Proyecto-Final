/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Estado;
import util.RHException;
import util.ServiceLocator;

/**
 * Esta clase encapsula el acceso a la base de datos para la Tarifa
 * @author Soky
 */
public class EstadoDAO {
    /*
     * Constructor de la clase
     */
    public EstadoDAO(){
  
    }
    
    /**
     * Registra una nueva Tarifa en la base de datos.
     * @param tarifa Tarifa a insetar en la base de datos.
     * @throws RHException 
     */ 
    public void registrarEstado(Estado estado) throws RHException {
      try {
        //Prepara la inserción de una Tarifa en la base de datos        
        String strSQL = "INSERT INTO estado (k_idEstado, n_estadoRegistrado, f_fecha, n_comentario,"
                + " k_numeroDeServicio ) VALUES(?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar la inserción de la Tarifa en la base de datos.
        prepStmt.setInt(1, estado.getK_idEstado()); 
        prepStmt.setString(2, estado.getN_estadoRegistrado()); 
        prepStmt.setDate(3, java.sql.Date.valueOf(estado.getF_fecha())); 
        prepStmt.setString(4, estado.getN_comentario()); 
        prepStmt.setInt(5, estado.getK_numeroDeServicio());   
          

        // Ejecuta la inserción de la nueva tarifa y el commit en la base de datos.
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de ocurrir un error en la creación de la Tarifa realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo insertar la Tarifa.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "Estado DAO", "No pudo crear la tarifa"+ e.getMessage());
      }  finally {
          // Libera la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
    
    
     public Estado buscarEstado(int k_idEstado) throws RHException {
        boolean existe = false;
        try {
            Estado e = new Estado(); //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT k_idEstado, n_estadoRegistrado, f_fecha, n_comentario, k_numeroDeServicio"
                    + " FROM estado WHERE k_idEstado = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_idEstado);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                //Asignación de los valores getResult al objeto empleado.
                e.setK_idEstado(rs.getInt(1));
                e.setN_estadoRegistrado(rs.getString(2));
                e.setF_fecha(rs.getDate( 3).toString()); 
                e.setN_comentario(rs.getString(4));
                e.setK_numeroDeServicio(rs.getInt(5));
             
                existe = true;
            }
            if (existe) 
                //Si encontro al empleado, devuelve el objeto empleado. 
                return e;
             else
                //Si no encontro al empleado, devuelve null.
                return null;
        } catch (SQLException e) {
            //captura y lanza la excepción RHException.
            throw new RHException("EstadoDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
 }