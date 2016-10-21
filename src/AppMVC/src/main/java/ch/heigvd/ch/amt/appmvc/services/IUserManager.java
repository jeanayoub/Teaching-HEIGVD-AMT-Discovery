/** 
 * Document           : IUserManager.java
 * Created on         : Oct 16, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : Interface that defined the mandatory methods to manage user
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.services;

import ch.heigvd.ch.amt.appmvc.model.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IUserManager {
    
    void       addUser      (User   user);
    int        deleteUser   (String   username);
    void       modifyUser   (User   user);
    boolean    userExists   (String username);
    boolean    verifyUser   (User   user);
    List<User> findAllUsers ();
    User       findUser     (String username);
    
}
