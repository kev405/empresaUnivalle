/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresaunivalle;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mavel
 */
public class Conexion {
    //String de conexion
        
        //url: programa:// conexion local: puerto / nombre de la base de datos en postgres
        String dbUrl = "jdbc:postgresql://localhost:5432/EmpresaUnivalle"; 
        String user = "postgres"; //Usuario
        String pass = "---";//contraseña
        
         Statement stmt = null;
        Connection con = null; // establecer una conexion
        
}
