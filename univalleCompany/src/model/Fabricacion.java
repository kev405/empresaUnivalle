/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mavel
 */
public class Fabricacion {
        private  int idProducto_Fab;
    private String materiaPrima;
    private String nombreProductos;

    public Fabricacion(String nombreInsumos, String materiaPrima, int idProducto_Fab) {
        this.materiaPrima = nombreInsumos;
        this.nombreProductos = nombreProductos;
        this.idProducto_Fab = idProducto_Fab;
    }

    public Fabricacion() {
    }
    

    public String getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(String materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public int getIdProducto_Fab() {
        return idProducto_Fab;
    }

    public void setIdProducto_Fab(int idProducto_Fab) {
        this.idProducto_Fab = idProducto_Fab;
    }
    
    
    
}
