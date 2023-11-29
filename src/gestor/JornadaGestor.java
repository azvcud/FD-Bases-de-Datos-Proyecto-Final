/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import datos.JornadaDAO;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import negocio.Jornada;
import util.RHException;


/**
 *
 * @author amirz
 */
public class JornadaGestor {
    private Jornada jornada;
    private JornadaDAO jornadaDAO;
    
    public JornadaGestor(){
        jornadaDAO = new JornadaDAO();
    }

    public void registrarJornada(int k_jornada, String n_diaServicio, String f_horaInicial, String f_horaFinal, long k_numeroDocumento, String k_tipoDocumento) throws RHException, ParseException {
        jornada = new Jornada();
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date parsingFecha1 = formatoHora.parse(f_horaInicial);
        Date parsingFecha2 = formatoHora.parse(f_horaFinal);
        
        Time tiempoInicial = new Time(parsingFecha1.getTime());
        Time tiempoFinal = new Time(parsingFecha2.getTime());
        
        jornada.setK_jornada(k_jornada);
        jornada.setN_diaServicio(n_diaServicio);
        jornada.setF_horaInicial(tiempoInicial);
        jornada.setF_horaFinal(tiempoFinal);
        jornada.setK_numeroDocumento(k_numeroDocumento);
        jornada.setK_tipoDocumento(k_tipoDocumento);
        
        jornadaDAO.registrarJornada(jornada);
    }
}