/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.PagoServicio;
import util.RHException;
import util.ServiceLocator;

/**
 * Esta clase encapsula la interacción con la base de datos para la entidad PagoServicio
 * @author Soky
 */
public class PagoServicioDAO {
    /*
     * Constructor de la clase
     */
    public PagoServicioDAO(){
  
    }

    /**
     * Registra un nuevo Pago de Servicio en la base de datos.
     * @param pagoServicio Objeto PagoServicio a insertar en la base de datos.
     * @throws RHException 
     */
    public void registrarPagoServicio(PagoServicio pagoServicio) throws RHException {
      try {
        //prepara la inserción de un nuevo Pago de Servicio en la base de datos.
        String strSQL = "INSERT INTO pagoservicio (k_referenciaPago, n_tipoPago, q_valor,"
                + " n_estado, k_numeroDeServicio) VALUES(?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        //Establece los parametros a insertar el Pago de Servicio
        prepStmt.setString(1, pagoServicio.getK_referenciaPago()); 
        prepStmt.setString(2, pagoServicio.getN_tipoPago()); 
        prepStmt.setInt(3, pagoServicio.getQ_valor()); 
        prepStmt.setString(4, pagoServicio.getN_estado()); 
        prepStmt.setInt(5, pagoServicio.getK_numeroDeServicio());   
     
        //Ejecuta la inserción del Pago del Servicio y realiza el commit en la base de datos
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           // En caso  de error en la creación del Pago del Servicio realiza un rollback y lanza la excepción
           // RHExpception mostrando que no se pudo registrar el Pago del Servicio.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "Tarifa DAO", "No pudo crear la tarifa"+ e.getMessage());
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
     
 }