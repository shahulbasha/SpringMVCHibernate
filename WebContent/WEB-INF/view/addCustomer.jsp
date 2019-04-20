<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Customer</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2> Customer Relationship Management</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<h3>Add Customer</h3>			
			<form:form action="processForm" modelAttribute="customer" method="POST">
				<form:hidden path="customerId"/>
				<table>
					<tbody>
						<tr>
							<td><label>First Name :</label></td>
							<td><form:input path="firstName" type="text"/></td>
						</tr>
						<tr>
							<td><label>Last Name :</label></td>
							<td><form:input path="lastName" type="text"/></td>
						</tr>
						<tr>
							<td><label>Email Id :</label></td>
							<td><form:input path="emailId" type="text"/></td>
						</tr>
						<tr>
						<td>
							<input type="submit" value="Add" class="save">
						</td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear;both;">
			</div>
			
			<p>
			<a href="${pageContext.request.contextPath}/customer/list"> Back </a>
			</p>
		</div>
	</div>
</body>
</html>