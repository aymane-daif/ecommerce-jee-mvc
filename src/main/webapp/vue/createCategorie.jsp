<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Categorie</title>
</head>
<body class="container">
<div>
		<a href="/ecomm/WelcomeController">Retour à l'acceuil</a>
	</div>
	<h1>Créer une nouvelle catégorie</h1>
	
		
	<form action="/ecomm/CategorieController" method="POST">
  		<div>
			<label for="nomCat">Nom catégorie</label>
  			<input type="text" id="nomCat" name="nomCat" required>
		</div>
	    
	   <button type="submit">Submit</button>
	</form>
</body>
</html>