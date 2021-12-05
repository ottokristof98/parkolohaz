<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.luv2code.jsp.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ParkHub - Főoldal</title>
	<link rel="stylesheet" href="res/index.css">
	<link rel="stylesheet" href="res/garage_style.css">
</head>
<body>
	
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
			 <header>
        <img src="res/parkhub.png">
        <a class="foglalas" href="#"><button><a href="rent.jsp">Foglalás</a></button></a>
        <nav>
            <ul class="navlinks">
                <li><a href="garage.jsp">Garázs</a></li>
                <li><a href="tortenet.jsp">Történet</a></li>
                <li><a href="kijelentkezes.jsp">Kijelentkezés</a></li>
            </ul>
        </nav>
        
    </header>
		<%}else{ 
			
			
			%>
			<div class="kep"><img src="res/parkhub.png"></div>
			<div class="doboz">
			<div class="indexgomb"><a href="login.jsp">Bejelentkezés</a></div>
		
			<div class="indexgomb"><a href="register.jsp">Regisztráció</a></div>
			</div>
		<% }
		int parkolo = com.luv2code.jsp.FunUtils.Parkolo("","").size();
        
        
        
        for (int i = 0; i < parkolo; i++) {
			int idparkolo = Integer.parseInt(com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[0]);
		}
		%>
		
		
		
				
		
				
		
</body>
</html>
