<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Sign up</title>
</head>
<body class="container">
	<h1>${ invalidUser ? 'Vous avez entré des données incorrectes. Inscrivez vous' : 'Inscrivez vous' }</h1>

	
	<form action="/ecomm/SignUpController" method="POST">
  		<div class="grid">
		    <label for="nom">
      			Nom
      			<input type="text" id="nom" name="nom" required>
    		</label>
		    <label for="prenom">
		      Prénom
		      <input type="text" id="prenom" name="prenom" required>
		    </label>
  		</div>

		<div>
			<label for="email">Email</label>
  			<input type="email" id="email" name="email" required>
		</div>
		
		<div class="grid">
		    <label for="ville">
      			Ville
      			<input type="text" id="ville" name="ville" required>
    		</label>
		    <label for="codePostal">
		      Code postal
		      <input type="number" id="codePostal" name="codePostal" required>
		    </label>
  		</div>
  		
  		<div>
			<label for="adresse">Adresse</label>
  			<input type="text" id="adresse" name="adresse" required>
		</div>
		
		<div class="grid">
		    <label for="tel">
      			Tél
      			<input type="text" id="tel" name="tel" required>
    		</label>
		    <label for="motDePasse">
		      Mot de passe
		      <input type="password" id="motDePasse" name="motDePasse" required>
		    </label>
  		</div>
  		
  		<label for="role">Role</label>
		<select id="role" name="role" required>
  			<option value="CLIENT" selected>Client</option>
  			<option value="ADMIN">Admin</option>
		</select>
	    
	   <button type="submit">Submit</button>
	</form>
</body>
</html>