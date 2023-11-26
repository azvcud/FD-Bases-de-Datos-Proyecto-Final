/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.sql.Time;
import java.time.LocalTime;

/**
 * Clase que encapsula los datos de un Servicio.
 * @author David
 */
public class Servicio {
   private int    k_numeroDeServicio;
   private String n_tipoDeServicio;
   private String f_horaDeInicio;
   private String f_fecha;
   private double q_calificacion;
   private int    q_cantidadDeTrayectos; 
   private int    k_numeroDocumentoM;
   private String k_tipoDocumentoM;
   private int    k_idCiudad;
   private int    k_numeroDocumentoS;
   private String k_tipoDocumentoS;

    public Servicio() {
    }

    public int getK_numeroDeServicio() {
        return k_numeroDeServicio;
    }

    public void setK_numeroDeServicio(int k_numeroDeServicio) {
        this.k_numeroDeServicio = k_numeroDeServicio;
    }

    public String getN_tipoDeServicio() {
        return n_tipoDeServicio;
    }

    public void setN_tipoDeServicio(String n_tipoDeServicio) {
        this.n_tipoDeServicio = n_tipoDeServicio;
    }

    public String getF_horaDeInicio() {
        return f_horaDeInicio;
    }

    public void setF_horaDeInicio(String f_horaDeInicio) {
        this.f_horaDeInicio = f_horaDeInicio;
    }

    

    

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public double getQ_calificacion() {
        return q_calificacion;
    }

    public void setQ_calificacion(double q_calificacion) {
        this.q_calificacion = q_calificacion;
    }

    public int getQ_cantidadDeTrayectos() {
        return q_cantidadDeTrayectos;
    }

    public void setQ_cantidadDeTrayectos(int q_cantidadDeTrayectos) {
        this.q_cantidadDeTrayectos = q_cantidadDeTrayectos;
    }

    public int getK_numeroDocumentoM() {
        return k_numeroDocumentoM;
    }

    public void setK_numeroDocumentoM(int k_numeroDocumentoM) {
        this.k_numeroDocumentoM = k_numeroDocumentoM;
    }

    public String getK_tipoDocumentoM() {
        return k_tipoDocumentoM;
    }

    public void setK_tipoDocumentoM(String k_tipoDocumentoM) {
        this.k_tipoDocumentoM = k_tipoDocumentoM;
    }

    public int getK_numeroDocumentoS() {
        return k_numeroDocumentoS;
    }

    public void setK_numeroDocumentoS(int k_numeroDocumentoS) {
        this.k_numeroDocumentoS = k_numeroDocumentoS;
    }

    public String getK_tipoDocumentoS() {
        return k_tipoDocumentoS;
    }

    public void setK_tipoDocumentoS(String k_tipoDocumentoS) {
        this.k_tipoDocumentoS = k_tipoDocumentoS;
    }

   

    public int getK_idCiudad() {
        return k_idCiudad;
    }

    public void setK_idCiudad(int k_idCiudad) {
        this.k_idCiudad = k_idCiudad;
    }

   
    
   
}
