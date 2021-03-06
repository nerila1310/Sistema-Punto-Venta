package com.lian.sistemas.gui;

import com.lian.sistemas.datos.baseDatos;
import com.lian.sistemas.pojos.Producto;
import com.lian.sistemas.pojos.Ventas;
import com.lian.sistemas.pojos.detalleVenta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.sql.Date;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author neri_laredo
 */
public class VentasFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaProductos = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();
    baseDatos datos = new baseDatos();        
            
    /**
     * Creates new form Ventas
     */
    public VentasFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarListenerModeloTabla();
    }
    
    
    private void cargarColumnasTabla(){
        modeloTablaProductos.addColumn("Clave");
        modeloTablaProductos.addColumn("Nombre");
        modeloTablaProductos.addColumn("Precio Venta");
        modeloTablaProductos.addColumn("Cantidad");
        modeloTablaProductos.addColumn("Importe");
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblImagenProd = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSumatoria = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoPagaCon = new javax.swing.JTextField();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoBuscarProd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        btnCancelarVenta = new javax.swing.JButton();
        btnQuitarProd = new javax.swing.JButton();
        btnCorteDia = new javax.swing.JButton();

        setTitle("Ventas");

        tablaVenta.setModel(modeloTablaProductos);
        tablaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaVentaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVenta);

        jPanel1.setBackground(new java.awt.Color(46, 46, 46));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenProd, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Venta Total:");

        lblSumatoria.setFont(new java.awt.Font("Ubuntu", 1, 56)); // NOI18N
        lblSumatoria.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel4.setText("Pago con:");

        btnRealizarVenta.setBackground(new java.awt.Color(143, 2, 3));
        btnRealizarVenta.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSumatoria))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(70, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSumatoria)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Buscar Producto:");

        campoBuscarProd.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarProdActionPerformed(evt);
            }
        });
        campoBuscarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarProdKeyReleased(evt);
            }
        });

        listaProductos.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        listaProductos.setModel(modeloListaProductos);
        listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listaProductos);

        btnCancelarVenta.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnCancelarVenta.setText("Cancelar Venta");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        btnQuitarProd.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnQuitarProd.setText("Quitar Producto");
        btnQuitarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProdActionPerformed(evt);
            }
        });

        btnCorteDia.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnCorteDia.setText("Corte del Día");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoBuscarProd)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCorteDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnQuitarProd)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCorteDia, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(campoBuscarProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarProdKeyReleased
        
        limpiarListaProductos();
        String cadenaBusqueda = campoBuscarProd.getText();
        if( cadenaBusqueda.isEmpty() ){
            limpiarListaProductos();
        }else{
            ArrayList<Producto> listaProductos = datos.obtenerProductoPorCriterio(cadenaBusqueda);
         
            for (Producto prod:listaProductos){
                modeloListaProductos.addElement(prod);
            }
        }
    }//GEN-LAST:event_campoBuscarProdKeyReleased

    private void campoBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarProdActionPerformed

    private void listaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProductosMousePressed
        
        JList list = (JList)evt.getSource();
        if(evt.getClickCount() == 2){
            int index = list.locationToIndex(evt.getPoint());
            Producto prod = (Producto)list.getSelectedValue();
            anadirProductoAVenta(prod);
            desplegarFoto(prod);
        }
    }//GEN-LAST:event_listaProductosMousePressed

    private void desplegarFoto(Producto producto){
        ImageIcon imageProducto = null;
       
        try {
            InputStream is = datos.buscarFoto(producto);
            BufferedImage bi = ImageIO.read(is);
            imageProducto = new ImageIcon(bi);
            
            Image imgProd = imageProducto.getImage();
            int anchoEtiqueta = lblImagenProd.getWidth();
            int altoEtiqueta = lblImagenProd.getHeight();
            
            Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
            ImageIcon iconoRedimensionado = new ImageIcon(imgRedimensionada);
            
            lblImagenProd.setIcon(iconoRedimensionado);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void tablaVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaVentaKeyReleased
        
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            int filaSeleccionada = tablaVenta.getSelectedRow();
            String cantidad = JOptionPane.showInputDialog("Modificar cantidad: ");
            String precioVenta = (String)modeloTablaProductos.getValueAt(filaSeleccionada, 2);
            double importe = Double.parseDouble(cantidad) * Double.parseDouble(precioVenta);
            String importeString = String.valueOf(importe);
            modeloTablaProductos.setValueAt(cantidad, filaSeleccionada, 3);
            modeloTablaProductos.setValueAt(importeString, filaSeleccionada, 4);
        }
        
    }//GEN-LAST:event_tablaVentaKeyReleased

    private void btnQuitarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProdActionPerformed
        int filaSeleccionada = tablaVenta.getSelectedRow();
        int cantidadFilas = modeloTablaProductos.getRowCount();
        
        if(cantidadFilas > 0){
            
            int opcion = JOptionPane.showConfirmDialog(this, "¿Eliminar Producto?");

            if (opcion == 0) {
                modeloTablaProductos.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_btnQuitarProdActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        int cantidadFilas = modeloTablaProductos.getRowCount();
        
        if(cantidadFilas > 0){
        
            int opcion = JOptionPane.showConfirmDialog(this, "¿Cancelar Venta?");

            if (opcion == 0) {
                for (int i = cantidadFilas-1; i >= 0; i--) {
                    modeloTablaProductos.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        
        ArrayList<detalleVenta> detalles = new ArrayList<detalleVenta>();
        
        String sumatoriaStr = lblSumatoria.getText();
        double montoVenta = Double.parseDouble(sumatoriaStr);
        
        String pagoStr = campoPagaCon.getText();
        double cambio = 0;
        
        if (!pagoStr.isEmpty()) {
            double montoPago = Double.parseDouble(pagoStr);
            cambio = montoPago-montoVenta;
        }
        
        Calendar calendarioLocal = Calendar.getInstance();
        java.util.Date fechaActual = calendarioLocal.getTime();
        long fechaMilisegundos = fechaActual.getTime();
        java.sql.Date fecha = new Date(fechaMilisegundos);
        
        Ventas venta = new Ventas(montoVenta, fecha);
        Long idVenta = datos.insertarVenta(venta);
        
        int numRows = modeloTablaProductos.getRowCount();
        
        for (int i = 0; i < numRows; i++) {
            String idProducto = (String)modeloTablaProductos.getValueAt(i, 0);
            String cantidadStr = (String)modeloTablaProductos.getValueAt(i, 3);
            double cantidad = Double.parseDouble(cantidadStr);
            
            detalleVenta detalle = new detalleVenta(idVenta, idProducto, cantidad);
            datos.insertarDetalleVenta(detalle);
            
            detalles.add(detalle);
        }
        
        for (int i = numRows-1; i >= 0; i--) {
            modeloTablaProductos.removeRow(i);
        }
        
        lblSumatoria.setText("0.00");
        
        if (!pagoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "<html><h1 style='font-size:100px; color:blue'>"+cambio+"</h1></html>", "Usted debe dar este cambio: ",1);
            campoPagaCon.setText("");
        }
        
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void anadirProductoAVenta(Producto producto){
        String claveProd = producto.getIdProducto();
        String nombreProd = producto.getNomProducto();
        String precioVenta = String.valueOf(producto.getPrecioVentaProducto());
        String importe = String.valueOf(producto.getPrecioVentaProducto());
        
        String[] datosProductos = {claveProd, nombreProd, precioVenta, "1", importe};
        modeloTablaProductos.addRow(datosProductos);
    }
    
    private void limpiarListaProductos(){
        modeloListaProductos.clear();
    }
    
    private void cargarListenerModeloTabla(){
    
        modeloTablaProductos.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e){
                int numFilas = modeloTablaProductos.getRowCount();
                double sumatoria = 0.0;
                for (int i = 0; i < numFilas; i++) {
                    String importe = (String)modeloTablaProductos.getValueAt(i, 4);
                    sumatoria += Double.parseDouble(importe);
                }
                lblSumatoria.setText(String.valueOf(sumatoria));
            }
        });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCorteDia;
    private javax.swing.JButton btnQuitarProd;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JTextField campoBuscarProd;
    private javax.swing.JTextField campoPagaCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenProd;
    private javax.swing.JLabel lblSumatoria;
    private javax.swing.JList<Producto> listaProductos;
    private javax.swing.JTable tablaVenta;
    // End of variables declaration//GEN-END:variables
}
