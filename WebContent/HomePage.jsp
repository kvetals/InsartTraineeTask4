<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.insart.task4.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
<%User user = (User) session.getAttribute("user"); %>
<%if (user == null){ %>
<jsp:forward page="index.html">
   <jsp:param name="errMsg"
   value="The name or password is not valid" />
</jsp:forward>
<%} %>
<p align="right">You signed in as "<%=user.getUserLogin() %>"</p>
<form action="Logout" method="post">
	
	<input type="submit" value="Logout"/>
	
</form>

<h1>Some page with fantastic design and functionality!</h1>
</body>
</html>