package com.lian.sistemas.pojos;

/**
 *
 * @author neri_laredo
 */
public class Categoria {

    private int idCategoriaProducto;
    private String nombreCategoriaProducto;
    private String descripcionCategoriaProducto;

    public Categoria(int idCategoriaProducto, String nombreCategoriaProducto, String descripcionCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.descripcionCategoriaProducto = descripcionCategoriaProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public String getDescripcionCategoriaProducto() {
        return descripcionCategoriaProducto;
    }

    public void setDescripcionCategoriaProducto(String descripcionCategoriaProducto) {
        this.descripcionCategoriaProducto = descripcionCategoriaProducto;
    }

    @Override
    public String toString(){
        return this.nombreCategoriaProducto;
    }
}
