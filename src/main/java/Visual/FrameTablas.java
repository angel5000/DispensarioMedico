
package Visual;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.math.*;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author angeldvp
 */
public class FrameTablas extends javax.swing.JFrame {

Connection conn;
boolean paciente=false,doctor=false,ingreso=false;
boolean especifico=false, todos=false;
String datoespe="";
   
    public FrameTablas() {
        initComponents();
           
        modibt.setEnabled(false);
        elimibt.setEnabled(false);
        txtape.setEnabled(false);
    txtcod.setEnabled(false);
     txtcod1.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
          btinser.setEnabled(false);
        insert.setEnabled(false);
        btmodi.setEnabled(false);
        btcancel.setEnabled(false);
        btactu.setEnabled(false);
        panel.setEnabled(false);
        panel.setEditable(false);
        panel.setLineWrap(true);
        panel.setWrapStyleWord(true);
        dia.setEnabled(false);
         mes.setEnabled(false);
          anio.setEnabled(false);
          numcam.setEnabled(false);
          cbpaciente.setEnabled(false);
         cbdoctor.setEnabled(false);
          dia1.setEnabled(false);
          mes1.setEnabled(false);
          numhab.setEnabled(false);
          anio1.setEnabled(false);
             txtbuscar.setEnabled(false);
        btbuscar.setEnabled(false);
        rbingre.setEnabled(false);
rbfingre.setEnabled(false);
rbdoc.setEnabled(false);
 rbdatos.setEnabled(false);
 rbnombre.setEnabled(false);
 Direccion.setEnabled(false);
  bttodos.setEnabled(false);
  dtespe.setEnabled(false);
  rdfecha.setEnabled(false);
  rbid.setEnabled(false);
  cborden.setEnabled(false);
  generar.setEnabled(false);
  txtcod1.setEditable(false);
  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        pane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabladt = new javax.swing.JTable();
        panelmodi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        directlb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        txtdir = new javax.swing.JTextField();
        txtprov = new javax.swing.JTextField();
        txtcodp = new javax.swing.JTextField();
        txttelef = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtespe = new javax.swing.JTextField();
        btinser = new javax.swing.JButton();
        btmodi = new javax.swing.JButton();
        btcancel = new javax.swing.JButton();
        estaddato = new javax.swing.JLabel();
        anio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtcod1 = new javax.swing.JTextField();
        numhab = new javax.swing.JTextField();
        numcam = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        dia1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        mes1 = new javax.swing.JTextField();
        anio1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbpaciente = new javax.swing.JComboBox<>();
        cbdoctor = new javax.swing.JComboBox<>();
        generar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btactu = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        modibt = new javax.swing.JButton();
        elimibt = new javax.swing.JButton();
        cbPersonal = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panel = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbconsul = new javax.swing.JTable();
        cborden = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        panel7 = new javax.swing.JPanel();
        rbnombre = new javax.swing.JRadioButton();
        Direccion = new javax.swing.JRadioButton();
        rbdatos = new javax.swing.JRadioButton();
        rbid = new javax.swing.JRadioButton();
        rdfecha = new javax.swing.JRadioButton();
        rbfingre = new javax.swing.JRadioButton();
        rbingre = new javax.swing.JRadioButton();
        rbdoc = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        btbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        bttodos = new javax.swing.JRadioButton();
        dtespe = new javax.swing.JRadioButton();
        actubt = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        lbselec = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        estadoconx = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbuser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(19, 20));
        setPreferredSize(new java.awt.Dimension(1328, 685));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel1.setText("Mantenimiento de Datos");

        pane.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabla de datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N

        Tabladt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabladt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabladt);

        panelmodi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N

        jLabel2.setText("C.I/ID:");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Provincia:");

        directlb.setText("Direccion:");

        jLabel7.setText("Codigo Postal:");

        jLabel8.setText("Telefono:");

        jLabel9.setText("Fecha nacimiento:");

        txtcod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcodFocusLost(evt);
            }
        });
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtcodp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodpKeyPressed(evt);
            }
        });

        txttelef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefKeyTyped(evt);
            }
        });

        jLabel10.setText("Especialidad:");

        btinser.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btinser.setText("Insertar");
        btinser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btinserActionPerformed(evt);
            }
        });

        btmodi.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btmodi.setText("Modificar");
        btmodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodiActionPerformed(evt);
            }
        });

        btcancel.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btcancel.setText("Limpiar campos");
        btcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelActionPerformed(evt);
            }
        });

        estaddato.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        estaddato.setText("Estado");

        anio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                anioFocusLost(evt);
            }
        });
        anio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anioKeyTyped(evt);
            }
        });

        jLabel13.setText("/");

        dia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                diaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                diaFocusLost(evt);
            }
        });
        dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diaKeyTyped(evt);
            }
        });

        jLabel14.setText("/");

        mes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mesFocusLost(evt);
            }
        });
        mes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesKeyTyped(evt);
            }
        });

        jLabel15.setText("Mes:");

        jLabel16.setText("Año:");

        jLabel17.setText("Dia:");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 14))); // NOI18N

        jLabel18.setText("Codigo:");

        jLabel19.setText("Numero cama:");

        jLabel20.setText("Fecha Ingreso:");

        jLabel21.setText("Numero habitacion:");

        txtcod1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcod1FocusLost(evt);
            }
        });
        txtcod1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcod1KeyTyped(evt);
            }
        });

        numhab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numhabKeyTyped(evt);
            }
        });

        numcam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numcamKeyTyped(evt);
            }
        });

        jLabel24.setText("Mes:");

        jLabel22.setText("Dia:");

        jLabel25.setText("/");

        jLabel26.setText("Año:");

        dia1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dia1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dia1FocusLost(evt);
            }
        });
        dia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dia1KeyTyped(evt);
            }
        });

        jLabel23.setText("/");

        mes1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mes1FocusLost(evt);
            }
        });
        mes1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mes1KeyTyped(evt);
            }
        });

        anio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                anio1FocusLost(evt);
            }
        });
        anio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anio1KeyTyped(evt);
            }
        });

        jLabel27.setText("Paciente:");

        jLabel28.setText("Medico:");

        generar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        generar.setText("Generar codigo");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numhab, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel18))
                                    .addGap(26, 26, 26)
                                    .addComponent(txtcod1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(dia1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbdoctor, 0, 158, Short.MAX_VALUE)
                                .addComponent(cbpaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(numcam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anio1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtcod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(numcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(anio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(dia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(mes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(numhab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelmodiLayout = new javax.swing.GroupLayout(panelmodi);
        panelmodi.setLayout(panelmodiLayout);
        panelmodiLayout.setHorizontalGroup(
            panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmodiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelmodiLayout.createSequentialGroup()
                        .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)
                                .addComponent(txtape))
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addComponent(directlb)
                                .addGap(18, 18, 18)
                                .addComponent(txtdir))
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtprov))
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcod)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelmodiLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmodiLayout.createSequentialGroup()
                                        .addComponent(btinser, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelmodiLayout.createSequentialGroup()
                                        .addComponent(btmodi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btcancel))
                                    .addGroup(panelmodiLayout.createSequentialGroup()
                                        .addComponent(txtespe)
                                        .addGap(112, 112, 112))))
                            .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtcodp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelmodiLayout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(txttelef, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(estaddato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelmodiLayout.setVerticalGroup(
            panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmodiLayout.createSequentialGroup()
                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelmodiLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelmodiLayout.createSequentialGroup()
                        .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelmodiLayout.createSequentialGroup()
                                .addComponent(estaddato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtcodp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txttelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(20, 20, 20)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(directlb)
                                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtespe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(panelmodiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btmodi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btinser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btactu.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btactu.setText("Actualizar");
        btactu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btactuActionPerformed(evt);
            }
        });

        insert.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        insert.setText("Insertar ");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        modibt.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modibt.setText("Modificar");
        modibt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modibtActionPerformed(evt);
            }
        });

        elimibt.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        elimibt.setText("Eliminar");
        elimibt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimibtActionPerformed(evt);
            }
        });

        cbPersonal.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione personal...", "Paciente", "Medico", "Ingresos" }));
        cbPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonalActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial de cambios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 14))); // NOI18N

        panel.setColumns(20);
        panel.setRows(5);
        jScrollPane3.setViewportView(panel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(modibt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 549, Short.MAX_VALUE)
                        .addComponent(elimibt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(cbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btactu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelmodi, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btactu)
                    .addComponent(insert)
                    .addComponent(modibt)
                    .addComponent(elimibt)
                    .addComponent(cbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelmodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pane.addTab("Modificacion de Datos", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N

        tbconsul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbconsul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbconsulMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbconsul);

        cborden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orden...", "Ascendente", "Desendente", " " }));
        cborden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbordenActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12))); // NOI18N

        panel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 14))); // NOI18N

        buttonGroup1.add(rbnombre);
        rbnombre.setText("Nombres completos");
        rbnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(Direccion);
        Direccion.setText("Direccion completa");
        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbdatos);
        rbdatos.setText("Datos completos");
        rbdatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdatosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbid);
        rbid.setText("Id/CI");
        rbid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbidActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdfecha);
        rdfecha.setText("Fecha nacimiento");
        rdfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdfechaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbfingre);
        rbfingre.setText("Fecha ingreso");
        rbfingre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfingreActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbingre);
        rbingre.setText("Datos de ingreso");
        rbingre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbingreActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbdoc);
        rbdoc.setText("Doctor asignado");
        rbdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbdocActionPerformed(evt);
            }
        });

        btbuscar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btbuscar.setText("Buscar ID/CI");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        txtbuscar.setVerifyInputWhenFocusTarget(false);
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        buttonGroup2.add(bttodos);
        bttodos.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        bttodos.setText("Todos");
        bttodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttodosActionPerformed(evt);
            }
        });

        buttonGroup2.add(dtespe);
        dtespe.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        dtespe.setText("Dato especifico (id/CI)");
        dtespe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtespeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbuscar)
                .addGap(18, 18, 18)
                .addComponent(bttodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtespe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbuscar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttodos)
                    .addComponent(dtespe))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel7Layout.createSequentialGroup()
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rbid)
                                .addComponent(rbdatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbdoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Direccion))
                        .addGap(19, 19, 19)
                        .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbnombre)
                            .addComponent(rbfingre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rbingre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdfecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnombre)
                    .addComponent(rbdatos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdfecha)
                    .addComponent(rbid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(rbfingre))
                .addGap(9, 9, 9)
                .addGroup(panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbdoc)
                    .addComponent(rbingre))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 275, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        actubt.setText("Actualizar");
        actubt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actubtActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel30.setText("Seleccion:");

        lbselec.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        lbselec.setText("n/a");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cborden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(actubt)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbselec)))
                        .addGap(0, 360, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cborden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(actubt)))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lbselec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pane.addTab("Reportes", jPanel2);

        jLabel12.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel12.setText("Conexion:");

        estadoconx.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        estadoconx.setText("n/a");

        jLabel29.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel29.setText("Usuario:");

        lbuser.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        lbuser.setText("n/a");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbuser))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estadoconx)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12)
                    .addComponent(estadoconx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void conectado(String connectURL, String sqlUser, String sqlPassword){
    
    try{
 conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
  
   estadoconx.setText("Conectado");
   this.setVisible(true);
 //  lbuser.setText(user);
 
   
 
   
   JOptionPane.showMessageDialog(null, "conectado");
}catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
} 
    
}

    private void cbPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonalActionPerformed
         
        if(cbPersonal.getSelectedIndex()==1){
           doctor=false;
           ingreso=false;
   paciente=true;
    consultas(cbPersonal.getSelectedItem().toString());     
     txtape.setEnabled(false);
     elimibt.setEnabled(false);
    txtcod.setEnabled(false);
     txtcod1.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
     dia1.setEnabled(false);
          mes1.setEnabled(false);
          anio1.setEnabled(false);
           dia.setEnabled(false);
          mes.setEnabled(false);
          anio.setEnabled(false);
          btinser.setEnabled(false);
btmodi.setEnabled(false); 
btcancel.setEnabled(false);
numhab.setEnabled(false);
cbpaciente.setEnabled(false);
         cbdoctor.setEnabled(false);
         numcam.setEnabled(false);
         modibt.setEnabled(false);
         cbpaciente.removeAllItems();
         txtape.setText("");
    txtcod.setText("");
      txtcod1.setText("");
      numcam.setText("");
      numhab.setText("");
      dia.setText("");
      mes.setText("");
      anio.setText("");
       dia1.setText("");
      mes1.setText("");
      anio1.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
         cbdoctor.removeAllItems();
        }
        if(cbPersonal.getSelectedIndex()==2){
     
                 doctor=true;
                 paciente=false;
                 ingreso=false;
                 elimibt.setEnabled(false);
consultas(cbPersonal.getSelectedItem().toString());
           txtape.setEnabled(false);
    txtcod.setEnabled(false);
     txtcod1.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
         cbpaciente.setEnabled(false);
         cbdoctor.setEnabled(false);
         numcam.setEnabled(false);
       dia1.setEnabled(false);
          mes1.setEnabled(false);
          anio1.setEnabled(false);
          dia.setEnabled(false);
          mes.setEnabled(false);
          anio.setEnabled(false);
            btinser.setEnabled(false);
            txtape.setText("");
    txtcod.setText("");
      txtcod1.setText("");
      numcam.setText("");
      numhab.setText("");
      dia.setText("");
      mes.setText("");
      anio.setText("");
       dia1.setText("");
      mes1.setText("");
      anio1.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
btmodi.setEnabled(false); 
btcancel.setEnabled(false);
numhab.setEnabled(false);
modibt.setEnabled(false);
cbpaciente.removeAllItems();
   cbdoctor.removeAllItems();
        }
        if(cbPersonal.getSelectedIndex()==3){
     ingreso=true;
       paciente=false;
       doctor=false;
       cbpaciente.setEnabled(false);
         cbdoctor.setEnabled(false);
         numcam.setEnabled(false);
         elimibt.setEnabled(false);
         modibt.setEnabled(false);
                   txtape.setEnabled(false);
    txtcod.setEnabled(false);
     txtcod1.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
     dia1.setEnabled(false);
          mes1.setEnabled(false);
          anio1.setEnabled(false);
           dia.setEnabled(false);
          mes.setEnabled(false);
          anio.setEnabled(false);
            btinser.setEnabled(false);
            numhab.setEnabled(false);
btmodi.setEnabled(false); 
btcancel.setEnabled(false);
   txtape.setText("");
    txtcod.setText("");
      txtcod1.setText("");
      numcam.setText("");
      numhab.setText("");
      dia.setText("");
      mes.setText("");
      anio.setText("");
       dia1.setText("");
      mes1.setText("");
      anio1.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
consultas(cbPersonal.getSelectedItem().toString());
         try{
Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery("select identificacion, nombres from paciente");
while (rs.next()) {
     String identificacion = rs.getString("identificacion");
        String nombreUsuario = rs.getString("nombres");
      
     
        cbpaciente.addItem(identificacion+" - "+nombreUsuario);
        
    }
         rs.close();
stmt.close();
}catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}

try{
Statement stmt2 = conn.createStatement();

ResultSet rs2 = stmt2.executeQuery("select codigo_med, apellidos from medico");
while (rs2.next()) {
     String codigo = rs2.getString("codigo_med");
        String apellidos = rs2.getString("apellidos");
        cbdoctor.addItem(codigo+" - "+apellidos);
    }
         rs2.close();
stmt2.close();

}catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
       
        }
        
        
    }//GEN-LAST:event_cbPersonalActionPerformed
public void consultas(String personal){
    DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
         try{
Statement stmt = conn.createStatement();
modelo.setColumnCount(0);
ResultSet rs = stmt.executeQuery("select*from "+personal);
 
for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
      modelo.addColumn(rs.getMetaData().getColumnName(i));
            }
int f = modelo.getRowCount();
 
for (int i = 0; i < f; i++) {
 
    modelo.removeRow(0);
}

Object[] row=null;
while (rs.next()) {
 row = new Object[rs.getMetaData().getColumnCount()];
    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
        row[i - 1] = rs.getObject(i);
     
    }
    
     modelo.addRow(row);   
}
 

rs.close();
stmt.close();
insert.setEnabled(true);
btactu.setEnabled(true);
}catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
 
    
    
}
    private void cbordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbordenActionPerformed
 DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
        if(cborden.getSelectedIndex()==1){
         

TableRowSorter<DefaultTableModel> orden = new TableRowSorter<>(modelo);
tbconsul.setRowSorter(orden);

List<RowSorter.SortKey> sortKeys = new ArrayList<>();
sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
orden.setSortKeys(sortKeys);
orden.sort();
          
      }
        if(cborden.getSelectedIndex()==2){

TableRowSorter<DefaultTableModel> orden = new TableRowSorter<>(modelo);
tbconsul.setRowSorter(orden);

List<RowSorter.SortKey> sortKeys = new ArrayList<>();
sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
orden.setSortKeys(sortKeys);
orden.sort();
          
      }
    }//GEN-LAST:event_cbordenActionPerformed

    private void rbdatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdatosActionPerformed
if(todos==true){
     reportes("select*from paciente");
}if(especifico==true){
    reportes("select * from paciente where identificacion = "+datoespe);

}
     
        
        
    }//GEN-LAST:event_rbdatosActionPerformed
 
     public void reportes(String consulta){
         DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
         try{
            
Statement stmt = conn.createStatement();
modelo.setColumnCount(0);
ResultSet rs = stmt.executeQuery(consulta);
 
for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
      modelo.addColumn(rs.getMetaData().getColumnName(i));
            }
int f = modelo.getRowCount();
 
for (int i = 0; i < f; i++) {
 
    modelo.removeRow(0);
}

Object[] row=null;
while (rs.next()) {
 row = new Object[rs.getMetaData().getColumnCount()];
    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
        row[i - 1] = rs.getObject(i);
     
    }
    
            modelo.addRow(row);   
}

rs.close();
stmt.close();

}catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
     }
        
   
    public void actionPerformed(ActionEvent e) {
     String consulta = "SELECT nombres, apellidos";
        boolean primero = true;

        if (rbnombre.isSelected()&&rbdatos.isSelected()==false) {
           
            reportes(consulta+" from paciente");
        }

        if (rdfecha.isSelected()&&rbdatos.isSelected()==false &&rbnombre.isSelected()) {
            reportes(consulta+", fecha_nacimiento from paciente");
            
          
        }
     
}

    private void TabladtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladtMouseClicked
       //DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
        int row = Tabladt.rowAtPoint(evt.getPoint());
        int col = Tabladt.columnAtPoint(evt.getPoint());

        // Realizar la acción deseada con los valores seleccionados
        Object value = Tabladt.getValueAt(row, col);
        System.out.println("Se ha seleccionado el valor: " + value);
        
         modibt.setEnabled(true);
        elimibt.setEnabled(true);
   
     
    }//GEN-LAST:event_TabladtMouseClicked

    public void insertardatos(boolean paciente, boolean doctor, boolean ingreso){
        if(paciente ==true){
         PreparedStatement ps;
        String sql;
        if(txtape.getText().equals("")||txtcod.getText().equals("")||txtcodp.getText().equals("")||
   txtdir.getText().equals("")||txtespe.getText().equals("")&&txtespe.isEnabled()==true||txtnombre.getText().equals("")||txtprov.getText().equals("")||
     txttelef.getText().equals("")){
    int respuesta = JOptionPane.showOptionDialog(null, "¿Esta seguro que desea dejar datos en blanco?", "INSERCCION DE DATOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

if (respuesta == JOptionPane.YES_OPTION) {
     try{
            sql = "insert into paciente(identificacion,nombres,apellidos, fecha_nacimiento,provincia,codigo_postal,direccion,telefono)"
                    + " values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtcod.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtape.getText());
             ps.setString(4, dia.getText()+"/"+mes.getText()+"/"+anio.getText());
                ps.setString(5, txtprov.getText());
                  ps.setString(6, txtcodp.getText());
                    ps.setString(7, txtdir.getText());
                       ps.setString(8, txttelef.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos en PACIENTE");
            panel.append("*Inserccion: codigo:"+txtcod.getText()+"Nombres:"+txtnombre.getText()+"Apellidos:"
            +txtape.getText()+"\n");
          
           
        }catch(SQLException e){
          
           
            if(e.getErrorCode()==00001){
                JOptionPane.showMessageDialog(null, "Identificacion ya existente, verifique sus datos");
                 this.paciente=true;
            }
            
            
            
            else{
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            }
        }
}else{
    this.paciente=true;
}
         
    }else{
            try{
            sql = "insert into paciente(identificacion,nombres,apellidos, fecha_nacimiento,provincia,codigo_postal,direccion,telefono)"
                    + " values(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtcod.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtape.getText());
             ps.setString(4, dia.getText()+"/"+mes.getText()+"/"+anio.getText());
                ps.setString(5, txtprov.getText());
                  ps.setString(6, txtcodp.getText());
                    ps.setString(7, txtdir.getText());
                       ps.setString(8, txttelef.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos en PACIENTE");
            panel.append("*Inserccion: codigo:"+txtcod.getText()+"Nombres:"+txtnombre.getText()+"Apellidos:"
            +txtape.getText()+"\n");
          
           
        }catch(SQLException e){
          
           
            if(e.getErrorCode()==00001){
                JOptionPane.showMessageDialog(null, "Identificacion ya existente, verifique sus datos");
                 this.paciente=true;
            }
            
            
            
            else{
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            }
        }
        }
        }
        
         if(doctor==true){
              PreparedStatement ps;
        String sql;
        if(txtape.getText().equals("")||txtcod.getText().equals("")||txtespe.getText().equals("")&&txtespe.isEnabled()==true||txtnombre.getText().equals("")||
     txttelef.getText().equals("")){
         int respuesta = JOptionPane.showOptionDialog(null, "¿Esta seguro que desea dejar datos en blanco?", "INSERCCION DE DATOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

if (respuesta == JOptionPane.YES_OPTION) {
        
              try{
            sql = "insert into medico(codigo_med,nombres,apellidos, especialidad,telefono)"
                    + " values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtcod.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtape.getText());
             ps.setString(4, txttelef.getText());
              ps.setString(5, txtespe.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos en doctor");
            panel.append("*Inserccion: codigo: "+txtcod.getText()+" Nombres: "+txtnombre.getText());
            
           
        }catch(SQLException e){
           
            if(e.getErrorCode()==00001){
                JOptionPane.showMessageDialog(null, "Identificacion ya existente, verifique sus datos");
                this.doctor=true;
            }else{
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
                this.doctor=true;
            }
        }
         }
else{
    this.doctor=true;
}
        }else{
                 try{
            sql = "insert into medico(codigo_med,nombres,apellidos, especialidad,telefono)"
                    + " values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtcod.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtape.getText());
             ps.setString(4, txttelef.getText());
              ps.setString(5, txtespe.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos en doctor");
            panel.append("*Inserccion: codigo: "+txtcod.getText()+" Nombres: "+txtnombre.getText());
            
           
        }catch(SQLException e){
           
            if(e.getErrorCode()==00001){
                JOptionPane.showMessageDialog(null, "Identificacion ya existente, verifique sus datos");
                this.doctor=true;
            }else{
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
                this.doctor=true;
            }
        }
        }
         }
        
     
        if(ingreso ==true){
            PreparedStatement ps;
        String sql;
        
         try{
            sql = "insert into ingresos(codigo_ingreso,identificacion,cod_medico,num_cam, fecha_ingreso,num_habitacion)"
                    + " values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtcod1.getText());
            String[] ident = String.valueOf(cbpaciente.getSelectedItem().toString()).split(" - ");
             String[] ident2 = String.valueOf(cbdoctor.getSelectedItem().toString()).split(" - ");
            ps.setString(2, ident[0]);
             //System.out.println(ident[0]);
            ps.setString(3, ident2[0]);
             ps.setString(4, numcam.getText());
                ps.setString(5, dia1.getText()+"/"+mes1.getText()+"/"+anio1.getText());
                  ps.setString(6, numhab.getText());
                    
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos en ingresos");
            panel.append("*Inserccion/ codigo: "+txtcod1.getText()+cbpaciente.getSelectedItem().toString());
           
           
        }catch(SQLException e){
            
           
            if(e.getErrorCode()==00001){
                JOptionPane.showMessageDialog(null, "Identificacion ya existente, verifique sus datos");
                 this.ingreso=true;
                
            }
            
            if(e.getErrorCode()==00001&&cbPersonal.getSelectedIndex()==3){
                JOptionPane.showMessageDialog(null, "Doctor ya asignado");
                 this.ingreso=true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
            }
        }
              
         }
       
    }
    
    
    public void modificar(boolean paciente,boolean medico,boolean ingreso){
        if(paciente==true){
         try{
        String sql = "UPDATE paciente SET nombres=?,apellidos=?, fecha_nacimiento=?,provincia=?,"
                + "codigo_postal=?,direccion=?,telefono=? where "+Tabladt.getColumnName(0)+ "=?";
    PreparedStatement statement = conn.prepareStatement(sql);
             System.out.println(Tabladt.getColumnName(0)+"|"+Tabladt.getColumnName(0));
            statement.setString(1, txtnombre.getText());
            statement.setString(2, txtape.getText());
               statement.setString(3, dia.getText()+"/"+mes.getText()+"/"+anio.getText());
                statement.setString(4, txtprov.getText());
                  statement.setString(5, txtcodp.getText());
                    statement.setString(6, txtdir.getText());
                       statement.setString(7, txttelef.getText());
    statement.setString(8, txtcod.getText());
   
    if(statement.executeUpdate()>0){

              JOptionPane.showMessageDialog(null,"SE HA MODIFICADO VALORES A: "+txtcod.getText());
               panel.append("*Modificacion: codigo:"+txtcod.getText()+"Se le ha modificado datos\n");
    }
     }catch(SQLException e ){
          
         JOptionPane.showMessageDialog(null, e);
     }
         try{
             Tabladt.getColumnName(0);
         }catch(java.lang.ArrayIndexOutOfBoundsException j){
             System.out.println("cambio de valor");
         }
        }
         
         if(medico==true){
         try{
             
        String sql = "UPDATE medico SET codigo_med=?,nombres=?,apellidos=?, especialidad=?,telefono=? where "+Tabladt.getColumnName(0)+" =?";
    PreparedStatement statement = conn.prepareStatement(sql);

   
   statement.setString(1, txtcod.getText());
            statement.setString(2, txtnombre.getText());
            statement.setString(3, txtape.getText());
          statement.setString(4, txtespe.getText());
               statement.setString(5, txttelef.getText());
               statement.setString(6, txtcod.getText());
    panel.append("*Modificacion: codigo: "+txtcod.getText()+" Se le ha modificado datos;\n");
    if(statement.executeUpdate()>0){
  
   JOptionPane.showMessageDialog(null,"SE HA MODIFICADO VALORES A: "+txtcod.getText()+" "+ txtnombre.getText());
    }
     }catch(SQLException e){
    
         JOptionPane.showMessageDialog(null, e);
     }
        }
         
         if(ingreso==true){
         try{
            
        String sql = "UPDATE ingresos SET codigo_ingreso=?,identificacion=?,cod_medico=?,num_cam=?,fecha_ingreso=?, num_habitacion=? where " +Tabladt.getColumnName(0)+" =?";
    PreparedStatement statement = conn.prepareStatement(sql);


   statement.setString(1, txtcod1.getText().trim());
             System.out.println(txtcod1.getText());
            statement.setString(4, numcam.getText());
             String[] ident2 = String.valueOf(cbdoctor.getSelectedItem().toString()).split(" - ");
           
             String[] ident = String.valueOf(cbpaciente.getSelectedItem().toString()).split(" - ");
            
            statement.setString(3, ident2[0]);
            statement.setString(2, ident[0]);
            statement.setString(5, dia1.getText()+"/"+mes1.getText()+"/"+anio1.getText());
          statement.setString(6, numhab.getText());
statement.setString(7, txtcod1.getText().trim());
    panel.append("*Modificacion: codigo: "+txtcod1.getText()+" Se le ha modificado datos;\n");
    if(statement.executeUpdate()>0){

              JOptionPane.showMessageDialog(null,"SE HA MODIFICADO VALORES A: "+txtcod1.getText());
    }
     }catch(SQLException e){
       
         JOptionPane.showMessageDialog(null, e);
     }
        }
         
       
         
    }
    
  
    private void btinserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btinserActionPerformed
  insertardatos(paciente,doctor,ingreso);
        
        
 dia.setText("");
 mes.setText("");
anio.setText("");
  txtape.setText("");
    txtcod.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
btcancel.setEnabled(false);
   
        
 
 
    }//GEN-LAST:event_btinserActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
if(cbPersonal.getSelectedIndex()==1){
     txtcod.setEditable(true);
          
         txtape.setEnabled(true);
    txtcod.setEnabled(true);
   txtcodp.setEnabled(true);
   txtdir.setEnabled(true);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(true);
     txtprov.setEnabled(true);
     txttelef.setEnabled(true);
    dia.setEnabled(true);
         mes.setEnabled(true);
          anio.setEnabled(true);
        numhab.setEnabled(false);
     generar.setEnabled(false);
}
if(cbPersonal.getSelectedIndex()==2){
         txtape.setEnabled(true);
    txtcod.setEnabled(true);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(true);
    txtnombre.setEnabled(true);
     txtprov.setEnabled(false);
     txttelef.setEnabled(true);
    dia.setEnabled(false);
         mes.setEnabled(false);
          anio.setEnabled(false);
    numhab.setEnabled(false);
     generar.setEnabled(false);
}
if(cbPersonal.getSelectedIndex()==3){
    txtcod1.setEditable(true);
    cbpaciente.setEnabled(true);
    cbdoctor.setEnabled(true);
         txtape.setEnabled(false);
    txtcod1.setEnabled(true);
     txtcod.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
    dia1.setEnabled(true);
         mes1.setEnabled(true);
          anio1.setEnabled(true);
          numhab.setEnabled(true);
          numcam.setEnabled(true);
          numhab.setEnabled(true);
    generar.setEnabled(true);
}
        
        
   btinser.setEnabled(true);
btmodi.setEnabled(false); 
btcancel.setEnabled(true);
 panel.setEnabled(true);
 
estaddato.setText("Inserccion de datos");

        
    }//GEN-LAST:event_insertActionPerformed

    private void modibtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modibtActionPerformed
btinser.setEnabled(false);
btmodi.setEnabled(true);
txtcod.setEditable(false);
txtcod1.setEditable(false);
btcancel.setEnabled(true);

 if(cbPersonal.getSelectedIndex()==1){
     
         txtape.setEnabled(true);
    txtcod.setEnabled(true);
   txtcodp.setEnabled(true);
   txtdir.setEnabled(true);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(true);
     txtprov.setEnabled(true);
     txttelef.setEnabled(true);
    dia.setEnabled(true);
         mes.setEnabled(true);
          anio.setEnabled(true);
        numhab.setEnabled(false);
    estaddato.setText("Modificacion de datos");
        DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
        int filaSeleccionada = Tabladt.getSelectedRow();
      
        if (filaSeleccionada >= 0) {
           
            Object dato1 = modelo.getValueAt(filaSeleccionada, 0);
            Object dato2 = modelo.getValueAt(filaSeleccionada, 1);
            Object dato3 = modelo.getValueAt(filaSeleccionada, 2);
             Object dato4 = modelo.getValueAt(filaSeleccionada, 3);
              Object dato5 = modelo.getValueAt(filaSeleccionada,4);
               Object dato6 = modelo.getValueAt(filaSeleccionada, 5);
                Object dato7 = modelo.getValueAt(filaSeleccionada, 6);
                 Object dato8 = modelo.getValueAt(filaSeleccionada, 7);
                    
         txtape.setText(dato3+"");
    txtcod.setText(dato1+"");
   txtcodp.setText(dato6+"");
   txtdir.setText(dato7+"");
   
String[] numeros = String.valueOf(dato4).split("/");
 dia.setText(numeros[0]);
 mes.setText(numeros[1]);
anio.setText(numeros[2]);

    txtnombre.setText(dato2+"");
     txtprov.setText(dato5+"");
     txttelef.setText(dato8+"");
        
        
        }
   
        
}
if(cbPersonal.getSelectedIndex()==2){
         txtape.setEnabled(true);
    txtcod.setEnabled(true);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(true);
    txtnombre.setEnabled(true);
     txtprov.setEnabled(false);
     txttelef.setEnabled(true);
    dia.setEnabled(false);
         mes.setEnabled(false);
          anio.setEnabled(false);
    numhab.setEnabled(false);
    
    estaddato.setText("Modificacion de datos");
        DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
        int filaSeleccionada = Tabladt.getSelectedRow();
        
        if (filaSeleccionada >= 0) {
         
            Object dato1 = modelo.getValueAt(filaSeleccionada, 0);
            Object dato2 = modelo.getValueAt(filaSeleccionada, 1);
            Object dato3 = modelo.getValueAt(filaSeleccionada, 2);
             Object dato4 = modelo.getValueAt(filaSeleccionada, 3);
              Object dato5 = modelo.getValueAt(filaSeleccionada,4);
               
         txtape.setText(dato3+"");
    txtcod.setText(dato1+"");
 
txtespe.setText(dato4+"");
    txtnombre.setText(dato2+"");
     txttelef.setText(dato5+"");
   
        }
    
}
if(cbPersonal.getSelectedIndex()==3){
    cbpaciente.setEnabled(true);
    cbdoctor.setEnabled(true);
         txtape.setEnabled(false);
    txtcod1.setEnabled(true);
     txtcod.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
    dia1.setEnabled(true);
         mes1.setEnabled(true);
          anio1.setEnabled(true);
          numhab.setEnabled(true);
          numcam.setEnabled(true);
          numhab.setEnabled(true);
            DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
        int filaSeleccionada = Tabladt.getSelectedRow();
      
        if (filaSeleccionada >= 0) {
        
            Object dato1 = modelo.getValueAt(filaSeleccionada, 0);
             Object dato4 = modelo.getValueAt(filaSeleccionada, 3);
              Object dato5 = modelo.getValueAt(filaSeleccionada,4);
               Object dato6 = modelo.getValueAt(filaSeleccionada, 5);
            
            
    txtcod1.setText(dato1+"");
   numcam.setText(dato4+"");
   numhab.setText(dato6+"");
String[] numeros = String.valueOf(dato5).split("/");
 dia1.setText(numeros[0]);
 mes1.setText(numeros[1]);
anio1.setText(numeros[2]);

        }
     
}

        
    }//GEN-LAST:event_modibtActionPerformed

    private void btmodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodiActionPerformed

       
        modificar(paciente,doctor,ingreso);
       txtape.setText("");
    txtcod.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
      dia.setText("");
 mes.setText("");
anio.setText("");
dia.setText("");
 mes.setText("");
anio.setText("");
btcancel.setEnabled(false);
    }//GEN-LAST:event_btmodiActionPerformed

    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelActionPerformed
  txtape.setText("");
    txtcod.setText("");
      txtcod1.setText("");
      numcam.setText("");
      numhab.setText("");
      dia.setText("");
      mes.setText("");
      anio.setText("");
       dia1.setText("");
      mes1.setText("");
      anio1.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
btcancel.setEnabled(false);

    }//GEN-LAST:event_btcancelActionPerformed

    private void btactuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btactuActionPerformed
cbPersonal.setSelectedIndex(cbPersonal.getSelectedIndex());
         txtape.setEnabled(false);
     elimibt.setEnabled(false);
    txtcod.setEnabled(false);
     txtcod1.setEnabled(false);
   txtcodp.setEnabled(false);
   txtdir.setEnabled(false);
     txtespe.setEnabled(false);
    txtnombre.setEnabled(false);
     txtprov.setEnabled(false);
     txttelef.setEnabled(false);
     dia1.setEnabled(false);
          mes1.setEnabled(false);
          anio1.setEnabled(false);
           dia.setEnabled(false);
          mes.setEnabled(false);
          anio.setEnabled(false);
          int selectedRow = Tabladt.getSelectedRow();


if(selectedRow != -1){
    Tabladt.getSelectionModel().removeSelectionInterval(selectedRow, selectedRow);
}
    }//GEN-LAST:event_btactuActionPerformed

    private void elimibtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimibtActionPerformed
   Object dato1=null,dato2=null;//dato3,dato4,dato5,dato6,dato7,dato8;
        DefaultTableModel modelo =(DefaultTableModel)Tabladt.getModel();
        int filaSeleccionada = Tabladt.getSelectedRow();
      
        if (filaSeleccionada >= 0) {
         
           dato1 = modelo.getValueAt(filaSeleccionada, 0);
             dato2 = modelo.getValueAt(filaSeleccionada, 1);
                }
  int respuesta = JOptionPane.showOptionDialog(null, "¿Esta seguro que desea borra a este usuario:"+String.valueOf(dato1)+";"+String.valueOf(dato2)+""+"?", "Guardar cambios", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

if (respuesta == JOptionPane.YES_OPTION) {
   try{
       System.out.println(cbPersonal.getSelectedItem().toString()+dato1);
   String sql = "DELETE FROM "+ cbPersonal.getSelectedItem().toString()+" WHERE "+Tabladt.getColumnName(0)+"= ?";
 PreparedStatement statement = conn.prepareStatement(sql);
  
   statement.setString(1, String.valueOf(dato1));

    statement.executeUpdate();

     panel.append("*Eliminacion: codigo:"+dato1+"Se ha eliminado usuario\n");
    JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado correctamente.");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, e);
}
    
} else {
 
}
txtape.setText("");
    txtcod.setText("");
      txtcod1.setText("");
      numcam.setText("");
      numhab.setText("");
      dia.setText("");
      mes.setText("");
      anio.setText("");
       dia1.setText("");
      mes1.setText("");
      anio1.setText("");
   txtcodp.setText("");
   txtdir.setText("");
    txtespe.setText("");
    txtnombre.setText("");
     txtprov.setText("");
     txttelef.setText("");
        
    }//GEN-LAST:event_elimibtActionPerformed

    private void diaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_diaFocusLost
       if(dia.getText().length()>=2){
        if(Integer.parseInt(dia.getText().trim())>31||Integer.parseInt(dia.getText().trim())<=0){
         
           dia.setText("");
        java.awt.Toolkit.getDefaultToolkit().beep();
       }
         
        
       }
        
    }//GEN-LAST:event_diaFocusLost

    private void diaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_diaFocusGained
      dia.setText("");
    }//GEN-LAST:event_diaFocusGained

    private void diaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diaKeyTyped
    int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }

        
        if(dia.getText().length()>=2){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt(dia.getText().trim())>31||Integer.parseInt(dia.getText().trim())<=0){
                System.out.println(dia.getText());
           evt.consume();
           dia.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        }
    }//GEN-LAST:event_diaKeyTyped

    private void mesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesKeyTyped
         int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }

        if(mes.getText().length()>=2){
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt(mes.getText().trim())>12||Integer.parseInt(mes.getText().trim())<=0){
                System.out.println(dia.getText());
           evt.consume();
           mes.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
       }
    }//GEN-LAST:event_mesKeyTyped

    private void anioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anioKeyTyped
      int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }

        if(anio.getText().length()>=4){
           evt.consume();
          
           java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt(anio.getText().trim())<2000||Integer.parseInt(anio.getText().trim())>=2050){   
          anio.setText("");
           java.awt.Toolkit.getDefaultToolkit().beep();
        }   
       }
        
    }//GEN-LAST:event_anioKeyTyped

    private void anioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anioFocusLost
       if(anio.getText().length()>=4){
          
            if(anio.getText().length()<4||Integer.parseInt(anio.getText().trim())<2000||Integer.parseInt(anio.getText().trim())>=2050){   
          anio.setText("");
           java.awt.Toolkit.getDefaultToolkit().beep();
        }   
       }
    }//GEN-LAST:event_anioFocusLost

    private void mesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mesFocusLost
      if(mes.getText().length()>=2){
        if(Integer.parseInt(mes.getText().trim())>12||Integer.parseInt(mes.getText().trim())<=0){
                System.out.println(mes.getText());
           
           mes.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
        }
    }//GEN-LAST:event_mesFocusLost

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void dia1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dia1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dia1FocusGained

    private void dia1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dia1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dia1FocusLost

    private void dia1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dia1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dia1KeyTyped

    private void mes1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mes1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_mes1FocusLost

    private void mes1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mes1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mes1KeyTyped

    private void anio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anio1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_anio1FocusLost

    private void anio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anio1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_anio1KeyTyped

    private void txtcodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcodFocusLost
        
    }//GEN-LAST:event_txtcodFocusLost

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
      if(cbPersonal.getSelectedIndex()==1){
        
          int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
          if( txtcod.getText().length()>=10){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt( txtcod.getText().trim())>31||Integer.parseInt( txtcod.getText().trim())<=0){
                System.out.println( txtcod.getText());
           evt.consume();
            txtcod.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        }
      }
       if(cbPersonal.getSelectedIndex()==2){
        if( txtcod.getText().length()>=4){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt( txtcod.getText().trim())>31||Integer.parseInt( txtcod.getText().trim())<=0){
                System.out.println( txtcod.getText());
           evt.consume();
            txtcod.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        }
      }
      
      
    }//GEN-LAST:event_txtcodKeyTyped

    private void txtcod1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcod1FocusLost
      
    }//GEN-LAST:event_txtcod1FocusLost

    private void txtcod1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcod1KeyTyped
 if( txtcod1.getText().length()>=4){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt( txtcod1.getText().trim())>31||Integer.parseInt( txtcod1.getText().trim())<=0){
                System.out.println( txtcod1.getText());
           evt.consume();
            txtcod1.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        }        
    }//GEN-LAST:event_txtcod1KeyTyped

    private void numcamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numcamKeyTyped
       if( numcam.getText().length()>=4){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt( numcam.getText().trim())>31||Integer.parseInt( numcam.getText().trim())<=0){
                System.out.println( numcam.getText());
           evt.consume();
            numcam.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        }        
    }//GEN-LAST:event_numcamKeyTyped

    private void numhabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numhabKeyTyped
      if( numhab.getText().length()>=4){
            
           evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
            if(Integer.parseInt( numhab.getText().trim())>31||Integer.parseInt( numhab.getText().trim())<=0){
                System.out.println( numhab.getText());
           evt.consume();
            numhab.setText("");
            java.awt.Toolkit.getDefaultToolkit().beep();
       }
        } 
        
        
    }//GEN-LAST:event_numhabKeyTyped

    private void rbnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnombreActionPerformed
if(todos==true){
        
        String consulta = "select nombres' '||apellidos as nombres_completos ";
       

        if (rbnombre.isSelected()) {
           
            reportes(consulta+" from paciente");
         
            System.out.println("todo");
        }
}
if(especifico==true){
        
        String consulta = "select nombres' '||apellidos as nombres_completos ";
     

        if (rbnombre.isSelected()) {
            
            reportes(consulta+" from paciente where identificacion = "+datoespe);
            System.out.println("espe");
            
        }
}

/*
         if(rbnombre.isSelected()==false){
        DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
    int indiceColumna = modelo.findColumn("NOMBRES_COMPLETOS");
         if (indiceColumna != -1) {
            tbconsul.removeColumn(tbconsul.getColumnModel().getColumn(indiceColumna));
           
        }
        }
        */

        
    }//GEN-LAST:event_rbnombreActionPerformed

    private void rdfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdfechaActionPerformed
if(todos==true){
if (rdfecha.isSelected()) {
            reportes("select nombres' '||apellidos as nombres_completos ,fecha_nacimiento from paciente");
             
            
        }


}      

if(especifico ==true){
if (rdfecha.isSelected()) {
            reportes("select nombres' '||apellidos as nombres_completos ,fecha_nacimiento from paciente where identificacion =" +datoespe);
             //rbdatos.setEnabled(false);
            
        }
if (rdfecha.isSelected()) {
            reportes("select identificacion, nombres, fecha_nacimiento from paciente where identificacion ="+datoespe);
             
            
        }

} 


/*
        if(rdfecha.isSelected()==false){
             DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
    int indiceColumna = modelo.findColumn("FECHA_NACIMIENTO");
        if (indiceColumna != -1) {
            tbconsul.removeColumn(tbconsul.getColumnModel().getColumn(indiceColumna));
           
        }
        }
            */
        
    }//GEN-LAST:event_rdfechaActionPerformed

    private void bttodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttodosActionPerformed
 todos=true;
        lbselec.setText("General");
 reportes("select * from paciente");
        txtbuscar.setEnabled(false);
        btbuscar.setEnabled(false);
        especifico=false;
       datoespe="";
        System.out.println(todos+"td "+especifico+"es");
        rbingre.setEnabled(true);
rbfingre.setEnabled(true);
rbdoc.setEnabled(true);
 rbdatos.setEnabled(true);
 rbnombre.setEnabled(true);
 Direccion.setEnabled(true);
        rdfecha.setEnabled(true);
  rbid.setEnabled(true);
  

 
 
 
    }//GEN-LAST:event_bttodosActionPerformed

    private void dtespeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtespeActionPerformed
      txtbuscar.setEnabled(true);
        btbuscar.setEnabled(true);
        reportes("select * from paciente");
        todos=false;
         especifico=true;
        if(bttodos.isSelected()==false){
            lbselec.setText("Seleccione a un dato");
            rbingre.setEnabled(false);
rbfingre.setEnabled(false);
rbdoc.setEnabled(false);
 rbdatos.setEnabled(false);
 rbnombre.setEnabled(false);
 Direccion.setEnabled(false);
     rdfecha.setEnabled(false);
        rbid.setEnabled(false);
        }
         
        
       
        
    }//GEN-LAST:event_dtespeActionPerformed

    private void rbingreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbingreActionPerformed
if(todos==true){     
        if (rbingre.isSelected()&&rbdatos.isSelected()==false &&rbnombre.isSelected()==false&&rdfecha.isSelected()==false) {
            reportes("select*from ingresos");
            
           
        }
        if(rbingre.isSelected()==false){
             DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
   modelo.setRowCount(0);
   
        }
        
}
if(especifico==true){
    if (rbingre.isSelected()&&rbdatos.isSelected()==false &&rbnombre.isSelected()==false&&rdfecha.isSelected()==false) {
            reportes("select * from ingresos where identificacion = "+datoespe);
           
        }
    
    
}


        
    }//GEN-LAST:event_rbingreActionPerformed

    private void rbdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbdocActionPerformed
     if(todos==true){  
        if (rbdoc.isSelected()&&rbdatos.isSelected()==false &&rbnombre.isSelected()==false&&rdfecha.isSelected()==false) {
            reportes("SELECT p.nombres, d.COD_MEDICO, m.NOMBRES, m.APELLIDOS FROM paciente p JOIN ingresos d ON p.IDENTIFICACION = d.IDENTIFICACION JOIN medico m ON m.CODIGO_MED= d.COD_MEDICO");
           
        }
     }
           
    
      if(especifico==true){
                
     if (rbdoc.isSelected()&&rbdatos.isSelected()==false &&rbnombre.isSelected()==false&&rdfecha.isSelected()==false) {
      reportes("SELECT  p.nombres, d.COD_MEDICO, m.NOMBRES, m.APELLIDOS FROM paciente p JOIN ingresos d ON p.IDENTIFICACION = d.IDENTIFICACION JOIN medico m ON m.CODIGO_MED= d.COD_MEDICO where p.IDENTIFICACION ="+datoespe);
           
        }
                
            }
            
            
    }//GEN-LAST:event_rbdocActionPerformed

    private void rbfingreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfingreActionPerformed
if(todos==true){
    if ( rbfingre.isSelected()) {
    reportes(" SELECT p.IDENTIFICACION, p.nombres,p.APELLIDOS, d.FECHA_INGRESO FROM paciente p JOIN ingresos d ON p.IDENTIFICACION = d.IDENTIFICACION");
           
        } 
}    
       
        if(especifico==true){
            if ( rbfingre.isSelected()) {
 reportes(" SELECT  p.nombres||' '||p.apellidos   as nombres_completos, i.FECHA_INGRESO from ingresos i inner join paciente p on i.IDENTIFICACION=p.IDENTIFICACION where p.IDENTIFICACION= "+datoespe);
           
        } 
        }
        
    }//GEN-LAST:event_rbfingreActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
        DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
if(!txtbuscar.getText().equals("")){
    
        for (int row = 0; row < tbconsul.getRowCount(); row++) {
        for (int col = 0; col < tbconsul.getColumnCount(); col++) {
            String cellText = String.valueOf(tbconsul.getValueAt(row, col)).toLowerCase();
            if (cellText.contains(txtbuscar.getText())) {
                tbconsul.getSelectionModel().setSelectionInterval(row, row);
             int filaSeleccionada = tbconsul.getSelectedRow();
             Rectangle rect = tbconsul.getCellRect(row, 0, true);
tbconsul.scrollRectToVisible(rect);
       
        if (filaSeleccionada >= 0) {
          
            datoespe=modelo.getValueAt(filaSeleccionada, 0).toString().trim();
             lbselec.setText(datoespe);
          rbingre.setEnabled(true);
rbfingre.setEnabled(true);
rbdoc.setEnabled(true);
 rbdatos.setEnabled(true);
 rbnombre.setEnabled(true);
 Direccion.setEnabled(true);
     rdfecha.setEnabled(true);
        rbid.setEnabled(true);
       
        }
                return;
            }
          
       
        }
            
        }
        JOptionPane.showMessageDialog(null, "No encontrado");
}if(txtbuscar.getText().equals("")){
     JOptionPane.showMessageDialog(null, "INGRESE UN ID O C.I.");
}



    }//GEN-LAST:event_btbuscarActionPerformed

    private void tbconsulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbconsulMouseClicked
 DefaultTableModel modelo =(DefaultTableModel)tbconsul.getModel();
        int filaSeleccionada = tbconsul.getSelectedRow();
       
        if (filaSeleccionada >= 0) {
          
            datoespe=modelo.getValueAt(filaSeleccionada, 0).toString().trim();
            lbselec.setText(datoespe);
        
              rbingre.setEnabled(true);
rbfingre.setEnabled(true);
rbdoc.setEnabled(true);
 rbdatos.setEnabled(true);
 rbnombre.setEnabled(true);
 Direccion.setEnabled(true);
     rdfecha.setEnabled(true);
        rbid.setEnabled(true);
        dtespe.setSelected(true);
         todos=false;
         especifico=true;
         btbuscar.setEnabled(true);
         txtbuscar.setEnabled(true);
        } 
        
        
        
        
    }//GEN-LAST:event_tbconsulMouseClicked

    private void actubtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actubtActionPerformed
  reportes("select*from paciente");
  bttodos.setEnabled(true);
  dtespe.setEnabled(true);
  cborden.setEnabled(true);
int selectedRow = tbconsul.getSelectedRow();


if(selectedRow != -1){
    tbconsul.getSelectionModel().removeSelectionInterval(selectedRow, selectedRow);
}
    }//GEN-LAST:event_actubtActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
       int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }

    }//GEN-LAST:event_txtbuscarKeyTyped

    private void rbidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbidActionPerformed

         if(todos==true){
if (rbid.isSelected()) {
            reportes("select identificacion, nombres||' '||apellidos as nombres_completos from paciente");
        
        }
       }
if(especifico==true){
    if (rbid.isSelected()) {
            reportes("select identificacion, nombres||' '||apellidos as nombres_completos from paciente where identificacion ="+datoespe);
           
            
        }
}
   
        
    }//GEN-LAST:event_rbidActionPerformed

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
       if(todos==true){
if (Direccion.isSelected()) {
            reportes("select nombres||' '||apellidos as nombres_completos ,direccion, provincia, codigo_postal from paciente");
            
        }
       }
if(especifico==true){
    if (Direccion.isSelected()) {
            reportes("select nombres||' '||apellidos as nombres_completos ,direccion, provincia, codigo_postal from paciente where identificacion ="+datoespe);
           
            
        }
}
    }//GEN-LAST:event_DireccionActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtcodpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodpKeyPressed
       if(dia.getText().length()>=5){
        if(Integer.parseInt(dia.getText().trim())>31||Integer.parseInt(dia.getText().trim())<=0){
         
           dia.setText("");
        java.awt.Toolkit.getDefaultToolkit().beep();
       }
         
        
       }
    }//GEN-LAST:event_txtcodpKeyPressed
private static final String CARACTERES_PERMITIDOS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
   
    private static final int LONGITUD_CODIGO = 4;
   
    private static SecureRandom random = new SecureRandom();
   
    public  String generarCodigo() {
       
        BigInteger numero = new BigInteger(32, random);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LONGITUD_CODIGO; i++) {
            int index = numero.mod(BigInteger.valueOf(CARACTERES_PERMITIDOS.length())).intValue();
            sb.append(CARACTERES_PERMITIDOS.charAt(index));
            numero = numero.divide(BigInteger.valueOf(CARACTERES_PERMITIDOS.length()));
        }
        
        return sb.toString();
    }
    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
       txtcod1.setText(generarCodigo());
       
    }//GEN-LAST:event_generarActionPerformed

    private void txttelefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefKeyTyped
       int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
          if(txttelef.getText().length()>=10){
        if(Integer.parseInt(txttelef.getText().trim())>31||Integer.parseInt(txttelef.getText().trim())<=0){
         
           txttelef.setText("");
        java.awt.Toolkit.getDefaultToolkit().beep();
       }
          }
        
        
        
    }//GEN-LAST:event_txttelefKeyTyped

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
            java.util.logging.Logger.getLogger(FrameTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTablas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Direccion;
    private javax.swing.JTable Tabladt;
    private javax.swing.JButton actubt;
    private javax.swing.JTextField anio;
    private javax.swing.JTextField anio1;
    private javax.swing.JButton btactu;
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btcancel;
    private javax.swing.JButton btinser;
    private javax.swing.JButton btmodi;
    private javax.swing.JRadioButton bttodos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbPersonal;
    private javax.swing.JComboBox<String> cbdoctor;
    private javax.swing.JComboBox<String> cborden;
    private javax.swing.JComboBox<String> cbpaciente;
    private javax.swing.JTextField dia;
    private javax.swing.JTextField dia1;
    private javax.swing.JLabel directlb;
    private javax.swing.JRadioButton dtespe;
    private javax.swing.JButton elimibt;
    private javax.swing.JLabel estaddato;
    private javax.swing.JLabel estadoconx;
    private javax.swing.JButton generar;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbselec;
    private javax.swing.JLabel lbuser;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField mes1;
    private javax.swing.JButton modibt;
    private javax.swing.JTextField numcam;
    private javax.swing.JTextField numhab;
    private javax.swing.JTabbedPane pane;
    private javax.swing.JTextArea panel;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panelmodi;
    private javax.swing.JRadioButton rbdatos;
    private javax.swing.JRadioButton rbdoc;
    private javax.swing.JRadioButton rbfingre;
    private javax.swing.JRadioButton rbid;
    private javax.swing.JRadioButton rbingre;
    private javax.swing.JRadioButton rbnombre;
    private javax.swing.JRadioButton rdfecha;
    private javax.swing.JTable tbconsul;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcod1;
    private javax.swing.JTextField txtcodp;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtespe;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprov;
    private javax.swing.JTextField txttelef;
    // End of variables declaration//GEN-END:variables
}
