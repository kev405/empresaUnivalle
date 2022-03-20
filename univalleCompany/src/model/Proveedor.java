/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresaunivalle;

/**
 *
 * @author mavel
 */
public class Proveedor extends Usuario {
    
    private String nombreInsumo;
    private int cantidadInsumo;

    public Proveedor(String nombreInsumo, int cantidadInsumo, String nombre, String direccion, int nit) {
        super(nombre, direccion, nit);
        this.nombreInsumo = nombreInsumo;
        this.cantidadInsumo = cantidadInsumo;
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