/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Proveedor;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class ProveedorDAO {
    
      public ProveedorDAO() {
    }
    
        /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarPrograma(Proveedor prov){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO proveedor values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, prov.getNombre());
            pstm.setString(2, prov.getDireccion());
            pstm.setInt(3,prov.getNit());
            pstm.setString(4, prov.getNombreInsumo());
            pstm.setInt(5, prov.getCantidadInsumo());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarPrograma(Proveedor prov){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE proveedor " +
                         "SET nombre = ?, direccion = ?,"
                    + " nombre_Insumo = ?, cantidad_Insumo = ? "
                    +    "WHERE Nit=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, prov.getNombre());
            pstm.setString(2, prov.getDireccion());
            pstm.setInt(3,prov.getNit());
            pstm.setString(4, prov.getNombreInsumo());
            pstm.setInt(5, prov.getCantidadInsumo());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param codigo código del programa a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarPrograma(String Nit){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM proveedor WHERE Nit = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Nit);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    /**
     * 
     * @param codigo codigo del programa a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Programa
     */
    public ArrayList<Proveedor> listadoProgramas(String Nit){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Proveedor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(Nit.equalsIgnoreCase("0")){
                sql = "SELECT * FROM proveedor ORDER BY Nit";            
            }else{
                sql = "SELECT * FROM proveedor where Nit = ? "
                    + "ORDER BY Nit";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(Nit != "0"){
                pstm.setString(1, Nit);
            }
            
            rs = pstm.executeQuery();
                        
            Proveedor proveedor = null;
            while(rs.next()){
                proveedor = new Proveedor();
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setNit(rs.getInt("Nit"));
                proveedor.setNombreInsumo("Nombre insumo");
                listado.add(proveedor);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Nit : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
      
}
