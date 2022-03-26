<%@ page import="java.util.Locale, java.util.ResourceBundle, ma.ensa.models.*" %>
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
	<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("signup");  
	String inValid = bundle.getString("inValid");
	String valid = bundle.getString("valid");
	String firstName = bundle.getString("firstName");
	String lastName = bundle.getString("lastName");
	String Email = bundle.getString("Email");
	String City = bundle.getString("City");
	String Zip = bundle.getString("Zip");
	String Address = bundle.getString("Address");
	String Tel = bundle.getString("Tel");
	String Password = bundle.getString("Password");
	String Submit = bundle.getString("Submit");
%>
	<%
		if((Boolean)request.getAttribute("invalidUser")){
			%>
			<h1><%= inValid %></h1>
		<% }else {
			%> <h1><%= valid %></h1>
		<% }
	%>

	
	<form action="/SignUpController" method="POST">
  		<div class="grid">
		    <label for="nom">
      			<%= firstName %>
      			<input type="text" id="nom" name="nom" required>
    		</label>
		    <label for="prenom">
		      <%= lastName %>
		      <input type="text" id="prenom" name="prenom" required>
		    </label>
  		</div>

		<div>
			<label for="email"><%= Email %></label>
  			<input type="email" id="email>" name="email" required>
		</div>
		
		<div class="grid">
		    <label for="ville">
      			<%=City%>
      			<input type="text" id="ville" name="ville" required>
    		</label>
		    <label for="codePostal">
		      <%=Zip %>
		      <input type="number" id="codePostal" name="codePostal" required>
		    </label>
  		</div>
  		
  		<div>
			<label for="adresse"><%=Address %></label>
  			<input type="text" id="adresse" name="adresse" required>
		</div>
		
		<div class="grid">
		    <label for="tel">
      			<%=Tel %>
      			<input type="text" id="tel" name="tel" required>
    		</label>
		    <label for="motDePasse">
		      <%=Password %>
		      <input type="password" id="motDePasse" name="motDePasse" required>
		    </label>
  		</div>
  		
  		<label for="role">Role</label>
		<select id="role" name="role" required>
  			<option value="CLIENT" selected>Client</option>
  			<option value="ADMIN">Admin</option>
		</select>
	    
	   <button type="submit"><%=Submit %></button>
	</form>
</body>
</html>