/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

/**
 * Vista que muestra el formulario de registro para un Mensajero nuevo.
 * @author amirz
 */
public class VistaRegistroMensajero extends javax.swing.JFrame {

    /**
     * Creates new form VistaRegistroMensajero
     */
    public VistaRegistroMensajero() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNumeroDocumento = new javax.swing.JTextField();
        numeroDocumento = new javax.swing.JLabel();
        tipoDocumento = new javax.swing.JLabel();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        primerNombre = new javax.swing.JLabel();
        tfPrimerNombre = new javax.swing.JTextField();
        tfSegundoNombre = new javax.swing.JTextField();
        segundoNombre = new javax.swing.JLabel();
        primerApellido = new javax.swing.JLabel();
        tfPrimerApellido = new javax.swing.JTextField();
        segundoApellido = new javax.swing.JLabel();
        tfSegundoApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        telefono = new javax.swing.JLabel();
        correoElectronico = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        nacionalidad = new javax.swing.JLabel();
        seguridadSocial = new javax.swing.JLabel();
        medioServicio = new javax.swing.JLabel();
        medioTransporte = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfCorreoElectronico = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        tfNacionalidad = new javax.swing.JTextField();
        cbSeguridadSocial = new javax.swing.JComboBox<>();
        cbMedioServicio = new javax.swing.JComboBox<>();
        cbMedioTransporte = new javax.swing.JComboBox<>();
        btnRegistrarMensajero = new javax.swing.JButton();
        registroMensajero = new javax.swing.JLabel();
        matricula = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        tfMatricula = new javax.swing.JTextField();
        tfMarca = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregarJornada = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJornada = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tfNumeroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroDocumentoActionPerformed(evt);
            }
        });

        numeroDocumento.setText("Número de documento");

        tipoDocumento.setText("Tipo de documento");

        cbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "TI", "RC", "CE" }));
        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        primerNombre.setText("Primer nombre");

        tfPrimerNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrimerNombreActionPerformed(evt);
            }
        });

        tfSegundoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSegundoNombreActionPerformed(evt);
            }
        });

        segundoNombre.setText("Segundo nombre");

        primerApellido.setText("Primer apellido");

        segundoApellido.setText("Segundo apellido");

        jLabel1.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino", "No binario" }));

        telefono.setText("Teléfono");

        correoElectronico.setText("Correo Electrónico");

        direccion.setText("Dirección");

        nacionalidad.setText("Nacionalidad");

        seguridadSocial.setText("Seguridad social");

        medioServicio.setText("Medio de servicio");

        medioTransporte.setText("Medio de transporte");

        tfCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCorreoElectronicoActionPerformed(evt);
            }
        });

        tfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionActionPerformed(evt);
            }
        });

        cbSeguridadSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        cbMedioServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Documento", "Factura", "Pequeño", "Mediano", "Grande" }));

        cbMedioTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motocicleta", "Bicicleta" }));

        btnRegistrarMensajero.setText("Registrar");
        btnRegistrarMensajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMensajeroActionPerformed(evt);
            }
        });

        registroMensajero.setText("Registro de mensajero");

        matricula.setText("Matrícula");

        marca.setText("Marca");

        btnCancelar.setText("Cancelar");

        btnAgregarJornada.setText("Añadir jornada");

        tablaJornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaJornada);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registroMensajero)
                .addGap(254, 254, 254))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numeroDocumento)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfNumeroDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tipoDocumento)
                                            .addComponent(primerNombre)
                                            .addComponent(segundoNombre)
                                            .addComponent(primerApellido)
                                            .addComponent(segundoApellido)
                                            .addComponent(jLabel1))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbTipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfPrimerNombre)
                                            .addComponent(tfSegundoNombre)
                                            .addComponent(tfPrimerApellido)
                                            .addComponent(tfSegundoApellido)
                                            .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfTelefono))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correoElectronico)
                                    .addComponent(direccion)
                                    .addComponent(nacionalidad)
                                    .addComponent(seguridadSocial)
                                    .addComponent(medioServicio)
                                    .addComponent(medioTransporte)
                                    .addComponent(matricula))
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(telefono)
                                .addGap(281, 281, 281)
                                .addComponent(marca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCorreoElectronico)
                            .addComponent(tfDireccion)
                            .addComponent(tfNacionalidad)
                            .addComponent(cbSeguridadSocial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMedioServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMedioTransporte, 0, 109, Short.MAX_VALUE)
                            .addComponent(tfMatricula)
                            .addComponent(tfMarca))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnCancelar)
                .addGap(79, 79, 79)
                .addComponent(btnRegistrarMensajero)
                .addGap(71, 71, 71)
                .addComponent(btnAgregarJornada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registroMensajero)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroDocumento)
                            .addComponent(tfNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoDocumento)
                            .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primerNombre)
                            .addComponent(tfPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segundoNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primerApellido)
                            .addComponent(tfPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(segundoApellido)
                            .addComponent(tfSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correoElectronico)
                            .addComponent(tfCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(direccion)
                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nacionalidad)
                            .addComponent(tfNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seguridadSocial)
                            .addComponent(cbSeguridadSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medioServicio)
                            .addComponent(cbMedioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(medioTransporte)
                            .addComponent(cbMedioTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matricula)
                    .addComponent(tfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrarMensajero)
                    .addComponent(btnAgregarJornada))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNumeroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroDocumentoActionPerformed

    private void tfPrimerNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrimerNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrimerNombreActionPerformed

    private void tfSegundoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSegundoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSegundoNombreActionPerformed

    private void tfCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCorreoElectronicoActionPerformed

    private void tfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionActionPerformed

    private void btnRegistrarMensajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMensajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarMensajeroActionPerformed

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMensajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMensajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMensajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroMensajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistroMensajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarJornada;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnRegistrarMensajero;
    public javax.swing.JComboBox<String> cbMedioServicio;
    public javax.swing.JComboBox<String> cbMedioTransporte;
    public javax.swing.JComboBox<String> cbSeguridadSocial;
    public javax.swing.JComboBox<String> cbSexo;
    public javax.swing.JComboBox<String> cbTipoDocumento;
    private javax.swing.JLabel correoElectronico;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel matricula;
    private javax.swing.JLabel medioServicio;
    private javax.swing.JLabel medioTransporte;
    private javax.swing.JLabel nacionalidad;
    private javax.swing.JLabel numeroDocumento;
    private javax.swing.JLabel primerApellido;
    private javax.swing.JLabel primerNombre;
    private javax.swing.JLabel registroMensajero;
    private javax.swing.JLabel segundoApellido;
    private javax.swing.JLabel segundoNombre;
    private javax.swing.JLabel seguridadSocial;
    public javax.swing.JTable tablaJornada;
    private javax.swing.JLabel telefono;
    public javax.swing.JTextField tfCorreoElectronico;
    public javax.swing.JTextField tfDireccion;
    public javax.swing.JTextField tfMarca;
    public javax.swing.JTextField tfMatricula;
    public javax.swing.JTextField tfNacionalidad;
    public javax.swing.JTextField tfNumeroDocumento;
    public javax.swing.JTextField tfPrimerApellido;
    public javax.swing.JTextField tfPrimerNombre;
    public javax.swing.JTextField tfSegundoApellido;
    public javax.swing.JTextField tfSegundoNombre;
    public javax.swing.JTextField tfTelefono;
    private javax.swing.JLabel tipoDocumento;
    // End of variables declaration//GEN-END:variables
}
