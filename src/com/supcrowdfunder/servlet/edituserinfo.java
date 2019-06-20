package com.supcrowdfunder.servlet;

import java.io.IOException;



import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.supcrowdfunder.dao.DaoFactory;
import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.entity.User;

/**
 * Servlet implementation class edituserinfo
 */
@WebServlet("/edituserinfo")
public class edituserinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edituserinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        RequestDispatcher rd = request.getRequestDispatcher("/myinfo.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid = request.getParameter("id");
		String userfName = request.getParameter("fname");
		String userlName = request.getParameter("lname");
		String userpwd = request.getParameter("password");
		String useremail = request.getParameter("email");
		UserDao ud = DaoFactory.retrieveUserDao();
		List<User> userList = ud.retrieveAllUsers();
		int i = 0;
		for (User user : userList) {
			if(user.getEmail()==useremail)
			{
				i = 1;
				break;
			}
		}
		if(i==0){
			ud.updateUser((new Long(userid)),useremail,userfName,userlName,userpwd);
			
			
		}
		
		
		
        
        
       
        	//HttpSession session  = request.getSession();
    	    //  session.setAttribute("email", useremail);
    		
    		
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	   
	}

}
