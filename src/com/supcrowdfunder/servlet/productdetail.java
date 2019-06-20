package com.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.entity.Product;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class productdetail
 */
@WebServlet(name = "productdetail", urlPatterns = "/productdetail")
public class productdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productdetail() {
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
		   RequestDispatcher rd = request.getRequestDispatcher("/productdetail.jsp");
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
