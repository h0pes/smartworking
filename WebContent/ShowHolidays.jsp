<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View BCM Office users holidays plan</title>
</head>
<body>
<section>
<!-- 	<div id="global"> -->
    <h2 align="center">Showing BCM Office holidays for the chosen period.</h2>
<form action="exporttoexcel" method="post">
<div class="scrollableContainer">
  <div class="scrollingArea">
  	<table class="holidays scrollable">
  	    <thead>
  			<tr>
			  <th class="userId"><div>userId</div></th>
			  <th class="Year"><div>Year</div></th>
			  <th class="Month"><div>Month</div></th>
			  <th class="Date"><div>Date</div></th>
			  <th class="Day"><div>Day</div></th>
			  <th class="Type"><div>Type</div></th>
  			</tr>
		</thead>
  		<tbody>
		<c:forEach items="${viewholidays}" var="allHolidays">
			<tr>
			  <td class="userid"><div>${allHolidays.userId}</div></td>
			  <td class="Year"><div>${allHolidays.year}</div></td>
			  <td class="Month"><div>${allHolidays.monthName}</div></td>
			  <td class="Date"><div>${allHolidays.udate}</div></td>
			  <c:choose>
					<c:when test="${allHolidays.dayOfWeek == '1'}">
						<td style="color:red;">Sunday</td>
					</c:when>
					<c:when test="${allHolidays.dayOfWeek == '2'}">
						<td style="color:green;">Monday</td>
					</c:when>
					<c:when test="${allHolidays.dayOfWeek == '3'}">
						<td style="color:green;">Tuesday</td>
					</c:when>
					<c:when test="${allHolidays.dayOfWeek == '4'}">
						<td style="color:green;">Wednesday</td>
					</c:when>
					<c:when test="${allHolidays.dayOfWeek == '5'}">
						<td style="color:green;">Thursday</td>
					</c:when>
					<c:when test="${allHolidays.dayOfWeek == '6'}">
						<td style="color:green;">Friday</td>
					</c:when>
					<c:otherwise>
						<td style="color:red;">Saturday</td>
					</c:otherwise>
				</c:choose>
			  				<c:choose>
					<c:when test="${allHolidays.dayOfWeek == '1' || allHolidays.dayOfWeek == '7'}">
						<td style="color:red;">n.a.</td>
					</c:when>			
					<c:when test="${empty allHolidays.dayType}">
						<td style="color:green;">At work</td>
					</c:when>
					<c:otherwise>
						<c:choose>
      						<c:when test="${allHolidays.dayType == 'ferie'}">
           						<td style="color:red;">${allHolidays.dayType}</td>
      						</c:when>	
	  						<c:when test="${allHolidays.dayType == 'sospensione attivita'}">
           						<td style="color:orange;">${allHolidays.dayType}</td>
      						</c:when>
						</c:choose>
					</c:otherwise>
				</c:choose>	
				<input type="hidden" name="myYear" value="${allHolidays.year}" />
				<input type="hidden" name="myMonth" value="${allHolidays.monthName}" />
				<input type="hidden" name="myUserId" value="${allHolidays.userId}" />
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</div>
<div style="text-align:center">
<input style="text-align:center; vertical-align: middle" type="submit" name="export-one" value="Export To Excel" />
<input style="text-align:center; vertical-align: middle" type="submit" name="export-all" value="Export all UBCM To Excel" />
<input type="submit" value="Print this page" onClick="window.print()"/>
</div>
</form>

<!-- <div style="text-align:center"> -->
<!-- <input type="submit" value="Print this page" onClick="window.print()"/> -->
<!-- </div> -->
</section>
</body>
</html>

<jsp:include page="/includes/footer.jsp" />