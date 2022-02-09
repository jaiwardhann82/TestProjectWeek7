<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank User Login Detail</title>
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
<h1>User Login Page</h1>
        <%-- The form data will be passed to acceptuser.jsp 
             for validation on clicking submit
        --%> 
        <form method ="get" action="AcceptUser.jsp">
            Enter Username : <input type="text" name="user"><br/><br/>
            Enter Password : <input type="password" name ="pass"><br/><br/>
                <input type ="submit" value="SUBMIT" name ="SUBMIT">    
        </form>
</body>
</html>