<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Reset your password</title>

<link rel="stylesheet" type="text/css" href="styles/tableLayout.css" />

<script type="text/javascript">
 function Verify() {
  var emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var emailObj = document.getElementById("emailId");
  if (emailObj.value == null || emailObj.value == "") {
   alert("Enter email Id");
   emailObj.focus();
   return false;
  } else if (!emailpattern.test(emailObj.value)) {
   alert("please enter valid e-mail address")
   emailObj.focus();
   return false;
  } else {
   return true;
  }
 }
</script>

</head>
<body>

<form method="post" action="Send">
<%
if (request.getAttribute("linkfailuremsg") != null) {
%>
<font color="black" size="4"><p align="center"
    style="background-color: lightyellow">
	This link has been already accessed.<br> OR it has been
	more than 1 hour since you requested it.<br> In case you
	are trying to reset your password again, request a new link below.
</p></font>
<%
}
%>
<table class="tablelayout">
<caption>Reset your Password</caption>
<tr>
<td class="required">Enter your Email id</td>
<td><input type="text" name="emailId" id="emailId" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="reset"
     onclick="javascript: return Verify()" /></td>
</tr>
</table>
</form>

</body>
</html>