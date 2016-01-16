package com.insart.task4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insart.task4.dto.User;
import com.insart.task4.service.LoginService;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet(description = "Testing servlet", urlPatterns = { "/LoginControllerServlet" })
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		if((request.getParameter("userLogin") != null && request.getParameter("userPassword") != null) && request.getParameter("userLogin").trim() != ""){
			user.setUserLogin(request.getParameter("userLogin"));
			user.setUserPassword(request.getParameter("userPassword"));
		}else if( request.getSession().getAttribute("user") != null){
			user = (User) request.getSession().getAttribute("user");
			response.sendRedirect("HomePage.jsp");
			return;
		}
		System.out.println(user.getUserLogin());
		System.out.println(user.getUserPassword());
		boolean authenticationResult = LoginService.authenticate(user.getUserLogin(), user.getUserPassword());
		if(authenticationResult){
			request.getSession().setAttribute("user", user); 
			response.sendRedirect("HomePage.jsp");
		}else{
			response.sendRedirect("index.html");
		}
		
		
	}

}
