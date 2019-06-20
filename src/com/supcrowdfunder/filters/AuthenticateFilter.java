package com.supcrowdfunder.filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter(filterName = "authenticate", urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        
        HttpSession currentRequestSession = req.getSession();
        
        if(currentRequestSession.getAttribute("email") == null||
        		currentRequestSession.getAttribute("email") == ""){
        	    
        	res.sendRedirect(req.getContextPath() +"/userlogin.jsp");
        	
        }
        else
        {
        	
        	chain.doFilter(request, response);}
        	  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
