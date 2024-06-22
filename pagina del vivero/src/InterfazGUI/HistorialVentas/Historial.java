package InterfazGUI.HistorialVentas;

import InterfazGUI.GUI;
import Historial.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;



/**
 * Clase que representa la ventana de historial de ventas.
 */
public class Historial extends javax.swing.JFrame {
    String ids[] = {"Numero", "Precio Total", "Fecha"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0);
    ClaseJson Historial=new ClaseJson();
    /**
     * Crea una nueva instancia de la ventana Historial.
     */
    public Historial() {
        initComponents();
        setTitle("Menu Historial");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable2.setModel(mt);
        ActualizarTabla();
        InitTableVentas(mt, LocalDate.now().toString());
        setResizable(false);
    }
    private void ActualizarTabla()
    {
        mt.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    System.out.println("ayudenme por favor me quiero suicidar");
                    actualizarTotal();

                }
            }
        });
    }
    private float actualizarTotal() {
        float total = 0;
        int rowCount = mt.getRowCount();
        // Verificar si hay filas en la tabla
        if (rowCount == 0) {
            txtTotal.setText("$0.0");
            return total;
        }
        for (int i = 0; i < rowCount; i++) {

            total += Float.parseFloat(jTable2.getValueAt(i,1 ).toString());
        }
        txtTotal.setText("$" + String.valueOf(total));
        return total;
    }
    private void InitTableVentas(DefaultTableModel mt, String fecha) {
        mt.setRowCount(0);
        if (Historial.archivoHistorial.exists()) {
            try {
                Historial= ClaseJson.cargarDesdeArchivoHistorial("archivoHistorial.json");
               ArrayList<Venta> Ventas=Historial.getHistorial();
               int contadorVentas=0;
               for(Venta i:Ventas)
               {
                   mt.addRow(new Object[]{contadorVentas+1, i.getPrecio_total(), i.getFechaActual()});
                   contadorVentas++;


               }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
            actualizarTotal();
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Método llamado desde el constructor para inicializar los componentes.
     * ADVERTENCIA: No modificar este código. El contenido de este método es
     * siempre generado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Buscar = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Fechas = new javax.swing.JLabel();
        txtFecha = crearFormattedTextField();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        Buscar.setBackground(new java.awt.Color(51, 102, 255));
        Buscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Buscar.setForeground(new java.awt.Color(0, 0, 0));
        Buscar.setText("Buscar");
        Buscar.setBorder(null);
        Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("TOTAL:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Numero", "Precio Total", "Fecha"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Fechas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fechas.setForeground(new java.awt.Color(0, 0, 0));
        Fechas.setText("Filtrar fecha:");

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar.doClick();
            }
        });// NOI18N

        Volver.setBackground(new java.awt.Color(51, 102, 255));
        Volver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Volver.setForeground(new java.awt.Color(0, 0, 0));
        Volver.setText("Volver");
        Volver.setBorder(null);
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(Fechas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(217, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305)
                                .addComponent(Total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fechas)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Total)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui = new GUI();
        gui.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {
        int flag = 0;
        try {
            String fechaInput = txtFecha.getText();
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            Date fechaDate = inputFormat.parse(fechaInput);
            String fechaFormatted = outputFormat.format(fechaDate);

            Historial = ClaseJson.cargarDesdeArchivoHistorial("archivoHistorial.json");

            ArrayList<Venta> aux = Historial.getHistorial();
            mt.setRowCount(0); // Limpiar la tabla antes de agregar nuevas filas
            for (Venta i : aux) {
                if (i.getFechaActual().equals(fechaFormatted)) {
                    InitTableVentas(mt, fechaFormatted);
                    flag = 1;
                }
            }

            actualizarTotal();
            if (flag == 0) {
                InitTableVentas(mt, fechaFormatted);
                txtFecha.setText("");
                JOptionPane.showMessageDialog(this, "No existen ventas en esta fecha", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtFecha.requestFocusInWindow();
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Fecha no válida. Por favor ingrese una fecha en el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            txtFecha.requestFocusInWindow(); // Asegurarse de que el foco vuelva al campo de texto
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private JFormattedTextField crearFormattedTextField() {
        JFormattedTextField formattedTextField = null;
        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
            formattedTextField = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedTextField;
    }

    /**
     * @param args los argumentos de la línea de comandos
     */

    // Declaración de variables - no modificar
    private javax.swing.JButton Buscar;
    private javax.swing.JLabel Fechas;
    private javax.swing.JLabel Total;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private JFormattedTextField txtFecha;  // Cambiado a JFormattedTextField
    private javax.swing.JTextField txtTotal;
    // Fin de la declaración de variables
}