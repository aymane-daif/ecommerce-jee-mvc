<%@page import="ma.ensa.models.Article, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Articles</title>
</head>
<body class="container">
	<%@ include file="header.jsp" %>

	<h1>Liste des articles</h1>
	<a href="/CommandeController">Go to panier</a>
		<table role="grid">
		<thead>
			<tr>
				<th scope="col">Categorie</th>
				<th scope="col">Titre</th>
				<th scope="col">Stock</th>
				<th scope="col">Prix</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
		
			<%
			List<Article> articles = (List<Article>)request.getAttribute("articles");
				for(int i=0; i< articles.size();i++){
					%>
					<tr>
            			<th scope="row"><%= articles.get(i).getCategorie().getNomCat() %></th>
            			<td><%= articles.get(i).getTitre() %></td>
            			<td><%= articles.get(i).getStock() %></td>
            			<td><%= articles.get(i).getPrix() %></td>
            			<td>
            				<form action="/CommandeController" method="POST">
            					<input type="hidden" name="codeArticle" value="<%= articles.get(i).getCodeArticle() %>" />
            					<button type="submit" class="outline">Ajouter au panier</button>
           					</form>
            			</td>
					</tr>
					
			<%	}
				%>
			
			
        </tbody>
      </table>
	
</body>
</html>