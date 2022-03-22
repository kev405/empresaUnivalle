/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Bodega {
    
    private int idProducto_Bod;
    private String nombreProdc;
    private double precio;
    private int cantidadProduc;

    public Bodega() {
    }

    public Bodega(int idProducto_Bod, String nombreProdc, double precio, int cantidadProduc) {
        this.idProducto_Bod = idProducto_Bod;
        this.nombreProdc = nombreProdc;
        this.precio = precio;
        this.cantidadProduc = cantidadProduc;
    }

    public int getIdProducto_Bod() {
        return idProducto_Bod;
    }

    public void setIdProducto_Bod(int idProducto_Bod) {
        this.idProducto_Bod = idProducto_Bod;
    }

 

    public String getNombreProdc() {
        return nombreProdc;
    }

    public void setNombreProdc(String nombreProdc) {
        this.nombreProdc = nombreProdc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadProduc() {
        return cantidadProduc;
    }

    public void setCantidadProduc(int cantidadProduc) {
        this.cantidadProduc = cantidadProduc;
    }
    
    public void valorTotalProdcutos(){

}
    
}
