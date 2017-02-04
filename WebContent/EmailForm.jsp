<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Send an email</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-2.2.3.js"></script>
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 
  <script type="text/javascript" src="/LoginTest/scripts/jquery.ui.datepicker-it.js"></script>
<!--   <script type="text/javascript" src="/LoginTest/scripts/ui.datepicker-it.js" ></script> -->
  <style>
    .datepicker{
     
    }
  </style>
 <%
String userId = "";
userId = (String) session.getAttribute("name");
%> 
 
 <script>
  $(document).ready(function () {
	    $.datepicker.setDefaults($.datepicker.regional['it']);  
	    $('#txtDate').datepicker(
		{  
			maxDate: 0 }
	        );
	});
  
  function generateSubject()
  {
	  var chosenDate = "";
	  var chosenDate = document.getElementById('txtDate').value
	  var userId = "<%= userId%>";
	  var txtSubject = "";
	  var txtSubject = "Activities performed by user "
	  var fillText = " on date "
	  var finalSubject = txtSubject.concat(userId, fillText, chosenDate);
	  document.getElementById("subjectId").value = finalSubject;
  }

  </script>
</head>
<body>

	<form action="EmailSendingServlet" method="post">
		<table border="0" width="75%" align="center">
			<caption><h2>Report your smart working activities by email</h2></caption>
			<tr>
				<td width="15%">Smart Working day to report</td>
				<td><input type="text" name="date" id="txtDate" size="50" class="datepicker"/></td>
			
			</tr>
			
			<tr>
				<td width="15%">Recipient address </td>
				<td><input type="text" name="recipient" size="50" placeholder="recipient email address"/></td>
			</tr>
			
			<tr>
				<td width="15%">Carbon copy address </td>
				<td><input type="text" name="carboncopy" size="50" placeholder="carbon copy email address"/></td>
			</tr>
			
			<tr>
				<td>Subject </td>
				<td><input type="text" id= "subjectId" name="subject" size="50" style="background-color:Green; color:white;"onclick = "generateSubject()" placeholder="click here" value="" readonly/></td>
			</tr>
			<tr>
				<td>Content </td>
				<td><textarea rows="10" cols="52" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Send"/></td>
			</tr>
		</table>
		
	</form>

</body>
</html>
<jsp:include page="/includes/footer.jsp" />