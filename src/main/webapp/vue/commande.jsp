<%@page import="ma.ensa.models.*,ma.ensa.config.ConnDb, java.util.List"%>

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
	<h1>You have ${ sessionScope.commandes.size() } products </h1>
	
	<table role="grid">
		<thead>
			<tr>
				<th scope="col">Titre</th>
				<th scope="col">Nombre d'articles</th>
				<th scope="col">Prix total</th>
			</tr>
		</thead>
		<tbody>
		
			<%
			ConnDb connDb = (ConnDb)request.getAttribute("connDb");
			List<Commande> commandes = (List<Commande>)request.getSession().getAttribute("commandes");
				for(int i=0; i< commandes.size();i++){
					Article article = Article.getArticleById(connDb, commandes.get(i).getCodeArticle());
					int qte = LigneCommande.getLigneCommandeQte(connDb, article.getCodeArticle(), commandes.get(i).getCommandeNum());
					%>
					<tr>
            			<th scope="row"><%= article.getTitre() %></th>
            			<td><%= qte %></td>
            			<td><%= article.getPrix() * qte %></td>
					</tr>
			<%	}
				%>
			
			
        </tbody>
      </table>
	
</body>
</html>