<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Home</title>
</head>
<body class="container">
	<h1>welcome ${param.email} </h1>
	<div>	
		<a href="vue/catalogue.jsp">Consultez le catalogue</a>
	</div>
	
	<div>	
		<a href="/ecomm/CategorieController">Ajouter une nouvelle catégorie</a>
	</div>
	
	<div>	
		<a href="/ecomm/ArticleController">Ajouter un nouveau article</a>
	</div>
</body>
</html>