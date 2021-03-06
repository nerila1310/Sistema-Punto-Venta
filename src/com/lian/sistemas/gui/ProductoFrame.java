/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lian.sistemas.gui;

import com.lian.sistemas.datos.baseDatos;
import com.lian.sistemas.pojos.Categoria;
import com.lian.sistemas.pojos.Producto;
import com.lian.sistemas.pojos.Proveedores;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author neri_laredo
 */
public class ProductoFrame extends javax.swing.JDialog {

    DefaultComboBoxModel<Categoria> modeloCategorias;
    DefaultComboBoxModel<Proveedores> modeloProveedores;
    baseDatos datos;
    boolean estaActualizando;
    String informacion;
    /**
     * Creates new form ArticuloFrame
     */
    public ProductoFrame(java.awt.Frame parent, boolean modal, Producto producto, ImageIcon icon, String titulo, boolean actualizacion) {
        super(parent, modal);
        modeloCategorias = new DefaultComboBoxModel<Categoria>();
        modeloProveedores = new DefaultComboBoxModel<>();
        datos = new baseDatos();
        cargarModedeloCategoria();
        cargarModeloProveedor();
        initComponents();
        this.estaActualizando = actualizacion;
        this.setTitle(titulo);
        
        if (producto != null) {
            cargarProducto(producto, icon);
        }
        
    }
    
    public void cargarProducto(Producto producto, ImageIcon icon){
        Image imgProd = icon.getImage();
        int anchoEtiqueta = lblImagenArticulo.getWidth();
        int altoEtiqueta = lblImagenArticulo.getHeight();
            
        Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
        ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
        
        lblImagenArticulo.setIcon(iconoRedimensionado);
        campoClave.setText(producto.getIdProducto());
        campoNombre.setText(producto.getNomProducto());
        campoDesc.setText(producto.getDescProducto());
        campoStock.setText(String.valueOf(producto.getStockProducto()));
        comboUnidades.setSelectedItem(producto.getUnidadProducto());
        campoPrecioCompra.setText(String.valueOf(producto.getPrecioCompraProducto()));
        campoPrecioVenta.setText(String.valueOf(producto.getPrecioVentaProducto()));
        campoExistencia.setText(String.valueOf(producto.getExistenciaProducto()));
        
        campoClave.setEnabled(false);
        campoNombre.setEnabled(false);
        
    }
    
    
    
    private void cargarModedeloCategoria(){
        ArrayList<Categoria> listaCategoria;
        listaCategoria =  datos.obtenerCategoria();
    
        for(Categoria categoria: listaCategoria){
            modeloCategorias.addElement(categoria);
        };
    }
    
    private void cargarModeloProveedor(){
        ArrayList<Proveedores> listaProveedores;
        listaProveedores = datos.obtenerProveedor();
        
        for (Proveedores proveedor : listaProveedores) {
            modeloProveedores.addElement(proveedor);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDesc = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        campoStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboUnidades = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        campoPrecioCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoPrecioVenta = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardarProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImagenArticulo = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campoExistencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Clave:");

        campoClave.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Descripción");

        campoDesc.setColumns(20);
        campoDesc.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoDesc.setRows(5);
        jScrollPane1.setViewportView(campoDesc);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Stock Requerido:");

        campoStock.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Categoría:");

        comboCategoria.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboCategoria.setModel(modeloCategorias);
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Agregar Categoría");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Unidad de Medida:");

        comboUnidades.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Litro", "Pieza", "Docena", "Caja" }));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Precio de Compra:");

        campoPrecioCompra.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Precio de Venta:");

        campoPrecioVenta.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioVentaActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardarProducto.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(109, 109, 109));

        lblImagenArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        comboProveedor.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        comboProveedor.setModel(modeloProveedores);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("Proveedor:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Nombre");

        campoNombre.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Existencia:");

        campoExistencia.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(campoClave)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(campoNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(comboUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoStock))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(campoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(campoPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addComponent(jLabel10)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 703, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioVentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CategoriaFrame categoria = new CategoriaFrame(null,true);
        categoria.setVisible(true);
        categoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        categoria.setLocation(600,150);
        categoria.setAlwaysOnTop(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    File imgArticuloFile;
    private void lblImagenArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMousePressed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, gif o png","jpg", "gif", "png");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            imgArticuloFile = chooser.getSelectedFile();
            ImageIcon icono = new ImageIcon(imgArticuloFile.getAbsolutePath());
            Image imagen = icono.getImage();
            
            int anchoImg = lblImagenArticulo.getWidth();
            int altoImg = lblImagenArticulo.getHeight();
            
            Image imgRedimensionada = imagen.getScaledInstance(anchoImg, altoImg, Image.SCALE_DEFAULT);
            
            ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
            
            lblImagenArticulo.setIcon(iconoRedimensionado);
        }
        
    }//GEN-LAST:event_lblImagenArticuloMousePressed

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        String clave = campoClave.getText();
        String nombre = campoNombre.getText();
        String descripcion = campoDesc.getText();
        double stock = Double.parseDouble(campoStock.getText());
        double precioCompra = Double.parseDouble(campoPrecioCompra.getText());
        double precioVenta = Double.parseDouble(campoPrecioVenta.getText());
        double existencia = Double.parseDouble(campoExistencia.getText());
        String unidad = comboUnidades.getSelectedItem().toString();
        Categoria categoria = (Categoria)comboCategoria.getSelectedItem();
        Proveedores proveedor = (Proveedores)comboProveedor.getSelectedItem();
        
        if (estaActualizando) {
            if(imgArticuloFile == null) {
            
                Producto producto = new Producto(clave, nombre, descripcion, stock, null, 
                                        unidad, precioCompra, precioVenta, existencia, 
                                        categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
        
                datos.actualizarProducto(producto, false);
            } else {
                
                Producto producto = new Producto(clave, nombre, descripcion, stock, imgArticuloFile, 
                                        unidad, precioCompra, precioVenta, existencia, 
                                        categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
        
                datos.actualizarProducto(producto, true);
                
            }
            
            JOptionPane.showMessageDialog(this, "Se ha guardado el Producto");
            this.dispose();
            informacion = "1";
            
        }
        
        if (imgArticuloFile == null) {
                JOptionPane.showMessageDialog(this, "No ha elegido ninguna imagen");
            }else{
                Producto producto = new Producto(clave, nombre, descripcion, stock, imgArticuloFile, 
                                        unidad, precioCompra, precioVenta, existencia, 
                                        categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
                
                datos.insertarProducto(producto);
                
                JOptionPane.showMessageDialog(this, "Se ha guardado el producto");
                this.dispose();
                informacion = "1";
            }
        
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    public String getInformacion(){
        return this.informacion;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoFrame dialog = new ProductoFrame(new javax.swing.JFrame(), true, null, new ImageIcon(), new String(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextArea campoDesc;
    private javax.swing.JTextField campoExistencia;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioCompra;
    private javax.swing.JTextField campoPrecioVenta;
    private javax.swing.JTextField campoStock;
    private javax.swing.JComboBox<Categoria> comboCategoria;
    private javax.swing.JComboBox<Proveedores> comboProveedor;
    private javax.swing.JComboBox<String> comboUnidades;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenArticulo;
    // End of variables declaration//GEN-END:variables
}
