/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author D4K4R
 */
public class ModeloChatServidor {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public javax.swing.JTextArea msg_area;
    public javax.swing.JTextField msg_text;


    public ModeloChatServidor(javax.swing.JTextArea msg_area, javax.swing.JTextField msg_text) {
        
        this.msg_area = msg_area;
        this.msg_text = msg_text;

    }
    
    //sobrecarga
    public ModeloChatServidor(){
    
    }

    public void accion() {
    

        String msgin = "";
        try {
            
            //dirigir conexion a el puerto 1201
            ss = new ServerSocket(1201);
            //aceptar la conxion
  
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Servidor Conectado ");

            
            

            while (!msgin.equals("exit")) {
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim() + "\nCliente: " + msgin);

            }
            
            

        } catch (Exception e) {
            System.out.print(e);
        }

    }
    
    
    
    
    public void msg_sendActionPerformed(){   
        System.out.print("se envio");
        
         try{
                //obtener el texto de el campo de texto y enviarlo
                String msgout = "";
                msgout = msg_text.getText().trim();
                dout.writeUTF(msgout);
                
            }catch(Exception i){
                System.out.print("estoy en el boton servidor");
            }

    }        

}

