/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entity.Persona;
import INegocio.IAutomovilNegocio;
import INegocio.ILicenciaNegocio;
import INegocio.IPersonaNegocio;
import IPersistencia.IConexionBD;
import Persistencia.ConexionBD;
import Persistencia.Encriptacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author diego
 */
public class frmTramites extends javax.swing.JFrame {

    private int row, columna;
    JButton btnLicencia = new JButton("Solicitar Licencia");
    JButton btnAutomoviles = new JButton("Automoviles");
    private IPersonaNegocio personaNegocio;
    private IAutomovilNegocio automovilNegocio;
    private ILicenciaNegocio LicenciaNegocio;
    private List<Persona> listaActual = new ArrayList<Persona>();

    /**
     * Creates new form frmTramites
     */
    public frmTramites(IPersonaNegocio personaNegocio, IAutomovilNegocio automovilNegocio, ILicenciaNegocio LicenciaNegocio) {
        this.automovilNegocio = automovilNegocio;
        this.personaNegocio = personaNegocio;
        this.LicenciaNegocio = LicenciaNegocio;

        botoneDiseño();
        initComponents();
        tabla();
        llenarTabla();
    }

    /**
     *
     * Configura el diseño de los botones para el menú de Licencias y
     * Automóviles.
     */
    public void botoneDiseño() {
        btnLicencia.setBackground(new Color(102, 89, 222));
        btnAutomoviles.setBackground(new Color(102, 89, 222));
        btnLicencia.setForeground(Color.BLACK);
        btnAutomoviles.setForeground(Color.BLACK);
        btnAutomoviles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnLicencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    }

    /**
     *
     * Configura la tabla de datos para mostrar información de personas.
     */
    public void tabla() {
        tblTramites.setDefaultRenderer(Object.class, new RenderTabla());
        DefaultTableModel defa = new DefaultTableModel();
        tblTramites.setRowHeight(40);
        tblTramites.setModel(defa);

        defa.addColumn("Nombre");
        defa.addColumn("Curp");
        defa.addColumn("RFC");
        defa.addColumn("Fecha de nacimiento");
        defa.addColumn("Telefono");
        defa.addColumn("Discapacidad");
        defa.addColumn("Licencia");
        defa.addColumn("Automoviles");
        TableColumn nombreColumna = tblTramites.getColumnModel().getColumn(0);
        TableColumn curpColumna = tblTramites.getColumnModel().getColumn(1);
        TableColumn rfcColumna = tblTramites.getColumnModel().getColumn(2);
        TableColumn fechaColumna = tblTramites.getColumnModel().getColumn(3);
        TableColumn teColumna = tblTramites.getColumnModel().getColumn(4);
        TableColumn disColumna = tblTramites.getColumnModel().getColumn(5);
        nombreColumna.setPreferredWidth(110);
        rfcColumna.setPreferredWidth(60);
        curpColumna.setPreferredWidth(100);
        fechaColumna.setPreferredWidth(50);
        teColumna.setPreferredWidth(25);
        disColumna.setPreferredWidth(45);

    }

    /**
     *
     * Llena la tabla de datos con información de personas.
     */
    public void llenarTabla() {
        listaActual = personaNegocio.BuscarPersonas(txtBusqueda.getText());
        DefaultTableModel defa = (DefaultTableModel) tblTramites.getModel();
        defa.setRowCount(0);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for (Persona persona : listaActual) {
            Object[] datos = new Object[defa.getColumnCount()];
            String nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
            datos[0] = nombreCompleto;
            datos[1] = persona.getCurp();
            datos[2] = persona.getRfc();
            datos[3] = formato.format(persona.getFechaNacimiento().getTime());
            datos[4] = persona.getTelefono();
            if (persona.getDiscapacidad() == 0) {
                datos[5] = "";
            } else {
                datos[5] = "Discapacitado";
            }

            datos[6] = btnLicencia;
            datos[7] = btnAutomoviles;
            defa.addRow(datos);
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
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 89, 222));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegresar.setForeground(new java.awt.Color(2, 2, 2));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tramites");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 0, 0));
        jLabel2.setText("Busqueda:");

        jScrollPane1.setFocusable(false);

        tblTramites = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTramites.setRowHeight(25);
        tblTramites.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblTramites.getTableHeader().setReorderingAllowed(false);
        tblTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTramites);
        tblTramites.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblTramites.getTableHeader().setOpaque(false);
        tblTramites.getTableHeader().setBackground(new Color(102,89,222));
        tblTramites.getTableHeader().setForeground(new Color(255,255,255));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTramitesMouseClicked
        columna = tblTramites.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / tblTramites.getRowHeight();
        if (columna <= tblTramites.getColumnCount() && columna >= 0 && row <= tblTramites.getRowCount() && row >= 0) {
            Object objeto = tblTramites.getValueAt(row, columna);
            if (objeto instanceof JButton) {
                ((JButton) objeto).doClick();
                JButton botones = (JButton) objeto;
                if (botones.equals(btnLicencia)) {
                    if (LicenciaNegocio.listaLicenciaPersonaVigentes(listaActual.get(row).getId()).isEmpty()) {

                        if (personaNegocio.Edad(listaActual.get(row)) >= 18) {

                            frmLicencia ee = new frmLicencia(listaActual.get(row), LicenciaNegocio);
                            ee.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Esta persona tiene menos de 18 años");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Esta persona ya cuenta con una licencia vigente");
                    }
                }
                if (botones.equals(btnAutomoviles)) {

                    frmAutomoviles frm = new frmAutomoviles(automovilNegocio, listaActual.get(row));
                    frm.setVisible(true);
                    this.dispose();
                }

            } else {

            }
        }
    }//GEN-LAST:event_tblTramitesMouseClicked

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmInicio inicio = new frmInicio();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
    int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean numeros = key >= 48 && key <= 57;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio || numeros)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBusquedaKeyTyped

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
            java.util.logging.Logger.getLogger(frmTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new frmTramites().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

}
