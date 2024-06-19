/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI;

import Excepciones.ExceptionDNI;
import Vivero.Vivero;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Cliente extends javax.swing.JFrame {

    String ids[] = {"Dni", "Nombre", "Apellido", "Categoria"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas no son editables
        }
    };
    Vivero vivero = new Vivero();//OTRO PROVISORIO
    ArrayList<Clientes.Cliente> todos = new ArrayList<>();
    File archivoVivero = new File("archivoVivero.json");
     static ObjectMapper objectMapper = new ObjectMapper();

    public Cliente() {
        initComponents();
        setTitle("Menu Clientes");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable1.setModel(mt);

        try {
            if (archivoVivero.exists()) {
                vivero = objectMapper.readValue(archivoVivero, Vivero.class);
            } else {
                vivero.guardarEnArchivo(archivoVivero.getPath());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        InitTable(mt);
        setResizable(false);
        GUI.setupButton(Volver);
        GUI.setupButton(Editar);
        GUI.setupButton(Nuevo);
        GUI.setupButton(Borrar);
        Buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarClientes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarClientes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No es relevante para JTextFields simples
            }
        });
    }

    private void InitTable(DefaultTableModel mt) {

        mt.addRow(new Object[]{46348819, "Gian Luka", "Fernandez", "Monotributista"});
        mt.addRow(new Object[]{44957193, "Yago", "Fernandez", "Monotributista"});
        mt.addRow(new Object[]{45895001, "Marcos", "Closter", "Responsable Inscripto"});
    }

    private void initComponents() {
        MainPanel = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Buscador = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());
        setMinimumSize(new java.awt.Dimension(800, 520));
        setPreferredSize(new java.awt.Dimension(800, 500));

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

        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //BuscarActionPerformed(evt);

            }
        });

        Buscar.setBackground(new java.awt.Color(51, 102, 255));
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar");
        Buscar.setBorder(null);
        Buscar.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));

        jTable1.setModel(mt);
        Scroll.setViewportView(jTable1);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            NuevoCliente cliente = new NuevoCliente();
            cliente.setVisible(true);
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

    private void buscarClientes() {
        String searchText = Buscador.getText().toLowerCase(); // Obtener el texto del campo de búsqueda
        mt.setRowCount(0); // Limpiar todas las filas actuales de la tabla
        /// aca se bajo del archivo de vivero a vivero para despues bajar todos los clientes para que se pueda mostrar
        try
        {
            vivero = objectMapper.readValue(archivoVivero, Vivero.class);

        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        HashMap<Integer, Clientes.Cliente>clientesDelVivero=vivero.getClientes();

        // Si el texto de búsqueda está vacío, mostrar todos los clientes de nuevo
        if (searchText.isEmpty()) {

            //// la idea es recorrer el hasmap de los clientes del vivero para despues mostrarlos
            ///TODO
            for(HashMap aux:clientesDelVivero)
            {

            }



            for (Clientes.Cliente cliente : todos) {
                mt.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getCategoria()});
            }
        } else {
            // Realizar la búsqueda según el texto ingresado
            for (Clientes.Cliente cliente : todos) {
                String dniStr = String.valueOf(cliente.getDni()).toLowerCase();
                String nombre = cliente.getNombre().toLowerCase();
                String apellido = cliente.getApellido().toLowerCase();
                String categoria = cliente.getCategoria().toLowerCase();

                // Verificar si alguna columna contiene el texto de búsqueda
                if (dniStr.contains(searchText) || nombre.contains(searchText) || apellido.contains(searchText) || categoria.contains(searchText)) {
                    // Agregar el cliente que coincide a la tabla
                    mt.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getCategoria()});
                }
            }
        }
    }

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(vivero.listar());
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente a borrar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar los clientes seleccionados?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opc == 0) {
                for (int i : jTable1.getSelectedRows()) {
                    try {
                        vivero.eliminar((Integer) jTable1.getValueAt(i, 0));
                        vivero.guardarEnArchivo(archivoVivero.getPath());
                        System.out.println(vivero.listar());
                        mt.removeRow(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                mt.setRowCount(0);
                HashMap<Integer, Clientes.Cliente> aux = vivero.getClientes();
                Iterator<Map.Entry<Integer, Clientes.Cliente>> i = aux.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry<Integer, Clientes.Cliente> e = i.next();
                    Clientes.Cliente aux1 = e.getValue();
                    mt.addRow(new Object[]{aux1.getDni(), aux1.getNombre(), aux1.getApellido(), aux1.getCategoria()});
                }
            }
        }
    }

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente a editar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int dni = (Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            VentanaEditarCliente ventanaEditarCliente = new VentanaEditarCliente(dni, vivero);
            ventanaEditarCliente.setVisible(true);
            setVisible(false);
        }
    }

    // Métodos para trabajar con JSON
    public void guardarEnArchivo(String ruta) throws IOException {
        objectMapper.writeValue(new File(ruta), this);
    }

    public static Vivero cargarDesdeArchivo(String ruta) throws IOException {
        return objectMapper.readValue(new File(ruta), Vivero.class);
    }

    // Métodos para convertir a JSON y desde JSON
    public String convertirAJson() throws IOException {
        return objectMapper.writeValueAsString(this);
    }

    public static Vivero desdeJson(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, Vivero.class);
    }

    // Variables declaration
    private javax.swing.JButton Borrar;
    private javax.swing.JTextField Buscador;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Editar;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton Nuevo;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton Volver;
    private javax.swing.JTable jTable1;
}
