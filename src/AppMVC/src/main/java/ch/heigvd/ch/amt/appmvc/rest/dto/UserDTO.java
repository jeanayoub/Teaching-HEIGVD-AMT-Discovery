/** 
 * Document           : UserDTO.java
 * Created on         : Oct 17, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : A class representing the DTO format for users. 
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.rest.dto;

/**
 * This class implements all the needs to have a DTO user form.
 * 
 * @author J. Ayoub & M-H. Aghamahdi
 */
public class UserDTO {
    
    private String username; // Unique Identifier for a user
    private String password; // Secrect word needed to login
    private String email; // Email address of the user
    private String firstName; // User's first name
    private String familyName; // User's family name
    
    /**
     * Empty constructor
     */
    public UserDTO() {}
    
    /**
     * 
     * @param username
     * @param password 
     */
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
     * @return firstNAme user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return 
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *  Sets the password.
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Sets the email address.
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *  Sets the user's first name.
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *  Sets the user's family name.
     * 
     * @param familyName 
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
