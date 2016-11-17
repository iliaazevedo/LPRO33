/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClass;

import java.io.IOException;
import socketserver.MultiServer;

/**
 *
 * @author ricar
 */
public class mainServer {
    public static void main(String[] args) throws IOException{
        System.out.println("SERVER INITIALIZED");
        MultiServer socket = new MultiServer();
        socket.openSocket();
        
    }
}
