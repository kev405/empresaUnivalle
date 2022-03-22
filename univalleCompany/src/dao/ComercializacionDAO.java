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
import model.Comercializacion;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class ComercializacionDAO {
    
     public ComercializacionDAO() {
    }
    
     /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grabar
     */
    public int grabarComercializacion(Comercializacion comerc){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO Comercializacion values (?,?,?,?,?,?, ?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, comerc.getIdCliente_Com());
            pstm.setString(2, comerc.getNombreProductos_Com());
            pstm.setDouble(3,comerc.getPrecio_Com());
            pstm.setString(4, comerc.getNombreProductos_Com());
            pstm.setString(5, comerc.getVendedor());
            pstm.setInt(6, comerc.getCantidad_Com());
            pstm.setString(7, comerc.getDireccionVenta());


            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
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
    public int modificarComercializacion(Comercializacion comerc){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE Comercializacion " +
                         "SET nombreProductos_Com = ?, precio_Com = ?, "
                    + "vendedor = ?, cantidad_Com= ?, numeroFactura = ?,  "
                    +    "WHERE idCliente_Com=?";
            pstm = con.prepareStatement(sql);            
             pstm.setInt(1, comerc.getIdCliente_Com());
            pstm.setString(2, comerc.getNombreProductos_Com());
            pstm.setDouble(3,comerc.getPrecio_Com());
            pstm.setString(4, comerc.getNombreProductos_Com());
            pstm.setString(5, comerc.getVendedor());
            pstm.setInt(6, comerc.getCantidad_Com());
            pstm.setString(7, comerc.getDireccionVenta());

            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
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
    public int borrarComercializacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM Comercializacion WHERE idCliente_Com = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
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
    public ArrayList<Comercializacion> listadoComercializacion(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Comercializacion> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM Comercializacion ORDER BY idCliente_Com";            
            }else{
                sql = "SELECT * FROM Comercializacion where idCliente_Com = ? "
                    + "ORDER BY idCliente_Com";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            Comercializacion comercializacion = null;
            while(rs.next()){
                comercializacion = new Comercializacion();
                comercializacion.setIdCliente_Com(rs.getInt("idCliente_Com"));
                comercializacion.setNombreProductos_Com(rs.getString("Producto_Com"));
                comercializacion.setPrecio_Com(rs.getDouble("Precio_Com"));
                comercializacion.setNumeroFactura(rs.getInt("NumeroFactura"));
                comercializacion.setVendedor(rs.getString("Vendedor"));
                comercializacion.setCantidad_Com(rs.getInt("Cantidad_Com")); 
                comercializacion.setDireccionVenta(rs.getString("DireccionVenta"));

                listado.add(comercializacion);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"idCliente_Com : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }

     
     
}
