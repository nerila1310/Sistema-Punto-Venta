package com.lian.sistemas.pojos;

/**
 *
 * @author neri_laredo
 */
public class Proveedores {
    
    private int idProveedor;
    private String nombreProveedor;
    private String direccionProvedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private String contactoProveedor;

    public Proveedores(int idProveedor, String nombreProveedor, String direccionProvedor, String telefonoProveedor, String emailProveedor, String contactoProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProvedor = direccionProvedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProvedor() {
        return direccionProvedor;
    }

    public void setDireccionProvedor(String direccionProvedor) {
        this.direccionProvedor = direccionProvedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    @Override
    public String toString(){
    return this.nombreProveedor;
    }
    
}
