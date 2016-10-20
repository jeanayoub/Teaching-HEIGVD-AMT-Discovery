/** 
 * Document           : UserManager.java
 * Created on         : Oct 17, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.rest;

import ch.heigvd.ch.amt.appmvc.model.User;

import ch.heigvd.ch.amt.appmvc.rest.dto.UserDTO;
import ch.heigvd.ch.amt.appmvc.services.IUserManager;
import java.net.URI;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ayoubo
 */
@Stateless
@Path("/users")
public class UserResource {
    
  @EJB
  private IUserManager userManager;

  @Context
  UriInfo uriInfo;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<UserDTO> getUsers(@QueryParam(value = "byName" ) String byName) {
    List<User> users = userManager.findAllUsers();
    return users.stream()
      .filter(p -> byName == null || p.getFamilyName().equalsIgnoreCase(byName))
      .map(p -> toDTO(p))
      .collect(toList());
      
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(UserDTO userDTO) {
    User user = fromDTO(userDTO);
    userManager.addUser(user);

    URI href = uriInfo
      .getBaseUriBuilder()
      .path(UserResource.class)
      .path(UserResource.class, "getUser")
      .build(user.getUsername());

    return Response
      .created(href)
      .build();
  }

  @Path("/{username}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public UserDTO getUser(@PathParam("username") String username) {
    User user = userManager.findUser(username);
    return toDTO(user);
  }
  
  
  
  @Path("/{username}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUser(@PathParam("username") String username) {
      if (userManager.deleteUser(username) != 0) {
          return Response
                  .accepted("The user have been successfully deleted")
                  .build();
      }
      else {
          return Response
                  .notModified("User does not exist")
                  .build();
      }
  }
  
  @Path("/{username}")
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateUser(@PathParam("username") String username, UserDTO userDTO) {
      User user = fromDTO(userDTO);
      if(userManager.findUser(username)!=null){
          userManager.modifyUser(user);
          return Response.accepted("The user have been successfully modified").build();
       }else{
          return Response.notModified("User does not exit").build();
      }
          
  }
  
  
  public User fromDTO(UserDTO userDTO) {
     User user = new User(userDTO.getUsername(), userDTO.getPassword());
     
     if (userDTO.getEmail() != null) {
        user.setEmail(userDTO.getEmail());
     }
     if (userDTO.getFirstName() != null) {
        user.setFirstName(userDTO.getFirstName());
     }
     if (userDTO.getFamilyName() != null) {
        user.setFamilyName(userDTO.getFamilyName());
     }
     return user;
  }
  
  public UserDTO toDTO(User user) {
    UserDTO dto = new UserDTO(user.getUsername(), user.getPassword());
    dto.setEmail(user.getEmail());
    dto.setFirstName(user.getFirstName());
    dto.setFamilyName(user.getFamilyName());
   
    return dto;
  }
  
    
}
