<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>

<title>Connectez-vous</title>

</head>
<body>

<h1>Login utilisateur</h1>

	
		<div class="alert alert-danger">  <h:outputText value="#{errorMessage)}"/>  </div>


	
	
	
	<form class="bg-blue" method="POST" action="login">
	<label>Utilisateur</label>
	<input type="text" name="username"></input>
	
	<label>Mot de passe</label>
	<input type="password" name="password"></input>
	
	<button type="submit" class="btn btn-primary">Se connecter</button>
	
	</form>
	
	

</body>
</html>