package InterfazGUI.HistorialVentas;

import Articulos.Articulo;
import Historial.HistorialMovimientos;
import Historial.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Clase DetalleVenta para mostrar el detalle de una venta o compra en una interfaz gráfica.
 */
public class DetalleVenta extends javax.swing.JDialog {
    private HistorialMovimientos venta; // Objeto que representa la venta o compra
    private ClaseJson historial; // Objeto para manejar el historial desde un archivo JSON
    String ids[] = {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"}; // Nombres de columnas para la tabla
    DefaultTableModel mt = new DefaultTableModel(ids, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hace que las celdas de la tabla no sean editables
        }
    };

    private int idVenta; // ID de la venta o compra a mostrar

    /**
     * Constructor de la clase para una venta o compra.
     * @param parent Frame padre de la ventana de diálogo
     * @param venta Objeto HistorialMovimientos que representa la venta o compra
     * @param id ID de la venta o compra
     * @param esCompra Booleano que indica si se trata de una compra (true) o venta (false)
     */
    public DetalleVenta(java.awt.Frame parent, HistorialMovimientos venta, int id, boolean esCompra) {
        super(parent, true); // Llama al constructor de JDialog con modalidad true
        this.venta = venta; // Asigna el objeto de venta o compra recibido
        if(esCompra)
        {
            initComponentsCompra(); // Inicializa componentes para detalle de compra si esCompra es true
        }
        else {
            initComponents(); // Inicializa componentes para detalle de venta si esCompra es false
        }

        jTable1.setModel(mt); // Asigna el modelo de tabla a jTable1
        this.idVenta=id; // Asigna el ID de venta o compra recibido
        mt.setRowCount(0); // Establece el número de filas del modelo de tabla a cero
        try
        {
            if(esCompra)
            {
                historial=ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialCompra.json"); // Carga historial de compras desde archivo JSON
                ArrayList<HistorialMovimientos> compras = historial.getHistorial(); // Obtiene la lista de compras del historial

                if(historial.archivoHistorialCompras.exists()) // Verifica si existe el archivo de historial de compras
                {
                    for (HistorialMovimientos compra : compras) {
                        if (compra.getId() == idVenta) {
                            mt.addRow(new Object[]{compra.getCodigo(), compra.getNombre(), compra.getCant(), compra.getPrecio_un(), compra.getPrecio_total()});
                            // Agrega una fila con los detalles de la compra encontrada al modelo de tabla
                        }
                    }
                }
            }
            else
            {
                historial=ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialVenta.json"); // Carga historial de ventas desde archivo JSON
                ArrayList<HistorialMovimientos> ventas = historial.getHistorial(); // Obtiene la lista de ventas del historial

                if(historial.archivoHistorialVentas.exists()) // Verifica si existe el archivo de historial de ventas
                {
                    for (HistorialMovimientos venta1 : ventas) {
                        if (venta1.getId() == idVenta) {
                            mt.addRow(new Object[]{venta1.getCodigo(), venta1.getNombre(), venta1.getCant(), venta1.getPrecio_un(), venta1.getPrecio_total()});
                            // Agrega una fila con los detalles de la venta encontrada al modelo de tabla
                        }
                    }
                }
            }


        }
        catch (IOException E)
        {

        }
    }

    /**
     * Inicializa los componentes de la interfaz gráfica para mostrar el detalle de una venta.
     */
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Configura la operación de cierre de la ventana
        setTitle("Detalle de Venta"); // Establece el título de la ventana
        setSize(400, 300); // Establece el tamaño inicial de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        jPanel1 = new javax.swing.JPanel(); // Panel principal de la interfaz
        jScrollPane1 = new javax.swing.JScrollPane(); // Panel de desplazamiento para la tabla
        jTable1 = new javax.swing.JTable(); // Tabla que muestra los detalles de la venta
        jLabel1 = new javax.swing.JLabel(); // Etiqueta para mostrar el texto "ID Venta:"
        jLabel2 = new javax.swing.JLabel(); // Etiqueta para mostrar el texto "Fecha:"
        lblIdVenta = new javax.swing.JLabel(); // Etiqueta que muestra el ID de la venta
        lblFecha = new javax.swing.JLabel(); // Etiqueta que muestra la fecha de la venta

        jPanel1.setLayout(new java.awt.BorderLayout()); // Establece el layout del panel principal

        jTable1.setModel(new javax.swing.table.DefaultTableModel( // Configura el modelo de la tabla jTable1
                new Object [][] {}, // Sin datos iniciales
                new String [] {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"} // Nombres de columnas
        ));
        jScrollPane1.setViewportView(jTable1); // Asocia la tabla al panel de desplazamiento

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER); // Agrega la tabla al centro del panel principal

        jLabel1.setText("ID Venta:"); // Establece el texto de la etiqueta jLabel1
        jLabel2.setText("Fecha:"); // Establece el texto de la etiqueta jLabel2

        lblIdVenta.setText(String.valueOf(venta.getId())); // Muestra el ID de la venta en lblIdVenta
        lblFecha.setText(venta.getFechaActual()); // Muestra la fecha de la venta en lblFecha

        JPanel infoPanel = new JPanel(); // Crea un panel para mostrar la información de la venta
        infoPanel.setLayout(new GridLayout(2, 2)); // Establece un layout de cuadrícula 2x2
        infoPanel.add(jLabel1); // Agrega la etiqueta "ID Venta:"
        infoPanel.add(lblIdVenta); // Agrega el ID de la venta
        infoPanel.add(jLabel2); // Agrega la etiqueta "Fecha:"
        infoPanel.add(lblFecha); // Agrega la fecha de la venta

        jPanel1.add(infoPanel, java.awt.BorderLayout.NORTH); // Agrega el panel de información en la parte superior del panel principal

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER); // Agrega el panel principal al contenido de la ventana
    }

    /**
     * Inicializa los componentes de la interfaz gráfica para mostrar el detalle de una compra.
     */
    private void initComponentsCompra() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Configura la operación de cierre de la ventana
        setTitle("Detalle de compra"); // Establece el título de la ventana
        setSize(400, 300); // Establece el tamaño inicial de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        jPanel1 = new javax.swing.JPanel(); // Panel principal de la interfaz
        jScrollPane1 = new javax.swing.JScrollPane(); // Panel de desplazamiento para la tabla
        jTable1 = new javax.swing.JTable(); // Tabla que muestra los detalles de la compra
        jLabel1 = new javax.swing.JLabel(); // Etiqueta para mostrar el texto "ID Compra:"
        jLabel2 = new javax.swing.JLabel(); // Etiqueta para mostrar el texto "Fecha:"
        lblIdVenta = new javax.swing.JLabel(); // Etiqueta que muestra el ID de la compra
        lblFecha = new javax.swing.JLabel(); // Etiqueta que muestra la fecha de la compra

        jPanel1.setLayout(new java.awt.BorderLayout()); // Establece el layout del panel principal

        jTable1.setModel(new javax.swing.table.DefaultTableModel( // Configura el modelo de la tabla jTable1
                new Object [][] {}, // Sin datos iniciales
                new String [] {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"} // Nombres de columnas
        ));
        jScrollPane1.setViewportView(jTable1); // Asocia la tabla al panel de desplazamiento

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER); // Agrega la tabla al centro del panel principal

        jLabel1.setText("ID Compra:"); // Establece el texto de la etiqueta jLabel1
        jLabel2.setText("Fecha:"); // Establece el texto de la etiqueta jLabel2

        lblIdVenta.setText(String.valueOf(venta.getId())); // Muestra el ID de la compra en lblIdVenta
        lblFecha.setText(venta.getFechaActual()); // Muestra la fecha de la compra en lblFecha



        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 2));
        infoPanel.add(jLabel1);
        infoPanel.add(lblIdVenta);
        infoPanel.add(jLabel2);
        infoPanel.add(lblFecha);

        jPanel1.add(infoPanel, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }


    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JLabel lblFecha;
}