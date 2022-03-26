<%@page import="java.util.Locale, java.util.ResourceBundle"%>

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
	<%@ include file="header.jsp" %>
	
	<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle catBundle = ResourceBundle.getBundle("createCategorie");  
	String titre = catBundle.getString("titre");
	String categoryName = catBundle.getString("categories");
	String Submit = catBundle.getString("Submit");

%>
	<h1><%=titre %></h1>
	
		
	<form action="/CategorieController" method="POST">
  		<div>
			<label for="nomCat"><%=categoryName %></label>
  			<input type="text" id="nomCat" name="nomCat" required>
		</div>
	    
	   <button type="submit"><%=Submit %></button>
	</form>
</body>
</html>