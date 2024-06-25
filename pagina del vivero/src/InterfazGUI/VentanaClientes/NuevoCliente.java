/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGUI.VentanaClientes;
import Excepciones.ExceptionCodigoDuplicado;
import Excepciones.ExceptionDNI;
import InterfazGUI.GUI;
import InterfazGUI.Ventas.VentanaPrincipal;
import Placeholder.TextPrompt;
import Vivero.Vivero;
//import com.fasterxml.jackson.databind.ObjectMapper;



import javax.swing.*;
import java.io.IOException;

/**
 *
 * @author Gian
 */
public class NuevoCliente extends javax.swing.JFrame {



    /**
     * Creates new form NuevoCliente
     */
    Vivero vivero = new Vivero();//PROVISORIO DE PERSISTENCIA(JSON)
    private int flag;
    VentanaPrincipal a;
    public NuevoCliente() {
        initComponents();
        setTitle("Nuevo cliente");
         setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        TextPrompt placeholdern1=new TextPrompt("Escriba aqui su nombre", txtNombre);
        TextPrompt placeholdern2=new TextPrompt("Escriba aqui su apellido", txtApellido);
        TextPrompt placeholdern3=new TextPrompt("Escriba aqui su dni", txtDNI);
        GUI.setupButton(Volver);
        GUI.setupButton(Guardar);
        setResizable(false);

    }
    public NuevoCliente(int flag, VentanaPrincipal a ) {
        initComponents1(flag);
        this.a=a;
        setTitle("Nuevo cliente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        TextPrompt placeholdern1=new TextPrompt("Escriba aqui su nombre", txtNombre);
        TextPrompt placeholdern2=new TextPrompt("Escriba aqui su apellido", txtApellido);
        TextPrompt placeholdern3=new TextPrompt("Escriba aqui su dni", txtDNI);
        GUI.setupButton(Volver);
        GUI.setupButton(Guardar);
        setResizable(false);
        this.flag= flag;
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
        Volver = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
         Nombre= new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        Dni = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        CategoriaCmBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        Apellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Apellido.setForeground(new java.awt.Color(0, 0, 0));
        Apellido.setText("Apellido");

        Categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Categoria.setForeground(new java.awt.Color(0, 0, 0));
        Categoria.setText("Categoria");

        Dni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dni.setForeground(new java.awt.Color(0, 0, 0));
        Dni.setText("DNI");

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

        CategoriaCmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consumidor final","Monotributista",  "Responsable Inscripto"}));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Apellido)
                                        .addComponent(Nombre))
                                .addGap(35, 35, 35)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(107, 107, 107)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Dni)
                                                        .addComponent(Categoria)))
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CategoriaCmBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDNI)))
                                .addGap(110, 110, 110))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nombre)
                                        .addComponent(Dni))
                                .addGap(43, 43, 43)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Apellido)
                                        .addComponent(Categoria)
                                        .addComponent(CategoriaCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initComponents1(int flag) {

        MainPanel = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        Nombre= new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        Dni = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        CategoriaCmBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                VolverActionPerformed1(evt, flag);
            }
        });

        Nombre.setForeground(new java.awt.Color(0, 0, 0));
        Nombre.setText("Nombre");

        Apellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Apellido.setForeground(new java.awt.Color(0, 0, 0));
        Apellido.setText("Apellido");

        Categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Categoria.setForeground(new java.awt.Color(0, 0, 0));
        Categoria.setText("Categoria");

        Dni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dni.setForeground(new java.awt.Color(0, 0, 0));
        Dni.setText("DNI");

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

        CategoriaCmBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consumidor final","Monotributista",  "Responsable Inscripto"}));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Apellido)
                                        .addComponent(Nombre))
                                .addGap(35, 35, 35)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(107, 107, 107)
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Dni)
                                                        .addComponent(Categoria)))
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CategoriaCmBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDNI)))
                                .addGap(110, 110, 110))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nombre)
                                        .addComponent(Dni))
                                .addGap(43, 43, 43)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Apellido)
                                        .addComponent(Categoria)
                                        .addComponent(CategoriaCmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
          Cliente cliente=new Cliente();
        cliente.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_VolverActionPerformed
    private void VolverActionPerformed1(java.awt.event.ActionEvent evt, int flag) {//GEN-FIRST:event_VolverActionPerformed

       a.setVisible(true);// TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_VolverActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        try {
            Clientes.Cliente cliente = new Clientes.Cliente();
            cliente.setNombre(txtNombre.getText());
            cliente.setApellido(txtApellido.getText());
            cliente.setCategoria((String) CategoriaCmBox.getSelectedItem());
            cliente.setDni(Integer.parseInt(txtDNI.getText()));

            if(  txtNombre.getText().equals("") ||  txtApellido.getText().equals("") || txtDNI.getText().equals(""))
            {
                throw new NumberFormatException("Campos vacios");
            }

            try {
                    if(vivero.archivoVivero.exists()) {
                        vivero = Vivero.cargarDesdeArchivo("archivo.json");
                    }

                vivero.agregar(cliente);
                vivero.guardarEnArchivo("archivo.json");
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            }catch (IOException e)
            {

            }

            catch (ExceptionDNI e)
            {
                JOptionPane.showInternalMessageDialog(null, "Ya existe un cliente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            } catch (ExceptionCodigoDuplicado e) {

            }
            txtNombre.setText("");
            txtApellido.setText("");
            CategoriaCmBox.setSelectedItem("Consumidor Final");
            txtDNI.setText("");
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_GuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Categoria;
    private javax.swing.JComboBox<String> CategoriaCmBox;
    private javax.swing.JLabel Dni;
    private javax.swing.JButton Guardar;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
