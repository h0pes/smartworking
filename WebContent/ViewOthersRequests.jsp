<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Office smart working requests</title>
</head>
<body>

<%
//BEGIN - code to retrieve next monday date
Calendar cal = Calendar.getInstance();
Date today = new Date();
cal.setTime(today);
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

<div id="global">
    <h3 align="center">Showing UBCM Office smart working requests for the current period.</h3>
    <p>
		<table width="700" border="1" cellpadding="2" cellspacing="2">
  		<thead>
			<tr>
			    <th width="184" scope="row">UserId</th>
			    <th width="184" scope="row">Req.Date</th>
			    <th width="184" scope="row">Mon - <%= mondayFirstWeek %></th>
				<th width="184" scope="row">Tue - <%= tuesdayFirstWeek %></th>
				<th width="184" scope="row">Wed - <%= wednesdayFirstWeek %></th>
				<th width="184" scope="row">Thu - <%= thursdayFirstWeek %></th>
				<th width="184" scope="row">Fri - <%= fridayFirstWeek %></th>
				<th width="184" scope="row">Mon - <%= mondaySecondWeek %></th>
				<th width="184" scope="row">Tue - <%= tuesdaySecondWeek %></th>
				<th width="184" scope="row">Wed - <%= wednesdaySecondWeek %></th>
				<th width="184" scope="row">Thu - <%= thursdaySecondWeek %></th>
				<th width="184" scope="row">Fri - <%= fridaySecondWeek %></th>
				<th width="184" scope="row">Status</th>
			 </tr>
  		</thead>
    	<c:forEach items="${viewothersrequests}" var="allusersPlanning">
			<tr>
				<td>${allusersPlanning.userId}</td>
				<td>${allusersPlanning.requestDate}</td>
				<td>${allusersPlanning.mondayFirstWeek}</td>
				<td>${allusersPlanning.tuesdayFirstWeek}</td>
				<td>${allusersPlanning.wednesdayFirstWeek}</td>
				<td>${allusersPlanning.thursdayFirstWeek}</td>
				<td>${allusersPlanning.fridayFirstWeek}</td>
				<td>${allusersPlanning.mondaySecondWeek}</td>
				<td>${allusersPlanning.tuesdaySecondWeek}</td>
				<td>${allusersPlanning.wednesdaySecondWeek}</td>
				<td>${allusersPlanning.thursdaySecondWeek}</td>
				<td>${allusersPlanning.fridaySecondWeek}</td>
				<c:choose>
      				<c:when test="${allusersPlanning.status == 'requested'}">
           				<td style="color:orange; font-weight:bold;">${allusersPlanning.status}</td>
      				</c:when>	
	  				<c:when test="${allusersPlanning.status == 'approved'}">
           				<td style="color:green; font-weight:bold;">${allusersPlanning.status}</td>
      				</c:when>
      				<c:when test="${allusersPlanning.status == 'rejected'}">
           				<td style="color:red; font-weight:bold;">${allusersPlanning.status}</td>
      				</c:when>
				</c:choose>
			</tr>
		</c:forEach>
    			
  		</table>
  		
  		<p></p>
  		<div style="text-align:center">
  		<input type="submit" value="Print this page" onClick="window.print()"/>

    </p>
</div>
</body>
</html>
<jsp:include page="/includes/footer.jsp" />