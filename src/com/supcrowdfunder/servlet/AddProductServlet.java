package com.supcrowdfunder.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import com.supcrowdfunder.dao.CategoryDao;

import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.dao.jpa.JpaUserDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;
import com.supcrowdfunder.entity.User;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(name="addProduct", urlPatterns="/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	

    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
        
        List<Category> categoryList = cd.retrieveAllCategories();
        request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
        rd.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		UserDao ud =  new JpaUserDao(PersistenceManager.retrieveEntityManagerFactory());
		CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
        ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
        String productName = request.getParameter("name");
        String productContent = request.getParameter("content");
        Float productCompletion = new Float(request.getParameter("completion"));
        String productCreator = session.getAttribute("email").toString();
        
        Category productCategory = cd.retrieveCategoryById(new Long(request.getParameter("categoryId")));
        
        User user = ud.retrieveUserById(new Long(session.getAttribute("id").toString()));
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        java.sql.Date currentdate = new java.sql.Date(utilDate.getTime());
        
        Product product = new Product(productName, productContent, productCompletion, productCreator , currentdate , productCategory,user);

        pd.addProduct(product);
        
        //response.sendRedirect(request.getContextPath() + "/showProduct?id=" + product.getId());
        response.sendRedirect(request.getContextPath() + "/listproduct");
        
	}

}
