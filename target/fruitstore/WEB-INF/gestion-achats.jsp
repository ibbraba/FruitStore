<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />

<title>Gestion achats</title>

</head>
<body>

	<header class="bg-warning">
		<p><%=session.getAttribute("nom")%>
			<%=session.getAttribute("prenom")%>
		</p>

	</header>

	<div class="container">
		<h1>Gestion des achats</h1>

	</div>



	<a class="btn btn-danger" href="logout"> Se Deconnecter </a>


</body>
</html>