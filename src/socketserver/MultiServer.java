/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author ricar
 */
public class MultiServer {
    public void openSocket() throws IOException {
      ServerSocket serverSocket = null;
      boolean listening = true;
 
      try {
         serverSocket = new ServerSocket(1633);
         System.out.println("Waiting on 1633.");
      } catch (IOException e) {
         System.err.println("Could not listen on port: 1633.");
         System.exit(-1);
      }
 
      while (listening)
	 new MultiServerThread(serverSocket.accept()).start();
 
      serverSocket.close();
   }
}
