<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<style>
.failed{
color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Pge</title>
</head>
<body>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.error !=null }">
	<i class="failed">Invalid username or password</i>
</c:if>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<br>Username: <input type="text" name="username">
	<br>Password: <input type="password" name="password">
	<br><input type="submit" value="Submit">
	</form:form>
</body>
</html>