package com.insart.task4.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insart.task4.dto.User;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;




public class LoginService {
	private static final Logger logger = LogManager.getLogger(LoginService.class);

	private static HashMap<String, User> userDB = new HashMap<>();
	public static User getUserByLogin(String userLogin){
		logger.entry(userLogin);
		logger.info("getUserByLogin");
		return logger.exit(userDB.get(userLogin));
	}
	public static void addNewUser(User user){
		logger.info("Adding new User, Login is " + user.getUserLogin());
		userDB.put(user.getUserLogin(), user);
		logger.debug("Trying to get deleted User(should = null): ");
	}
	public static void deleteUserByLogin(String userLogin){
		logger.info("Removing Login is ", userLogin);
		userDB.remove(userLogin);
		logger.debug("trying to get deleted User(should = null): ", userDB.get(userLogin));
	}
	
	public static boolean authenticate(String userLogin, String userPassword){
		logger.entry(userLogin, userPassword);
		logger.info("Entering authenticate method for user: ", userLogin);
		boolean result = false;
		User user = userDB.get(userLogin);
		if(user != null){
			if(user.getUserPassword().equals(userPassword))
				result = true;
		}
		
		return logger.exit(result);
	}
	
	public static boolean logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
		return true;
	}

}
