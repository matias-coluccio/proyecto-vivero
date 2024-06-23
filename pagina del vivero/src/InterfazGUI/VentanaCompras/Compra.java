/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI.VentanaCompras;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Articulos.Articulo;
import Historial.ClaseJson;
import Historial.HistorialMovimientos;
import InterfazGUI.GUI;
import InterfazGUI.VentanaArticulos.NuevoArticulo;
import Vivero.Vivero;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class Compra extends javax.swing.JFrame {
    String ids[] = {"Codigo", "Nombre", "Precio unitario","Precio Total",  "Stock anterior", "Cantidad", "Nuevo Stock"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 5; // Solo la columna de cantidad es editable
        }
    };
    ClaseJson a=new ClaseJson();
    Vivero vivero = new Vivero(); // OTRO PROVISORIO
    String tipoDearticulo=null;

    public Compra() {
        initComponents();
        setTitle("Menu Compras");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jTable2.setModel(mt);
        GUI.setupButton(Volver);
        GUI.setupButtonAceptar(Aceptar);
        GUI.setupButtonCancelar(Cancelar);
        setResizable(false);
        txtTotal.setText("$0.00");

        // Agregar TableModelListener
        mt.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    if (column == 5) { // Columna de cantidad
                        actualizarStockTotal(row);
                        actualizarPrecioTotal(row);
                        actualizarTotal();
                    }
                }
            }
        });
        jTable2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int[] selectedRows = jTable2.getSelectedRows();
                    if (selectedRows.length > 0) {
                        int confirm = JOptionPane.showConfirmDialog(null, "¿Desea borrar los artículos seleccionados?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            // Eliminar las filas desde el final hacia el inicio para evitar problemas de indexación
                            for (int i = selectedRows.length - 1; i >= 0; i--) {
                                mt.removeRow(selectedRows[i]);
                            }
                            actualizarTotal();
                        }
                    }
                }
            }
        });

    }


    private void InitTableVentas(DefaultTableModel mt, int codigo) {
        if (vivero.archivoVivero.exists()) {
            try {
                vivero=Vivero.cargarDesdeArchivo("archivo.json");
                HashMap<Integer, Articulo> articulos=vivero.getArticulos();
                if(articulos.containsKey(codigo))
                {
                    Articulo aux=articulos.get(codigo);
                    if(aux.getStock()<0)
                    {
                        mt.addRow(new Object[]{aux.getCodigo(), aux.getNombreDelArticulo(), aux.getPrecio(), aux.getPrecio(), aux.getStock(), 1, 1});
                    }

                   else
                    {
                        mt.addRow(new Object[]{aux.getCodigo(), aux.getNombreDelArticulo(), aux.getPrecio(), aux.getPrecio(), aux.getStock(), 1, aux.getStock()+1});
                    }

                }

            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }


    // Método para actualizar el precio total de una fila
    private void actualizarStockTotal(int row) {
        int Stocktotal=0;
        try {
            int cantidad=0;
            try
            {
                 cantidad = Integer.parseInt(jTable2.getValueAt(row, 5).toString());
            }
            catch (NumberFormatException e)
            {

            }



            int StockAnterior = Integer.parseInt(jTable2.getValueAt(row, 4).toString());
            if(StockAnterior<0)
            {
                Stocktotal=cantidad;
                jTable2.setValueAt(Stocktotal, row, 6);
            }
            else
            {
                Stocktotal = cantidad + StockAnterior;
                jTable2.setValueAt(Stocktotal, row, 6);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Manejo del error en caso de que la conversión falle
        }
    }
    // Método para actualizar el precio total de una fila
    private void actualizarPrecioTotal(int row) {
        try {
            int cantidad=0;
            try
            {
                 cantidad = Integer.parseInt(jTable2.getValueAt(row, 5).toString());
            }
            catch (NumberFormatException e)
            {

            }

            float precioUnitario = Float.parseFloat(jTable2.getValueAt(row, 2).toString());
            float precioTotal = cantidad * precioUnitario;
            jTable2.setValueAt(precioTotal, row, 3);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Manejo del error en caso de que la conversión falle
        }
    }

    // Método para actualizar el total de la venta
    private float actualizarTotal() {
        float total = 0;
        for (int i = 0; i < mt.getRowCount(); i++) {
            total += Float.parseFloat(jTable2.getValueAt(i,3 ).toString());
        }
        txtTotal.setText("$" +String.valueOf(total));
        return total;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        Codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Cargar = new javax.swing.JButton();

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
                new Object [][] {

                },
                new String [] {
                        "Codigo", "Nombre", "Precio unitario", "Precio Total", "Stock anterior", "Cantidad", "Nuevo Stock"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Codigo.setText("Codigo");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar.doClick();
            }
        });

        Aceptar.setBackground(new java.awt.Color(153, 255, 153));
        Aceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(0, 0, 0));
        Aceptar.setText("Aceptar");
        Aceptar.setBorder(null);
        Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(255, 51, 51));
        Cancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(0, 0, 0));
        Cancelar.setText("Cancelar");
        Cancelar.setBorder(null);
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Cargar.setBackground(new java.awt.Color(51, 102, 255));
        Cargar.setForeground(new java.awt.Color(0, 0, 0));
        Cargar.setText("Cargar");
        Cargar.setBorder(null);
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
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
                                                .addComponent(Codigo)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(91, 91, 91)
                                                .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(Total)
                                                .addGap(14, 14, 14)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Codigo)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(Total))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>




    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui=new GUI();
        gui.setVisible(true);
        setVisible(false);
    }





    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {

        int opc = JOptionPane.showConfirmDialog(null, "Estas seguro? se borrara toda la compra", "Borrar articulo", JOptionPane.YES_NO_OPTION);
        if(opc==0)
        {
            mt.setRowCount(0);
            actualizarTotal();
        }
    }

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {
        HistorialMovimientos aux = new HistorialMovimientos();
        int opc = JOptionPane.showConfirmDialog(null, "Confirmar compra", "Confirmacion de compra", JOptionPane.YES_NO_OPTION);
        boolean entro=false;

        if(opc == JOptionPane.YES_OPTION) {
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                entro=true;
                Object value;

                // Nombre (asumiendo que siempre es String)
                aux.setNombre((String) mt.getValueAt(i, 1));

                // Codigo
                value = mt.getValueAt(i, 0);
                if (value instanceof Integer) {
                    aux.setCodigo((Integer) value);
                } else if (value instanceof String) {
                    try {
                        aux.setCodigo(Integer.parseInt((String) value));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("El valor en la celda (i, 0) no es un entero válido: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("El valor en la celda (i, 0) no es un entero: " + value.getClass().getName());
                }

                // Precio Unitario
                value = mt.getValueAt(i, 2);
                if (value instanceof Float) {
                    aux.setPrecio_un((Float) value);
                } else if (value instanceof String) {
                    try {
                        aux.setPrecio_un(Float.parseFloat((String) value));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("El valor en la celda (i, 2) no es un float válido: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("El valor en la celda (i, 2) no es un float: " + value.getClass().getName());
                }

                // Precio Total
                value = mt.getValueAt(i, 3);
                if (value instanceof Float) {
                    aux.setPrecio_total((Float) value);
                } else if (value instanceof String) {
                    try {
                        aux.setPrecio_total(Float.parseFloat((String) value));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("El valor en la celda (i, 3) no es un float válido: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("El valor en la celda (i, 3) no es un float: " + value.getClass().getName());
                }

                // Cantidad
                value = mt.getValueAt(i, 5);
                if (value instanceof Integer) {
                    aux.setCant((Integer) value);
                } else if (value instanceof String) {
                    try {
                        aux.setCant(Integer.parseInt((String) value));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("El valor en la celda (i, 4) no es un entero válido: " + value);
                    }
                } else {
                    throw new IllegalArgumentException("El valor en la celda (i, 4) no es un entero: " + value.getClass().getName());
                }


                // Guardar Historial
                try {
                    if (a.archivoHistorialCompras.exists()) {
                        a = ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialCompra.json");
                    }

                    a.Agregar(aux);
                    a.guardarEnArchivoHistorial("archivoHistorialCompra.json");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                //Aumentar el stock en al articulo
                try
                {
                    int codigo=0;
                    //Recupero el codigo de la tabla para buscarlo en el archivo

                    codigo =(Integer) mt.getValueAt(i, 0);




                    vivero=Vivero.cargarDesdeArchivo("archivo.json");
                    Iterator e = vivero.getArticulos().entrySet().iterator();
                    int flag =0;
                    while(e.hasNext() && flag==0)
                    {
                        try
                        {
                            Map.Entry<Integer, Articulo> o = (Map.Entry<Integer, Articulo>) e.next();
                            Articulo aux1 = o.getValue();
                            if(aux1.getCodigo()==codigo)
                            {
                                int stockTotal= aux1.getStock();
                                int nuevoStock=stockTotal+ aux.getCant();
                                aux1.setStock(nuevoStock);
                                vivero.getArticulos().put(aux1.getCodigo(), aux1);
                                vivero.guardarEnArchivo("archivo.json");

                                flag=1;
                            }

                        }
                        catch (ConcurrentModificationException j)
                        {

                        }

                    }
                    if(flag==0)
                    {
                        int opc1 = JOptionPane.showConfirmDialog(null, "No existe un cliente con este dni, desea crearlo?", "DNI NO ENCONTRADO", JOptionPane.YES_NO_OPTION);
                        if(opc1==0)
                        {
                            NuevoArticulo nuevoArticulo= new NuevoArticulo(flag, this);
                            nuevoArticulo.setVisible(true);
                        }
                    }


                }
                catch (IOException e)
                {

                }
            }

            if(entro)
            {
                JOptionPane.showMessageDialog(null, "Compra registrada exitosamente");
            }
            txtCodigo.setText("");
            mt.setRowCount(0);
            actualizarTotal();

        }
    }

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {
        int flag=0;
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            vivero=Vivero.cargarDesdeArchivo("archivo.json");
            HashMap<Integer, Articulo> aux = vivero.getArticulos();
            Iterator<Map.Entry<Integer, Articulo>> i = aux.entrySet().iterator();
            while (i.hasNext() && flag==0) {
                Map.Entry<Integer, Articulo> e = i.next();
                Articulo aux1 = e.getValue();
                if(aux1.getCodigo()==codigo)
                {
                    tipoDearticulo=aux1.getTipoDeArticulo();
                    InitTableVentas(mt, codigo);
                    actualizarTotal() ;
                    txtCodigo.setText("");
                    txtCodigo.requestFocusInWindow(); // Establece el foco de nuevo en el campo de texto
                    flag=1;
                }
            }
            if (flag==0)
            {
                int opc1 = JOptionPane.showConfirmDialog(null, "No existe un articulo con este codigo, desea crearlo?", "DNI NO ENCONTRADO", JOptionPane.YES_NO_OPTION);
                if(opc1==0)
                {
                    NuevoArticulo articuloNuevo= new NuevoArticulo(flag, this);
                    articuloNuevo.setVisible(true);
                }
            }

        } catch (NumberFormatException e) {
            // Manejar la excepción si el texto no es un número válido
            JOptionPane.showMessageDialog(this, "Ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
            txtCodigo.requestFocusInWindow(); // Asegurarse de que el foco vuelva al campo de texto
        }
        catch (IOException e)
        {

        }

    }
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Cargar;
    private javax.swing.JLabel Codigo;
    private javax.swing.JLabel Total;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration
}