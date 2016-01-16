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
<p align="right">You signed in as "<%=user.getUserLogin() %>"</p>

<h1>Some page with fantastic design and functionality!</h1>
</body>
</html>