/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * Clase que encapsula los datos del Estado en que se encuentra una actividad.
 * @author David.
 */
public class Estado {
    private int    k_idEstado;
    private String n_estadoRegistrado;
    private String f_fecha;
    private String n_comentario;
    private int    k_numeroDeServicio;

    public Estado() {
    }

    public int getK_idEstado() {
        return k_idEstado;
    }

    public void setK_idEstado(int k_idEstado) {
        this.k_idEstado = k_idEstado;
    }

    public String getN_estadoRegistrado() {
        return n_estadoRegistrado;
    }

    public void setN_estadoRegistrado(String n_estadoRegistrado) {
        this.n_estadoRegistrado = n_estadoRegistrado;
    }

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public String getN_comentario() {
        return n_comentario;
    }

    public void setN_comentario(String n_comentario) {
        this.n_comentario = n_comentario;
    }

    public int getK_numeroDeServicio() {
        return k_numeroDeServicio;
    }

    public void setK_numeroDeServicio(int k_numeroDeServicio) {
        this.k_numeroDeServicio = k_numeroDeServicio;
    }
    
    
    
}
