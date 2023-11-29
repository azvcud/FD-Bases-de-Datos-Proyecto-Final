/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.ActividadDAO;
import java.util.ArrayList;
import negocio.Actividad;
import util.RHException;

/**
 *
 * @author amirz
 */
public class ActividadGestor {
    private Actividad actividad;
    private ActividadDAO actividadDAO;
    
    public ActividadGestor(){
        actividadDAO = new ActividadDAO();
    }

    public void registrarActividad(int k_numeroDeTrayecto, String n_descripcion, String n_direccion, int k_numeroDeServicio) throws RHException {
        actividad = new Actividad();
        
        actividad.setK_numeroDeTrayecto(k_numeroDeTrayecto);
        actividad.setN_descripcion(n_descripcion);
        actividad.setN_direccion(n_direccion);
        actividad.setK_numeroDeServicio(k_numeroDeServicio);
        
        actividadDAO.registrarActividad(actividad);
    }
    
    public ArrayList<Actividad> listaActividades(long k_numeroDeServicio) throws RHException {
        ArrayList<Actividad> listaActividades = new ArrayList<>();
        listaActividades = actividadDAO.actividadPorServicios(k_numeroDeServicio);
        return listaActividades;
    }
}
