/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainClass.*;

/**
 *
 * @author ricar
 */
public class MultiServerThread extends Thread{
   private Socket socket = null;
   
    PrintWriter out = null;
     BufferedReader in = null;
    
    
   public MultiServerThread(Socket socket){
      super("MultiServerThread");
      this.socket = socket;
   }
   String[] uno = new String[2];
   @Override
   public void run() {
      try {
         out = new PrintWriter(socket.getOutputStream(), true);
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
         String inputLine, outputLine;
         ServerProtocol kappakappakappa = new ServerProtocol();
     
        if ((inputLine = in.readLine()) != null){
            uno = kappakappakappa.getLogin(inputLine);
        }    
          System.out.println(uno[0]);
       
            outputLine="Login&OK&"+uno[0];
            
            if(uno[0].equals("FailedConnection")){
                if(!User.confirmUsername(uno[0]))   outputLine = "Login&Erro&Username";  
                 if(!User.confirmPassword(uno[1]))   outputLine = "Login&Erro&Password";
            }
                            
            out.println(outputLine);
        
        
        
       
 
      } catch (IOException e) {
      System.err.println(e.getMessage());} catch (Exception ex) {
           Logger.getLogger(MultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void close() throws IOException{
         out.close();
         in.close();
           socket.close();
   }
}
