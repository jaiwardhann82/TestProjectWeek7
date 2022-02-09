<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management</title>
<style>
body{
background-image: url("Test.jpg");
background-size: cover;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
}
</style>
</head>
<body bgcolor="skyblue"> 

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Customer Management App </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/CustomerServlet/list" class="nav-link">Customers</a></li>
					
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/UsersRegistration.jsp"
					class="btn btn-success">Add New Customer</a>
			</div>
			<br>
			 <table class="table table-bordered">
				<thead>
					<tr>
					
						<th>Name</th>
						<th>DOB</th>
						<th>Identification</th>
						<th>Address</th>
						<th>Mobile</th>
						<th>Email</th>
						<!-- below line commented by jai-->
						<!-- <th>Actions</th>-->
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="user" items="${listUser}">
						<script>
							console.log("${user.name}");
							console.log("comes here");
						</script>
						<tr>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.dob}" /></td>
							<td><c:out value="${user.identification}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.mobile}" /></td>
							<td><c:out value="${user.email}" /></td>
							<!-- Below line commented by Jai-->
							<!-- <td><a href="edit?name=<c:out value='${user.name}' />">Edit</a>	&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?name=<c:out value='${user.name}' />">Delete</a></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
<br/><br/>
<a href="BankHome.jsp" class="nav-link">CLICK HERE TO NAVIGATE HOME PAGE...</a>
</body>
</html>