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

public class DetalleVenta extends javax.swing.JDialog {
    private HistorialMovimientos venta;
    private ClaseJson historial;
    String ids[] = {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"};
    DefaultTableModel mt = new DefaultTableModel(ids, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Todas las celdas no son editables
        }
    };

    private int idVenta;

    public DetalleVenta(java.awt.Frame parent, HistorialMovimientos venta, int id, boolean esCompra) {
        super(parent, true);
        this.venta = venta;
        if(esCompra)
        {
            initComponentsCompra();
        }
        else {
            initComponents();
        }

        jTable1.setModel(mt);
        this.idVenta=id;
        mt.setRowCount(0);
        try
        {
            if(esCompra)
            {
                historial=ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialCompra.json");
                ArrayList<HistorialMovimientos> compras = historial.getHistorial();

                if(historial.archivoHistorialCompras.exists())
                {
                    for (HistorialMovimientos compra : compras) {
                        System.out.println(idVenta);
                        //System.out.println(venta.getId());
                        if (compra.getId() == idVenta) {
                            System.out.println("hola");
                            mt.addRow(new Object[]{compra.getCodigo(), compra.getNombre(), compra.getCant(), compra.getPrecio_un(), compra.getPrecio_total()});
                        }
                    }
                }
            }
            else
            {
                historial=ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialVenta.json");
                ArrayList<HistorialMovimientos> ventas = historial.getHistorial();

                if(historial.archivoHistorialVentas.exists())
                {
                    for (HistorialMovimientos venta1 : ventas) {
                        System.out.println(idVenta);
                        //System.out.println(venta.getId());
                        if (venta1.getId() == idVenta) {
                            System.out.println("hola");
                            mt.addRow(new Object[]{venta1.getCodigo(), venta1.getNombre(), venta1.getCant(), venta1.getPrecio_un(), venta1.getPrecio_total()});
                        }
                    }
                }
            }


        }
        catch (IOException E)
        {

        }
        //System.out.println(idVenta);
    }






    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de Venta");
        setSize(400, 300);
        setLocationRelativeTo(null);

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"}
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("ID Venta:");
        jLabel2.setText("Fecha:");

        lblIdVenta.setText(String.valueOf(venta.getId()));
        lblFecha.setText(venta.getFechaActual());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 2));
        infoPanel.add(jLabel1);
        infoPanel.add(lblIdVenta);
        infoPanel.add(jLabel2);
        infoPanel.add(lblFecha);

        jPanel1.add(infoPanel, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }
    private void initComponentsCompra() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de compra");
        setSize(400, 300);
        setLocationRelativeTo(null);

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"}
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("ID Compra:");
        jLabel2.setText("Fecha:");

        lblIdVenta.setText(String.valueOf(venta.getId()));
        lblFecha.setText(venta.getFechaActual());

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