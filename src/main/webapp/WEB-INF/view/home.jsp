
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Home Page</title>
	</head>
	<body>
		<h1>Home Page</h1>
		<hr>
		<!-- We do not need to cfreate any mapping as it will be hadled by Sprin -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit"  value="Log Out">
		</form:form>
	</body>
</html>