/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresaunivalle;

/**
 *
 * @author mavel
 */
public class Fabricacion {
    
    private String nombreInsumos;
    private String nombreProductos;
    private  int idInsumos;

    public Fabricacion(String nombreInsumos, String nombreProductos, int idInsumos) {
        this.nombreInsumos = nombreInsumos;
        this.nombreProductos = nombreProductos;
        this.idInsumos = idInsumos;
    }

    public String getNombreInsumos() {
        return nombreInsumos;
    }

    public void setNombreInsumos(String nombreInsumos) {
        this.nombreInsumos = nombreInsumos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public int getIdInsumos() {
        return idInsumos;
    }

    public void setIdInsumos(int idInsumos) {
        this.idInsumos = idInsumos;
    }
    
    
    
}
