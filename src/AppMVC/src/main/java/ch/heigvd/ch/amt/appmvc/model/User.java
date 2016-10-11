/** 
 * Document           : User.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.model;

/**
 *
 * @author J. Ayoub & M-H. Aghamahdi
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
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isEqual (User user) { 
        return (this.username.equals(user.username) ) && (this.password.equals(user.password) ); 
    } 
}