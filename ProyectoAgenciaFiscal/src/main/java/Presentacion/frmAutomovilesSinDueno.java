/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Entity.Automovil;
import Entity.Licencia;
import Entity.Persona;
import INegocio.IAutomovilNegocio;
import INegocio.ILicenciaNegocio;
import INegocio.IPersonaNegocio;
import INegocio.IPlacasNegocio;
import IPersistencia.IConexionBD;
import IPersistencia.ILicenciaDAO;
import IPersistencia.IPersonaDAO;
import IPersistencia.IPlacasDAO;
import Negocio.LicenciaNegocio;
import Negocio.PersonaNegocio;
import Negocio.PlacasNegocio;
import Persistencia.ConexionBD;
import Persistencia.LicenciaDAO;
import Persistencia.PersonaDAO;
import Persistencia.PlacasDAO;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author diego
 */
public class frmAutomovilesSinDueno extends javax.swing.JFrame {

    private int row, columna;
    private JButton btnAdquirir = new JButton("Adquirir Automovil");
    private JButton btnHistorial = new JButton("Historial Placas");
    private List<Automovil> listaActual = new ArrayList<Automovil>();
    private IPlacasNegocio placasNegocio;
    private IAutomovilNegocio automovilNegocio;
    private ILicenciaNegocio licenciaNegocio;
    private Persona persona;

    /**
     * Creates new form frmAutomoviles
     */
    public frmAutomovilesSinDueno(IAutomovilNegocio automovilNegocio, Persona persona) {
        IConexionBD conexionBD = new ConexionBD();
        IPlacasDAO placasDAO = new PlacasDAO(conexionBD);
        ILicenciaDAO licenciaDAO = new LicenciaDAO(conexionBD);
        this.licenciaNegocio = new LicenciaNegocio(licenciaDAO);
        this.placasNegocio = new PlacasNegocio(placasDAO);
        this.persona = persona;
        this.automovilNegocio = automovilNegocio;
        initComponents();
        tabla();
        llenarTabla();
        botoneDiseño();
        String nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
        this.lblCliente.setText(nombreCompleto);
    }

    /**
     *
     * Establece el diseño de los botones de la interfaz de usuario.
     */
    public void botoneDiseño() {
        btnAdquirir.setBackground(new Color(232, 57, 95));
        btnHistorial.setBackground(new Color(102, 89, 222));
        btnAdquirir.setForeground(Color.BLACK);
        btnHistorial.setForeground(Color.BLACK);
        btnAdquirir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnHistorial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    }

    /**
     *
     * Configura la tabla de la interfaz de usuario para mostrar la información
     * de los autos. Establece las columnas, los renderers y los tamaños de las
     * columnas.
     */
    public void tabla() {
        tblAuto.setDefaultRenderer(Object.class, new RenderTabla());
        DefaultTableModel defa = new DefaultTableModel();
        tblAuto.setModel(defa);
        defa.addColumn("NumeroDeSerie");
        defa.addColumn("Marca");
        defa.addColumn("Linea");
        defa.addColumn("Modelo");
        defa.addColumn("Estado");
        defa.addColumn("Adquirir Automovil");
        defa.addColumn("Historial Placas");
        tblAuto.setRowHeight(40);
        TableColumn solicitarColumna = tblAuto.getColumnModel().getColumn(5);
        TableColumn historialColumna = tblAuto.getColumnModel().getColumn(6);
        solicitarColumna.setPreferredWidth(100);
        historialColumna.setPreferredWidth(100);
        defa.fireTableDataChanged();
    }

    /**
     *
     * Llena la tabla de la interfaz de usuario con la información de los autos
     * sin dueño. Obtiene la información de los autos y sus placas y muestra los
     * datos en la tabla.
     */
    public void llenarTabla() {

        listaActual = automovilNegocio.listaAutosSinDueño();
        DefaultTableModel defa = (DefaultTableModel) tblAuto.getModel();
        defa.setRowCount(0);
        for (int i = 0; i < listaActual.size(); i++) {
            Object[] datos = new Object[defa.getColumnCount()];
            datos[0] = listaActual.get(i).getNumeroDeSerie();
            datos[1] = listaActual.get(i).getMarca();
            datos[2] = listaActual.get(i).getLinea();
            datos[3] = listaActual.get(i).getModelo();
            if (placasNegocio.BuscarPorAuto(listaActual.get(i).getId()).isEmpty()) {
                datos[4] = "Nuevo";
            } else {
                datos[4] = "Usado";
            }

            datos[5] = btnAdquirir;
            datos[6] = btnHistorial;
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
        jLabel3 = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(102, 89, 222));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Automoviles Sin Dueño");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 520, 87));

        lblLicencia.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lblLicencia.setForeground(new java.awt.Color(255, 255, 255));
        lblLicencia.setText("Cliente:");
        jPanel3.add(lblLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, 40));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 60, 30));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        lblCliente.setText("Estado Licencia");
        jPanel3.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 240, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabel2.setText("Busqueda:");

        tblAuto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAuto.setFocusable(false);
        tblAuto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAuto.setRowHeight(25);
        tblAuto.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblAuto.setShowVerticalLines(false);
        tblAuto.getTableHeader().setReorderingAllowed(false);
        tblAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAuto);
        tblAuto.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblAuto.getTableHeader().setOpaque(false);
        tblAuto.getTableHeader().setBackground(new Color(102,89,222));
        tblAuto.getTableHeader().setForeground(new Color(255,255,255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        llenarTabla();

    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        frmAutomoviles frm = new frmAutomoviles(automovilNegocio, persona);
        frm.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoMouseClicked
        columna = tblAuto.getColumnModel().getColumnIndexAtX(evt.getX());
        row = evt.getY() / tblAuto.getRowHeight();
        if (columna <= tblAuto.getColumnCount() && columna >= 0 && row <= tblAuto.getRowCount() && row >= 0) {
            Object objeto = tblAuto.getValueAt(row, columna);
            if (objeto instanceof JButton) {
                ((JButton) objeto).doClick();
                JButton boton = (JButton) objeto;
                if (boton.equals(btnHistorial)) {
                    frmHistorialPlacas frmhisto = new frmHistorialPlacas(listaActual.get(row), persona,true);
                    frmhisto.setVisible(true);
                    this.dispose();
                }
                if (boton.equals(btnAdquirir)) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de quieres adquirir este Automovil?");
                    if (opcion == JOptionPane.YES_OPTION) {
                        if (automovilNegocio.cambiarDueño(listaActual.get(row), persona) != null) {
                            String nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
                            JOptionPane.showMessageDialog(null, "El Automovil ahora es de la Persona : " + nombreCompleto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            llenarTabla();
                        } else {
                            JOptionPane.showMessageDialog(null, "No fue posible establecer el auto ala persona", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_tblAutoMouseClicked

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
            java.util.logging.Logger.getLogger(frmAutomovilesSinDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAutomovilesSinDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAutomovilesSinDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAutomovilesSinDueno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new frmAutomoviles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JTable tblAuto;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
