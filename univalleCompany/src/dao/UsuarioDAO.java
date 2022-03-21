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
import model.Usuario;
import servicios.Fachada;

/**
 *
 * @author mavel
 */
public class UsuarioDAO {
    
    public UsuarioDAO() {
    }
    
    /**
     * 
     * @param p Objeto de la clase Programa a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarPrograma(Usuario us){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO programa values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, us.getNombre());
            pstm.setString(2, us.getDireccion());
            pstm.setInt(3,us.getNit());
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
    public int modificarPrograma(Usuario us){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE usuario " +
                         "SET nombre = ?, direccion = ? "
                    +    "WHERE Nit=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, us.getNombre());
            pstm.setString(2, us.getDireccion());
            pstm.setInt(3,us.getNit());
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
            String sql = "DELETE FROM Usuario WHERE Nit = ? ";
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
    public ArrayList<Usuario> listadoProgramas(String Nit){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Usuario> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(Nit.equalsIgnoreCase("0")){
                sql = "SELECT * FROM programa ORDER BY codigo";            
            }else{
                sql = "SELECT * FROM programa where codigo = ? "
                    + "ORDER BY codigo";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(Nit != "0"){
                pstm.setString(1, Nit);
            }
            
            rs = pstm.executeQuery();
                        
            Usuario usuario = null;
            while(rs.next()){
                usuario = new Usuario();
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setNit(rs.getInt("Nit"));
                listado.add(usuario);
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
