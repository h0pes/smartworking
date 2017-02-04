<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/main.css" />
<title>Login application</title>
</head>
<body>
<div class="login" align="center">
<form action="home" method="post">
<fieldset style="width: 250px">
<input type="text" name="username" required="required" placeholder="username"/>
<br>
<br>
<input type="password" name="userpass" required="required" placeholder="password"/>
<br>
<a href="<c:url value='/reset-password' />" class="forgot">forgot password?</a>
<br>
<br>
<input type="submit" value="Login" />
</fieldset>
</form>
</body>
</html>