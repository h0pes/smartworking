<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${name eq 'admin' }" >
	<jsp:include page="/includes/header_manager.jsp" />
	<jsp:include page="/includes/column_left_homemanager.jsp" />
</c:if>	

<c:if test="${name ne 'admin' }" >
	<jsp:include page="/includes/header_user.jsp" />
	<jsp:include page="/includes/column_left_home.jsp" />
</c:if>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View BCM Office users holidays plan</title>
</head>
<body>
<section>
<form action = "view-holidays" method = "post">
	Select a year:
	<select name="year" display: inline>
		<option disabled selected value> -- select an option -- </option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
	</select>
	Select a month:
	<select name="month" display: inline>
		<option disabled selected value> -- select an option -- </option>
		<option value="January">January</option>
		<option value="February">February</option>
		<option value="March">March</option>
		<option value="April">April</option>
		<option value="May">May</option>
		<option value="June">June</option>
		<option value="July">July</option>
		<option value="August">August</option>
		<option value="September">September</option>
		<option value="October">October</option>
		<option value="November">November</option>
		<option value="December">December</option>
	</select>
	Select a user:
	<select name="username" display: inline>
		<option disabled selected value> -- select an option -- </option>
		<option value="%">***All***</option>
		<option value="u014042">Pappaianni</option>
		<option value="u023166">Beltramo</option>
		<option value="u028196">Balduzzi</option>
		<option value="u030523">Canavese</option>
		<option value="u052026">Procopio</option>
		<option value="u083744">Fratelli</option>
		<option value="u086148">Aricò</option>
		<option value="u087074">Poletti</option>
		<option value="u087940">Riccitelli</option>
		<option value="u089824">Colombini</option>
		<option value="u089927">Ceccarini</option>
		<option value="u093113">Marchetti</option>
		<option value="u301943">Varlese</option>
		<option value="u351498">Lehotai</option>
	</select>

	<input type="submit" name="getholidays" value="Get holidays" display: inline>
	
</form>
</section>
</body>
</html>

<jsp:include page="/includes/footer.jsp" />