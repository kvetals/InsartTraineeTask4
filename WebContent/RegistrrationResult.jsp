<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.insart.task4.dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page! Congratulations! U did IT :-)</title>
</head>
<body>
<%User user =(User) session.getAttribute("user");
String userLogin = user.getUserLogin();%>
	<h1>Hello dear <%=user.getUserLogin() %></h1>
	<p>Please, take our sincere congratulations with registration at the best site of the WWW!!!</p>
	<form action="Login" method="post">		
		<input type="submit" value="Just push it to go on :-)"/>
	</form>
</body>
</html>