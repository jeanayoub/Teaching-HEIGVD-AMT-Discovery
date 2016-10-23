/** 
 * Document           : RegistrationServlet.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : A Servlet to manage the Registration page. 
 * Information Source : https://www.tutorialspoint.com/javaexamples/regular_email.htm
 */

package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.heigvd.ch.amt.appmvc.services.IUserManager;
import ch.heigvd.ch.amt.appmvc.model.User;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author J. Ayoub & M-H. Aghamahdi
 */
public class RegistrationServlet extends HttpServlet {

    @EJB
    private IUserManager userManager;
    
    public static final String VIEW_REGISTRATION = "/WEB-INF/pages/Registration.jsp";
    public static final String LINK_LOGIN        = "/login";
    public static final String LINK_PROTECTED    = "/restricted/protected";
    public static final String EMAIL_REGEX       = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static final String ERR_REQUIRED      = "You must fill all required fields (*) !";
    public static final String ERR_USERNAME      = "Username exists ! Choose a different one !";
    public static final String ERR_PASSQORD_CONF = "Password and password confirmation doesn't match !";
    public static final String ERR_EMAIL         = "Email address syntax is incorrect !";
    public static final String USERNAME          = "username";
    public static final String PASSWORD          = "password";
    public static final String CONFIRMATION      = "confirmation";
    public static final String EMAIL             = "email";
    public static final String FIRST_NAME        = "firstName";
    public static final String FAMILY_NAME       = "familyName";
    

    /**
     * treatment of "get" on the Registration page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionTest = request.getSession();
        
        if(sessionTest.getAttribute("username") != null) {
            response.sendRedirect( request.getContextPath() + LINK_PROTECTED);
        }
        else {
            request.getRequestDispatcher(VIEW_REGISTRATION).include(request, response);
        }
    }

    /**
     * treatment of "post" on the Registration page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username     = request.getParameter(USERNAME);
        String password     = request.getParameter(PASSWORD); 
        String confirmation = request.getParameter(CONFIRMATION);
        String email        = request.getParameter(EMAIL);
        String firstName    = request.getParameter(FIRST_NAME);
        String familyName   = request.getParameter(FAMILY_NAME);
        
        // treatment of various errors
        if (username.isEmpty() || password.isEmpty() || confirmation.isEmpty()) {
            request.setAttribute("err_register", ERR_REQUIRED);
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
            
        else if (userManager.userExists(username)) {
            request.setAttribute("err_register", ERR_USERNAME);
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
        
        else if (!password.equals(confirmation)) {
            request.setAttribute("err_register", ERR_PASSQORD_CONF);
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
        
        else if (email != null && !email.trim().isEmpty() && !email.matches(EMAIL_REGEX)) {
                request.setAttribute("err_register", ERR_EMAIL);
                request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);   
        }
        
        else {
            
            User user = new User(username, password);
            
            
            if (email != null) {
                user.setEmail(email);
            }

            
            if (firstName != null) {
                user.setFirstName(firstName);
            }
        
            if (familyName != null) {
                user.setFamilyName(familyName);
            }
            
            userManager.addUser(user);
            request.setAttribute("succ_register", " You have successfully registerd !");
            response.sendRedirect( request.getContextPath() + LINK_LOGIN);
        }
    }
}
