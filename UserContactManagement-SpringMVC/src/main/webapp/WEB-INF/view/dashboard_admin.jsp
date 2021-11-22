<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.topnav {
  background-color: #064653;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
<s:url var="url_logout" value="/logout"/>
	<c:if test="${sessionScope.userid!=null && sessionScope.role==1}">
	<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#news">All Users</a>
  <a href="${url_logout}">Logout</a>
  </div>
	</c:if>

	<h1>Admin Dashboard</h1>
</body>
</html>