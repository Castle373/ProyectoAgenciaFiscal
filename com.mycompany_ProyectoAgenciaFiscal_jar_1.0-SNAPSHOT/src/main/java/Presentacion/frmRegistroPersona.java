/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entity.Persona;
import INegocio.IPersonaNegocio;
import IPersistencia.IConexionBD;
import IPersistencia.IPersonaDAO;
import Negocio.PersonaNegocio;
import Persistencia.ConexionBD;
import Persistencia.Encriptacion;
import Persistencia.PersonaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Gabriel
 */
public class frmRegistroPersona extends javax.swing.JFrame {

    private IPersonaNegocio personaNegocio;
    private Persona persona;
    private boolean editar = false;

    /**
     * Creates new form frmPersona
     */
    public frmRegistroPersona(IPersonaNegocio personaNegocio, Persona persona) {
        this.personaNegocio = personaNegocio;
        this.persona = persona;
        initComponents();

        if (this.persona != null) {
            lbltitulo.setText("Editar");

            editar = true;
            txtNombre.setText(persona.getNombre());
            txtApellidop.setText(persona.getApellidoPaterno());
            txtApellidom.setText(persona.getApellidoMaterno());
            txtRFC.setText(persona.getRfc());
            txtCurp.setText(persona.getCurp());
            txtTelefono.setText(persona.getTelefono());
            System.out.println(persona.getFechaNacimiento());

            LocalDate persona3 = LocalDateTime.ofInstant(persona.getFechaNacimiento().toInstant(), persona.getFechaNacimiento().getTimeZone().toZoneId()).toLocalDate();

            dpFecha.setDate(persona3);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbodiscapacidad = new javax.swing.JCheckBox();
        txtCurp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        dpFecha = new com.github.lgooddatepicker.components.DatePicker();
        txtApellidop = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellidom = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtRFC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 89, 222));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbltitulo.setText("Registro");
        lbltitulo.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 60)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbodiscapacidad.setText("¿Cuentas con alguna discapacidad?");
        cbodiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbodiscapacidadActionPerformed(evt);
            }
        });

        txtCurp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCurpKeyTyped(evt);
            }
        });

        jLabel6.setText("Telefono:");

        jLabel10.setText("Curp");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel4.setText("RFC:");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel8.setText("Apellido_p");

        jButton1.setText("Siguiente");
        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Apellido_m");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidopKeyTyped(evt);
            }
        });

        jLabel1.setText("Asegurese de que sus datos esten correctos");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtApellidom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidomKeyTyped(evt);
            }
        });

        jButton2.setText("Atras");
        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(96, 96, 96)
                                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(73, 73, 73)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(64, 64, 64)
                                .addComponent(txtApellidop, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(60, 60, 60)
                                .addComponent(txtApellidom, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(94, 94, 94)
                                .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(7, 7, 7)
                                .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(71, 71, 71)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(cbodiscapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtApellidop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtApellidom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(cbodiscapacidad)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IConexionBD conexionBD = new ConexionBD();
        IPersonaDAO personaDAO = new PersonaDAO(conexionBD);
        IPersonaNegocio personaNegocio = new PersonaNegocio(personaDAO);
        frmCrudPersona inicio = new frmCrudPersona(personaNegocio);
        inicio.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtRFC.getText().length() == 13 && txtCurp.getText().length() == 18 && txtTelefono.getText().length() == 10) {
            if (editar) {
                editar();
            } else {
                agregar();
            }
        } else {
            JOptionPane.showMessageDialog(this, "NO SE PUDO COMPLETAR EL TRAMITE, POR FAVOR MODIFIQUE SU INFORMACIÓN");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbodiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodiscapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbodiscapacidadActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtTelefono.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCurpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurpKeyTyped

        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean numeros = key >= 48 && key <= 57;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio || numeros)) {
            evt.consume();
        }
        if (txtCurp.getText().trim().length() == 18) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCurpKeyTyped

    private void txtRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyTyped

        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean numeros = key >= 48 && key <= 57;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio || numeros)) {
            evt.consume();
        }
        if (txtRFC.getText().trim().length() == 13) {
            evt.consume();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
        if (txtNombre.getText().trim().length() == 50) {
            evt.consume();
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidopKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
        if (txtApellidom.getText().trim().length() == 50) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidopKeyTyped

    private void txtApellidomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidomKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
        if (txtApellidom.getText().trim().length() == 50) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidomKeyTyped
    /**
     *
     * Agrega una nueva persona a la base de datos.
     */
    public void agregar() {
        byte check;
        if (!validarcampos()) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        LocalDate fechahoy= LocalDate.now();
        LocalDate localito = dpFecha.getDate();
        java.sql.Date Fechanac = java.sql.Date.valueOf(localito);
        calendar.setTime(Fechanac);
        
        long diferenciaDeAnios = ChronoUnit.YEARS.between(localito, fechahoy);
        
        
        if (cbodiscapacidad.isSelected()) {
            check = 1;
        } else {
            check = 0;
        }
        Persona persona1 = new Persona(txtNombre.getText(), txtApellidop.getText(), txtApellidom.getText(), txtRFC.getText(), txtCurp.getText(), txtTelefono.getText(), calendar, check);
        Encriptacion e = new Encriptacion();
        persona1.setNombre(e.encriptar(persona1.getNombre()));
        persona1.setApellidoPaterno(e.encriptar(persona1.getApellidoPaterno()));
        persona1.setApellidoMaterno(e.encriptar(persona1.getApellidoMaterno()));
        Persona guardar = personaNegocio.agregarPersona(persona1);
        if (guardar != null) {
            JOptionPane.showMessageDialog(this, "El registro se efectuo con exito");
            frmCrudPersona per = new frmCrudPersona(personaNegocio);
            per.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo efectuar el registro");
        }

    }

    /**
     *
     * Edita una persona existente en la base de datos.
     */
    public void editar() {
        byte check;
        if (!validarcampos()) {
            return;
        }
        persona.setNombre(txtNombre.getText());
        persona.setApellidoPaterno(txtApellidop.getText());
        persona.setApellidoMaterno(txtApellidom.getText());
        persona.setRfc(txtRFC.getText());
        persona.setTelefono(txtTelefono.getText());
        persona.setCurp(txtCurp.getText());
        if (cbodiscapacidad.isSelected()) {
            check = 1;
        } else {
            check = 0;
        }
        Calendar calendarito = Calendar.getInstance();
        LocalDate localito1 = dpFecha.getDate();
        java.sql.Date Fechanac = java.sql.Date.valueOf(localito1);
        calendarito.setTime(Fechanac);
        persona.setFechaNacimiento(calendarito);
        Encriptacion e = new Encriptacion();
        persona.setNombre(e.encriptar(persona.getNombre()));
        persona.setApellidoPaterno(e.encriptar(persona.getApellidoPaterno()));
        persona.setApellidoMaterno(e.encriptar(persona.getApellidoMaterno()));
        persona.setDiscapacidad(check);
        Persona editarpersona = personaNegocio.editarPersona(persona);
        if (editarpersona != null) {
            JOptionPane.showMessageDialog(this, "El registro se efectuo con exito");
            frmCrudPersona per = new frmCrudPersona(personaNegocio);
            per.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo efectuar el registro");
        }
    }

    /**
     *
     * Valida que los campos de la interfaz estén llenos para poder agregar o
     * editar una persona.
     *
     * @return verdadero si los campos están llenos, falso en caso contrario.
     */
    public boolean validarcampos() {
        if (txtRFC.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("")
                || txtApellidop.getText().equalsIgnoreCase("") || txtApellidom.getText().equalsIgnoreCase("")
                || txtCurp.getText().equalsIgnoreCase("") || txtTelefono.getText().equalsIgnoreCase("") || dpFecha.getDate() == null) {
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(frmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //    new frmRegistroPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbodiscapacidad;
    private com.github.lgooddatepicker.components.DatePicker dpFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtApellidom;
    private javax.swing.JTextField txtApellidop;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}