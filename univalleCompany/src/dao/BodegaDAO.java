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
import model.Bodega;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class BodegaDAO {
 
    public BodegaDAO() {
    }
    
    
    /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int grabarBodega(Bodega bod){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO bodega values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, bod.getIdProducto_Bod());
            pstm.setString(2, bod.getNombreProdc());
            pstm.setDouble(3,bod.getPrecio());
            pstm.setInt(4, bod.getCantidadProduc());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
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
    public int modificarBodega(Bodega bod){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE Bodega " +
                         "SET NombreProducto_Bod = ?, Precio_Bod = ?, "
                    + "cantidad = ? "
                    +    "WHERE idProducto_Bod=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, bod.getIdProducto_Bod());
            pstm.setString(2, bod.getNombreProdc());
            pstm.setDouble(3,bod.getPrecio());
            pstm.setInt(4, bod.getCantidadProduc());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
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
    public int borrarBodega(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM Bodega WHERE idProducto_Bod = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
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
    public ArrayList<Bodega> listadoBodega(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Bodega> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM Bodega ORDER BY idProducto_Bod";            
            }else{
                sql = "SELECT * FROM Bodega where idProducto_Bod = ? "
                    + "ORDER BY idProducto_Bod";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Bodega bodega = null;
            while(rs.next()){
                bodega = new Bodega();
                bodega.setIdProducto_Bod(rs.getInt("idProducto_Bod"));
                bodega.setNombreProdc(rs.getString("NombreProducto_Bod"));
                bodega.setPrecio(rs.getDouble("Precio_Bod"));
                bodega.setCantidadProduc(rs.getInt("cantidad")); 
                listado.add(bodega);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Bod : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    
    
    
}
