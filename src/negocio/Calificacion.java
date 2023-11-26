/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * Clase que encapsula los datos de la Calificación de un servicio.
 * @author David
 */
public class Calificacion {
    private int     k_idCalificacion;
    private float   v_valor;
    private String  n_comentario;
    private int     k_numeroDocumento;
    private String  k_tipoDocumento;

    public Calificacion() {
    }

    public int getK_idCalificacion() {
        return k_idCalificacion;
    }

    public void setK_idCalificacion(int k_idCalificacion) {
        this.k_idCalificacion = k_idCalificacion;
    }

    public float getV_valor() {
        return v_valor;
    }

    public void setV_valor(float v_valor) {
        this.v_valor = v_valor;
    }

    public String getN_comentario() {
        return n_comentario;
    }

    public void setN_comentario(String n_comentario) {
        this.n_comentario = n_comentario;
    }

    public int getK_numeroDocumento() {
        return k_numeroDocumento;
    }

    public void setK_numeroDocumento(int k_numeroDocumento) {
        this.k_numeroDocumento = k_numeroDocumento;
    }

    public String getK_tipoDocumento() {
        return k_tipoDocumento;
    }

    public void setK_tipoDocumento(String k_tipoDocumento) {
        this.k_tipoDocumento = k_tipoDocumento;
    }
    
    
    
    
    
}
