<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Register User</h2>
<form method="post" action="register.jsp">
		
		FirstName:<input type="text" name="firstName"/><br><br>
		LastName:<input type="text" name="lastName"/><br><br>
		Email: <input type="text" name="email"/> <br/><br/>
		Password: <input type="password" name="password"/> <br/><br/>
		DOB:<input type="date" name="dob"/><br><br>
		<input type="submit" value="submit"/>
		
	</form>
</body>
</html>