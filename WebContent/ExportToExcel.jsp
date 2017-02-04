<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@ page import="java.util.List"%>
<%@ page import="com.kirth.model.Holiday"%>
<html>
<head>
<title>Export to Excel Example</title>
</head>
<body>
<h3>Export to Excel Example</h3>
<table cellpadding="1" cellspacing="1" border="1" bordercolor="gray">
        <tr>
                <td>userId</td>
                <td>Year</td>
                <td>Month</td>
				<td>Date</td>
				<td>Day</td>
				<td>Type</td>
        </tr>
<%--        <% --%>
// 	   List<Holiday> excelHoliday = (List<Holiday>) request.getAttribute("viewholidaysforexcel");
//                  if (excelHoliday != null) {
//                          response.setContentType("application/vnd.ms-excel");
//                          response.setHeader("Content-Disposition", "inline; filename=HolidayReport.xls");
//                  }
//                  for (Holiday allHolidays : excelHoliday) {
<%--          %> --%>
        		<c:forEach items="${viewholidaysforexcel}" var="allHolidays">
			<tr>
			  <td class="userid"><div>${allHolidays.getUserId}</div></td>
			  <td class="Year"><div>${allHolidays.getYear}</div></td>
			  <td class="Month"><div>${allHolidays.getMonthName}</div></td>
			  <td class="Date"><div>${allHolidays.getUdate}</div></td>
			  <td class="Date"><div>${allHolidays.getDayOfWeek}</div></td>
			  <td class="Date"><div>${allHolidays.getDayType}</div></td>
<%-- 			  <c:choose> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '1'}"> --%>
<!-- 						<td style="color:red;">Sunday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '2'}"> --%>
<!-- 						<td style="color:green;">Monday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '3'}"> --%>
<!-- 						<td style="color:green;">Tuesday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '4'}"> --%>
<!-- 						<td style="color:green;">Wednesday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '5'}"> --%>
<!-- 						<td style="color:green;">Thursday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '6'}"> --%>
<!-- 						<td style="color:green;">Friday</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 						<td style="color:red;">Saturday</td> -->
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<%-- 			  				<c:choose> --%>
<%-- 					<c:when test="${allHolidays.dayOfWeek == '1' || allHolidays.dayOfWeek == '7'}"> --%>
<!-- 						<td style="color:red;">n.a.</td> -->
<%-- 					</c:when>			 --%>
<%-- 					<c:when test="${empty allHolidays.dayType}"> --%>
<!-- 						<td style="color:green;">At work</td> -->
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<%-- 						<c:choose> --%>
<%--       						<c:when test="${allHolidays.dayType == 'ferie'}"> --%>
<%--            						<td style="color:red;">${allHolidays.dayType}</td> --%>
<%--       						</c:when>	 --%>
<%-- 	  						<c:when test="${allHolidays.dayType == 'sospensione attivita'}"> --%>
<%--            						<td style="color:orange;">${allHolidays.dayType}</td> --%>
<%--       						</c:when> --%>
<%-- 						</c:choose> --%>
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose>	 --%>
			</tr>
			</c:forEach>
<%-- 		 <% --%>
//                  }
<%--          %> --%>
</table>
</body>
</html>