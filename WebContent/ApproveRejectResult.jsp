<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header_manager.jsp" />
<jsp:include page="/includes/column_left_homemanager.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Approve/Reject users smart working requests</title>
</head>
<body>
<section>
<h3>You have performed the following action:</h3>
        ${message}
<p>
Return to view requests page to perform further approvals.
<a href="<c:url value='/view-requests' />">
                  View Requests for approval</a> 
</p>        
</section>
</body>
</html>
<jsp:include page="/includes/footer.jsp" />