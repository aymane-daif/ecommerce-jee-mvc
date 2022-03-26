<%@page import="ma.ensa.models.*, java.util.List,ma.ensa.config.ConnDb, java.util.Locale, java.util.ResourceBundle"%>

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
	<%@ include file="header.jsp" %>

<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("commande");  
	String titre = bundle.getString("titre");
	String title = bundle.getString("title");
	String nbArticles = bundle.getString("nbArticles");
	String totalPrice = bundle.getString("totalPrice");
%>

	
	<%
		List<Commande> commandes = (List<Commande>)request.getSession().getAttribute("commandes");
		if(commandes != null){
	%>
				<h1><%= titre %> <%= commandes.size() %> articles</h1>
	
					<table role="grid">
						<thead>
							<tr>
								<th scope="col"><%=title %></th>
								<th scope="col"><%=nbArticles %></th>
								<th scope="col"><%=totalPrice %></th>
							</tr>
						</thead>
						<tbody>
							<%
							ConnDb connDb = (ConnDb)request.getAttribute("connDb");
							for(int i=0; i< commandes.size();i++){
								Article article = Article.getArticleById(connDb, commandes.get(i).getCodeArticle());
								int qte = LigneCommande.getLigneCommandeQte(connDb, article.getCodeArticle(), commandes.get(i).getCommandeNum());
							%>
							<tr>
            					<th scope="row"><%= article.getTitre() %></th>
            					<td><%= qte %></td>
            					<td><%= article.getPrix() * qte %></td>
							</tr>
						<%	} %>
        				</tbody>
     			 </table>
			<%
		}else {
			%>
			<h1><%= titre %> 0 articles</h1>
<%	} %>
	
</body>
</html>