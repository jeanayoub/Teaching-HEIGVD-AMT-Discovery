/** 
 * Document           : LoginServlet.java
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
public class LoginServlet extends HttpServlet {

    @EJB
    private IUserManager userManager;
    
    private static final String VIEW_LOGIN     = "/WEB-INF/pages/Login.jsp";
    private static final String LINK_PROTECTED = "/restricted/protected";
    private static final String USERNAME       = "username";
    private static final String PASSWORD       = "password";
    public static final  String EMAIL          = "email";
    public static final  String FIRST_NAME     = "firstName";
    public static final  String FAMILY_NAME    = "familyName";

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
            //request.getRequestDispatcher(VIEW_PROTECTED).forward(request, response);
        }
        else {
            request.getRequestDispatcher(VIEW_LOGIN).include(request, response);
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
        
        String username   = request.getParameter(USERNAME);
        String password   = request.getParameter(PASSWORD); 
        String email      = request.getParameter(EMAIL);
        String firstName  = request.getParameter(FIRST_NAME);
        String familyName = request.getParameter(FAMILY_NAME);
        
        
        if (userManager.verifyUser(new User(username, password))) {
                HttpSession session = request.getSession(true);
            
                session.setAttribute("username",   username);
                session.setAttribute("email",      email);
                session.setAttribute("firstName",  firstName);
                session.setAttribute("familyName", familyName);
                response.sendRedirect( request.getContextPath() + LINK_PROTECTED);
        } 
        else {  
                request.setAttribute("err_login", "Invalid username or/and password !");  
                request.getRequestDispatcher(VIEW_LOGIN).include(request, response);
        }
    }
}
