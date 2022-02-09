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
<form action="UserTransactionServlet" method="post">
<h1>Transaction Page</h1><br/><br/>
Account Number:<input type="text" name="AccountNumber" /><br/><br/>
Transaction Type: <select name="TransactionType">
<option>Deposit</option>
<option>Withdraw</option>
</select> <br/><br/>
Transaction Mode: <select name="TransactionMode">
<option>Cash</option>
<option>Cheque</option>
</select> <br/><br/>
Transaction Amount:<input type="text" name="TransactionAmount" /><br/><br/>
Remarks:<input type="text" name="Remarks" /><br/><br/>
<input type="submit" value="Submit" name="SUBMIT"/>
</form><br/><br/>
<a href="BankHome.jsp" class="nav-link">CLICK HERE TO NAVIGATE HOME PAGE...</a>
</body>
</html>