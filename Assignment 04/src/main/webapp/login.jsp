<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<%@ page import="dao.UserDaoImpl" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<div>
		<jsp:useBean id="login" class="com.sunbeam.LogInUserBean" scope="session"/>
		
		<jsp:setProperty name="login" property="email" param="email"/>
		<jsp:setProperty name="login" property="passwd" param="passwd"/>
		
		 ${login.logInUser()}
		
		<c:choose>
		<c:when test="${login.user !=null }">
		
		            <c:choose>
		                           <c:when test="${login.user.role=='admin' }">
		                           <c:redirect url="result.jsp"/>
		                           </c:when>
		                           
		                          <c:otherwise>
					     <c:redirect url="candlist.jsp"/>
				                </c:otherwise>
		
	             </c:choose>
		
		</c:when>
		
		<c:otherwise>
			<h2>Login Failed</h2>
			<p>
			Invalid email or password.
			</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
		</c:choose>
		 
		</div>
</body>
</html>