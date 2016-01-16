package com.insart.task4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insart.task4.dto.User;
import com.insart.task4.service.LoginService;

/**
 * Servlet implementation class RegistrationControllerServlet
 */
@WebServlet("/RegistrationControllerServlet")
public class RegistrationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserLogin(request.getParameter("userLogin"));
		user.setUserPassword(request.getParameter("userPassword"));
		LoginService.addNewUser(user);
		request.getSession().setAttribute("user", user);
		response.sendRedirect("RegistrrationResult.jsp");
	}

}
