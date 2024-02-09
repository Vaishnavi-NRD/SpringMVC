<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="u" method="post" action="save">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<form:label path="phone">Phone</form:label>
		<form:input path="phone" />
		<br>
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<br>
		<form:label path="password">Password</form:label>
		<form:input path="password" />
		<br>
		<form:button>Register</form:button>
	</form:form>
</body>
</html>