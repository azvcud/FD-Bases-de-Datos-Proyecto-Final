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

/**
 * Esta clase encapsula el acceso a la base de datos por parte del Solicitante.
 * @author Soky
 */
public class SolicitanteDAO {
    /*
     * Constructor de la clase
     */
    
    
    //Creditos a Alba Consuelo Nieto.
    public SolicitanteDAO(){
  
    }
    
    /**
     * Registra un nuevo usuario Solicitante en la base de datos.
     * @param solicitante Objeto Solicitante a registrar en la base de datos.
     * @throws RHException 
     */
    public void registrarSolicitante(Solicitante solicitante) throws RHException {
      try {
        // Prepara la inserción de un nuevo Solicitante en la base de datos.
        String strSQL = "INSERT INTO solicitante (k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                + " n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        //Establece los parametros a insertar el Solicitane
        prepStmt.setLong(1, solicitante.getK_numeroDocumento()); 
        prepStmt.setString(2, solicitante.getK_tipoDocumento()); 
        prepStmt.setString(3, solicitante.getN_primerNombre()); 
        prepStmt.setString(4, solicitante.getN_segundoNombre()); 
        prepStmt.setString(5, solicitante.getN_primerApellido());   
        prepStmt.setString(6, solicitante.getN_segundoApellido()); 
        prepStmt.setString(7, solicitante.getN_sexo());   
        prepStmt.setLong(8, solicitante.getQ_telefono());
        prepStmt.setString(9, solicitante.getN_correoElectronico());   
        prepStmt.setString(10, solicitante.getN_direccion());  
        //Ejecuta el registro del solicitante en la base de datos
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
          // En caso de error en el registro del Solicitante realiza un rollback y lanza la excepción
          // RHException mostrando que no se pudo realizar el registro del Solicitante.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "SolicitanteDAO", "No pudo crear el solicitante"+ e.getMessage());
      }  finally {
         //Libera la conexción con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
    public Solicitante buscarSolicitante(long k_numeroDocumento) throws RHException {
        boolean existe = false;
        try {
            Solicitante e = new Solicitante(); //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                    + "n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion"
                    + " FROM solicitante WHERE k_numeroDocumento = ?";
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
            throw new RHException("SolicitanteDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
   
    
    public void modificarSolicitante(long k_numeroDocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion) throws RHException {
            //verifica que el objeto empleado exista.
            if (buscarSolicitante(k_numeroDocumento) != null) {
                try{
                //Actualiza el salario del empleado en la base de datos.

                String strSQL = "UPDATE solicitante SET n_primerNombre = ?, n_segundonombre=?,"
                        + "n_primerapellido=?, n_segundoapellido=?, n_sexo=?,"
                        + " q_telefono=?, n_correoelectronico=?,n_direccion=?  WHERE k_numeroDocumento = ? ";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setLong(9, k_numeroDocumento);
                prepStmt.setString(1,n_primerNombre);
                prepStmt.setString(2,n_segundonombre);
                prepStmt.setString(3,n_primerapellido);
                prepStmt.setString(4,n_segundoapellido);
                prepStmt.setString(5,n_sexo);
                prepStmt.setInt(6,q_telefono);
                prepStmt.setString(7,n_correoelectronico);
                prepStmt.setString(8,n_direccion);
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
    
    public void eliminarSolicitante(long k_numeroDocumento)throws RHException {
            
        if (buscarSolicitante(k_numeroDocumento) != null) {
                try{
                //Elimina al usuario
            
                String strSQL = "DELETE FROM solicitante WHERE k_numeroDocumento=?";
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
                    throw new RHException("SolicitanteDAO", "No pudo borrar al soliciante " + e.getMessage());
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

