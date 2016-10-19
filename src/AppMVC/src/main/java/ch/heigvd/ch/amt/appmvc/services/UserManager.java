/** 
 * Document           : UserManager.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.services;

import ch.heigvd.ch.amt.appmvc.model.User;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author J. Ayoub & M-H. Aghamahdi
 */
@Singleton
public class UserManager implements IUserManager{

    public UserManager() {}
    
    @Override
    public void addUser(User user) {
        listOfUsers.put(user.getUsername(), user);
    }
    
    @Override
     public boolean userExists(String username) {
        return listOfUsers.containsKey(username);
    }
     
    @Override
    public boolean verifyUser(User user) {
        if ( userExists(user.getUsername()) ) {
            return listOfUsers.get(user.getUsername()).isEqual(user);
        }
        return false;
    }
    
   

    @Override
    public User deleteUser(String username) {
      return listOfUsers.remove(username);
    }

    @Override
    public void modifyUser(User user) {
       
        if (user.getPassword() != null)
           listOfUsers.get(user.getUsername()).setPassword(user.getPassword());
     
        if (user.getEmail() != null)
            listOfUsers.get(user.getUsername()).setEmail(user.getEmail());
        
        if (user.getFirstName() != null)
            listOfUsers.get(user.getUsername()).setFirstName(user.getFirstName());
        
        if (user.getFamilyName() != null)
            listOfUsers.get(user.getUsername()).setFamilyName(user.getFamilyName());
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<User>(listOfUsers.values());
    }

    @Override
    public User findUser(String username) {
        return listOfUsers.get(username);
    }
    
    
     private static Map<String, User> listOfUsers = new HashMap<String, User>();
}