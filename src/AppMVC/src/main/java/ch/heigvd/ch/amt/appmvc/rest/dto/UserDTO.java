/** 
 * Document           : UserDTO.java
 * Created on         : Oct 17, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This class represent our DTO. 
 *                      So this is a class representing users.
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.rest.dto;

public class UserDTO {
    
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String familyName;

    public UserDTO() {};
    
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
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
}
