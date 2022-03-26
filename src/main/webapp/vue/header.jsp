<%@page import="java.util.Locale, java.util.ResourceBundle"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  Locale.setDefault(new Locale("en", "US"));
	ResourceBundle bundle = ResourceBundle.getBundle("header");  
	String linkBackWelcome = bundle.getString("linkBackWelcome");

%>
	<div>
		<a href="/WelcomeController"><%=linkBackWelcome %></a>
	<div>