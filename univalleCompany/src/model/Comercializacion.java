/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresaunivalle;

/**
 *
 * @author mavel
 */
public class Comercializacion {
    
    private int idCliente;
    private String nombreProductos;
    private double precio;
    private String vendedor;
    private int cantidad;
    private int numeroFactura;
    private String direccion;

    public Comercializacion(int idCliente, String nombreProductos, double precio, String vendedor, int cantidad, int numeroFactura, String direccion) {
        this.idCliente = idCliente;
        this.nombreProductos = nombreProductos;
        this.precio = precio;
        this.vendedor = vendedor;
        this.cantidad = cantidad;
        this.numeroFactura = numeroFactura;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
}
