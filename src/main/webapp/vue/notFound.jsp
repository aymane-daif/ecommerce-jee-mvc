
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Not found</title>
</head>
<body class="container">
		<%@ include file="header.jsp" %>
<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle nFbundle = ResourceBundle.getBundle("header");  
	String titre = nFbundle.getString("titre");

%>
	<h1><%= titre %></h1>

</body>
</html>