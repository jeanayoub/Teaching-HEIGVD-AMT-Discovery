/** 
 * Document           : User.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : A class to represent the user form.  
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.model;

/**
 * This class give a model to the user type.
 * A user has a unique ID that once set can't be changed. While all the other
 * parameters can be modified.
 * 
 * @author J. Ayoub & M-H. Aghamahdi
 */
public class User {
    
    private final String username; // Unique Identifier for a user
    private       String password   = null; // Secrect word needed to login
    private       String email      = null; // Email address of the user
    private       String firstName  = null; // User's first name
    private       String familyName = null; // User's family name
    
    /**
     * Constructor with the minimum of necessary parameters.
     * 
     * @param username the identification of the user
     * @param password the secret word associated with the username
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor with all the parameters.
     * 
     * @param username username of user
     * @param password password of user
     * @param email email of user
     * @param firstName first name of user
     * @param familyName last name of user
     */
    public User(String username, String password, String email, String firstName, String familyName) {
        this.username   = username;
        this.password   = password;
        this.email      = email;
        this.firstName  = firstName;
        this.familyName = familyName;
    }

    /**
     * 
     * @return username 
     */
    public String getUsername() {
        return username;
    }


    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * 
     * @return email address 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @return first name 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return family name 
     */
    public String getFamilyName() {
        return familyName;
    }
   
    
    /**
     * Sets the password.
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Sets the email address.
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the first name.
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the family name.
     * 
     * @param familyName 
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
    
    /**
     * This method checks if the input fields are correct between two users.
     * 
     * In our case it's the username and the password.
     * @param user to be compared.
     * @return 
     */
    public boolean isEqual (User user) { 
        return (this.username.equals(user.username) ) && (this.password.equals(user.password) ); 
    } 
}