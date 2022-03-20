<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Commande</title>
</head>
<body class="container">
	<h1>You have ${ sessionScope.commande.articles.size() } products </h1>
	<p>${ sessionScope.commande.articles.size() > 1 ? sessionScope.commande.articles.get(1).getTitre():  sessionScope.commande.articles.get(0).getTitre() }</p>
</body>
</html>