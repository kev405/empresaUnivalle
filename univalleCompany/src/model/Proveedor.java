/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Proveedor extends Usuario {
    
    private String nombreInsumo;
    private int cantidadInsumo;

    public Proveedor(String nombreInsumo, int cantidadInsumo, String nombre, String direccion, int id) {
        super(nombre, direccion, id);
        this.nombreInsumo = nombreInsumo;
        this.cantidadInsumo = cantidadInsumo;
    }

   

    public Proveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }
    
    
    
}
