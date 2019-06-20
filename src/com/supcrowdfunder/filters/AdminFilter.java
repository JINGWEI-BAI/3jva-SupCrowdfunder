package com.supcrowdfunder.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;


import com.supcrowdfunder.dao.UserDao;

import com.supcrowdfunder.dao.jpa.JpaUserDao;

import com.supcrowdfunder.entity.User;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(filterName = "admin", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        
        HttpSession currentRequestSession = req.getSession();
        UserDao ud = new JpaUserDao(PersistenceManager.retrieveEntityManagerFactory());
        List<User> users = ud.retrieveAllUsers();
        boolean admin = false;
        	for (User user : users) {
        		if(user.getId().toString().equals(currentRequestSession.getAttribute("id"))){
                   admin = user.getAdmin();
			}
        }
        	if(!admin){
        		req.setAttribute("admin", "admin");
        		RequestDispatcher rd = request.getRequestDispatcher("/userlogin.jsp");
                rd.forward(request, response);
        		
        		
        	}else{
        		
        		chain.doFilter(request, response);	
        		
        		
        	}
        
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
