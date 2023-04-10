package Presentacion;

import Entity.Licencia;
import Entity.Placas;
import Entity.Tramite;
import INegocio.IPersonaNegocio;
import INegocio.ITramiteNegocio;
import IPersistencia.IAutomovilDAO;
import IPersistencia.IConexionBD;
import IPersistencia.IPersonaDAO;
import IPersistencia.ITramiteDAO;
import Negocio.PersonaNegocio;
import Negocio.TramiteNegocio;
import Persistencia.AutomovilDAO;
import Persistencia.ConexionBD;
import Persistencia.PersonaDAO;
import Persistencia.TramiteDAO;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DELL User
 */
public class frmReporte extends javax.swing.JFrame {

    private int row, columna;
    private List<Tramite> listaActual = new ArrayList<Tramite>();

    /**
     * Creates new form frmReporte
     */
    public frmReporte() {
        initComponents();
        fechaInicio.addDateChangeListener(event -> {
            // Obtener la fecha seleccionada
            LocalDate dateInicio = event.getNewDate();

            if (fechaFin.getDate() != null && fechaFin.getDate() != null) {
                LocalDate dateFin = fechaFin.getDate();
                if (dateInicio.isAfter(dateFin)) {
                    fechaInicio.setDate(event.getOldDate());
                    fechaInicio.closePopup();
                    JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser posterior a la fecha de fin", "Error en la fecha de inicio", JOptionPane.ERROR_MESSAGE);
                }
            }
            llenarTabla();
        });
        fechaFin.addDateChangeListener(event -> {
            // Obtener la fecha seleccionada

            LocalDate dateFin = event.getNewDate();

            if (fechaFin.getDate() != null && fechaFin.getDate() != null) {
                LocalDate dateInicio = fechaInicio.getDate();
                if (dateFin.isBefore(dateInicio)) {
                    fechaFin.closePopup();
                    fechaFin.setDate(event.getOldDate());
                    JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio", "Error en la fecha de fin", JOptionPane.ERROR_MESSAGE);

                }
            }
            llenarTabla();
        });
        tabla();
        llenarTabla();
    }

    public void tabla() {
        tblConsultas.setDefaultRenderer(Object.class, new RenderTabla());
        DefaultTableModel defa = new DefaultTableModel();
        tblConsultas.setModel(defa);
        defa.addColumn("Fecha");
        defa.addColumn("Tipo");
        defa.addColumn("Nombre de Solicitante");
        defa.addColumn("Costo");
        tblConsultas.setRowHeight(40);
        defa.fireTableDataChanged();
    }

    public void llenarTabla() {
        IConexionBD conexionBD = new ConexionBD();
        ITramiteDAO tramiteDAO = new TramiteDAO(conexionBD);
        ITramiteNegocio tramiteNegocio = new TramiteNegocio(tramiteDAO);
        if (!chkPeriodos.isSelected()) {
            listaActual = tramiteDAO.listaTramite(chkLicencia.isSelected(), chkPlaca.isSelected(), txtBusqueda.getText(), null, null);
        } else {
            listaActual = tramiteDAO.listaTramite(chkLicencia.isSelected(), chkPlaca.isSelected(), txtBusqueda.getText(), fechaInicio.getDate(), fechaFin.getDate());
        }

        DefaultTableModel defa = (DefaultTableModel) tblConsultas.getModel();
        defa.setRowCount(0);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < listaActual.size(); i++) {
            Object[] datos = new Object[defa.getColumnCount()];
            datos[0] = formato.format(listaActual.get(i).getFechaTramite().getTime());
            if (listaActual.get(i) instanceof Placas) {
                datos[1] = "Placas";
            }
            if (listaActual.get(i) instanceof Licencia) {
                datos[1] = "Licenciass";
            }
            datos[2] = listaActual.get(i).getPersona().getNombre();
            datos[3] = listaActual.get(i).getCosto();
            defa.addRow(datos);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkLicencia = new javax.swing.JCheckBox();
        chkPlaca = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fechaInicio = new com.github.lgooddatepicker.components.DatePicker();
        fechaFin = new com.github.lgooddatepicker.components.DatePicker();
        chkPeriodos = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Filtros");

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Reporte de trámites");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel3.setText("Periodo:");

        jLabel4.setText("Nombre:");

        chkLicencia.setSelected(true);
        chkLicencia.setText("Licencia");
        chkLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLicenciaActionPerformed(evt);
            }
        });

        chkPlaca.setSelected(true);
        chkPlaca.setText("Placa");
        chkPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPlacaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de trámite:");

        jLabel6.setText("a");

        jButton1.setText("Buscar");

        fechaInicio.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                fechaInicioInputMethodTextChanged(evt);
            }
        });

        chkPeriodos.setSelected(true);
        chkPeriodos.setText("Por Periodos");
        chkPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPeriodosActionPerformed(evt);
            }
        });

        jScrollPane3.setFocusable(false);

        tblConsultas = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblConsultas.getTableHeader().setReorderingAllowed(false);
        tblConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblConsultas);

        jButton3.setText("Generar Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkPeriodos)))
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkLicencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkPlaca))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPeriodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkPlaca)
                    .addComponent(chkLicencia)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmInicio frminicio = new frmInicio();
        frminicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void chkPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPeriodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkPeriodosActionPerformed

    private void chkPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPlacaActionPerformed
        if (chkPlaca.isSelected()) {

        } else {

            if (!chkLicencia.isSelected()) {
                chkPlaca.setSelected(true);
                JOptionPane.showMessageDialog(this, "Debe Haber un tipo de tramite seleccionado");
            }
        }
        llenarTabla();

    }//GEN-LAST:event_chkPlacaActionPerformed

    private void chkLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLicenciaActionPerformed
        if (chkLicencia.isSelected()) {

        } else {
            if (!chkPlaca.isSelected()) {
                chkLicencia.setSelected(true);
                JOptionPane.showMessageDialog(this, "Debe Haber un tipo de tramite seleccionado");
            }
        }
        llenarTabla();
    }//GEN-LAST:event_chkLicenciaActionPerformed

    private void tblConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultasMouseClicked

    }//GEN-LAST:event_tblConsultasMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (listaActual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay Registros");
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de ejecutar este comando?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<ReporteTramites> listat = new ArrayList<ReporteTramites>();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < listaActual.size(); i++) {
                Tramite tramite = listaActual.get(i);
                String costo = String.valueOf(tramite.getCosto());
                String fecha = formato.format(tramite.getFechaTramite().getTime());
                String tipo="";
                if (listaActual.get(i) instanceof Placas) {
                    tipo = "Placas";
                }
                if (listaActual.get(i) instanceof Licencia) {
                    tipo = "Licenciass";
                }
                String nombre = tramite.getPersona().getNombre();
                ReporteTramites repo = new ReporteTramites(costo, fecha, tipo, nombre);
                listat.add(repo);
            }

            try {
                // Cargar los datos en un JRBeanCollectionDataSource
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listat);

                // Cargar el archivo JRXML del reporte
                InputStream reportFile = getClass().getResourceAsStream("/reporteTramite.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);

                // Visualizar el reporte
                JasperExportManager.exportReportToPdfFile(jasperPrint, "./ReporteTramites.pdf");
            } catch (JRException ex) {
                Logger.getLogger(frmReporte.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fechaInicioInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fechaInicioInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioInputMethodTextChanged

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporte().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkLicencia;
    private javax.swing.JCheckBox chkPeriodos;
    private javax.swing.JCheckBox chkPlaca;
    private com.github.lgooddatepicker.components.DatePicker fechaFin;
    private com.github.lgooddatepicker.components.DatePicker fechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblConsultas;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
