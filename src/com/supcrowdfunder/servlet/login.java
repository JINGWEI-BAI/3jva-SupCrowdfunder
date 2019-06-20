package com.supcrowdfunder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import com.supcrowdfunder.dao.CategoryDao;
import com.supcrowdfunder.dao.DaoFactory;
import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.User;
import com.supcrowdfunder.util.PersistenceManager;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/userlogin.jsp");
        rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
        UserDao pd2 = DaoFactory.retrieveUserDao();
        List<User> users = pd2.retrieveAllUsers();
        int j = 0 ;
        Long id = null;
        for (User user : users) {
			if(user.getEmail().equals(email)&&user.getPassword().equals(pwd)){
				j=1;
				id = user.getId();
	            break;
			}
		}
        if(j==1){
        	HttpSession session  = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("id", id.toString());
       
        CategoryDao cd =  new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
        
        List<Category> categoryList = cd.retrieveAllCategories();
        request.setAttribute("categoryList", categoryList);
        }
       
        
        
		
	    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
	}

}
