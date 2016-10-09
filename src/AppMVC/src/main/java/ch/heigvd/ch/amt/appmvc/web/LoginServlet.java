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


import ch.heigvd.ch.amt.appmvc.services.UserManager;
import ch.heigvd.ch.amt.appmvc.model.User;

/**
 *
 * @author Ayoubo
 */
public class LoginServlet extends HttpServlet {

    UserManager userManager = new UserManager();
    
    public static final String VIEW_REGISTRATION = "/WEB-INF/pages/Registration.jsp";
    public static final String VIEW_LOGIN        = "/WEB-INF/pages/Login.jsp";
    public static final String VIEW_PROTECTED    = "/WEB-INF/pages/ProtectedPage.jsp";
    public static final String USERNAME          = "username";
    public static final String PASSWORD          = "password";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        request.getRequestDispatcher(VIEW_LOGIN).include(request, response);
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
        
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD); 
        
        Object counter = request.getSession().getAttribute("counter");
        request.getSession().setAttribute("counter", 0);
        
        
        if (userManager.verifyUser(new User(username, password))) {
            //HttpSession session = request.getSession(true);
            if(counter != null && counter.equals(0) ) {
                request.getSession().setAttribute("counter", 1);
                request.setAttribute("conn_user", new User(username, password));
                request.getRequestDispatcher(VIEW_PROTECTED).forward(request, response);
            }
            else
                request.getRequestDispatcher(VIEW_LOGIN).include(request, response);
        }
        
        else {
            request.setAttribute("err_login", "Invalid username or/and password !");
            request.getRequestDispatcher(VIEW_LOGIN).include(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
