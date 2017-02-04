<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html>
<head>
    <meta charset="utf-8">
    <title>Smart Working app</title>
    <link rel="shortcut icon" href="<c:url value='/images/favicon.png'/>">
    <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
<!--     <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
</head>

<body>

    <header>
        <img src="<c:url value='/images/SmartWorking_logo.jpg'/>" 
             alt="Smart Working Logo" width="58">
        <h1>Smart Working application</h1>
        <h2>Plan your working days from home!</h2>
    </header>
    <nav id="nav_bar">
        <ul>
            <li><a href="<c:url value='/deleteCookies'/>">
                    Delete Cookies</a></li>

        </ul>
    </nav>