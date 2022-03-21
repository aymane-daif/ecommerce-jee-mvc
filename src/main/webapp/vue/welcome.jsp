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
	<h1>Bienvenue ${ sessionScope.currentClient.prenom } dans notre site </h1>
	${ 
		!empty sessionScope.currentClient && sessionScope.currentClient.role.equals("ADMIN") 
			? 
				'
					<div>	
						<a href="/ecomm/ArticleController">Consulter les articles</a>
					</div> 
					
					<div>	
						<a href="/ecomm/CategorieController">Ajouter une nouvelle catégorie</a>
					</div>
					
					<div>	
						<a href="/ecomm/AddArticleController">Ajouter un nouveau article</a>
					</div>

				'
			: 
				!empty sessionScope.currentClient && sessionScope.currentClient.role.equals("CLIENT") 
					? 
  						'
					    	<div>	
								<a href="/ecomm/ArticleController">Consultez les articles</a>
							</div> 
						'
					:
						'
							<div>	
								<a href="/ecomm/SignInController">Déjà client?: identifiez-vous</a>
							</div>
							<div>
								<a href="/ecomm/SignUpController">Nouveau client?: inscrivez-vous</a>
							</div>
	
						' 
	}
	
</body>
</html>