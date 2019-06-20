package com.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supcrowdfunder.dao.CategoryDao;

import com.supcrowdfunder.dao.jpa.JpaCategoryDao;

import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class RemoveCategory
 */
@WebServlet(name="RemoveCategoryServlet", urlPatterns="/auth/removeCategory")
public class RemoveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCategory() {
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
		String categoryId = request.getParameter("id");
		CategoryDao cd = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
		cd.removeCategory(new Long(categoryId));
		response.sendRedirect(request.getContextPath() + "/admin/adminpage");
	}

}
