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
import model.Fabricacion;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class FabricacionDAO {
     public FabricacionDAO() {
    }
    
     
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int grabarFabricacion(Fabricacion fabri){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO Fabricacion values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, fabri.getIdProducto_Fab());
            pstm.setString(2, fabri.getNombreProductos());
            pstm.setString(3, fabri.getMateriaPrima());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
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
    public int modificarFabricacion(Fabricacion fabri){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE Fabricacion " +
                         "SET nombreProductos = ?, "
                    + "materiaPrima = ? "
                    +    "WHERE idProducto_Fab=?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, fabri.getIdProducto_Fab());
            pstm.setString(2, fabri.getNombreProductos());
            pstm.setString(3, fabri.getMateriaPrima());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
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
    public int borrarFabricacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM Fabricacion WHERE idProducto_Fab = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idProducto_Fab : " + 
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
    public ArrayList<Fabricacion> listadoFabricacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Fabricacion> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM Fabricacion ORDER BY idProducto_Fab";            
            }else{
                sql = "SELECT * FROM Fabricacion where idProducto_Fab = ? "
                    + "ORDER BY idProducto_Fab";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Fabricacion fabricacion = null;
            while(rs.next()){
                fabricacion = new Fabricacion();
                fabricacion.setIdProducto_Fab(rs.getInt("idProducto_Fab"));
                fabricacion.setNombreProductos(rs.getString("nombreProductos"));
                fabricacion.setMateriaPrima(rs.getString("materiaPrima"));
                listado.add(fabricacion);
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
