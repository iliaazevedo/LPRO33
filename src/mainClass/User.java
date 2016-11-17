/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainClass;
import database.*;

/**
 *
 * @author ilia&magno
 */
public class User {
    
    private String name;
    private String email;
    private String username;
    private String password;
    private Integer question;
    private String anwser;
    public static UserDB userData;
    
    public User (String name, String email, String username, String password, Integer question, String anwser) throws Exception{
        this.name=name;
        this.email=email;
        this.username= username;
        this.password=password;
        this.question=question;
        this.anwser=anwser;
    }
    
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getUsername(){
        return username;
    }
     
    public Integer getQuestion(){
        return question;
    }
      
    public String getAnwser(){
        return anwser;
    }
    
   
    
    public static boolean confirmUsername(String received) throws Exception{
        System.out.println("USER.JAVA "+received);
        userData=new UserDB(received);
        //Chamar a parte do DB >> verificar se encontrou uma lista através daquele username
        return received.equals(userData.getUsername());                //SAME AS WHAT FOLLOWS
    }
    
    public static boolean confirmPassword(String received){
        //Chamar a parte do DB >> verificar a palavra passe retornada com aquela recebida
        return received.equals(userData.getPassword());              //CRIAR O GETPASSWORD NO USERDB PARA RETORNAR A PALAVRA PASSE
    }
}
