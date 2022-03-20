/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Vendedor extends Usuario {
    
    private int cantidadProductos;
    private int numeroVenta;

   
    public Vendedor(int cantidadProductos, int numeroVenta, String nombre, String direccion, int nit) {
        super(nombre, direccion, nit);
        this.cantidadProductos = cantidadProductos;
        this.numeroVenta = numeroVenta;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }
    
    public void totalVenta(){
    
    
    }
    
   public void comision(){
   
   
   }
    
}
