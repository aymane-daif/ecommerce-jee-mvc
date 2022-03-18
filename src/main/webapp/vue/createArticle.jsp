<%@page import="ma.ensa.models.Categorie, java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Article</title>
</head>
<body class="container">
	<h1>Créer un nouveau article</h1>
	
		
	<form action="/ecomm/ArticleController" method="POST">
  		<div class="grid">
  			<label for="titre">
		      Titre
		      <input type="text" id="titre" name="titre" required>
		    </label>
		    <label for="designation">
      			Désignation
      			<input type="text" id="designation" name="designation" required>
    		</label>
  		</div>
		
		<div class="grid">
		    <label for="prix">
      			Prix
      			<input type="text" id="prix" name="prix" required>
    		</label>
		    <label for="stock">
		      Stock
		      <input type="number" id="stock" name="stock" required>
		    </label>
  		</div>
  		
  		<label for="categorie">Categories</label>
		<select name="categorie" id="categorie" required>
			<%
			List<Categorie> categories = (List<Categorie>)request.getAttribute("categories");
				for(int i=0; i< categories.size();i++){
					%>
				<option value="<%= categories.get(i).getRefCat() %>"><%= categories.get(i).getNomCat() %></option>
					
			<%	}
				%>
		</select>
		
		
	    
	   <button type="submit">Submit</button>
	</form>
</body>
</html>