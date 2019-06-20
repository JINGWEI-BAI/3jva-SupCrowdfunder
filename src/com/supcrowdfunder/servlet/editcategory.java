package com.supcrowdfunder.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supcrowdfunder.dao.CategoryDao;
import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class editcategory
 */
@WebServlet(name = "editcategory", urlPatterns = "/editcategory")
public class editcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String id1 = request.getParameter("id");
		   CategoryDao cd = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	       Category category = cd.retrieveCategoryById(new Long(id1));

	        request.setAttribute("category", category);
		   RequestDispatcher rd = request.getRequestDispatcher("/editcategory.jsp");
		   rd.forward(request, response);   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
		String categoryid = request.getParameter("id");
		String categoryName = request.getParameter("name");
		cd.updateCategory((new Long(categoryid)), categoryName);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		   rd.forward(request, response); 
	}

}
