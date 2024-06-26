package InterfazGUI.VentanaArticulos;


import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;
import Historial.ClaseJson;
import InterfazGUI.GUI;
import InterfazGUI.VentanaClientes.Cliente;
import Vivero.Vivero;
import Articulos.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Gian
 */
public class VentanaEditarArticulo extends JFrame {

    /**
     * Creates new form VentanaEditarCliente
     */
    private Vivero vivero;
    private int codigo;
    public VentanaEditarArticulo(int codigo, Vivero vivero) {
        initComponents();
        setTitle("Editar articulo");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        GUI.setupButton(Volver);
        GUI.setupButton(Guardar);
        setResizable(false);
        this.codigo=codigo;
        this.vivero=vivero;
        cargar();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        Tipo = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        TipoCmBox = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        Stock = new javax.swing.JLabel();
        Codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 400));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marchitez-de-la-planta-solar.png")).getImage());
        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setForeground(new java.awt.Color(0, 0, 0));

        Volver.setBackground(new java.awt.Color(52, 102, 255));
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.setBorder(null);
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        Nombre.setForeground(new java.awt.Color(0, 0, 0));
        Nombre.setText("Nombre");

        Precio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Precio.setForeground(new java.awt.Color(0, 0, 0));
        Precio.setText("Precio");

        Tipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tipo.setForeground(new java.awt.Color(0, 0, 0));
        Tipo.setText("Tipo");

        Guardar.setBackground(new java.awt.Color(52, 102, 255));
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar");
        Guardar.setBorder(null);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        TipoCmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planta", "Maceta", "Agroquimico", "Tierra" }));
        TipoCmBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TipoCmBoxActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //txtPrecioActionPerformed(evt);
            }
        });

        Stock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 0, 0));
        Stock.setText("Stock");

        Codigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Codigo.setForeground(new java.awt.Color(0, 0, 0));
        Codigo.setText("Codigo");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Stock)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(Nombre)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(78, 78, 78)
                                                                .addComponent(Tipo)))
                                                .addGap(28, 28, 28)
                                                .addComponent(TipoCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(Precio)
                                                                .addGap(42, 42, 42)
                                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                                                                                .addGap(132, 132, 132)
                                                                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Codigo)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(Nombre))
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(Tipo))
                                        .addComponent(TipoCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Precio)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Stock))
                                .addGap(52, 52, 52)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Codigo)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {
        Articulos articulos=new Articulos();
        articulos.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }

    private void cargar()
    {
        Articulo aux=(Articulo) vivero.buscarCodigo(codigo);
        txtNombre.setText(aux.getNombreDelArticulo());
        txtPrecio.setText(String.valueOf(aux.getPrecio()));
        TipoCmBox.setSelectedItem(aux.getTipoDeArticulo());
        txtStock.setText(String.valueOf(aux.getStock()));
        txtCodigo.setText(String.valueOf(aux.getCodigo()));
    }


    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Articulo articulo = new Articulo();
            articulo.setNombreDelArticulo(txtNombre.getText());
            articulo.setPrecio(Float.parseFloat(txtPrecio.getText()));
            articulo.setCodigo(Integer.parseInt(txtCodigo.getText()));
            articulo.setStock(Integer.parseInt(txtStock.getText()));
            articulo.setTipoDeArticulo((String) TipoCmBox.getSelectedItem());

            if (txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtCodigo.getText().equals("") || txtStock.getText().equals("")) {
                throw new NumberFormatException("Campos vacíos");
            }

            try {
                // Remover el artículo existente con el mismo código
                Articulo articuloExistente = (Articulo) vivero.buscarCodigo(codigo);
                if (articuloExistente != null) {
                    vivero.getArticulos().remove(articuloExistente.getCodigo());
                }

                // Agregar el artículo modificado
                vivero.agregar(articulo);
                vivero.guardarEnArchivo("archivo.json");
                JOptionPane.showMessageDialog(null, "Artículo registrado exitosamente");

                // Limpiar los campos
                txtNombre.setText("");
                txtStock.setText("");
                txtCodigo.setText("");
                txtPrecio.setText("");
                TipoCmBox.setSelectedItem("Planta");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ExceptionCodigoDuplicado e) {
                JOptionPane.showInternalMessageDialog(null, "Ya existe un artículo con ese código", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            } catch (ExceptionDNI e) {
                // Manejar la excepción de DNI aquí si es necesario
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    /**
     */



    // Variables declaration - do not modify
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton Guardar;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel Tipo;
    private javax.swing.JComboBox<String> TipoCmBox;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration
}
