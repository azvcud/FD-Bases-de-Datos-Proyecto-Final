/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Actividad;
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
}
