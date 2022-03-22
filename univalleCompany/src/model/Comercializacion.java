/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Comercializacion {
    
    private int idCliente_Com;
    private String nombreProductos_Com;
    private double precio_Com;
    private String vendedor;
    private int cantidad_Com;
    private int numeroFactura;
    private String direccionVenta;

    public Comercializacion(int idCliente_Com, String nombreProductos_Com, double precio_Com,
            String vendedor, int cantidad_Com, int numeroFactura, String direccionVenta) {
        this.idCliente_Com = idCliente_Com;
        this.nombreProductos_Com = nombreProductos_Com;
        this.precio_Com = precio_Com;
        this.vendedor = vendedor;
        this.cantidad_Com = cantidad_Com;
        this.numeroFactura = numeroFactura;
        this.direccionVenta = direccionVenta;
    }

    public Comercializacion() {
    }
    
    

    public int getIdCliente_Com() {
        return idCliente_Com;
    }

    public void setIdCliente_Com(int idCliente_Com) {
        this.idCliente_Com = idCliente_Com;
    }

    public String getNombreProductos_Com() {
        return nombreProductos_Com;
    }

    public void setNombreProductos_Com(String nombreProductos_Com) {
        this.nombreProductos_Com = nombreProductos_Com;
    }

    public double getPrecio_Com() {
        return precio_Com;
    }

    public void setPrecio_Com(double precio_Com) {
        this.precio_Com = precio_Com;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getCantidad_Com() {
        return cantidad_Com;
    }

    public void setCantidad_Com(int cantidad_Comd) {
        this.cantidad_Com = cantidad_Com;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDireccionVenta() {
        return direccionVenta;
    }

    public void setDireccionVenta(String direccionVenta) {
        this.direccionVenta = direccionVenta;
    }
    
    
    
    
}
