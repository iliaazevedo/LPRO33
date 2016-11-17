/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import mainClass.*;
import java.io.IOException;

/**
 *
 * @author ilia&magno
 */
public class ServerProtocol extends Thread{
    
   //private final SocketServer server;
   
   /*public ServerProtocol(){
       server = new SocketServer();
   }*/
   
   
   public String[] getLogin(String server) throws IOException, Exception {                  // DONE FOR NOW // CREATE PLAYER CLASS
       String[] UsernameEPass = new String[2];
       //String serverReceived = server.received();
       String[] stringUis;
       stringUis = server.split("&");
       int state = 0;
       for(String Ui : stringUis){
           
           
           System.out.println(Ui);
           if(state==0){
               if(Ui.equals("Login")){
                   state=1;
                   
               }else{
               System.out.println("LOGIN FAILED");
               return new String[] {"FailedConnection","LOGIN_FAILED"};
               
               }
           }
           else if(state==1){
               if(User.confirmUsername(Ui)){              //CRIAR NA CLASSE PLAYER O METODO CONFIRMUSERNAME
                   UsernameEPass[0] = Ui;
                   System.out.println("Protocol_Username: " + Ui);
                   state=2;
                  
               }else{
               System.out.println("USERNAME NOT FOUND: "+ Ui);      //VERIFICAR ISTO
               return new String[] {"FailedConnection","USERNAME_FAILED"};
               
               }
           }
           
           else if(state==2){
              if(User.confirmPassword(Ui)){               //SAME AS ABOVE
                  UsernameEPass[1] = Ui;
                  System.out.println("Protocol_EncryptedPassword: "+ Ui);
                  //System.out.println(Arrays.toString(UsernameEPass));
                  
                  System.out.println("LOGIN SUCCESFULL");
                  return UsernameEPass;
              }
               System.out.println("WRONG PASSWORD");
              return new String[] {"FailedConnection","PASSWORD_FAILED"};
           }
       }
    return new String[] {"0X7E", "debee"};
   }
}
