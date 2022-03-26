<%@page import="ma.ensa.models.*, java.util.List, java.util.Locale, java.util.ResourceBundle"%>
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
	<%@ include file="header.jsp" %>

<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("createArticle");  
	String titre = bundle.getString("titre");
	String title = bundle.getString("title");
	String designation = bundle.getString("designation");	
	String price = bundle.getString("price");
	String categories = bundle.getString("categories");
	String Submit = bundle.getString("Submit");

%>
	<h1><%=titre %></h1>
	
		
	<form action="/ArticleController" method="POST">
  		<div class="grid">
  			<label for="titre">
		      <%=title %>
		      <input type="text" id="titre" name="titre" required>
		    </label>
		    <label for="designation">
      			<%=designation %>
      			<input type="text" id="designation" name="designation" required>
    		</label>
  		</div>
		
		<div class="grid">
		    <label for="prix">
      			<%=price %>
      			<input type="text" id="prix" name="prix" required>
    		</label>
		    <label for="stock">
		      Stock
		      <input type="number" id="stock" name="stock" required>
		    </label>
  		</div>
  		
  		<label for="categorie"><%=categories %></label>
		<select name="categorie" id="categorie" required>
			<%
			List<Categorie> allCategories = (List<Categorie>)request.getAttribute("categories");
				for(int i=0; i< allCategories.size();i++){
					%>
				<option value="<%= allCategories.get(i).getRefCat() %>"><%= allCategories.get(i).getNomCat() %></option>
					
			<%	}
				%>
		</select>
		
		
	    
	   <button type="submit"><%= Submit%> </button>
	</form>
</body>
</html>