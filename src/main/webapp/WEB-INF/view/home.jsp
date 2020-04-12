
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- TO display user roles from spring security tag library -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
	<head>
		<title>Home Page</title>
	</head>
	<body>
		<h1>Home Page</h1>
		<hr>
		
		<!-- Logged in user data cannot be accessed directly -->
		Username: <security:authentication property="principal.username"/>
		Roles: <security:authentication property="principal.authorities"/>
		
		
		<!-- Accessible to Admin -->
		<br><a href="${pageContext.request.contextPath}/admins">Admin Accessible Page</a>
		<!-- Accessible to Managers -->
		<br><a href="${pageContext.request.contextPath}/managers">Admin Accessible Page</a>
		
		<!-- We do not need to cfreate any mapping as it will be hadled by Sprin -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit"  value="Log Out">
		</form:form>
	</body>
</html>