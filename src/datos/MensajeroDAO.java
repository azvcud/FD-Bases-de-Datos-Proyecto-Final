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
    
    
     public Mensajero buscarMensajero(Integer k_numeroDocumento) throws RHException {
        boolean existe = false;
        try {
            Mensajero e = new Mensajero(); //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT k_numeroDocumento, k_tipodocumento, n_primerNombre, n_segundonombre,"
                    + "n_primerapellido, n_segundoapellido, n_sexo, q_telefono, n_correoelectronico,n_direccion,"
                    + "n_nacionalidad, q_seguridadsocial, n_mediodeservicio, n_mediodetransporte,"
                    + "n_matricula, n_marca, v_pago, v_calificacion"
                    + " FROM solicitante WHERE k_numeroDocumento = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, k_numeroDocumento);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                //Asignación de los valores getResult al objeto empleado.
                e.setK_numeroDocumento(rs.getInt(1));
                e.setK_tipoDocumento(rs.getString(2));
                e.setN_primerNombre(rs.getString(3)); 
                e.setN_segundoNombre(rs.getString(4));
                e.setN_primerApellido(rs.getString(5));
                e.setN_segundoApellido(rs.getString(6));
                e.setN_sexo(rs.getString(7));
                e.setQ_telefono(rs.getInt(8));
                e.setN_correoElectronico(rs.getString(9));
                e.setN_direccion(rs.getString(10));
                e.setN_nacionalidad(rs.getString(11));
                e.setQ_seguridadSocial(rs.getInt(12));
                e.setM_medioDeServicio(rs.getString(13));
                e.setM_medioDeTransporte(rs.getString(14));
                e.setM_matricula(rs.getString(15));
                e.setM_marca(rs.getString(16));
                e.setV_pago(rs.getDouble(17));
                e.setV_calificacion(rs.getDouble(18));
                
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
    
   
    
    public void modificarMensajero(int k_numeroDocumento, String n_primerNombre, String n_segundonombre,
             String n_primerapellido, String n_segundoapellido, String n_sexo,int q_telefono, String n_correoelectronico, String n_direccion) throws RHException {
            //verifica que el objeto empleado exista.
            if (buscarMensajero(k_numeroDocumento) != null) {
                try{
                //Actualiza el salario del empleado en la base de datos.

                String strSQL = "UPDATE mensajero SET n_primerNombre = ?, n_segundonombre=?,"
                        + "n_primerapellido=?, n_segundoapellido=?, n_sexo=?,"
                        + " q_telefono=?, n_correoelectronico=?,n_direccion=?  WHERE k_numeroDocumento = ? ";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setInt(9, k_numeroDocumento);
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
    
    public void eliminarMensajero(int k_numeroDocumento)throws RHException {
            
        if (buscarMensajero(k_numeroDocumento) != null) {
                try{
                //Elimina al usuario
            
                String strSQL = "DELETE FROM mensajero WHERE k_numeroDocumento=?";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setInt(1, k_numeroDocumento);
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


