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
 * Servlet implementation class editproduct
 */
@WebServlet(name = "editproduct", urlPatterns = "/editproduct")
public class editproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String id1 = request.getParameter("id");
		   
	       ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
		   Product product = pd.retrieveProductById(new Long(id1));
	       request.setAttribute("product", product);
		   CategoryDao cd = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	       List<Category> categories = cd.retrieveAllCategories();

	       request.setAttribute("categoryList", categories);
		   RequestDispatcher rd = request.getRequestDispatcher("/editproduct.jsp");
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
        ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
        String productid = request.getParameter("id");
        String productName = request.getParameter("name");
        String productContent = request.getParameter("content");
        Float productCompletion = new Float(request.getParameter("completion"));
        Category productCategory = cd.retrieveCategoryById(new Long(request.getParameter("categoryId")));
		pd.updateProduct((new Long(productid)),productName,productContent,productCompletion,productCategory);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	}

}
