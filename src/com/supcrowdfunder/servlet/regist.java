package com.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.supcrowdfunder.dao.DaoFactory;
import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.entity.User;

/**
 * Servlet implementation class regist
 */
@WebServlet("/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/userreg.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userfName = request.getParameter("fname");
		String userlName = request.getParameter("lname");
		String userpwd = request.getParameter("password");
		String useremail = request.getParameter("email");
		HttpSession session  = request.getSession();
		UserDao ud =  DaoFactory.retrieveUserDao();
		User user = new User(useremail,userfName,userlName,userpwd);
		ud.addUser(user);
        
        List<User> userList = ud.retrieveAllUsers();
        
        	Long id = null;
        	 for (User user3 : userList) {
     			if(user3.getEmail().equals(useremail))
     			{id = user3.getId();
     		     break;
     				}
     		}
        	session.setAttribute("email", useremail);
    	    session.setAttribute("id", id.toString());
    	    
    	    
        	request.setAttribute("judge", "yes");
    		RequestDispatcher rd = request.getRequestDispatcher("/listproduct");
            rd.forward(request, response);
        
		
		
        
		
	}
}
