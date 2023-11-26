/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * Clase que encapsula los datos del Pago que debe realizar el solicitante por el Servicio.
 * @author David
 */
public class PagoServicio {
    private String k_referenciaPago;
    private String n_tipoPago;
    private int    q_valor;
    private String n_estado;
    private int k_numeroDeServicio;

    public PagoServicio() {
    }

    public String getK_referenciaPago() {
        return k_referenciaPago;
    }

    public void setK_referenciaPago(String k_referenciaPago) {
        this.k_referenciaPago = k_referenciaPago;
    }

    

    public String getN_tipoPago() {
        return n_tipoPago;
    }

    public void setN_tipoPago(String n_tipoPago) {
        this.n_tipoPago = n_tipoPago;
    }

    public int getQ_valor() {
        return q_valor;
    }

    public void setQ_valor(int q_valor) {
        this.q_valor = q_valor;
    }

    public String getN_estado() {
        return n_estado;
    }

    public void setN_estado(String n_estado) {
        this.n_estado = n_estado;
    }

    public int getK_numeroDeServicio() {
        return k_numeroDeServicio;
    }

    public void setK_numeroDeServicio(int k_numeroDeServicio) {
        this.k_numeroDeServicio = k_numeroDeServicio;
    }

   
    
}
