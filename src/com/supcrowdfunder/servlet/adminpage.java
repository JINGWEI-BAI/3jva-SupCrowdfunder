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
import com.supcrowdfunder.dao.DaoFactory;
import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;
import com.supcrowdfunder.entity.User;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class adminpage
 */
@WebServlet("/admin/adminpage")
public class adminpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
	     List<Product> products = pd.retrieveAllProducts();
         request.setAttribute("productList", products);
	        CategoryDao pd1 = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	        List<Category> categories = pd1.retrieveAllCategories();
            request.setAttribute("categoryList", categories);
            UserDao pd2 = DaoFactory.retrieveUserDao();
            List<User> users = pd2.retrieveAllUsers();
            request.setAttribute("UserList", users);
            
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
