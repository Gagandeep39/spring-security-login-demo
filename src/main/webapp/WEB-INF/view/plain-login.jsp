<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Pge</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<br>Username: <input type="text" name="username">
	<br>Password: <input type="password" name="password">
	<br><input type="submit" value="Submit">
	</form:form>
</body>
</html>