<%@ page import="java.util.Locale, java.util.ResourceBundle, ma.ensa.models.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Bienvenue</title>
</head>
<body class="container">

<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("welcome");  
	String welcome = bundle.getString("welcome");
	String titre = bundle.getString("titre");
	String linkArticles = bundle.getString("linkArticles");
	String linkAddCategory = bundle.getString("linkAddCategory");
	String linkAddArticle = bundle.getString("linkAddArticle");
	String linkSignIn = bundle.getString("linkSignIn");
	String linkSignUp = bundle.getString("linkSignUp");

%>
	<% Client currentClient = (Client)request.getSession().getAttribute("currentClient"); %>
	
	
	
	<%
		
		if(currentClient != null && currentClient.getRole().equals("ADMIN")){
			%>
				<h1><%= welcome %> <%= currentClient.getPrenom() %> <%= titre %> </h1>
				
					<div>	
						<a href="/ArticleController"><%= linkArticles %></a>
					</div> 
					
					<div>	
						<a href="/CategorieController"><%= linkAddCategory %></a>
					</div>
					
					<div>	
						<a href="/AddArticleController"><%= linkAddArticle %></a>
					</div>
					<% 
		}else if(currentClient != null && currentClient.getRole().equals("CLIENT")){
		%>
			<div>	
				<a href="/ArticleController"><%= linkArticles %></a>
			</div> 
			
		<% }else {
			%>
				<h1><%= welcome %> <%= titre %> </h1>
			
				<div>	
					<a href="/SignInController"><%= linkSignIn %></a>
				</div>
				<div>
					<a href="/SignUpController"><%= linkSignUp %></a>
				</div>
	<% 	} %>
	
	
</body>
</html>