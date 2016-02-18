package com.insart.task4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.insart.task4.dto.User;
import com.insart.task4.service.LoginService;

@WebServlet("/Registration")
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("RegistrationControllerServlet");

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entry();
		User user = new User();
		user.setUserLogin(request.getParameter("userLogin"));
		user.setUserPassword(request.getParameter("userPassword"));
		LoginService.addNewUser(user);
		request.getSession().setAttribute("user", user);
		response.sendRedirect("RegistrrationResult.jsp");
		logger.exit();
	}

}
