<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.luv2code.jsp.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ParkHub - Főoldal</title>
</head>
<body>
	<h1>ParkHub</h1>
	
	
	
	<% 
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		int oke = 0;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("email") && cookies[i].getValue() != ""){
					oke = 1;
					
				}
			}
		}
    	 if(oke == 1){ %>
			//Bejelentkezett oldal
		<a href="kijelentkezes.jsp">Kijelentkezés</a>
		<%}else{ 
			
			
			%>
			
			<a href="login.html">Bejelentkezés</a>
			<br>
			<a href="register.html">Regisztráció</a>
		<% }
		
		%>
		
		
		
				
		
				
		
</body>
</html>
