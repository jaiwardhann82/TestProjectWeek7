<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="RegisterServlet" method="post">

Name:<input type="text" name="userName"/><br/>
ID:<input type="text" name="password"/><br/>
Email Id:<input type="text" name="email" /><br/>
language: <select name="language">
<option>Canadian</option>
<option>English</option>
<option>French</option>
</select> <br/>
<input type="submit" value="Submit"/>
</form>

</body>
</html>