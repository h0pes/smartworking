<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Log in</title>

	<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
	<link rel="stylesheet" href="styles/login.css">

</head>

<body>

<div class="login-card">
    <h1>Log-in</h1><br>
    
    <form action="home" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="userpass" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="Login">
  	</form>
  	
 <div class="login-help">
    <a href="#">Forgot Password</a>
</div>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>

</body>
</html>