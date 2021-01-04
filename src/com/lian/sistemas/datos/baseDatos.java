package com.lian.sistemas.datos;

import com.lian.sistemas.pojos.Categoria;
import com.lian.sistemas.pojos.Producto;
import com.lian.sistemas.pojos.Proveedores;
import com.lian.sistemas.pojos.Ventas;
import com.lian.sistemas.pojos.detalleVenta;
import java.io.File;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neri_laredo
 */
public class baseDatos {

    Connection conn = null;
    Statement statement = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    
    public baseDatos(){
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void insertarProducto(Producto producto){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
            FileInputStream fis = new FileInputStream(producto.getFotoProducto());
            
            String sql = "INSERT INTO cat_productos (id_prod, nombre_prod, desc_prod, stock_prod, foto_prod,"
                    + " unidad_prod, precio_compra_prod, precio_venta_prod, existencia_prod, id_categoria_prod, id_proveedor) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
            st = conn.prepareStatement(sql);
            
            st.setString(1, producto.getIdProducto());
            st.setString(2, producto.getNomProducto());
            st.setString(3, producto.getDescProducto());
            st.setDouble(4, producto.getStockProducto());
            st.setBinaryStream(5, fis, (int)producto.getFotoProducto().length());
            st.setString(6, producto.getUnidadProducto());
            st.setDouble(7, producto.getPrecioCompraProducto());
            st.setDouble(8, producto.getPrecioVentaProducto());
            st.setDouble(9, producto.getExistenciaProducto());
            st.setInt(10, producto.getIdCategoria());
            st.setInt(11, producto.getIdProveedor());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(baseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void actualizarProducto(Producto producto, boolean cambiarFoto){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            if (cambiarFoto == true) {
                File fileFoto = producto.getFotoProducto();
                FileInputStream fis = new FileInputStream(fileFoto);
            
                String sql = "UPDATE cat_productos SET desc_prod=?, stock_prod=?, foto_prod=?, unidad_prod=?, "
                        + "precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=?, existencia_prod=? "
                        + "WHERE id_prod=?";
                
                st = conn.prepareStatement(sql);
                
                st.setString(1, producto.getDescProducto());
                st.setDouble(2, producto.getStockProducto());
                long tamanoFoto = fileFoto.length();
                st.setBinaryStream(3, fis, tamanoFoto);
                st.setString(4, producto.getUnidadProducto());
                st.setDouble(5, producto.getPrecioCompraProducto());
                st.setDouble(6, producto.getPrecioVentaProducto());
                st.setInt(7, producto.getIdCategoria());
                st.setInt(8, producto.getIdProveedor());
                st.setDouble(9, producto.getExistenciaProducto());
                st.setString(10, producto.getIdProducto());
                
            } else {
                String sql = "UPDATE cat_productos SET desc_prod=?, stock_prod=?,  unidad_prod=?, "
                        + "precio_compra_prod=?, precio_venta_prod=?, id_categoria_prod=?, id_proveedor=? "
                        + "WHERE id_prod=?";
                
                st = conn.prepareStatement(sql);
                
                st.setString(1, producto.getDescProducto());
                st.setDouble(2, producto.getStockProducto());
                st.setString(3, producto.getUnidadProducto());
                st.setDouble(4, producto.getPrecioCompraProducto());
                st.setDouble(5, producto.getPrecioVentaProducto());
                st.setInt(6, producto.getIdCategoria());
                st.setInt(7, producto.getIdProveedor());
                st.setString(8, producto.getIdProducto());
            }
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void actualizarInventario(Producto producto, double cantidad){
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "UPDATE cat_productos SET existencia_prod = ? WHERE id_prod = ?";
            
            st = conn.prepareStatement(sql);
            
            st.setDouble(1, cantidad);
            st.setString(2, producto.getIdProducto());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarCategoria(Categoria categoria){
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "INSERT INTO cat_categorias (nom_categoria_prod, desc_categoria_prod) "
                    + "VALUES (?, ?)";

            st = conn.prepareStatement(sql);
            
            st.setString(1, categoria.getNombreCategoriaProducto());
            st.setString(2, categoria.getDescripcionCategoriaProducto());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarProveedor(Proveedores proveedor){
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "INSERT INTO cat_proveedores (nombre_proveedor, dir_proveedor, telefono_proveedor, email_proveedor, contacto_proveedor) "
                    + "VALUES (?, ?, ?, ?, ?)";

            st = conn.prepareStatement(sql);
            
            st.setString(1, proveedor.getNombreProveedor());
            st.setString(2, proveedor.getDireccionProvedor());
            st.setString(3, proveedor.getTelefonoProveedor());
            st.setString(4, proveedor.getEmailProveedor());
            st.setString(5, proveedor.getContactoProveedor());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarVenta(Ventas venta){
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "INSERT INTO ventas (monto_venta, fecha_venta) "
                    + "VALUES (?, ?)";

            st = conn.prepareStatement(sql);
            
            st.setDouble(1, venta.getMontoVenta());
            st.setDate(2, venta.getFechaVenta());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarDetalleVenta(detalleVenta detalle){
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad_vendida) "
                    + "VALUES (?, ?, ?)";

            st = conn.prepareStatement(sql);
            
            st.setInt(1, detalle.getIdDetalleVenta() );
            st.setString(2, detalle.getIdProducto());
            st.setDouble(3, detalle.getCantidadVendida());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<Producto> obtenerProducto(){
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM cat_productos ORDER BY nombre_prod";

            st = conn.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                
                String id = rs.getString("id_prod");
                String nombre = rs.getString("nombre_prod");
                String descripcion = rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                //File fotoProducto;
                String unidad = rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencia = rs.getDouble("existencia_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");
                
                Producto producto = new Producto(id, nombre, descripcion, stock, null ,unidad, precioCompra, 
                                                 precioVenta, existencia, idCategoria, idProveedor);
            
                listaProductos.add(producto);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProductos;
    }
    
    public ArrayList<Producto> obtenerProductoPorCriterio(String criterio){
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM cat_productos"
                    + " WHERE id_prod LIKE '%"+criterio+"%'"
                    + " OR nombre_prod LIKE '%"+criterio+"%'"
                    + " ORDER BY nombre_prod";

            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {                
                
                String id = rs.getString("id_prod");
                String nombre = rs.getString("nombre_prod");
                String descripcion = rs.getString("desc_prod");
                double stock = rs.getDouble("stock_prod");
                //File fotoProducto;
                String unidad = rs.getString("unidad_prod");
                double precioCompra = rs.getDouble("precio_compra_prod");
                double precioVenta = rs.getDouble("precio_venta_prod");
                double existencia = rs.getDouble("existencia_prod");
                int idCategoria = rs.getInt("id_categoria_prod");
                int idProveedor = rs.getInt("id_proveedor");
                
                Producto producto = new Producto(id, nombre, descripcion, stock, null ,unidad, precioCompra, 
                                                 precioVenta, existencia, idCategoria, idProveedor);
            
                listaProductos.add(producto);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProductos;
    }
    
    public ArrayList<Categoria> obtenerCategoria(){
        
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM cat_categorias";

            st = conn.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                
                int id = rs.getInt("id_categoria_prod");
                String nombre = rs.getString("nom_categoria_prod");
                String descripcion = rs.getString("desc_categoria_prod");
                
                Categoria categoria = new Categoria(id, nombre, descripcion);
            
                listaCategoria.add(categoria);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaCategoria;
    }
    
    public ArrayList<Proveedores> obtenerProveedor(){
        
        ArrayList<Proveedores> listaProveedores = new ArrayList<Proveedores>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM cat_proveedores";

            st = conn.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String direccion = rs.getString("dir_proveedor");
                String telefono = rs.getString("telefono_proveedor");
                String email = rs.getString("email_proveedor");
                String contacto = rs.getString("contacto_proveedor");
                
                Proveedores proveedor = new Proveedores(id, nombre, direccion, telefono, email, contacto);
            
                listaProveedores.add(proveedor);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaProveedores;
    }
    
    public ArrayList<Ventas> obtenerVentas(){
        
        ArrayList<Ventas> listaVentas = new ArrayList<Ventas>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM ventas";

            st = conn.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                
                int id = rs.getInt("id_venta");
                double monto = rs.getDouble("monto_venta");
                Date fecha = rs.getDate("fecha_venta");
                
                Ventas venta = new Ventas(id, monto, fecha);
            
                listaVentas.add(venta);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaVentas;
    }
    
    public ArrayList<detalleVenta> obtenerdetalleVentas(){
        
        ArrayList<detalleVenta> listadetalleVenta = new ArrayList<detalleVenta>();
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT * FROM detalle_venta";

            st = conn.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                
                int idDetalleVenta = rs.getInt("id_detalle_venta");
                int idVenta = rs.getInt("id_venta");
                String producto = rs.getString("id_prod");
                double cantidadVendida = rs.getDouble("cantidad_vendida");
                
                detalleVenta detalleVenta = new detalleVenta(idDetalleVenta, idVenta, producto, cantidadVendida);
            
                listadetalleVenta.add(detalleVenta);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listadetalleVenta;
    }
    
    public void borrarProducto(Producto producto){
    
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "DELETE FROM cat_productos WHERE id_prod = ?";

            st = conn.prepareStatement(sql);
            
            st.setString(1, producto.getIdProducto());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public InputStream buscarFoto(Producto producto){
        InputStream streamFoto = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/db-sistema", "postgres", "123");
        
            String sql = "SELECT foto_prod FROM cat_productos WHERE id_prod = ?";

            st = conn.prepareStatement(sql);
            st.setString(1, producto.getIdProducto());
            
            rs = st.executeQuery();
            
            while (rs.next()) {                
                streamFoto = rs.getBinaryStream("foto_prod");
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return streamFoto;
    }
    
}