package InterfazGUI;

import InterfazGUI.VentanaArticulos.Articulos;
import InterfazGUI.VentanaClientes.Cliente;
import InterfazGUI.VentanaCompras.Compra;
import InterfazGUI.Ventas.VentanaPrincipal;
import InterfazGUI.HistorialVentas.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Gian
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private Color colorOriginal;
    public GUI() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDate();
        setTitle("Vivero Professional version");
        setHora();
        setupButton(Ventas);
        setupButton(Compras);
        setupButton(Caja);
        setupButton(Historial);
        setupButton(Ayuda);
        setupButton(Articulos);
        setupButton(Clientes);
        
    }
    private void setDate()
            {
                LocalDate now=LocalDate.now();
                Locale spanishLocale= new Locale("es", "ES");
                Fecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es 'EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
                
            }


    private void setHora() {
        Hora.setEditable(false); // Make the text field non-editable
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
                String formattedTime = now.format(DateTimeFormatter.ofPattern("hh:mm a"));
                Hora.setText(formattedTime);
            }
        });
        timer.start();
    }

    //Hacer el efecto de hover en todos los botones
    public static void setupButton(JButton button) {
        // Guardar el color original del botón
       Color original= button.getBackground();

        // Agregar MouseListener al botón
        button.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.BLUE);  // Cambia a un color de fondo más claro
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(original);  // Restaura el color de fondo original
            }
        });
    }

    public static void setupButtonAceptar(JButton button) {
        // Guardar el color original del botón
        Color original= button.getBackground();

        // Agregar MouseListener al botón
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.GREEN);  // Cambia a un color de fondo más claro
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(original);  // Restaura el color de fondo original
            }
        });
    }

    public static void setupButtonCancelar(JButton button) {
        // Guardar el color original del botón
        Color original= button.getBackground();

        // Agregar MouseListener al botón
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.red);  // Cambia a un color de fondo más claro
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(original);  // Restaura el color de fondo original
            }
        });
    }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        Ventas = new javax.swing.JButton();
        Compras = new javax.swing.JButton();
        Caja = new javax.swing.JButton();
        Historial = new javax.swing.JButton();
        Ayuda = new javax.swing.JButton();
        Articulos = new javax.swing.JButton();
        Clientes = new javax.swing.JButton();
        Imagen = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        Hora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png"))).getImage());

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        MainPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        Titulo.setBackground(new java.awt.Color(204, 255, 255));
        Titulo.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        Titulo.setText("Vivero ");

        PanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Ventas.setBackground(new java.awt.Color(51, 102, 255));
        Ventas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ventas.setForeground(new java.awt.Color(255, 255, 255));
        Ventas.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\carrito-de-compras (1).png"));
        Ventas.setText("Ventas");
        Ventas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Ventas.setBorderPainted(false);
        Ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ventas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Ventas.setIconTextGap(10);
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });

        Compras.setBackground(new java.awt.Color(51, 101, 255));
        Compras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Compras.setForeground(new java.awt.Color(255, 255, 255));
        Compras.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\usuarios.png"));
        Compras.setText("Compras");
        Compras.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Compras.setBorderPainted(false);
        Compras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Compras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Compras.setIconTextGap(10);
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });

        Caja.setBackground(new java.awt.Color(51, 102, 255));
        Caja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Caja.setForeground(new java.awt.Color(255, 255, 255));
        Caja.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\dolar.png"));
        Caja.setText("Caja");
        Caja.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Caja.setBorderPainted(false);
        Caja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Caja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Caja.setIconTextGap(10);
        Caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CajaActionPerformed(evt);
            }
        });

        Historial.setBackground(new java.awt.Color(51, 102, 255));
        Historial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Historial.setForeground(new java.awt.Color(255, 255, 255));
        Historial.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\libro-alt.png"));
        Historial.setText("Historial");
        Historial.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Historial.setBorderPainted(false);
        Historial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Historial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Historial.setIconTextGap(10);
        Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialActionPerformed(evt);
            }
        });

        Ayuda.setBackground(new java.awt.Color(51, 102, 255));
        Ayuda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ayuda.setForeground(new java.awt.Color(255, 255, 255));
        Ayuda.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\interrogatorio.png"));
        Ayuda.setText("Ayuda");
        Ayuda.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Ayuda.setBorderPainted(false);
        Ayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ayuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Ayuda.setIconTextGap(10);
        Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaActionPerformed(evt);
            }
        });

        Articulos.setBackground(new java.awt.Color(51, 102, 255));
        Articulos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Articulos.setForeground(new java.awt.Color(255, 255, 255));
        Articulos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\planta-de-semillero.png"));
        Articulos.setText("Articulos");
        Articulos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Articulos.setBorderPainted(false);
        Articulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Articulos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Articulos.setIconTextGap(10);
        Articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArticulosActionPerformed(evt);
            }
        });

        Clientes.setBackground(new java.awt.Color(51, 102, 255));
        Clientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Imagenes\\usuario.png"));
        Clientes.setText("Clientes");
        Clientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        Clientes.setBorderPainted(false);
        Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Clientes.setIconTextGap(10);
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
                PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Compras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Articulos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Caja, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        PanelMenuLayout.setVerticalGroup(
                PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelMenuLayout.createSequentialGroup()
                                .addComponent(Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Compras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Articulos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Caja, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png")));

        Fecha.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 0, 0));
        Fecha.setText("\"'Hoy es 'EEEE dd 'de' MMMM 'de' yyyy\"");

        Hora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(Titulo)
                                                                .addGap(169, 169, 169)
                                                                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(37, 37, 37))
                                                        .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(62, Short.MAX_VALUE))))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Titulo)
                                                        .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
          VentanaPrincipal pantallaVentas=new VentanaPrincipal();
          pantallaVentas.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_VentasActionPerformed

    private void ArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArticulosActionPerformed
      InterfazGUI.VentanaArticulos.Articulos pantallaArticulos=new Articulos();
        pantallaArticulos.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_ArticulosActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
          Compra pantallaCompras=new Compra();
          pantallaCompras.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_ComprasActionPerformed

    private void CajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CajaActionPerformed
        Caja pantallaCaja=new Caja();
         
          pantallaCaja.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_CajaActionPerformed

    private void HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialActionPerformed
        Historial pantallaHistorial=new Historial();
        
          pantallaHistorial.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_HistorialActionPerformed

    private void AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaActionPerformed
        Ayuda pantallaAyuda=new Ayuda();
        
          pantallaAyuda.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_AyudaActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Cliente pantallaCliente=new Cliente();
        
          pantallaCliente.setVisible(true);
          setVisible(false);
    }//GEN-LAST:event_ClientesActionPerformed

    private void HoraActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Articulos;
    private javax.swing.JButton Ayuda;
    private javax.swing.JButton Caja;
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Compras;
    private javax.swing.JLabel Fecha;
    private javax.swing.JButton Historial;
    private javax.swing.JLabel Imagen;
    private javax.swing.JTextField Hora;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton Ventas;
    // End of variables declaration//GEN-END:variables
}
