<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
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

<form action="UserRegisterServlet" method="post">
<h1>Customer Registration Detail</h1><br/><br/>
Customer Name:<input type="text" name="CustomerName"/><br/><br/>
DOB:<input type="text" name="DOB" /><br/><br/>
Identification Type: <select name="IdentficationType">
<option>Passport</option>
<option>SSN</option>
<option>FIN</option>
</select> <br/><br/>
Identification Number:<input type="text" name="IdentificationNumber"/><br/><br/>
Address:<input type="text" name="Address" /><br/><br/>
Mobile Number:<input type="text" name="MobileNumber" /><br/><br/>
Email ID:<input type="text" name="EmailID" /><br/><br/>
Occupation:<input type="text" name="Occupation" /><br/><br/>
Account Type: <select name="AccountType">
<option>Saving</option>
<option>Current</option>
</select> <br/><br/>
Account Number:<input type="text" name="AccountNumber" /><br/><br/>

<input type="submit" value="Submit" name="SUBMIT"/>
</form>
<br/><br/>
<a href="BankHome.jsp" class="nav-link">CLICK HERE TO NAVIGATE HOME PAGE...</a>
</body>
</html>