/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * Clase que encapsula los datos de la Jornada del empleado.
 * @author David
 */
public class Jornada {
    private int    k_jornada;
    private String n_diaServicio;
    private String f_horaInicial;
    private String f_horaFinal;
    private int    k_numeroDocumento;
    private String k_tipoDocumento;

    public Jornada() {
    }

    public int getK_jornada() {
        return k_jornada;
    }

    public void setK_jornada(int k_jornada) {
        this.k_jornada = k_jornada;
    }

    public String getN_diaServicio() {
        return n_diaServicio;
    }

    public void setN_diaServicio(String n_diaServicio) {
        this.n_diaServicio = n_diaServicio;
    }

    public String getF_horaInicial() {
        return f_horaInicial;
    }

    public void setF_horaInicial(String f_horaInicial) {
        this.f_horaInicial = f_horaInicial;
    }

    public String getF_horaFinal() {
        return f_horaFinal;
    }

    public void setF_horaFinal(String f_horaFinal) {
        this.f_horaFinal = f_horaFinal;
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
