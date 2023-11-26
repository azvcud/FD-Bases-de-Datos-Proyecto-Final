/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * Clase que encapsula los datos del Pago a realizar al mensajero.
 * @author David
 */
public class PagoMensajero {
    private int    k_referenciaPago;
    private float  v_valorPago;
    private String f_fechaPago;
    private int    k_numeroDocumento;
    private String k_tipoDocumento;

    public PagoMensajero() {
    }

    public int getK_referenciaPago() {
        return k_referenciaPago;
    }

    public void setK_referenciaPago(int k_referenciaPago) {
        this.k_referenciaPago = k_referenciaPago;
    }

    public float getV_valorPago() {
        return v_valorPago;
    }

    public void setV_valorPago(float v_valorPago) {
        this.v_valorPago = v_valorPago;
    }

    public String getF_fechaPago() {
        return f_fechaPago;
    }

    public void setF_fechaPago(String f_fechaPago) {
        this.f_fechaPago = f_fechaPago;
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
