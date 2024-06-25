/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI.VentanaArticulos;

import InterfazGUI.GUI;
import InterfazGUI.VentanaClientes.NuevoCliente;
import Placeholder.TextPrompt;
import Vivero.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import Articulos.*;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Articulos extends javax.swing.JFrame {
    String ids[] = {"Codigo", "Tipo", "Nombre", "Precio", "Stock"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas no son editables
        }
    };
    Vivero vivero = new Vivero();//OTRO PROVISORIO
    static ObjectMapper objectMapper = new ObjectMapper();


    public Articulos() {
        initComponents();
        setTitle("Menu Articulos");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable1.setModel(mt);
        InitTable(mt);
        setResizable(false);
        GUI.setupButton(Volver);
        GUI.setupButton(Editar);
        GUI.setupButton(Nuevo);
        GUI.setupButton(Borrar);
        TextPrompt placeholdern1=new TextPrompt("Escriba aqui el elemento a buscar", Buscador);

        Buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarArticulos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarArticulos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextFields simples
            }
        });
    }

    private void InitTable(DefaultTableModel mt) {
        if (vivero.archivoVivero.exists()) {
            try {
                vivero=Vivero.cargarDesdeArchivo("archivo.json");
                HashMap<Integer, Articulo> articulos=vivero.getArticulos();
                for (Map.Entry<Integer, Articulo> aux : articulos.entrySet()){
                   Articulo articulo=aux.getValue();
                    mt.addRow(new Object[]{articulo.getCodigo(), articulo.getTipoDeArticulo(), articulo.getNombreDelArticulo(), articulo.getPrecio(), articulo.getStock()});
                }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    private void initComponents() {
        MainPanel = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Buscador = new javax.swing.JTextField();
        Scroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());
        setMinimumSize(new java.awt.Dimension(800, 520));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setForeground(new java.awt.Color(0, 0, 0));
        MainPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        Volver.setBackground(new java.awt.Color(51, 102, 255));
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.setBorder(null);
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        Borrar.setBackground(new java.awt.Color(51, 102, 255));
        Borrar.setForeground(new java.awt.Color(255, 255, 255));
        Borrar.setText("Borrar");
        Borrar.setBorder(null);
        Borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        Editar.setBackground(new java.awt.Color(51, 102, 255));
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Editar");
        Editar.setBorder(null);
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Nuevo.setBackground(new java.awt.Color(51, 102, 255));
        Nuevo.setForeground(new java.awt.Color(255, 255, 255));
        Nuevo.setText("Nuevo");
        Nuevo.setBorder(null);
        Nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Codigo", "Tipo", "Nombre", "Precio", "Stock"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Scroll.setViewportView(jTable1);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(215, 215, 215)
                                                .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            NuevoArticulo articulo = new NuevoArticulo();
            articulo.setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui = new GUI();
        gui.setVisible(true);
        setVisible(false);
    }

    private void buscarArticulos() {
        String searchText = Buscador.getText().toLowerCase(); // Obtener el texto del campo de búsqueda
        mt.setRowCount(0); // Limpiar todas las filas actuales de la tabla
        ArrayList<Articulo> todos=new ArrayList<>();

        /// aca se bajo del archivo de vivero a vivero para despues bajar todos los articulos para que se pueda mostrar
        try
        {
            vivero = objectMapper.readValue("archivo.json", Vivero.class);

        }catch (IOException e)
        {

        }
        HashMap<Integer, Articulo>ArticulosDelVivero=vivero.getArticulos();
        for (Map.Entry<Integer, Articulo>entry:ArticulosDelVivero.entrySet())
        {
            Articulo aux =entry.getValue();
            todos.add(aux);
        }
        // Si el texto de búsqueda está vacío, mostrar todos los articulo de nuevo
        if (searchText.isEmpty()) {

            for (Articulo i : todos ) {
                mt.addRow(new Object[]{i.getCodigo(), i.getTipoDeArticulo(), i.getNombreDelArticulo(), i.getPrecio(), i.getStock()});
            }
        } else {
            // Realizar la búsqueda según el texto ingresado
            for (Articulo i : todos) {
                String codigo = String.valueOf(i.getCodigo()).toLowerCase();
                String tipo = i.getTipoDeArticulo().toLowerCase();
                String nombre = i.getNombreDelArticulo().toLowerCase();


                // Verificar si alguna columna contiene el texto de búsqueda
                if (codigo.contains(searchText) || tipo.contains(searchText) || nombre.contains(searchText)) {
                    // Agregar el articulo que coincide a la tabla
                    mt.addRow(new Object[]{i.getCodigo(), i.getTipoDeArticulo(), i.getNombreDelArticulo(), i.getPrecio(), i.getStock()});
                }
            }
        }
    }

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente a borrar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar los clientes seleccionados?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opc == 0) {
                for (int i : jTable1.getSelectedRows()) {
                    try {
                        vivero.eliminar(jTable1.getValueAt(i, 0));
                        vivero.guardarEnArchivo("archivo.json");
                        jTable1.remove(i);
                    } catch (Exception e) {

                    }
                }
                mt.setRowCount(0);
                HashMap<Integer, Articulo> aux = vivero.getArticulos();
                Iterator<Map.Entry<Integer, Articulo>> o = aux.entrySet().iterator();
                while (o.hasNext()) {
                    Map.Entry<Integer, Articulo> e = o.next();
                   Articulo i = e.getValue();
                    mt.addRow(new Object[]{i.getCodigo(), i.getTipoDeArticulo(), i.getNombreDelArticulo(), i.getPrecio(), i.getStock()});
                }
            }
        }
    }

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente a editar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int codigo = (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            VentanaEditarArticulo VentanaeditarArticulo = new VentanaEditarArticulo(codigo, vivero);
            VentanaeditarArticulo.setVisible(true);
            setVisible(false);
        }
    }






    // Variables declaration
    private javax.swing.JButton Borrar;
    private javax.swing.JTextField Buscador;
    private javax.swing.JButton Editar;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton Nuevo;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton Volver;
    private javax.swing.JTable jTable1;
}