/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Actividad;
import negocio.Jornada;
import util.RHException;
import util.ServiceLocator;

/**
 *
 * @author amirz
 */
public class JornadaDAO {
    
    public JornadaDAO() {
        
    }
    
    public void registrarJornada(Jornada jornada) throws RHException {
        try {
            String strSQL = "INSERT INTO Jornada (k_jornada, n_diaServicio, f_horaInicial, f_horaFinal, k_numeroDocumento, k_tipoDocumento)"
                + " VALUES(?, ?, ?, ?, ?, ?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            
            prepStmt.setInt(1, jornada.getK_jornada());
            prepStmt.setString(2, jornada.getN_diaServicio());
            prepStmt.setTime(3, jornada.getF_horaInicial());
            prepStmt.setTime(4, jornada.getF_horaFinal());
            prepStmt.setLong(5, jornada.getK_numeroDocumento());
            prepStmt.setString(6, jornada.getK_tipoDocumento());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            
        } catch(SQLException e) {
          // En caso de error en la creación del Mensajero realiza un rollback y lanza la excepción
          // RHExceptión mostranto de que no pudo registrar el Mensajero
           ServiceLocator.getInstance().rollback();
           throw new RHException( "JornadaDAO", "No pudo crear la jornada"+ e.getMessage());
      }  finally {
          // Finaliza la conexión con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
    } 
}
