<%@ page import="dao.UserDaoImpl" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration</h1>
<jsp:useBean id="cb" class="com.sunbeam.UserBean"  scope="application"/>
<jsp:setProperty name="cb" property="firstName" param="firstName" />
<jsp:setProperty name="cb" property="lastName" param="lastName" />
<jsp:setProperty name="cb" property="email" param="email" />
<jsp:setProperty name="cb" property="password" param="password" />
<jsp:setProperty name="cb" property="birth" param="dob" />
	
${cb.registerUser()}
<c:choose>
<c:when test="${cb.count==1}">
Success: ${count}
</c:when>
<c:otherwise>
Failure: ${count}
</c:otherwise>
</c:choose>
		
</body>
</html>