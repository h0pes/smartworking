<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Smart working week planning</title>
</head>
<body>
<table width="700" border="1" cellpadding="2" cellspacing="2">
<%
java.util.Calendar now = java.util.Calendar.getInstance();
int weekday = now.get(java.util.Calendar.DAY_OF_WEEK);
if (weekday != java.util.Calendar.MONDAY)
{
    // calculate how much to add
    // the 2 is the difference between Saturday and Monday
    int days = (java.util.Calendar.SATURDAY - weekday + 2) % 7;
    now.add(java.util.Calendar.DAY_OF_YEAR, days);
}
java.util.Date mondayDate = now.getTime();
java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ITALY);
String monday = df.format(mondayDate);

now.setTime(df.parse(monday));
now.add(java.util.Calendar.DATE, 1);
String tuesday = df.format(now.getTime());

now.add(java.util.Calendar.DATE, 1);
String wednesday = df.format(now.getTime());

now.add(java.util.Calendar.DATE, 1);
String thursday = df.format(now.getTime());

now.add(java.util.Calendar.DATE, 1);
String friday = df.format(now.getTime());


%>
  <caption>First week</caption>
  <thead>
  <tr>
    <th width="184" scope="row">Monday - <%= monday %></th>
	<th width="184" scope="row">Tuesday - <%= tuesday %></th>
	<th width="184" scope="row">Wednesday - <%= wednesday %></th>
	<th width="184" scope="row">Thursday - <%= thursday %></th>
	<th width="184" scope="row">Friday - <%= friday %></th>
  </tr>
  </thead>
  <tr>
    <td>Smart working on Monday</td>
    <td>Smart working on Tuesday</td>
    <td>Smart working on Wednesday</td>
    <td>Smart working on Thursday</td>
	<td>Smart working on Friday</td>
  </tr>
  </table>
</body>
</html>
<jsp:include page="/includes/footer.jsp" />