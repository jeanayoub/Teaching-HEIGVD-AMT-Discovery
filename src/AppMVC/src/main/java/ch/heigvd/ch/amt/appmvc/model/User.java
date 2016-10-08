/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.ch.amt.appmvc.model;

/**
 *
 * @author Ayoubo
 */
public class User {
    
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
   
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPasswors(String password) {
        this.password = password;
    }
    
    public boolean isEqual (User user) { 
        return (this.username.equals(user.username) ) && (this.password.equals(user.password) ); 
    }
    
}