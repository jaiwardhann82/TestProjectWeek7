<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
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
<body bgcolor="lightgreen">
<form action="UserFeedBackServlet" method="post">
<h1>Customer Feedback Page</h1><br/><br/>
Name:<input type="text" name="Name" /><br/><br/>
Mobile:<input type="text" name="Mobile" /><br/><br/>
Email:<input type="text" name="Email" /><br/><br/>
Customer Service Helpful: <select name="CustomerServiceHelpful">
<option>Yes</option>
<option>No</option>
</select> <br/><br/>
Customer Service Knowledge: <select name="CustomerServiceKnowledge">
<option>Poor</option>
<option>Fair</option>
<option>Good</option>
<option>Excellent</option>
</select> <br/><br/>
Communication Of Service Offered: <select name="CommunicationOfServiceOffered">
<option>Poor</option>
<option>Fair</option>
<option>Good</option>
<option>Excellent</option>
</select> <br/><br/>
Problem Resolution: <select name="ProblemResolution">
<option>Poor</option>
<option>Fair</option>
<option>Good</option>
<option>Excellent</option>
</select> <br/><br/>
Remarks:<input type="text" name="Remarks" /><br/><br/>
<input type="submit" value="Submit"/>
</form><br/><br/>
<a href="BankHome.jsp" class="nav-link">CLICK HERE TO NAVIGATE HOME PAGE...</a>
</body>
</html>