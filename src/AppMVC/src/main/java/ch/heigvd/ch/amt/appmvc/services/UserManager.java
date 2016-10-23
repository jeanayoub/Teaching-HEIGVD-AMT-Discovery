/** 
 * Document           : UserManager.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This class provides methods to manage a user and makes 
 *                       changes in the database.
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.services;

import ch.heigvd.ch.amt.appmvc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Manage the users accounts by providing managing method and accessing the 
 * database. 
 * 
 * @author J. Ayoub & M-H. Aghamahdi
 */
@Stateless
public class UserManager implements IUserManager{

    @Resource(lookup = "jdbc/amtDB")
    private DataSource dataSource;
    
    /**
     * This method adds a user in the DB.
     * 
     * @param user the user to be added.
     */
    @Override
    public void addUser(User user) {
        
        try {
            // Establish a connection with the data source.
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "INSERT INTO users VALUES(?,?,?,?,?)" );
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getFamilyName());
            
            ps.executeUpdate();
            // Close the connection.
            conn.close();
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method checks if the user has already made a registration using a 
     * specific username.
     * 
     * @param username username to be verified.
     * @return true if user has already made registration , false if not.
     */
    @Override
     public boolean userExists(String username) {
         
         boolean exists = false;
       
          try {
              // Establish a connection with the data source.
              Connection conn = dataSource.getConnection();
              
              // Find the user to verfy.
              PreparedStatement ps = conn.prepareStatement( "SELECT username FROM users WHERE username = ?");
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
              
              // If rs.next() is not null, it means the user exists.
              if (rs.next()) {
                  exists = true;
              }
              // Close the connection.
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }
     
    /**
     * This method checks if the user has correctly enter his username and 
     * password.
     * 
     * @param user user who fill in his fields
     * @return true if user and password does match, false if not.
     */
    @Override
    public boolean verifyUser(User user) {
        if ( userExists(user.getUsername()) ) {
            User userTmp = null;
            try {
              // Establish a connection with the data source.
              Connection conn = dataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement( "SELECT username, password FROM users WHERE username = ?");
              ps.setString(1, user.getUsername());
              ResultSet rs = ps.executeQuery();
               if(rs.next()) {
                 userTmp = new User(rs.getString("username"), rs.getString("password"));  
               }
               // Close the connection.
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
     * This method deletes a given user via its username.
     * 
     * @param username username to be deleted.
     * @return status of the delete operation.
     */
    @Override
    public int deleteUser(String username) {
        int state = 0;
        try {
            // Establish a connection with the data source.
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "DELETE FROM users WHERE username = ?" );
            ps.setString(1, username);
         
            // we save the result of delete operation.
            state = ps.executeUpdate();
            // Close the connection.
            conn.close();           
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    
    /**
     * This method updates the user's informations.
     * 
     * @param user the user to update.
     */
    @Override
    public void modifyUser(User user) {
       
        try {
            // Establish a connection with the data source.
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement( "UPDATE users SET password = ? , email = ? ,  firstName = ? , familyName = ? WHERE username = ?" );            
            
            ps.setString(1, user.getPassword()   );
            ps.setString(2, user.getEmail()      );
            ps.setString(3, user.getFirstName()  );
            ps.setString(4, user.getFamilyName() );
            ps.setString(5, user.getUsername()   );
            
            ps.executeUpdate();
            // Close the connection.
            conn.close();
        }
        catch (SQLException ex){
            ex.toString();
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method finds all user and saves them in a list.
     * 
     * @return a list of all the users.
     */
    @Override
    public List<User> findAllUsers() {
        
        List<User> users = new ArrayList<>();
        
        try {
              // Establish a connection with the data source.
              Connection conn = dataSource.getConnection();
              
              // Saves all users in DB.
              PreparedStatement ps = conn.prepareStatement( "SELECT * FROM users");
              ResultSet rs = ps.executeQuery();
              
              // Adds all users in the list.
              while (rs.next()) {
                  users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("firstName"), rs.getString("familyName")));
              }
              // Close the connection.
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        return users;
    }

    /**
     * Finds a specified user by its username.
     * 
     * @param username username to find
     * @return user as a User form
     */
    @Override
    public User findUser(String username) {
        
        User user = null;
        
        try {
              // Establish a connection with the data source.
              Connection conn = dataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement( "SELECT * FROM users WHERE username = ?");
              ps.setString(1, username);
              ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                  user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("firstName"), rs.getString("familyName"));
              }
              // Close the connection.
              conn.close();
        }
            catch (SQLException ex){
                ex.toString();
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        return user;
    }
}