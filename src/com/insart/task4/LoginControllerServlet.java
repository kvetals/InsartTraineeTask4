package com.insart.task4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insart.task4.dto.User;
import com.insart.task4.service.LoginService;

import org.apache.logging.log4j.*;


@WebServlet(description = "Login servlet", urlPatterns = { "/Login" })
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LoginControllerServlet");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entry();
		User user = new User();
		if((request.getParameter("userLogin") != null && request.getParameter("userPassword") != null) && request.getParameter("userLogin").trim() != ""){
			user.setUserLogin(request.getParameter("userLogin"));
			user.setUserPassword(request.getParameter("userPassword"));
		}else if( request.getSession().getAttribute("user") != null){
			user = (User) request.getSession().getAttribute("user");
			response.sendRedirect("HomePage.jsp");
			logger.exit();
			return;
		}
		
		boolean authenticationResult = LoginService.authenticate(user.getUserLogin(), user.getUserPassword());
		if(authenticationResult){
			request.getSession().setAttribute("user", user); 
			response.sendRedirect("HomePage.jsp");
			logger.exit();
		}else{
			response.sendRedirect("index.html");
			logger.exit();
		}
		
		
	}

}
