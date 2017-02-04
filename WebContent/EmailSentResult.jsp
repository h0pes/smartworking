<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Email sent result</title>
</head>
<body>

	<center>
		<h3><%=request.getAttribute("Message")%></h3>
	</center>

</body>
</html>
<jsp:include page="/includes/footer.jsp" />