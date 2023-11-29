/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.Actividad;
import negocio.Servicio;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author amirz
 */
public class ActividadDAO {

    public ActividadDAO() {
        
    }
    
    public void registrarActividad(Actividad actividad) throws RHException {
        try {
            String strSQL = "INSERT INTO Actividad (k_numeroDeTrayecto, n_descripcion, n_direccion, k_numeroDeServicio)"
                + " VALUES(?, ?, ?, ?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, actividad.getK_numeroDeTrayecto());
            prepStmt.setString(2, actividad.getN_descripcion());
            prepStmt.setString(3, actividad.getN_direccion());
            prepStmt.setInt(4, actividad.getK_numeroDeServicio());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        } catch(SQLException e) {
          // En caso de error en la creación del Mensajero realiza un rollback y lanza la excepción
          // RHExceptión mostranto de que no pudo registrar el Mensajero
           ServiceLocator.getInstance().rollback();
           throw new RHException( "ActividadDAO", "No pudo crear la actividad"+ e.getMessage());
      }  finally {
          // Finaliza la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
    }
    
    public ArrayList<Actividad> actividadPorServicios(long k_numeroDeServicio) throws RHException {
        ArrayList<Actividad> actividades = new ArrayList<>();
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            String strSQL = "SELECT n_descripcion, n_direccion FROM Servicio "
                    + "JOIN Actividad ON Servicio.k_numeroDeServicio = Actividad.k_numeroDeServicio "
                    + "WHERE servicio.k_numeroDeServicio = ? ";
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setLong(1, k_numeroDeServicio);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Actividad actividad = new Actividad();
                actividad.setN_descripcion(rs.getString("n_descripcion"));
                actividad.setN_direccion(rs.getString("n_direccion"));
                actividades.add(actividad);
            }
        } catch (SQLException e) {
            throw new RHException("ActividadDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
        return actividades;
    }
}
