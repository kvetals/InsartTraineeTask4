package com.insart.task4.service;

import java.util.HashMap;

import com.insart.task4.dto.User;

public class LoginService {
	private static HashMap<String, User> userDB = new HashMap<>();
	public static User getUserByLogin(String userLogin){
		User user;
		user = userDB.get(userLogin);
		return user;
	}
	public static void addNewUser(User user){
		userDB.put(user.getUserLogin(), user);
	}
	public static void deleteUserByLogin(String userLogin){
		userDB.remove(userLogin);
	}
	
	public static boolean authenticate(String userLogin, String userPassword){
		boolean result = false;
		User user = userDB.get(userLogin);
		if(user != null){
			if(user.getUserPassword().equals(userPassword))
				result = true;
		}
		
		return result;
	}

}
