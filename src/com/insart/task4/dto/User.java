package com.insart.task4.dto;

public class User {
	private String userLogin;
	private String userPassword;
	private String userEmail;
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String login) {
		this.userLogin = login;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
