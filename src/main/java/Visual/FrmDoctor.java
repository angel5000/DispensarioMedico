/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visual;

import Control.AdmCitasMedicas;
import Control.AdmHistMedico;
import Control.AdmHorariosCitas;
import Model.CitasMedicas;
import Model.Doctor;
import Model.HistorialMedico;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angeldvvp
 */
public class FrmDoctor extends javax.swing.JFrame {

    /**
     * Creates new form FrmDoctor
     */
    AdmCitasMedicas cm = new AdmCitasMedicas();
    int ID=0, IDCITA=0,IDPACIENTE=0, IDHORARIO=0;int Estado=3;
    int idmed=0;
    String  sintomas, diagnostico, tratamiento, receta,Dispo="";
    Doctor dc;
    public FrmDoctor(Doctor med) {
        initComponents();
        dc=med;
        idmed=dc.getIdDoctor();
        lbdocnom.setText(dc.getNombresdoc());
         pnelhisto.setEnabled(false);
         btingrehisto.setEnabled(false);
         btlimpcamp.setEnabled(false);
         txtreceta.setEnabled(false);
         txtdiag.setEnabled(false);
          txtsint.setEnabled(false);
           txttrata.setEnabled(false);
       Listar();
         tbdocct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

     tbdocct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener la fila seleccionada
                    int selectedRow = tbdocct.getSelectedRow();

                    // Verificar si hay una fila seleccionada
                    if (selectedRow != -1) {
                        // Obtener los valores de las celdas en la fila seleccionada
                        // txardetal.setText("");
                        Object idcita=tbdocct.getValueAt(selectedRow, 0);
                         Object estado=tbdocct.getValueAt(selectedRow, 4);
                         Dispo=estado.toString();
                         int id = ((Number) idcita).intValue();
                        selectindex( id,Dispo);
                     
                  /*     
                     
                     */
                       
                    }
                }
            }
     });
     
    }

    public void selectindex(int id, String dispo){
        if(dispo.equals("Terminado")){
            pnelhisto.setEnabled(false);
            btingrehisto.setEnabled(false);
         btlimpcamp.setEnabled(false);
         txtreceta.setEnabled(false);
         txtdiag.setEnabled(false);
          txtsint.setEnabled(false);
           txttrata.setEnabled(false);
        }else{
             pnelhisto.setEnabled(true);
             pnelhisto.setEnabled(true);
         btingrehisto.setEnabled(true);
         btlimpcamp.setEnabled(true);
         txtreceta.setEnabled(true);
         txtdiag.setEnabled(true);
          txtsint.setEnabled(true);
           txttrata.setEnabled(true);
        txtareadet.setText("");
          System.out.println(id+""+cm.MostrarDetCitas(id));
                         for(CitasMedicas dt: cm.MostrarDetCitas(id)){
                             lbidpac.setText(dt.getIdPaciente()+"");
                             ID=dt.getIdMedico(); IDCITA=dt.getCodigCita();IDPACIENTE=dt.getIdPaciente();
                             IDHORARIO=dt.getIdHorario();
                             
                              System.out.println(dt.getApellidos()+" "+dt.getNombresdoc()+"");
                             txtareadet.append("**********************DETALLES CITA MEDICA***************"
                             + "\n\n"+"*****************\n"+"IDCitaMedica:"+dt.getCodigCita()+
                             "\n NOMBRE DEL PACIENTE:"+dt.getApellidos()+" "+dt.getNombres()+
                                     "\n NOMBRE DEL DOCTOR: "+dt.getNombresdoc()+"\n"+
                             " ESPECIALIDAD: "+dt.getSpecialidad()+"\n FECHA CITA MEDICA: "+dt.getFechaHora()+
                                     "\n MOTIVO DE LA CITA: "+dt.getMotivos()
                                     +"\n*******"
                             + "********************"
                             + "*****************************".toUpperCase());
                             
                         }
        }
    }
    
    private FrmDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public void Listar() {
    DefaultTableModel TB = (DefaultTableModel)  tbdocct.getModel();
       TB.setRowCount(0);
   
   SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       System.out.println(idmed+"");
              
    for(CitasMedicas dt :  cm.MostrarCitasMedicas(135)){
        
          String fecha= formatter.format(dt.getFechaHora());
          
           
                TB.addRow(new Object[]{dt.getCodigCita(),dt.getNombres()+" "+dt.getApellidos(),
                fecha,dt.getMotivos(),dt.getDisponible(), dt.getFechafin()});
                
                int tamaño = tamañofila( tbdocct.getFont());
      tbdocct.setRowHeight(tamaño);
      TB.fireTableDataChanged();
            }

    

}

 private int tamañofila(Font font) {
        
        int incrementa = 6;
        return font.getSize() + incrementa;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lbdocnom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbdocct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lbidpac = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareadet = new javax.swing.JTextArea();
        pnelhisto = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtdiag = new javax.swing.JTextPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        txttrata = new javax.swing.JTextPane();
        btingrehisto = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtsint = new javax.swing.JTextPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtreceta = new javax.swing.JTextPane();
        jLabel20 = new javax.swing.JLabel();
        btlimpcamp = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btsesion = new javax.swing.JButton();
        btregmed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 20));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        lbdocnom.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        lbdocnom.setText("Nombdoc");

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jLabel1.setText("Bienvenido Dr.");

        jLabel5.setFont(new java.awt.Font("Perpetua", 0, 14)); // NOI18N
        jLabel5.setText("Mata Sano");

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 0, 18)); // NOI18N
        jLabel4.setText("Dispensario Medico");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\angeldvvp\\Desktop\\DispensarioMedico\\src\\main\\Imagenes\\medicina (2).jpg")); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Citas Pendientes"));
        jPanel7.setPreferredSize(new java.awt.Dimension(1042, 558));

        tbdocct.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        tbdocct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Cita", "Nombres Paciente", "Fecha Y Hora Cita", "Motivo Cita", "Estado", "FechaFinal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(tbdocct);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        jLabel24.setText("Paciente:");

        lbidpac.setText("xxxxx");

        txtareadet.setColumns(20);
        txtareadet.setRows(5);
        jScrollPane1.setViewportView(txtareadet);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbidpac)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lbidpac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnelhisto.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Historial"));

        jLabel23.setText("Receta:");

        jScrollPane17.setViewportView(txtdiag);

        jScrollPane20.setViewportView(txttrata);

        btingrehisto.setText("Ingresar Historial Medico");
        btingrehisto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btingrehistoActionPerformed(evt);
            }
        });

        jLabel21.setText("Diagnostico:");

        jScrollPane18.setViewportView(txtsint);

        jScrollPane19.setViewportView(txtreceta);

        jLabel20.setText("Sintomas:");

        btlimpcamp.setText("Limpia Campos");

        jLabel22.setText("Tratamiento:");

        javax.swing.GroupLayout pnelhistoLayout = new javax.swing.GroupLayout(pnelhisto);
        pnelhisto.setLayout(pnelhistoLayout);
        pnelhistoLayout.setHorizontalGroup(
            pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelhistoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(pnelhistoLayout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btingrehisto)
                        .addGap(48, 48, 48)
                        .addComponent(btlimpcamp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnelhistoLayout.createSequentialGroup()
                        .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(37, 37, 37)
                        .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(183, 183, 183))
        );
        pnelhistoLayout.setVerticalGroup(
            pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelhistoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane17)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelhistoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnelhistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btingrehisto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btlimpcamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(pnelhistoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnelhisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1086, 1086, 1086))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnelhisto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel7);

        btsesion.setText("Cerrar Sesion");
        btsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsesionActionPerformed(evt);
            }
        });

        btregmed.setText("Registros");
        btregmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregmedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbdocnom)))
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btregmed, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbdocnom)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btregmed, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btingrehistoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btingrehistoActionPerformed
     AdmHistMedico hm = new  AdmHistMedico();
     AdmHorariosCitas hr = new AdmHorariosCitas();
     LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Formatear la fecha y hora (opcional, puedes omitir esta parte si no necesitas formato)
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);
     hm.IngresarHistorialMed( IDPACIENTE,ID, IDHORARIO, txtsint.getText(), txtdiag.getText(), 
             txttrata.getText(), txtreceta.getText());
     hr.SetHorariOcupado(IDHORARIO, Estado);
        System.out.println(IDHORARIO+"");
        
        JOptionPane.showMessageDialog(null,"HISTORIAL INGRESADO - CITA REGISTRADA" );
        Listar();
    }//GEN-LAST:event_btingrehistoActionPerformed

    private void btsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsesionActionPerformed
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "SESION CERRADA");
        FrmLoginMedico l = new FrmLoginMedico();
        l.setVisible(true);
    }//GEN-LAST:event_btsesionActionPerformed

    private void btregmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregmedActionPerformed
       FrmReporteDoc dc = new FrmReporteDoc(idmed);
        System.out.println(idmed+"");
       dc.setVisible(true);
    }//GEN-LAST:event_btregmedActionPerformed

    
    
    
    
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
             javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel" );
            /*
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btingrehisto;
    private javax.swing.JButton btlimpcamp;
    private javax.swing.JButton btregmed;
    private javax.swing.JButton btsesion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JLabel lbdocnom;
    private javax.swing.JLabel lbidpac;
    private javax.swing.JPanel pnelhisto;
    private javax.swing.JTable tbdocct;
    private javax.swing.JTextArea txtareadet;
    private javax.swing.JTextPane txtdiag;
    private javax.swing.JTextPane txtreceta;
    private javax.swing.JTextPane txtsint;
    private javax.swing.JTextPane txttrata;
    // End of variables declaration//GEN-END:variables
}
