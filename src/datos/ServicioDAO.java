/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
                + " q_cantidadDeTrayectos, v_costoTotal, k_idCiudad, k_numeroDocumentoS, k_tipoDocumentoS) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        // Establece los parametros para insertar el Servicio
        prepStmt.setInt(1, servicio.getK_numeroDeServicio()); 
        prepStmt.setString(2, servicio.getN_tipoDeServicio());
        Date FyH = new Date();
        prepStmt.setTime(3, new Time(FyH.getHours(),FyH.getMinutes(),FyH.getSeconds())); 
        prepStmt.setDate(4, new java.sql.Date(FyH.getYear(),FyH.getMonth(),FyH.getDay()));
        prepStmt.setInt(5, servicio.getQ_cantidadDeTrayectos());
        prepStmt.setFloat(6, servicio.getV_costoTotal());
        prepStmt.setInt(7, servicio.getK_idCiudad());
        prepStmt.setInt(8, servicio.getK_numeroDocumentoS());
        prepStmt.setString(9, servicio.getK_tipoDocumentoS());
       
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
    
   public List<Servicio> buscarServiciosPorDocumentoSolicitante(long k_numeroDocumento) throws RHException {
        List<Servicio> servicios = new ArrayList<>();
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            String strSQL = "SELECT k_numerodeservicio, n_tipodeservicio, f_fecha, v_costototal, k_numerodocumentos FROM servicio WHERE servicio.k_numerodocumentos = ?";
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_numeroDocumento);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setK_numeroDeServicio(rs.getInt("k_numerodeservicio"));
                servicio.setN_tipoDeServicio(rs.getString("n_tipodeservicio"));
                
                // Convertir el Date a String antes de asignarlo al objeto Servicio
                Date fecha = rs.getDate("f_fecha");
                String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
                servicio.setF_fecha(fechaStr);
                
                servicio.setV_costoTotal((float) rs.getDouble("v_costototal"));
                servicio.setK_numeroDocumentoS(rs.getInt("k_numerodocumentos"));
                servicios.add(servicio);
            }
            ServiceLocator.getInstance().liberarConexion();
        } catch (SQLException e) {
            throw new RHException("ServicioDAO", e.getMessage());
        }
        return servicios;
    }
   
    public List<Servicio> buscarServiciosPorDocumentoMensajero(String n_tipodeservicio) throws RHException {
        List<Servicio> servicios = new ArrayList<>();
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            String strSQL = "SELECT k_numerodeservicio, n_tipodeservicio, f_fecha, v_costototal, k_numerodocumentos FROM servicio WHERE servicio.n_tipodeservicio = ?";
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, n_tipodeservicio);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setK_numeroDeServicio(rs.getInt("k_numerodeservicio"));
                servicio.setN_tipoDeServicio(rs.getString("n_tipodeservicio"));
                
                // Convertir el Date a String antes de asignarlo al objeto Servicio
                Date fecha = rs.getDate("f_fecha");
                String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
                servicio.setF_fecha(fechaStr);
                
                servicio.setV_costoTotal((float) rs.getDouble("v_costototal"));
                servicio.setK_numeroDocumentoS(rs.getInt("k_numerodocumentos"));
                servicios.add(servicio);
            }
            ServiceLocator.getInstance().liberarConexion();
        } catch (SQLException e) {
            throw new RHException("ServicioDAO", e.getMessage());
        }
        return servicios;
    }
   
     public void añadirMensajero(int k_numerodeservicio, long k_numeroDocumentoM, String k_tipoDocumentom) throws RHException {
            
           try{
                //Actualiza el mensajero del empleado en la base de datos.

                String strSQL = "UPDATE servicio SET k_numerodocumentom = ?, k_tipodocumentom=?"
                        + "WHERE servicio.k_numerodeservicio = ? ";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setLong(3, k_numerodeservicio);
                prepStmt.setLong(1,k_numeroDocumentoM);
                prepStmt.setString(2,k_tipoDocumentom);
               
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
         } 
}
