/** 
 * Document           : LogoutServlet.java
 * Created on         : Oct 10, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This Servlet manage the logout page. 
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {

    private static final String LINK_LOGIN = "/login";
    
    /**
     * treatment of "get" on the logout page
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession(); 
        session.invalidate();

        response.sendRedirect(request.getContextPath() + LINK_LOGIN);
    }
}
