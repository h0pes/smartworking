<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.kirth.model.Requests" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="Requests" class="com.kirth.model.Requests"   scope="application" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_homemanager.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View all smart working planning requests</title>
</head>
<body>

<script type="text/javascript">
function checkboxes()
{
	var inputElements = document.getElementsByTagName("input"),
	count = 0;
	for (var i = 0; i < inputElements.length; i++)
	{
		if (inputElements[i].type === "checkbox" && inputElements[i].checked === true)
			{
				count++;
// 				alert(document.querySelectorAll('input[type="checkbox"]:checked').lenght)
			}
	}
	
	switch (count)
	{
 	case 0:
 		return;
// 		alert("You have to select at least one working day from home in order to submit the planning")
// 		document.getElementById("sendPlan").disabled = true;
// 		break;
	case 1:
	case 2:
	case 3:
	case 4:
		document.getElementById("approveAll").disabled = true;
		document.getElementById("rejectAll").disabled = true;
		alert("You have already submitted for approval or reject at least one record in the table.")
		break;
	}
}	
	
</script>

<%
//BEGIN - code to retrieve next monday date
Calendar cal = Calendar.getInstance();
Date today = new Date();
cal.setTime(today);
//cal.set(2016, 03, 24);
if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
     cal.add( Calendar.DATE, 7 );
while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
     cal.add( Calendar.DATE, 1 );

System.out.println(cal.getTime());
DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

Date mondayDate = cal.getTime();
System.out.println("Today is: " + df.format(today));
System.out.println("Next business monday is: " + df.format(mondayDate));
String mondayFirstWeek = df.format(mondayDate);

cal.setTime(df.parse(mondayFirstWeek));
cal.add(java.util.Calendar.DATE, 1);
String tuesdayFirstWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String wednesdayFirstWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String thursdayFirstWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String fridayFirstWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 3);
String mondaySecondWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String tuesdaySecondWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String wednesdaySecondWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String thursdaySecondWeek = df.format(cal.getTime());

cal.add(java.util.Calendar.DATE, 1);
String fridaySecondWeek = df.format(cal.getTime());
%>	

<form action="<c:url value="/approve-reject-request" />" method="post">

<table style="width:1000px" align="center" cellspacing="1" border="1" cellpadding="2">
 
 <thead>
 	<tr>
 		<th>Id</th>
        <th>userID</th>
        <th>requestDate</th>
        <th>Mon - <%= mondayFirstWeek %></th>
		<th>Tue - <%= tuesdayFirstWeek %></th>
		<th>Wed - <%= wednesdayFirstWeek %></th>
		<th>Thu - <%= thursdayFirstWeek %></th>
		<th>Fri - <%= fridayFirstWeek %></th>
		<th>Mon - <%= mondaySecondWeek %></th>
		<th>Tue - <%= tuesdaySecondWeek %></th>
		<th>Wed - <%= wednesdaySecondWeek %></th>
		<th>Thu - <%= thursdaySecondWeek %></th>
		<th>Fri - <%= fridaySecondWeek %></th>
		<th>Approve</th>
		<th>Reject</th>
		<th>Chk</th>
 	</tr>
 </thead>

<form action="<c:url value="/approve-reject-request" />" method="post">
<c:forEach items="${requests}" var="request">
<tr>
	<td>${request.planningId}</td>  
	<td>${request.userId}</td>  
	<td><fmt:formatDate pattern="dd-MM-yyyy" 
            value="${request.requestDate}" /></td>
              
	<td style="width:70px"><c:if test="${not empty request.mondayFirstWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td> 
	
	<td style="width:70px"><c:if test="${not empty request.tuesdayFirstWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.wednesdayFirstWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.thursdayFirstWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.fridayFirstWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
    		
	<td style="width:70px"><c:if test="${not empty request.mondaySecondWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td> 
	
	<td style="width:70px"><c:if test="${not empty request.tuesdaySecondWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.wednesdaySecondWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.thursdaySecondWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
	
	<td style="width:70px"><c:if test="${not empty request.fridaySecondWeek}">
    	<h4 style="color:orange;">Requested</h4>
    </c:if></td>
    								
    <td class="centerBtn"><input type="submit" name="${request.planningId}" value="Approve" <c:if test="${request.managed == 'true'}">disabled</c:if>/></td>
    <td class="centerBtn"><input type="submit" name="${request.planningId}" value="Reject" <c:if test="${request.managed == 'true'}">disabled</c:if>/></td>
    <td><input type="checkbox" name="managed_${request.planningId}" value="managedvalue_${request.planningId}" <c:if test="${request.managed == 'true' || request.managed == 'false' || empty request.managed}">disabled="disabled"</c:if> <c:if test="${request.managed == 'true'}">checked="checked"</c:if>/></td>	
</tr>
</c:forEach>
</form>              
</table>
	<div class="centerBtn">
	<input type="submit" id="approveAll" name="approveAll" value="Approve All" onclick="checkboxes()" <c:if test="${request.managed == 'true'}">disabled</c:if>/>
    <input type="submit" id="rejectAll" name="rejectAll" value="Reject All" onclick="checkboxes()" <c:if test="${request.managed == 'true'}">disabled</c:if>/>
    </div>
<p></p>
</form>

</body>
</html>
<jsp:include page="/includes/footer.jsp" />