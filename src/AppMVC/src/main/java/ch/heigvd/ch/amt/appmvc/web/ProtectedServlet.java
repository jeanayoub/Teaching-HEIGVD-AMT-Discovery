/** 
 * Document           : ProtectedServlet.java
 * Created on         : Oct 6, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This Servlet manage the protected page. 
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProtectedServlet extends HttpServlet {
    
    private static final String LINK_LOGOUT    = "/logout";
    private static final String VIEW_PROTECTED = "/WEB-INF/pages/Restricted/ProtectedPage.jsp";
    
    /**
     * treatment of "get" on the Protected page
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        request.getRequestDispatcher(VIEW_PROTECTED).forward(request, response);    
    }

    /**
     * treatment of "POST" on the login page
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        response.sendRedirect( request.getContextPath() + LINK_LOGOUT);
    }
}
