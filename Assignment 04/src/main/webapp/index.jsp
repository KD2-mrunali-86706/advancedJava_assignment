<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post" action="login.jsp">
		Email : <input type="text" name="email"/><br/><br/>
		Password : <input type="password" name="passwd"/><br/><br/>
		<input type="submit" value="Login"><br/><br/>
		
	</form>
	<a href="newuser.jsp">Registration</a>
</body>
</html>