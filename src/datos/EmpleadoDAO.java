//Clase a ELIMINAR

package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import negocio.Empleado;

import util.RHException;
import util.ServiceLocator;

/**
 * @author Alba Consuelo Nieto.
 * Esta clase encapsula el acceso a la Base de Datos
 */
public class EmpleadoDAO {
    /*
     * Constructor de la clase
     */
    public EmpleadoDAO(){
  
    }
    /**
     * Incluye una nueva fila en la tabla EMPLOYEES.
     * @throws RHException
     */
    public void incluirEmpleado(Empleado empleado) throws RHException {
      try {
        //Prepara la inseción de un empleado en la base de datos.
        String strSQL = "INSERT INTO employees (employee_id, first_name, last_name, job_id, email,salary, hire_date) VALUES(?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1,empleado.getEmployee_id()); 
        prepStmt.setString(2, empleado.getFirst_name()); 
        prepStmt.setString(3, empleado.getLast_name()); 
        prepStmt.setString(4, empleado.getJob_id()); 
        prepStmt.setString(5, empleado.getEmail());   
        prepStmt.setDouble(6, empleado.getSalary());  
        prepStmt.setDate(7, java.sql.Date.valueOf(empleado.getHire_date()));
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
      } catch (SQLException e) {
           //En caso de un error en la creación del empleado realiza un rollback y lanza la excepción 
           //RHException indicando que no se pudo crear el empleado.
           ServiceLocator.getInstance().rollback();
           throw new RHException( "EmpleadoDAO", "No pudo crear el empleado"+ e.getMessage());
      }  finally {
         //finaliza la coneccion con la base de datos.
         ServiceLocator.getInstance().liberarConexion();
      }
      
    }
    
    public void modificarEmpleado(){
      //implementar
    }
    
    public void eliminarEmpleado(){
      //implementar
    }
    
    /**
     * Busca en la base de datos un empleado por su ID
     * @param employee_id Id del empleado a buscar.
     * @return El objeto empleado correspondiente al ID ó null en caso de no encontrarse.
     * @throws RHException Si ocurre un error en la interación con la BD
     */
    public Empleado buscarEmpleado(Integer employee_id) throws RHException {
        boolean existe = false;
        try {
            Empleado e = new Empleado(); //Instancia el objeto para retornar los datos del empleado
            String strSQL = "SELECT employee_id, first_name, last_name, job_id, email, hire_date FROM employees WHERE employee_id = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, employee_id);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                //Asignación de los valores getResult al objeto empleado.
                e.setEmployee_id(rs.getInt(1));
                e.setFirst_name(rs.getString(2));
                rs.getString(3);
                rs.getString(4);
                rs.getString(5);
                rs.getDate(6);
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
            throw new RHException("EmpleadoDAO", e.getMessage());
        } finally {
            //finaliza la coneccion con la base de datos.
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    /**
     * Busca el empleado identificado por el ID y actualiza su salario en la Base de datos.
     * @param id        Id del empleado cuyo salario será actualizado.
     * @param salario   nuevo salario a actualizar en la base de datos
     * @throws RHException 
     */
    public void actualizarSalario(int id, Double salario) throws RHException {
            //verifica que el objeto empleado exista.
            if (buscarEmpleado(id) != null) {
                try{
                //Actualiza el salario del empleado en la base de datos.
                String strSQL = "UPDATE employees SET salary = ? WHERE employee_id = ? ";
                Connection conexion = ServiceLocator.getInstance().tomarConexion();
                PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
                prepStmt.setInt(1, id);
                prepStmt.setDouble(2, salario);
                prepStmt.executeUpdate();
                prepStmt.close();
                ServiceLocator.getInstance().commit();
                }
               catch (SQLException e) {
                    //En caso de un error realiza un rollback y lanza la excepción RHException.
                    ServiceLocator.getInstance().rollback();
                    throw new RHException("EmpleadoDAO", "No pudo modificar salario " + e.getMessage());
                 } finally {
                    //finaliza la coneccion con la base de datos.
                      ServiceLocator.getInstance().liberarConexion();
                 }
            } else {
                //Si el empleado no existe, lanza una excepción indicando que no se puede actualizar el salario.
                 throw new RHException("EmpleadoDAO", "Empleado no existe ");
            }
         
    }
 }


