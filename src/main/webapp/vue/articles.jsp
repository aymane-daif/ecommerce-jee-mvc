<%@page import="ma.ensa.models.*, java.util.List, java.util.Locale, java.util.ResourceBundle"%>
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
	
	<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("articles");  
	String titre = bundle.getString("titre");
	String linkToShoppingCart = bundle.getString("linkToShoppingCart");
	String category = bundle.getString("category");
	String title = bundle.getString("title");
	String price = bundle.getString("price");
	String addToShoppingCart = bundle.getString("addToShoppingCart");

%>

	<h1><%=titre %></h1>
	<a href="/CommandeController"><%=linkToShoppingCart %></a>
		<table role="grid">
		<thead>
			<tr>
				<th scope="col"><%= category %></th>
				<th scope="col"><%= title %></th>
				<th scope="col">Stock</th>
				<th scope="col"><%= price %></th>
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
            					<button type="submit" class="outline"><%=addToShoppingCart %></button>
           					</form>
            			</td>
					</tr>
					
			<%	}
				%>
			
			
        </tbody>
      </table>
	
</body>
</html>