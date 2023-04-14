package Presentacion;

import Entity.Licencia;
import Entity.Persona;
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
import Persistencia.Encriptacion;
import Persistencia.PersonaDAO;
import Persistencia.TramiteDAO;
import com.github.lgooddatepicker.components.DatePicker;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//        fechaInicio.addDateChangeListener(event -> {
//            // Obtener la fecha seleccionada
//            LocalDate dateInicio = event.getNewDate();
//
//            if (fechaFin.getDate() != null && fechaFin.getDate() != null) {
//                LocalDate dateFin = fechaFin.getDate();
//                if (dateInicio.isAfter(dateFin)) {
//                    fechaInicio.setDate(event.getOldDate());
//                    fechaInicio.closePopup();
//                    JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser posterior a la fecha de fin", "Error en la fecha de inicio", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//            llenarTabla();
//        });
//        fechaFin.addDateChangeListener(event -> {
//            // Obtener la fecha seleccionada
//
//            LocalDate dateFin = event.getNewDate();
//
//            if (fechaFin.getDate() != null && fechaFin.getDate() != null) {
//                LocalDate dateInicio = fechaInicio.getDate();
//                if (dateFin.isBefore(dateInicio)) {
//                    fechaFin.closePopup();
//                    fechaFin.setDate(event.getOldDate());
//                    JOptionPane.showMessageDialog(null, "La fecha de fin no puede ser anterior a la fecha de inicio", "Error en la fecha de fin", JOptionPane.ERROR_MESSAGE);
//
//                }
//            }
//            llenarTabla();
//        });
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
            listaActual = tramiteDAO.listaTramite(chkLicencia.isSelected(), chkPlaca.isSelected(), null, null);
        } else {
            listaActual = tramiteDAO.listaTramite(chkLicencia.isSelected(), chkPlaca.isSelected(), null, null);
        }

        Encriptacion AES = new Encriptacion();
        AES.desencriptarListaTramite(listaActual);
        if (!txtBusqueda.getText().isEmpty()) {
            List<Tramite> listaPorNombre = new ArrayList<Tramite>();

            for (Tramite tramite : listaActual) {
                String NombreCompleto = tramite.getPersona().getNombre() + " " + tramite.getPersona().getApellidoPaterno() + " " + tramite.getPersona().getApellidoMaterno();
                if (NombreCompleto.toLowerCase().contains(txtBusqueda.getText().toLowerCase())) {
                    listaPorNombre.add(tramite);
                }
            }
            listaActual = listaPorNombre;
        }

        DefaultTableModel defa = (DefaultTableModel) tblConsultas.getModel();
        defa.setRowCount(0);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for (Tramite tramite : listaActual) {
            Object[] datos = new Object[defa.getColumnCount()];
            datos[0] = formato.format(tramite.getFechaTramite().getTime());
            if (tramite instanceof Placas) {
                datos[1] = "Placas";
            }
            if (tramite instanceof Licencia) {
                datos[1] = "Licencias";
            }
            String NombreCompleto = tramite.getPersona().getNombre() + " " + tramite.getPersona().getApellidoPaterno() + " " + tramite.getPersona().getApellidoMaterno();
            datos[2] = NombreCompleto;
            datos[3] = tramite.getCosto();
            defa.addRow(datos);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkLicencia = new javax.swing.JCheckBox();
        chkPlaca = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chkPeriodos = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 89, 222));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 60)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reporte Tramites");

        jButton2.setText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(55, 55, 55)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel3.setText("Periodo:");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de trámite:");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        jLabel6.setText("a");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        chkPeriodos.setSelected(true);
        chkPeriodos.setText("Por Periodos");
        chkPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPeriodosActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generar Reporte");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(123, 123, 123)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(21, 21, 21)
                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(1, 1, 1)
                                        .addComponent(chkLicencia)
                                        .addGap(11, 11, 11)
                                        .addComponent(chkPlaca)))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(chkPeriodos))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(117, 117, 117)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(chkLicencia)
                            .addComponent(chkPlaca)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkPeriodos)
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            return;
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de ejecutar este comando?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<ReporteTramites> listaReporteTramite = new ArrayList<ReporteTramites>();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < listaActual.size(); i++) {

                String costo = String.valueOf(listaActual.get(i).getCosto());
                String fecha = formato.format(listaActual.get(i).getFechaTramite().getTime());
                String tipo = "";
                if (listaActual.get(i) instanceof Placas) {
                    tipo = "Placas";
                }
                if (listaActual.get(i) instanceof Licencia) {
                    tipo = "Licencias";
                }
                String nombre = listaActual.get(i).getPersona().getNombre();
                ReporteTramites repo = new ReporteTramites(costo, fecha, tipo, nombre);
                listaReporteTramite.add(repo);
            }

            try {
                Map parametro = new HashMap();
                LocalDateTime fechaHoraActual = LocalDateTime.now();
                DateTimeFormatter formatEscrito = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, hh:mm a");
                String fechaHoraEscrita = fechaHoraActual.format(formatEscrito);
                parametro.put("fecha",fechaHoraEscrita);
                // Cargar los datos en un JRBeanCollectionDataSource
                JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listaReporteTramite);

                // Cargar el archivo JRXML del reporte
                InputStream reportFile = getClass().getResourceAsStream("/reporteTramite.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(reportFile);

                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, beanColDataSource);

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
        llenarTabla();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblConsultas;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
