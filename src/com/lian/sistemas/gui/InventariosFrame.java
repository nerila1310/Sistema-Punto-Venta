/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lian.sistemas.gui;

import com.lian.sistemas.datos.baseDatos;
import com.lian.sistemas.pojos.Producto;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author neri_laredo
 */
public class InventariosFrame extends javax.swing.JInternalFrame {
    
    DefaultTableModel modeloTabla = new DefaultTableModel();
    baseDatos datos = new baseDatos();
    Producto productoSeleccionado = null;
    
    /**
     * Creates new form Inventarios
     */
    public InventariosFrame() {
        initComponents();
        cargarColumnas();
        cargarModeloTabla();
    }
    
    private void cargarColumnas(){
        modeloTabla.addColumn("Clave");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Unidad");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Existencia");
    }
    
    private void cargarModeloTabla(){
        
        limpiarTabla();
        ArrayList<Producto> listaProductos = datos.obtenerProducto();
        
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        
        
        for(int i = 0; i < numeroProductos; i++){
            Producto producto = listaProductos.get(i); 
            
            modeloTabla.setValueAt(producto, i, 0);
            modeloTabla.setValueAt(producto.getNomProducto(), i, 1);
            modeloTabla.setValueAt(producto.getUnidadProducto(), i, 2);
            modeloTabla.setValueAt(producto.getPrecioCompraProducto(), i, 3);
            modeloTabla.setValueAt(producto.getPrecioVentaProducto(), i, 4);
            modeloTabla.setValueAt(producto.getExistenciaProducto(), i, 5);
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

        btnNuevoArticulo = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnProveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        campoExistencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoIngresar = new javax.swing.JTextField();
        btnAgregarExistencia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnModificarProd = new javax.swing.JButton();
        btnBorrarProd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();

        setTitle("Inventarios");

        btnNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArticuloActionPerformed(evt);
            }
        });

        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel1.setText("Inventarios:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Clave:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        campoNombre.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Existencia:");

        campoClave.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        campoExistencia.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoExistenciaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Ingresar al inventario:");

        CampoIngresar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btnAgregarExistencia.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnAgregarExistencia.setText("Agregar");
        btnAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciaActionPerformed(evt);
            }
        });

        tablaProductos.setModel(modeloTabla);
        tablaProductos.getSelectionModel().addListSelectionListener(

            new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent event){

                    if(!event.getValueIsAdjusting() && (tablaProductos.getSelectedRow()>=0)){

                        int filaSeleccionada = tablaProductos.getSelectedRow();
                        Producto producto = (Producto)modeloTabla.getValueAt(filaSeleccionada, 1);

                        campoClave.setText(producto.getIdProducto());
                        campoNombre.setText(producto.getNomProducto());
                        campoExistencia.setText(String.valueOf(producto.getExistenciaProducto()));
                        productoSeleccionado = producto;
                    }
                }
            }
        );
        jScrollPane1.setViewportView(tablaProductos);

        btnModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProdActionPerformed(evt);
            }
        });

        btnBorrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Buscar:");

        campoBuscar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBorrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoExistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CampoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 138, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoExistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoExistenciaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        ProveedorFrame proveedor = new ProveedorFrame(null,true);
        proveedor.setVisible(true);
        proveedor.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        proveedor.setLocation(600,150);
        proveedor.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArticuloActionPerformed
        ProductoFrame articulo = new ProductoFrame(null,true, null, null, "Nuevo Producto", false);
        articulo.setVisible(true);
        articulo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        articulo.setLocation(600,150);
        articulo.setAlwaysOnTop(true);
        
        if(articulo != null ){
            if (articulo.getInformacion() != "") {
                cargarModeloTabla();
            }
        }
    }//GEN-LAST:event_btnNuevoArticuloActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        CategoriaFrame categoria = new CategoriaFrame(null,true);
        categoria.setVisible(true);
        categoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        categoria.setLocation(600,150);
        categoria.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciaActionPerformed
        double existencia = Double.parseDouble(CampoIngresar.getText());
        double cantidadActual = productoSeleccionado.getExistenciaProducto();
        double nuevaCantidad = cantidadActual + existencia;
        
        datos.actualizarInventario(productoSeleccionado, nuevaCantidad);
        
        CampoIngresar.setText("");
        cargarModeloTabla();
    }//GEN-LAST:event_btnAgregarExistenciaActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        
        limpiarTabla();
        String cadenaBusqueda = campoBuscar.getText();
        ArrayList<Producto> listaProductos = datos.obtenerProductoPorCriterio(cadenaBusqueda);
        
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        
        for(int i = 0; i < numeroProductos; i++){
            Producto producto = listaProductos.get(i); 
            
            modeloTabla.setValueAt(producto.getIdProducto(), i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(producto.getUnidadProducto(), i, 2);
            modeloTabla.setValueAt(producto.getPrecioCompraProducto(), i, 3);
            modeloTabla.setValueAt(producto.getPrecioVentaProducto(), i, 4);
            modeloTabla.setValueAt(producto.getExistenciaProducto(), i, 5);
        }
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void btnBorrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProdActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"El elemento se borrará definitivamente");
        
        if(opcion == 0){
            modeloTabla.removeRow(tablaProductos.getSelectedRow());
            datos.borrarProducto(productoSeleccionado);
        }
        
    }//GEN-LAST:event_btnBorrarProdActionPerformed

    private void btnModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProdActionPerformed
        
        String nombreProducto = productoSeleccionado.getNomProducto();
        ImageIcon imagenProducto = null;
        ProductoFrame frameProd = null;
        
        int opcion = JOptionPane.showConfirmDialog(this,"¿Desea modificar el producto " + nombreProducto+"?");
        
        if (opcion == 0) {
            try {
                /* Obtener imagen*/
                InputStream is = datos.buscarFoto(productoSeleccionado);
                BufferedImage bi = ImageIO.read(is);
                imagenProducto = new ImageIcon(bi);
                
                /* Crear ventana con datos*/
                frameProd = new ProductoFrame(null, true, productoSeleccionado, imagenProducto, "Actualizar Producto", true);
                frameProd.setVisible(true);
                frameProd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                frameProd.setLocation(600,150);
                frameProd.setAlwaysOnTop(true);
                
                if(frameProd != null ){
                    if (frameProd.getInformacion() != "") {
                        cargarModeloTabla();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }//GEN-LAST:event_btnModificarProdActionPerformed

    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoIngresar;
    private javax.swing.JButton btnAgregarExistencia;
    private javax.swing.JButton btnBorrarProd;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnModificarProd;
    private javax.swing.JButton btnNuevoArticulo;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoExistencia;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
