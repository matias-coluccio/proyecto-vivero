package InterfazGUI.HistorialVentas;

import Clientes.Cliente;
import InterfazGUI.GUI;
import Historial.*;
import Vivero.Vivero;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase que representa la ventana de historial de ventas.
 */
public class Historial extends javax.swing.JFrame {
    String ids[] = {"Numero", "Precio Total", "Fecha"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0);
    ClaseJson Historial = new ClaseJson();

    /**
     * Crea una nueva instancia de la ventana Historial.
     */
    public Historial() {
        initComponents();
        setTitle("Menu Historial");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable2.setModel(mt);
        setResizable(false);
        txtTotal.setText("$0.0");
        InitTableVentas(mt);
        GUI.setupButton(Volver);

        // Listener para cambios en la tabla
        mt.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    actualizarTotal();
                }
            }
        });

        // Añadir DocumentListener al txtFecha
        txtFecha.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String venta="Ventas";
                if(venta.equals(Categoriacmbox.getSelectedItem()))
                {
                    buscarPorFecha("archivoHistorialVenta.json");
                    //InitTableVentas(mt);
                }
                else
                {
                    buscarPorFecha("archivoHistorialCompra.json");
                    //InitTableCompras(mt);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String venta="Ventas";
                if(venta.equals(Categoriacmbox.getSelectedItem()))
                {
                    buscarPorFecha("archivoHistorialVenta.json");
                    //InitTableVentas(mt);
                }
                else
                {
                    buscarPorFecha("archivoHistorialCompra.json");
                    //InitTableCompras(mt);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextFields simples
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
            total += Float.parseFloat(jTable2.getValueAt(i, 1).toString());
        }
        txtTotal.setText("$" + total);
        return total;
    }

    private void InitTableVentas(DefaultTableModel mt) {
        mt.setRowCount(0); // Limpiar la tabla
        if (Historial.archivoHistorialVentas.exists()) {
            try {
                Historial = ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialVenta.json");
                ArrayList<HistorialMovimientos> ventas = Historial.getHistorial();
                for (HistorialMovimientos venta : ventas) {
                    mt.addRow(new Object[]{mt.getRowCount() + 1, venta.getPrecio_total(), venta.getFechaActual()});
                }
                actualizarTotal();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }
    private void InitTableCompras(DefaultTableModel mt) {
        mt.setRowCount(0); // Limpiar la tabla
        if (Historial.archivoHistorialCompras.exists()) {
            try {
                Historial = ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialCompra.json");
                ArrayList<HistorialMovimientos> ventas = Historial.getHistorial();
                for (HistorialMovimientos venta : ventas) {
                    mt.addRow(new Object[]{mt.getRowCount() + 1, venta.getPrecio_total(), venta.getFechaActual()});
                }
                actualizarTotal();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    private void buscarPorFecha(String ruta) {
        String fechaInput = txtFecha.getText().trim();
        if (fechaInput.isEmpty() || fechaInput.equals("__/__/____")) {
            if(ruta.equals("archivoHistorialVenta.json"))
            {
                InitTableVentas(mt);
            }
            else {
                InitTableCompras(mt);
            }

            return;
        }

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            // Convertir la fecha de entrada al formato yyyy-MM-dd
            Date fechaDate = inputFormat.parse(fechaInput);
            String fechaFormatted = outputFormat.format(fechaDate);

            // Cargar el historial de ventas desde el archivo
            Historial = ClaseJson.cargarDesdeArchivoHistorial(ruta);
            ArrayList<HistorialMovimientos> ventas = Historial.getHistorial();

            // Limpiar la tabla antes de agregar nuevas filas
            mt.setRowCount(0);

            // Filtrar las ventas por la fecha formateada y agregarlas a la tabla
            boolean ventasEncontradas = false;
            for (HistorialMovimientos venta : ventas) {
                if (venta.getFechaActual().equals(fechaFormatted)) {
                    mt.addRow(new Object[]{mt.getRowCount() + 1, venta.getPrecio_total(), venta.getFechaActual()});
                    ventasEncontradas = true;
                }
            }

            actualizarTotal();

            // Mostrar mensaje si no se encontraron ventas
            if (!ventasEncontradas) {
                //JOptionPane.showMessageDialog(this, "No existen ventas en esta fecha", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ParseException e) {
            //JOptionPane.showMessageDialog(this, "Fecha no válida. Por favor ingrese una fecha en el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            txtFecha.requestFocusInWindow(); // Asegurarse de que el foco vuelva al campo de texto
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el historial de ventas.", "Error", JOptionPane.ERROR_MESSAGE);
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
     * Método llamado desde el constructor para inicializar los componentes.
     * ADVERTENCIA: No modificar este código. El contenido de este método es
     * siempre generado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Fecha = new javax.swing.JLabel();
        txtFecha = crearFormattedTextField();
        Categoriacmbox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

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

        Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("TOTAL:");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Numero", "Precio total", "Fecha"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Fecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 0, 0));
        Fecha.setText("Filtrar fecha:");

        txtFecha.setFont(new java.awt.Font("Segoe UI", 0, 18));

        Categoriacmbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ventas", "Compras"}));
        Categoriacmbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriacmboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(Total)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addComponent(Categoriacmbox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(Fecha)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(280, 280, 280)
                                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Categoriacmbox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fecha)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Total)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
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
        // Acción para el botón "Volver"
        GUI gui = new GUI();
        gui.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }

    private void CategoriacmboxActionPerformed(java.awt.event.ActionEvent evt) {
        // Acción para el combobox "Categoriacmbox"
        txtFecha.setText("");
        String selectedCategory = (String) Categoriacmbox.getSelectedItem();
        if (selectedCategory.equals("Ventas")) {
            // Mostrar ventas
            InitTableVentas(mt);
        } else {
            InitTableCompras(mt);

            // Implementar lógica para mostrar compras si es necesario
        }
    }

    /**
     * @param args los argumentos de la línea de comandos
     */

    // Declaración de variables - no modificar
    private javax.swing.JComboBox<String> Categoriacmbox;
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Total;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotal;
    // Fin de la declaración de variables
}