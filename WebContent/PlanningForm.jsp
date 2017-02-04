<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kirth.dao.SavePlanningAction"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Smart working week planning</title>
</head>
<body onload="checkday()">

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
		alert("You have to select at least one working day from home in order to submit the planning")
		document.getElementById("sendPlan").disabled = true;
		break;
	case 1:
	case 2:
	case 3:
	case 4:
		return;
	case 5:
		document.getElementById("sendPlan").disabled = true;
		alert("You can select a maximum of 2 working days from home. Please click on the refresh link to modify your planning.")
		break;
	default:
		alert("Something wrong happened when choosing your working from home days")
		document.getElementById("sendPlan").disabled = true;
		break;	
	}
}

function checkday()
{
	//check day of the week
	var d = new Date();
	var n = d.getDay();
	
	if (n < 0)
		{
			alert("Planning is not available today")
			document.getElementById("sendPlan").disabled = true;	
		}
}

</script>

<form method="post" action="save-planning" >

<table width="700" border="1" cellpadding="2" cellspacing="2" align="center">

<%
//BEGIN - code to retrieve next monday date -- refactor using DateUtil class methods
Calendar cal = Calendar.getInstance();
Date today = new Date();
cal.setTime(today);
int planningWeek = cal.get(Calendar.WEEK_OF_YEAR);
int firstWeek = planningWeek + 1;
int secondWeek = planningWeek + 2;

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
//END - code to retrieve next monday date
%>

<%
//new code to check whether current week is enabled for planning
boolean weekEnabled = false;
	weekEnabled = SavePlanningAction.weekEnabledForPlanning(planningWeek);
	request.setAttribute("enabled", weekEnabled);
	if (weekEnabled) {
  %>
      <h2>Planning IS allowed during current week</h2>
  <%
    } else {
  %>
      <h2>Planning IS NOT allowed during current week</h2>
  <%
    }
  %>

  <caption>First week</caption>
  <thead>
  <tr>
	<th width="184" scope="row">Monday - <%= mondayFirstWeek %></th>
	<th width="184" scope="row">Tuesday - <%= tuesdayFirstWeek %></th>
	<th width="184" scope="row">Wednesday - <%= wednesdayFirstWeek %></th>
	<th width="184" scope="row">Thursday - <%= thursdayFirstWeek %></th>
	<th width="184" scope="row">Friday - <%= fridayFirstWeek %></th>
  </tr>
  </thead>
    <tr>
    <td><input type="checkbox" name="mondayFirstWeek" value="<%= mondayFirstWeek %>"></input> Monday
	<br/>
	<textarea name='notesMondayFirstWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="tuesdayFirstWeek" value="<%= tuesdayFirstWeek %>"></input> Tuesday
	<br/>
	<textarea name='notesTuesdayFirstWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="wednesdayFirstWeek" value="<%= wednesdayFirstWeek %>"></input> Wednesday
	<br/>
	<textarea name='notesWednesdayFirstWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="thursdayFirstWeek" value="<%= thursdayFirstWeek %>"></input> Thursday
	<br/>
	<textarea name='notesThursdayFirstWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="fridayFirstWeek" value="<%= fridayFirstWeek %>"></input> Friday
	<br/>
	<textarea name='notesFridayFirstWeek' cols='20' rows='5'></textarea>
	</td>
  </tr>
  </table>
  <p></p>
  
  <table width="700" border="1" cellpadding="2" cellspacing="2" align="center">
  <caption>Second week</caption>
  <thead>
  <tr>
    <th width="184" scope="row">Monday - <%= mondaySecondWeek %></th>
	<th width="184" scope="row">Tuesday - <%= tuesdaySecondWeek %></th>
	<th width="184" scope="row">Wednesday - <%= wednesdaySecondWeek %></th>
	<th width="184" scope="row">Thursday - <%= thursdaySecondWeek %></th>
	<th width="184" scope="row">Friday - <%= fridaySecondWeek %></th>
  </tr>
  </thead>
    <tr>
    <td><input type="checkbox" name="mondaySecondWeek" value="<%= mondaySecondWeek %>"></input> Monday
	<br/>
	<textarea name='notesMondaySecondWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="tuesdaySecondWeek" value="<%= tuesdaySecondWeek %>"></input> Tuesday
	<br/>
	<textarea name='notesTuesdaySecondWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="wednesdaySecondWeek" value="<%= wednesdaySecondWeek %>"></input> Wednesday
	<br/>
	<textarea name='notesWednesdaySecondWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="thursdaySecondWeek" value="<%= thursdaySecondWeek %>"></input> Thursday
	<br/>
	<textarea name='notesThursdaySecondWeek' cols='20' rows='5'></textarea>
	</td>
    <td><input type="checkbox" name="fridaySecondWeek" value="<%= fridaySecondWeek %>"></input> Friday
	<br/>
	<textarea name='notesFridaySecondWeek' cols='20' rows='5'></textarea>
	</td>
  </tr>
  </table>
  
 <input type="hidden" id="userName" name="userName" value="<%=session.getAttribute("name")%>">
 <input type="hidden" id="planningWeek" name="planningWeek" value="<%=planningWeek%>">
 <input type="hidden" id="firstWeek" name="firstWeek" value="<%=firstWeek%>">
 <input type="hidden" id="secondWeek" name="secondWeek" value="<%=secondWeek%>">
  <div style="text-align:center"> 
<!--   <input type="button" value="Submit planning" disabled="disabled"/> -->
<%--   <input type = "button" value="Submit planning" <c:if test="${numberOfDays > 2}"><c:out value = "disabled='disabled'"/></c:if>">  --%>
<p></p>
<input type="submit" value="Submit planning" id="sendPlan" <c:if test="${enabled == 'false'}">disabled</c:if> onclick="checkboxes()" /> 
  </div> 
  <p>Click here to refresh the page:</p>
  <a href = "javascript:location.reload(true)">Refresh page</a>

</form>
</body>
</html>
<jsp:include page="/includes/footer.jsp" />