<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>



<body>
<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
<div>
<a href="https://www.javaguides.net" class="navbar-brand"> Customer Management App </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Customers</a></li>
</ul>
</nav>



</header>
<br>
<div class="container col-md-5">
<div class="card">
<div class="card-body">
<c:if test="${user != null}">
<form action="update" method="post">
</c:if>
<c:if test="${user == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${user != null}">
Edit User
</c:if>
<c:if test="${user == null}">
Add New User
</c:if>
</h2>
</caption>



<c:if test="${user != null}">
<input type="hidden" name="oriName" value="<c:out value='${user.name}' />" />
</c:if>
<fieldset class="form-group">
<label>Customer Name</label> <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
</fieldset>
<fieldset class="form-group">
<label>DOB</label> <input type="text" value="<c:out value='${user.dob}' />" class="form-control" name="dob">
</fieldset>

<fieldset class="form-group">
<label>IdentficationType</label> <input type="text" value="<c:out value='${user.identification}' />" class="form-control" name="identification">
</fieldset>
<fieldset class="form-group">
<label> Address</label> <input type="text" value="<c:out value='${user.address}' />" class="form-control" name="address">
</fieldset>
<fieldset class="form-group">
<label> Mobile</label> <input type="text" value="<c:out value='${user.mobile}' />" class="form-control" name="mobile">
</fieldset>
<fieldset class="form-group">
<label> EmailID</label> <input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email">
</fieldset>
<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>