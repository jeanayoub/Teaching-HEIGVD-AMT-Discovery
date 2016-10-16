/** 
 * Document           : UserManager.java
 * Created on         : Oct 16, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.services;

import ch.heigvd.ch.amt.appmvc.model.User;
import javax.ejb.Local;

/**
 *
 * @author J. Ayoub & M-H. Aghamahdi
 */
@Local
public interface IUserManager {
    
    void    addUser    (User   user);
    void    deleteUser (User   user);
    void    modifyUser (User   user);
    boolean userExists (String username);
    boolean verifyUser (User   user);  
}
