<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2> Customer Relationship Management</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	<div class=".add-button">
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button">
	</div>
	<div>
		<form:form action="searchForm" method="GET">
			Search Customer : <input type="text" placeholder="Name" name="searchName">
			<input type="submit" value="Search" class="add-button">
		</form:form>
	</div>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
			<c:url var="updateCustomerLink" value="showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.customerId}"></c:param>
			</c:url>
			<c:url var="deleteLink" value="deleteCustomer">
				<c:param name="customerId" value="${tempCustomer.customerId}"></c:param>
			</c:url>
			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.emailId}</td>
				<td><a href="${updateCustomerLink}">Update</a> | <a href="${deleteLink}" onclick="return confirm('Are you sure you want to delete the customer ${tempCustomer.firstName}?');">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>