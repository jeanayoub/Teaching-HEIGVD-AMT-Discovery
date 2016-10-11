/** 
 * Document           : LogoutServlet.java
 * Created on         : Oct 10, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Information Source : N/A
 */

package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J. Ayoub & M-H. Aghamahdi
 */
public class LogoutServlet extends HttpServlet {

    public static final String LINK_LOGIN = "/login";

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession(); 
        session.invalidate();

        response.sendRedirect(request.getContextPath() + LINK_LOGIN);
    }
}
