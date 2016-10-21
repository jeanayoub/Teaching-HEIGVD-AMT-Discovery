/** 
 * Document           : UserManager.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This class provides methods to manage user
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.services;

import ch.heigvd.ch.amt.appmvc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class UserManager implements IUserManager{

    @Resource(lookup = "jdbc/amtDB")
    private DataSource dataSource;
    
    /**
     * This method add a user in DB.
     * @param user user to add
     */
    @Override
    public void addUser(User user) {
        
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "INSERT INTO users VALUES(?,?,?,?,?)" );
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getFamilyName());
            
            ps.executeUpdate();
            conn.close();
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method checks if the user has already made registration.
     * @param username username to verify
     * @return true if user has already made registration , false if not.
     */
    @Override
     public boolean userExists(String username) {
         
         boolean exists = false;
       
          try {
              Connection conn = dataSource.getConnection();
              
              // find the user to verfy
              PreparedStatement ps = conn.prepareStatement( "SELECT username FROM users WHERE username = ?");
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
              
              // if rs.next() is not null, it means the user exists.
              if (rs.next()) {
                  exists = true;
              }
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }
     
     
    /**
     * This method checks if the user has correctly enter his username and password
     * @param user user who fill in his fields
     * @return true if user and password does match, false if not.
     */
    @Override
    public boolean verifyUser(User user) {
        if ( userExists(user.getUsername()) ) {
            User userTmp = null;
            try {
              Connection conn = dataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement( "SELECT username, password FROM users WHERE username = ?");
              ps.setString(1, user.getUsername());
              ResultSet rs = ps.executeQuery();
               if(rs.next()) {
                 userTmp = new User(rs.getString("username"), rs.getString("password"));  
               }
                conn.close();
               return userTmp.isEqual(user);
            }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
   
    /**
     * this method deletes the user
     * @param username username to delete
     * @return status of delete operation
     */
    @Override
    public int deleteUser(String username) {
        int state = 0;
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "DELETE FROM users WHERE username = ?" );
            ps.setString(1, username);
         
            // we save the result of delete operation.
            state = ps.executeUpdate();
            conn.close();           
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return state;
    }

    
    /**
     * This method update the users's informations
     * @param user user to update
     */
    @Override
    public void modifyUser(User user) {
       
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "UPDATE users SET password = ? , email = ? ,  firstName = ? , familyName = ? WHERE username = ?" );            
            
            ps.setString(1, user.getPassword()   );
            ps.setString(2, user.getEmail()      );
            ps.setString(3, user.getFirstName()  );
            ps.setString(4, user.getFamilyName() );
            ps.setString(5, user.getUsername()   );
            
            ps.executeUpdate();
            conn.close();
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method find all user and save them in the list.
     * @return list of users.
     */
    @Override
    public List<User> findAllUsers() {
        
        List<User> users = new ArrayList<>();
        
        try {
              Connection conn = dataSource.getConnection();
              
              // save all users in DB.
              PreparedStatement ps = conn.prepareStatement( "SELECT * FROM users");
              ResultSet rs = ps.executeQuery();
              
              // add all users in the list.
              while (rs.next()) {
                  users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("firstName"), rs.getString("familyName")));
              }
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }

    /**
     * Find a specified user
     * @param username username to find
     * @return user as a User form
     */
    @Override
    public User findUser(String username) {
        
        User user = null;
        
        try {
              Connection conn = dataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement( "SELECT * FROM users WHERE username = ?");
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                  user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("firstName"), rs.getString("familyName"));
              }
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return user;
    }
    
}