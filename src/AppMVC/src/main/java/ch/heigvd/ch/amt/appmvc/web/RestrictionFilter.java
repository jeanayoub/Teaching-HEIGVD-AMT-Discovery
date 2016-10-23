/** 
 * Document           : RestrictionFilter.java
 * Created on         : Oct 10, 2016
 * Author             : J. Ayoub & M-H. Aghamahdi
 * Object             : This Servlet manage the Restriction page. It manage
 *                      authetification.
 * Information Source : N/A
 */
package ch.heigvd.ch.amt.appmvc.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * A Servlet to manage the access rights to the protected pages
 * 
 * @author J. Ayoub & M-H. Aghamahdi
 */
public class RestrictionFilter implements Filter {
    
    public static final String LINK_LOGIN = "/login";
    
    /**
     * Empty filter constructor.
     */
    public RestrictionFilter() {}    
    
    /**
     *
     * @param request The servlet request 
     * @param response The servlet response 
     * @param chain The filter chain 
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request; 
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        
        if ( session.getAttribute("username") == null ) { 
            res.sendRedirect( req.getContextPath() + LINK_LOGIN);
        } 
        else {
            chain.doFilter( request, response ); 
        }
    }
    
    /**
     * Destroy method for this filter
     */
    public void destroy() {}

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {}   
}