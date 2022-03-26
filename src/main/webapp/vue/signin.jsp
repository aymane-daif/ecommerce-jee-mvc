<%@ page import="java.util.Locale, java.util.ResourceBundle, ma.ensa.models.*" %>
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
	<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("signin");  
	String SignIn = bundle.getString("SignIn");
	String Password = bundle.getString("Password");
	String Submit = bundle.getString("Submit");
%>
	<h1><%=SignIn %></h1>
	
		<form action="/SignInController" method="POST">
			<div>
				<label for="login">Login</label>
	  			<input type="text" id="login" name="login" required>
			</div>
	  		
	  		<div>
				<label for="password"><%=Password %></label>
	  			<input type="password" id="password" name="password" required>
			</div>
		    
		   <button type="submit"><%=Submit%></button>
	</form>
</body>
</html>