package com.lian.sistemas.pojos;

/**
 *
 * @author neri_laredo
 */
public class detalleVenta {

    private Long idVenta;
    private String idProducto;
    private double cantidadVendida;

    public detalleVenta( Long idVenta, String idProducto, double cantidadVendida) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadVendida = cantidadVendida;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
