/**
 * 
 */
package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.heigvd.ch.amt.appmvc.services.FruitsManager;
import ch.heigvd.ch.amt.appmvc.model.Fruit;

/**
 *
 * @author Ayoubo
 */
public class FruitsServlet extends HttpServlet {
    
    FruitsManager fruitsManager = new FruitsManager();

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
        
        Fruit fruit = fruitsManager.getRandomFruit();
        
        request.getRequestDispatcher("/WEB-INF/pages/Fruit.jsp").forward(request, response);
        
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FruitsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FruitsServlet at " + request.getContextPath() + "</h1>");
            out.println("The fruit is " + fruit.getName() + " and it's color is " + fruit.getColor());
            out.println("</body>");
            out.println("</html>");
        }
    */
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
