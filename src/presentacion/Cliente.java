package presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * Clase que representa la aplicación principal
 * @author Soky
 */
public class Cliente {
    
    /**
     * Constructo de la clase Cliente.
     * Crea y muestra una ventana centrada al iniciar la aplicaión.
     */
    
    public Cliente() {
        //Creacion de una nueva ventana y ajuste de su posición en la pantalla.
        JFrame frame = new Ventana();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }

    /**
     * Metodo principal de la aplicacíón.
     * Configura la apariencia y comportamiento del sistema y crea una instancia cliente.   
     * 
     * @param args 
     */
    public static void main(String[] args) {
        try {
            //Configuración de la apariencia y comportamiento del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Creacion de una instancia cliente que permita iniciar el sismtema
        new Cliente();
    }
}
