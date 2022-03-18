<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Sign in</title>
</head>
<body class="container">
	<h1>Identifiez vous</h1>
	
		<form action="/ecomm/SignInController" method="POST">
			<div>
				<label for="email">Email</label>
	  			<input type="email" id="email" name="email" required>
			</div>
	  		
	  		<div>
				<label for="motDePasse">Mot de passe</label>
	  			<input type="password" id="motDePasse" name="motDePasse" required>
			</div>
		    
		   <button type="submit">Submit</button>
	</form>
</body>
</html>