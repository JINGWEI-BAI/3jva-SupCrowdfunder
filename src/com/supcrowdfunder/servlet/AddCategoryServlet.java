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
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet(name="AddCategoryServlet", urlPatterns="/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		RequestDispatcher rd = request.getRequestDispatcher("/add1.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryName = request.getParameter("name");
        Category category = new Category(categoryName);

        CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
        cd.addCategory(category);

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	}

}
