/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI;


import Excepciones.ExceptionDNI;
import Vivero.Vivero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
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

    public Cliente() {
        initComponents();
        setTitle("Menu Clientes");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable1.setModel(mt);
        try {
            Clientes.Cliente cliente1 = new Clientes.Cliente("Gian Luka", "Fernandez", "Monotributista", 46348819);
            Clientes.Cliente cliente2 = new Clientes.Cliente("Yago ", "Fernandez", "Monotributista", 44957193);
            Clientes.Cliente cliente3 = new Clientes.Cliente("Marcos ", "Closter", "Responsable Inscripto", 45895001);
            vivero.agregar(cliente1);
            vivero.agregar(cliente2);
            vivero.agregar(cliente3);
            todos.add(cliente1);
            todos.add(cliente2);
            todos.add(cliente3);

        } catch (ExceptionDNI e) {
            System.out.println(e.getMessage());
        }


        mt.addRow(new Object[]{46348819, "Gian Luka", "Fernandez", "Monotributista"});
        mt.addRow(new Object[]{44957193, "Yago", "Fernandez", "Monotributista"});
        mt.addRow(new Object[]{45895001, "Marcos", "Closter", "Responsable Inscripto"});
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

        Editar.setBackground(new java.awt.Color(51, 102, 255));
        Editar.setForeground(new java.awt.Color(255, 255, 255));
        Editar.setText("Editar");
        Editar.setBorder(null);
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        NuevoCliente cliente = new NuevoCliente();
        cliente.setVisible(true);
        setVisible(false);
    }

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui = new GUI();
        gui.setVisible(true);
        setVisible(false);
    }


    private void buscarClientes() {
        String searchText = Buscador.getText().toLowerCase(); // Obtener el texto del campo de búsqueda
        mt.setRowCount(0); // Limpiar todas las filas actuales de la tabla

        // Si el texto de búsqueda está vacío, mostrar todos los clientes de nuevo
        if (searchText.isEmpty()) {
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

/*
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {
        int dni = Integer.parseInt(Buscador.getText());
        // Suponiendo que vivero.buscar retorna un objeto Cliente encontrado
        // Replace Clientes.Cliente with the actual class type
        Clientes.Cliente cliente = (Clientes.Cliente) vivero.buscar(dni);
        System.out.println(cliente.toString());

        // Limpiar todas las filas existentes en la tabla
        int rowCount = mt.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            mt.removeRow(i);
        }

        // Agregar la fila del cliente encontrado
        mt.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getCategoria()});

        // Limpiar el campo de búsqueda
        Buscador.setText("");
        String busqueda = Buscador.getText().toLowerCase();
        if (busqueda.isEmpty()) {
            for (Clientes.Cliente i : todos) {
                mt.addRow(new Object[]{i.getDni(), i.getNombre(), i.getApellido(), i.getCategoria()});
            }

        } else {
            // Realizar la búsqueda según el texto ingresado
            for (Clientes.Cliente j : todos) {
                String dniStr = String.valueOf(j.getDni()).toLowerCase();
                String nombre = j.getNombre().toLowerCase();
                String apellido = j.getApellido().toLowerCase();
                String categoria = j.getCategoria().toLowerCase();

                // Verificar si alguna columna contiene el texto de búsqueda
                if (dniStr.contains(busqueda) || nombre.contains(busqueda) || apellido.contains(busqueda) || categoria.contains(busqueda)) {

                    // Agregar el cliente que coincide a la tabla
                    mt.addRow(new Object[]{cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getCategoria()});
                }


            }
        }
    }
     */



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
