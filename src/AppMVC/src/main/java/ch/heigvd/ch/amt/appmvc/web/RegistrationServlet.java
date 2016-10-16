/** 
 * Document           : RegistrationServlet.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
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
    public static final String VIEW_LOGIN        = "/WEB-INF/pages/Login.jsp";
    public static final String LINK_LOGIN        = "/login";
    public static final String USERNAME          = "username";
    public static final String PASSWORD          = "password";
    public static final String CONFIRMATION      = "confirmation";
    public static final String LINK_PROTECTED    = "/restricted/protected";

    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
        
        if (username.isEmpty() || password.isEmpty() || confirmation.isEmpty()) {
            request.setAttribute("err_register", "You must fill all required fields (*) !");
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
            
        else if (userManager.userExists(username)) {
            request.setAttribute("err_register", "Username exists ! Choose a different one !");
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
        
        else if (!password.equals(confirmation)) {
            request.setAttribute("err_register", "Password and password confirmation doesn't match !");
            request.getRequestDispatcher(VIEW_REGISTRATION).forward(request, response);
        }
        
        else {
            userManager.addUser(new User(username, password));
            request.setAttribute("succ_register", " You have successfully registerd !");
            //request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
            response.sendRedirect( request.getContextPath() + LINK_LOGIN);
        }
    }
}
