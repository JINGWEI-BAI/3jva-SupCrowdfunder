package com.supcrowdfunder.servlet;

import java.io.IOException;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supcrowdfunder.dao.CategoryDao;
import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class contribute
 */
@WebServlet(name = "contribute", urlPatterns = "/auth/contribute")
public class contribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
	       List<Product> productList = pd.retrieveAllProducts();
	       request.setAttribute("productList", productList);
		   CategoryDao cd = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	       List<Category> categories = cd.retrieveAllCategories();

	        request.setAttribute("categoryList", categories);
		    RequestDispatcher rd = request.getRequestDispatcher("/contribute.jsp");
		    rd.forward(request, response);		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String id = request.getParameter("id");
		   
		   
		   float num = Float.valueOf(request.getParameter("num")).floatValue();
		   float oldnum = Float.valueOf(request.getParameter("oldnum")).floatValue();
		   
		   ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
		   pd.contribute(new Long(id), num, oldnum);

		   RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		   rd.forward(request, response); 

	}

}
