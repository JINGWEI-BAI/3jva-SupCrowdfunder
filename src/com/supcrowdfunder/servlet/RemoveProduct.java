package com.supcrowdfunder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet(name="RemoveProductServlet", urlPatterns="/auth/removeProduct")
public class RemoveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProduct() {
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
        String productId = request.getParameter("id");
        ProductDao pd = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
        pd.removeProduct(new Long(productId));
        response.sendRedirect(request.getContextPath() + "/admin/adminpage");
	}

}
