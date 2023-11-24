package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Clase ventana _AboutBoxPanel1 que representa un panel para mostrar la información "About"
 * @author Soky
 */

public class Ventana_AboutBoxPanel1 extends JPanel {
    //Declaración de los componentes del panel.
    private JLabel labelTitle = new JLabel();
    private JLabel labelAuthor = new JLabel();
    private JLabel labelCopyright = new JLabel();
    private JLabel labelCompany = new JLabel();
    private GridBagLayout layoutMain = new GridBagLayout();
    private Border border = BorderFactory.createEtchedBorder();

    /**
     * Constructor de la clase Ventana_AboutBoxPanel1.
     * Inicializa y configura los componentes del panel.
     */
    
    public Ventana_AboutBoxPanel1() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa y configura los componentes del panel.
     * @throws Exception Lanza la excepción en caso de ocurrir un error durante la inicialización.
     */
    
    private void jbInit() throws Exception {
        //Configuración del panel y los componentes .
        this.setLayout( layoutMain );
        this.setBorder( border );
        
        //Configuración de los textos de los JLabels.
        labelTitle.setText( "Title" );
        labelAuthor.setText( "Author" );
        labelCopyright.setText( "Copyright" );
        labelCompany.setText( "Company" );
        
        //Agragar los componentes al panel usando GridBagConstraints.
        this.add( labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0) );
        this.add( labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
        this.add( labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
        this.add( labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 5, 15), 0, 0) );
    }
}
