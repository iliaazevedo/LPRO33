/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public final class UserDB extends PostgreSQLink{

    private final String username;
    private String password;
    private String email;
    private Integer question;
    private String answer;
    private static boolean ack=false;
    
    public UserDB(String username) throws Exception  {
        this.username = username;
        this.getLine();
        this.password = password;
    }
    
    public void getLine(){
        PostgreSQLink.connect();
        //System.out.println("here");
        try {
            Statement statement = getConnection().createStatement();

                ResultSet results = statement.executeQuery("SELECT password FROM signuplpro WHERE username = '"+this.username+"';");
            
            if (results.next()){
                
           this.password =results.getString("password");
            }
            
        } catch (Exception ex) {
            System.err.println("error!" + ex.getMessage());
        }
    }
    
    
    public String getUsername(){
        if(ack=true) return "error!";
        return username;
    }
    
    public String getPassword(){
        System.out.println("pass!!" + password);
        return password;
    }
}
