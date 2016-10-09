/** 
 * Document           : UserManager.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.services;
import ch.heigvd.ch.amt.appmvc.model.User;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Ayoubo
 */
public class UserManager {

    public UserManager() {}
    
    
    public void addUser(User user) {
        listOfUsers.put(user.getUsername(), user);
    }
    
     public boolean userExists(String username) {
        return listOfUsers.containsKey(username);
    }
    
    public boolean verifyUser(User user) {
        if ( userExists(user.getUsername()) ) {
            return listOfUsers.get(user.getUsername()).isEqual(user);
        }
      
        return false;
    }
    
    private static Map<String, User> listOfUsers = new HashMap<String, User>();
}
