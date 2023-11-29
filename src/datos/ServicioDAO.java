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
import java.time.LocalTime;
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
    
   public List<Servicio> buscarServiciosPorDocumento(long k_numeroDocumento) throws RHException {
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
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
        return servicios;
    }
   
       
    public Object[] servicioSolicitante(long k_numeroDeServicio) throws RHException {
        Object[] objetoConsulta;
        try {
            String strSQL = "SELECT Solicitante.k_numeroDocumento, n_primerNombre,"
                    + " f_horaDeInicio, Servicio.f_fecha, n_tipoDeServicio, n_estadoRegistrado, v_costoTotal "
                    + "FROM Servicio WHERE Servicio.k_numeroDeServicio = ? "
                    + "JOIN Solicitante ON Solicitante.k_numeroDocumento = Servicio.k_numeroDeServicio "
                    + "JOIN Estado ON Estado.k_numeroDeServicio = Servicio.k_numeroDeServicio";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_numeroDeServicio);
            ResultSet rs = prepStmt.executeQuery();
            
            objetoConsulta = new Object[7];
            objetoConsulta[0] = rs.getLong("k_numeroDocumento");
            objetoConsulta[1] = rs.getString("n_primerNombre");
            
            LocalTime tiempoLocal = rs.getTime("f_horaDeInicio").toLocalTime();
            String horaInicio = tiempoLocal.toString();
            objetoConsulta[2] = horaInicio;
            
            // Convertir el Date a String antes de asignarlo al objeto Servicio
            Date fecha = rs.getDate("f_fecha");
            String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
            objetoConsulta[3] = fechaStr;
            
            objetoConsulta[4] = rs.getString("n_tipoDeServicio");
            objetoConsulta[5] = rs.getString("n_estadoRegistrado");
            objetoConsulta[6] = rs.getLong("v_costoTotal");
            
        } catch (SQLException e) {
            //captura y lanza la excepción RHException.
            throw new RHException("SolicitanteDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
        
        return objetoConsulta;
    }
    
    public Object[] mensajeroSolicitante(long k_numeroDeServicio) throws RHException {
        Object[] objetoConsulta;
        try {
            String strSQL = "SELECT Mensajero.n_primerNombre, n_medioDeTransporte, n_matricula"
                    + " FROM Servicio WHERE Servicio.k_numeroDeServicio = ? "
                    + "JOIN Solicitante ON Solicitante.k_numeroDocumento = Servicio.k_numeroDocumentoS "
                    + "JOIN Mensajero ON Mensajero.k_numeroDocumento = Servicio.k_numeroDocumentoM";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_numeroDeServicio);
            ResultSet rs = prepStmt.executeQuery();
            
            objetoConsulta = new Object[3];
            objetoConsulta[0] = rs.getString("n_primerNombre");
            objetoConsulta[1] = rs.getString("n_medioDeTransporte");
            objetoConsulta[2] = rs.getString("n_matricula");
            
        } catch (SQLException e) {
            //captura y lanza la excepción RHException.
            throw new RHException("SolicitanteDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
        
        return objetoConsulta;
    }
}