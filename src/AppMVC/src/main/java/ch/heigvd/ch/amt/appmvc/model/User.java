/** 
 * Document           : User.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This class represent our model. 
 *                      So This is a class representing users.
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.model;

public class User {
    
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String familyName;
    

    /**
     * constructor of class
     * @param username username of user
     * @param password password of user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * constructor of class
     * @param username username of user
     * @param password password of user
     * @param email email of user
     * @param firstName first name of user
     * @param familyName last name of user
     */
    public User(String username, String password, String email, String firstName, String familyName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }
   
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
    
    /**
     * This method checks if the input fields are correct. (username and password)
     * @param user
     * @return 
     */
    public boolean isEqual (User user) { 
        return (this.username.equals(user.username) ) && (this.password.equals(user.password) ); 
    } 
}