/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author David
 */
public class Solicitante {
    private int    k_numeroDocumento;
    private String k_tipoDocumento;
    private String n_primerNombre;
    private String n_segundoNombre;
    private String n_primerApellido;
    private String n_segundoApellido;
    private String n_sexo;
    private int    q_telefono;
    private String n_correoElectronico;
    private String n_direccion;

    public Solicitante() {
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

    public String getN_primerNombre() {
        return n_primerNombre;
    }

    public void setN_primerNombre(String n_primerNombre) {
        this.n_primerNombre = n_primerNombre;
    }

    public String getN_segundoNombre() {
        return n_segundoNombre;
    }

    public void setN_segundoNombre(String n_segundoNombre) {
        this.n_segundoNombre = n_segundoNombre;
    }

    public String getN_primerApellido() {
        return n_primerApellido;
    }

    public void setN_primerApellido(String n_primerApellido) {
        this.n_primerApellido = n_primerApellido;
    }

    public String getN_segundoApellido() {
        return n_segundoApellido;
    }

    public void setN_segundoApellido(String n_segundoApellido) {
        this.n_segundoApellido = n_segundoApellido;
    }

    public String getN_sexo() {
        return n_sexo;
    }

    public void setN_sexo(String n_sexo) {
        this.n_sexo = n_sexo;
    }

    public int getQ_telefono() {
        return q_telefono;
    }

    public void setQ_telefono(int q_telefono) {
        this.q_telefono = q_telefono;
    }

    public String getN_correoElectronico() {
        return n_correoElectronico;
    }

    public void setN_correoElectronico(String n_correoElectronico) {
        this.n_correoElectronico = n_correoElectronico;
    }

    public String getN_direccion() {
        return n_direccion;
    }

    public void setN_direccion(String n_direccion) {
        this.n_direccion = n_direccion;
    }   
}
