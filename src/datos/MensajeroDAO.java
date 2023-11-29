/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
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
        String strSQL = "INSERT INTO Mensajero (k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                + " n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion,"
                + " n_nacionalidad, q_seguridadsocial, n_mediodeservicio, n_mediodetransporte,"
                + " n_matricula, n_marca) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        //Establece los parametros para insertar el Mensajero
        prepStmt.setLong(1, mensajero.getK_numeroDocumento()); 
        prepStmt.setString(2, mensajero.getK_tipoDocumento()); 
        prepStmt.setString(3, mensajero.getN_primerNombre()); 
        prepStmt.setString(4, mensajero.getN_segundoNombre()); 
        prepStmt.setString(5, mensajero.getN_primerApellido());   
        prepStmt.setString(6, mensajero.getN_segundoApellido()); 
        prepStmt.setString(7, mensajero.getN_sexo());   
        prepStmt.setLong(8, mensajero.getQ_telefono());
        prepStmt.setString(9, mensajero.getN_correoElectronico());   
        prepStmt.setString(10, mensajero.getN_direccion());  
        prepStmt.setString(11, mensajero.getN_nacionalidad()); 
        prepStmt.setBoolean(12, mensajero.getQ_seguridadSocial()); 
        prepStmt.setString(13, mensajero.getM_medioDeServicio()); 
        prepStmt.setString(14, mensajero.getM_medioDeTransporte()); 
        prepStmt.setString(15, mensajero.getM_matricula());   
        prepStmt.setString(16, mensajero.getM_marca()); 
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
    
    
     public Mensajero buscarMensajero(long k_numeroDocumento) throws RHException {
        boolean existe = false;
        try {
            Mensajero e = new Mensajero(); //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                    + "n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion,"
                    + "n_nacionalidad, q_seguridadsocial, n_mediodeservicio, n_mediodetransporte,"
                    + "n_matricula, n_marca, v_pago, v_calificacion"
                    + " FROM mensajero WHERE k_numeroDocumento = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_numeroDocumento);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                //Asignación de los valores getResult al objeto empleado.
                e.setK_numeroDocumento(rs.getLong(1));
                e.setK_tipoDocumento(rs.getString(2));
                e.setN_primerNombre(rs.getString(3)); 
                e.setN_segundoNombre(rs.getString(4));
                e.setN_primerApellido(rs.getString(5));
                e.setN_segundoApellido(rs.getString(6));
                e.setN_sexo(rs.getString(7));
                e.setQ_telefono(rs.getLong(8));
                e.setN_correoElectronico(rs.getString(9));
                e.setN_direccion(rs.getString(10));
                e.setN_nacionalidad(rs.getString(11));
                e.setQ_seguridadSocial(rs.getBoolean(12));
                e.setM_medioDeServicio(rs.getString(13));
                e.setM_medioDeTransporte(rs.getString(14));
                e.setM_matricula(rs.getString(15));
                e.setM_marca(rs.getString(16));
                
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
            throw new RHException("MensajeroDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
   
    
    public void modificarMensajero(long k_numeroDocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,long q_telefono, String n_correoelectronico, String n_direccion,
             String n_nacionalidad, boolean q_seguridadsocial, String n_mediodeservicio, String n_mediodetransporte,
             String n_matricula, String n_marca) throws RHException {
            //verifica que el objeto empleado exista.
            if (buscarMensajero(k_numeroDocumento) != null) {
                try{
                //Actualiza el salario del empleado en la base de datos.

                String strSQL = "UPDATE mensajero SET n_primerNombre = ?, n_segundonombre=?,"
                        + "n_primerapellido=?, n_segundoapellido=?, n_sexo=?,"
                        + " q_telefono=?, n_correoelectronico=?,n_direccion=? "
                        + "n_nacionalidad=?, q_seguridadsocial=?, n_mediodeservicio=?, n_mediodetransporte=?,"
                        + "n_matricula=?, n_marca=?, v_pago=?, v_calificacion=?"
                        + " WHERE k_numeroDocumento = ? ";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setLong(16, k_numeroDocumento);
                prepStmt.setString(1,n_primerNombre);
                prepStmt.setString(2,n_segundonombre);
                prepStmt.setString(3,n_primerapellido);
                prepStmt.setString(4,n_segundoapellido);
                prepStmt.setString(5,n_sexo);
                prepStmt.setLong(6,q_telefono);
                prepStmt.setString(7,n_correoelectronico);
                prepStmt.setString(8,n_direccion);
                prepStmt.setString(9,n_nacionalidad);
                prepStmt.setBoolean(10,q_seguridadsocial);
                prepStmt.setString(11,n_mediodeservicio);
                prepStmt.setString(12,n_mediodetransporte);
                prepStmt.setString(13,n_matricula);
                prepStmt.setString(14,n_marca);
            

                prepStmt.executeUpdate();
                prepStmt.close();
                ServiceLocator.getInstance().commit();
                }
               catch (SQLException e) {
                    //En caso de un error realiza un rollback y lanza la excepción RHException.
                    ServiceLocator.getInstance().rollback();
                    throw new RHException("SolicitanteDAO", "No pudo modificar soliciante " + e.getMessage());
                 } finally {
                    //finaliza la coneccion con la base de datos.
                      ServiceLocator.getInstance().liberarConexion();
                 }
            } else {
                //Si el empleado no existe, lanza una excepción indicando que no se puede actualizar el salario.
                 throw new RHException("SolicitanteDAO", "No existe solicitante ");
            }
         
    }
    
    public void eliminarMensajero(long k_numeroDocumento)throws RHException {
            
        if (buscarMensajero(k_numeroDocumento) != null) {
                try{
                //Elimina al usuario
            
                String strSQL = "DELETE FROM mensajero WHERE k_numeroDocumento=?";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setLong(1, k_numeroDocumento);
                prepStmt.executeUpdate();
                prepStmt.close();
                ServiceLocator.getInstance().commit();
                }
               catch (SQLException e) {
                    //En caso de un error realiza un rollback y lanza la excepción RHException.
                    ServiceLocator.getInstance().rollback();
                    throw new RHException("MensajeroDAO", "No pudo borrar al mensajero " + e.getMessage());
                 } finally {
                    //finaliza la coneccion con la base de datos.
                      ServiceLocator.getInstance().liberarConexion();
                 }
            } else {
                //Si el empleado no existe, lanza una excepción indicando que no se puede actualizar el salario.
                 throw new RHException("SolicitanteDAO", "No existe solicitante ");
            }
    } 
     
 }