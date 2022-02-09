<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate User</title>
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

<h1>Verifying Details</h1>
        <%-- Include the ValidateUser.java class whose method 
             boolean validate(String, String) we will be using
        --%>
        <%-- Create and instantiate a bean and assign an id to 
             uniquely identify the action element throughout the jsp
        --%>
        <jsp:useBean id="snr" class="WebPageTesting.ValidateUser"/>
          
        <%-- Set the value of the created bean using form data --%>
        <jsp:setProperty name="snr" property="user"/>
        <jsp:setProperty name="snr" property="pass"/>
          
        <%-- Display the form data --%>
        The Details Entered Are as Under<br/>
        <p>Username : <jsp:getProperty name="snr" property="user"/></p>
        <p>Password : <jsp:getProperty name="snr" property="pass"/></p>
          
        <%-- Validate the user using the validate() of 
             ValidateUser.java class
        --%>
        <%if(snr.validate("jai", "wardhan")){%>
            Welcome! You are a VALID USER<br/>
            <br><br>
            <a href="BankHome.jsp" class="nav-link">CLICK HERE FOR MORE ACTIONS...</a>
            
        <%}else{%>
            Error! You are an INVALID USER<br/><br/><br/>
            <a href="BankLogin.jsp" class="nav-link">Retry Login...</a>
        <%}%>  
</body>
</html>