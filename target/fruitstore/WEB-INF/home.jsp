<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body>

	<h1> Bienvenue chez fruitsotre</h1>
	<p>${message}</p>
	<p><%= request.getAttribute("message") %></p>
	<p>{{requestScope.message}</p>
</body>
</html>