<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Welcome</title>
</head>
<body class="container">
	<h1>welcome ${ sessionScope.currentClient.prenom } dans notre site </h1>
	${ !empty sessionScope.currentClient && sessionScope.currentClient.role.equals("ADMIN") ? '
	<div>	
		<a href="vue/catalogue.jsp">Consultez le catalogue</a>
	</div> 
	
	<div>	
		<a href="/ecomm/CategorieController">Ajouter une nouvelle catégorie</a>
	</div>
	
	<div>	
		<a href="/ecomm/ArticleController">Ajouter un nouveau article</a>
	</div>

': !empty sessionScope.currentClient && !sessionScope.currentClient.role.equals("ADMIN") ? 
  '<div>	
		<a href="vue/catalogue.jsp">Consultez le catalogue</a>
	</div> ':'
		<div>	
			<a href="vue/signin.jsp">Déjà client?: identifiez-vous</a>
		</div>
		<div>
			<a href="vue/signup.jsp">Nouveau client?: inscrivez-vous</a>
		</div>
	
' }
	
</body>
</html>