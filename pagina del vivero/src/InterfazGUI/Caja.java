/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI;

import Articulos.Articulo;
import Historial.ClaseJson;
import Historial.HistorialMovimientos;
import Vivero.Vivero;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Gian
 */
public class Caja extends javax.swing.JFrame {

    /**
     * Creates new form Caja
     */
    ClaseJson Historial=new ClaseJson();
    Vivero HistorialVivero=new Vivero();
    public Caja() {
        initComponents();
        setTitle("Menu Caja");
        setLocationRelativeTo(null);
        GUI.setupButton(Volver);
        //Hago que no se puedan borrar los datos mostrados en los TextFields
        FalseEditable();
        //Actualizo el diseño de la fuente en los TextFields
        AgrandarLetra();
        //Muestro los TextFields con los datos correspondientes
        ActualizarTxts();
        PanelDescripcion.requestFocusInWindow();
        actualizarPrecioTotal();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
    }

    private void FalseEditable()
    {
        txtAgroquimicos.setEditable(false);
        txtCantTotal.setEditable(false);
        txtMacetas.setEditable(false);
        txtPlantas.setEditable(false);
        txtTierras.setEditable(false);
        txtTotal.setEditable(false);
    }

    private void AgrandarLetra()
    {
        txtAgroquimicos.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtTierras.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtPlantas.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtMacetas.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtCantTotal.setFont(new java.awt.Font("Segoe UI", 0, 22));
    }
    private void ActualizarTxts()
    {
        try {
            txtTierras.setText("0");
            txtAgroquimicos.setText("0");
            txtMacetas.setText("0");
            txtPlantas.setText("0");
            txtCantTotal.setText("0");
            if (Historial.archivoHistorialVentas.exists()) {
                Historial = ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialVenta.json");
                ArrayList<HistorialMovimientos> ventas =Historial.getHistorial();
                HistorialVivero=Vivero.cargarDesdeArchivo("archivo.json");
                HashMap<Integer, Articulo> articulos=HistorialVivero.getArticulos();
                int cantidadPlanta=0;
                int cantidadTierra=0;
                int cantidadMaceta=0;
                int cantidadAgroquimico=0;
                int CantTotal=0;
                txtTierras.setText("0");
                txtAgroquimicos.setText("0");
                txtMacetas.setText("0");
                txtPlantas.setText("0");
                txtCantTotal.setText("0");
                for(HistorialMovimientos i:ventas)
                {
                    if(i.getFechaActual().equals(LocalDate.now().toString()))
                    {
                        CantTotal+=i.getCant();
                        if(articulos.containsKey(i.getCodigo()))
                        {
                            Articulo aux=articulos.get(i.getCodigo());
                            if(aux.getTipoDeArticulo().equals("Planta"))
                            {

                                cantidadPlanta+=i.getCant();
                                txtPlantas.setText(String.valueOf(cantidadPlanta));
                            }
                            else if(aux.getTipoDeArticulo().equals("Maceta"))
                            {
                                cantidadMaceta+=i.getCant();
                                txtMacetas.setText(String.valueOf(cantidadMaceta));
                            }
                            else if(aux.getTipoDeArticulo().equals("Agroquimico"))
                            {
                                cantidadAgroquimico+=i.getCant();
                                txtAgroquimicos.setText(String.valueOf(cantidadAgroquimico));
                            }
                            else if(aux.getTipoDeArticulo().equals("Tierra"))
                            {
                                cantidadTierra+=i.getCant();
                                txtTierras.setText(String.valueOf(cantidadTierra));
                            }

                        }
                    }





                }
                txtCantTotal.setText(String.valueOf(CantTotal));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void actualizarPrecioTotal() {
       try
       {
           txtTotal.setText("$0.00");
           float total=0;
           if(Historial.archivoHistorialVentas.exists())
           {

               Historial=ClaseJson.cargarDesdeArchivoHistorial("archivoHistorialVenta.json");
              ArrayList<HistorialMovimientos> ventas =Historial.getHistorial();
              for(HistorialMovimientos i:ventas)
              {
                  if(i.getFechaActual().equals(LocalDate.now().toString()))
                  {
                      total+=i.getPrecio_total();
                  }

              }
              txtTotal.setText("$"+(total));
           }


       }
       catch (IOException e)
       {

       }
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
        txtTotal = new javax.swing.JTextField();
        Total = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        PanelDescripcion = new javax.swing.JPanel();
        CantTotal = new javax.swing.JLabel();
        Plantas = new javax.swing.JLabel();
        Agroquimicos = new javax.swing.JLabel();
        Tierras = new javax.swing.JLabel();
        Macetas = new javax.swing.JLabel();
        txtMacetas = new javax.swing.JTextField();
        txtCantTotal = new javax.swing.JTextField();
        txtPlantas = new javax.swing.JTextField();
        txtAgroquimicos = new javax.swing.JTextField();
        txtTierras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("TOTAL:");

        Titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Titulo.setText("Movimientos de ventas de hoy");

        PanelDescripcion.setBackground(new java.awt.Color(204, 204, 204));

        CantTotal.setBackground(new java.awt.Color(0, 0, 0));
        CantTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CantTotal.setForeground(new java.awt.Color(0, 0, 0));
        CantTotal.setText("Cantidad Total:");

        Plantas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Plantas.setForeground(new java.awt.Color(0, 0, 0));
        Plantas.setText("Plantas:");

        Agroquimicos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Agroquimicos.setForeground(new java.awt.Color(0, 0, 0));
        Agroquimicos.setText("Agroquimicos:");

        Tierras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Tierras.setForeground(new java.awt.Color(0, 0, 0));
        Tierras.setText("Tierras:");

        Macetas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Macetas.setForeground(new java.awt.Color(0, 0, 0));
        Macetas.setText("Macetas:");

        javax.swing.GroupLayout PanelDescripcionLayout = new javax.swing.GroupLayout(PanelDescripcion);
        PanelDescripcion.setLayout(PanelDescripcionLayout);
        PanelDescripcionLayout.setHorizontalGroup(
                PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                                .addComponent(CantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtCantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                                .addComponent(Plantas)
                                                .addGap(20, 20, 20)
                                                .addComponent(txtPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                                .addComponent(Agroquimicos)
                                                .addGap(14, 14, 14)
                                                .addComponent(txtAgroquimicos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                                .addComponent(Tierras)
                                                .addGap(15, 15, 15)
                                                .addComponent(txtTierras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                                .addComponent(Macetas)
                                                .addGap(11, 11, 11)
                                                .addComponent(txtMacetas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        PanelDescripcionLayout.setVerticalGroup(
                PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelDescripcionLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCantTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Plantas)
                                        .addComponent(txtPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Agroquimicos)
                                        .addComponent(txtAgroquimicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Tierras)
                                        .addComponent(txtTierras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(PanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Macetas)
                                        .addComponent(txtMacetas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addComponent(Total)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(PanelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(Total))
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
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
        gui.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JLabel Agroquimicos;
    private javax.swing.JLabel CantTotal;
    private javax.swing.JLabel Macetas;
    private javax.swing.JPanel PanelDescripcion;
    private javax.swing.JLabel Plantas;
    private javax.swing.JLabel Tierras;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel Total;
    private javax.swing.JButton Volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAgroquimicos;
    private javax.swing.JTextField txtCantTotal;
    private javax.swing.JTextField txtMacetas;
    private javax.swing.JTextField txtPlantas;
    private javax.swing.JTextField txtTierras;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration
}
