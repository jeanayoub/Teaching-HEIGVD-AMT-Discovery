/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ayoubo
 */
public class LogoutServlet extends HttpServlet {

    
    public static final String VIEW_INDEX = "/index.html";
    public static final String VIEW_PROTECTED = "/WEB-INF/pages/ProtectedPage.jsp";
    
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
                
        //HttpSession session=request.getSession(false); 
        
        //if (session!=null) {
          //  System.out.println(session.getId());
          
          
          if (request.getSession().getAttribute("counter") != null && 
                  request.getSession().getAttribute("counter").equals(1)) {
              request.getRequestDispatcher(VIEW_PROTECTED).include(request, response);
        } 
        
        else{  
            request.getRequestDispatcher(VIEW_INDEX).forward(request, response);  
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
              
            //request.getSession().invalidate();
            request.getSession().setAttribute("counter", 0);
        request.getRequestDispatcher(VIEW_INDEX).forward(request, response);
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
