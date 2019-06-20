package com.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.dao.jpa.JpaUserDao;
import com.supcrowdfunder.util.PersistenceManager;



/**
 * Servlet implementation class removeUser
 */
@WebServlet(name="RemoveUserServlet", urlPatterns="/removeUser")
public class removeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long userId =new Long(request.getParameter("id"));
        UserDao ud = new JpaUserDao(PersistenceManager.retrieveEntityManagerFactory());
        ud.removeUser(userId);
        response.sendRedirect(request.getContextPath() + "/admin/adminpage");
	}

}
