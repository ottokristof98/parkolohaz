<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ParkHub | Garázs</title>
    <link rel="stylesheet" href="res/garage_style.css">
    <%@ page import="com.luv2code.jsp.*" %>
</head>
<body>
<% 
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		int oke = 0;
        String email = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("email") && cookies[i].getValue() != ""){
					oke = 1;
					//email = cookie[i].getValue();
				}
			}
		}
    	 if(oke == 1){%>
    <header>
        <img src="res/parkhub.png">
        <a class="foglalas" href="#"><a href="rent.jsp">Foglalás</a></a>
        <nav>
            <ul class="navlinks">
                <li><button><a href="garage.html">Garázs</a></button></li>
                <li><a href="tortenet.html">Történet</a></li>
                <li><a href="kijelentkezes.jsp">Kijelentkezés</a></li>
            </ul>
        </nav>
        
    </header>

    <div class="blocks">
        <%

        
          int parkolo = com.luv2code.jsp.FunUtils.Parkolo("","").size();
        if(parkolo > 0){
            for(Parkolo p :  com.luv2code.jsp.FunUtils.Parkolo("","")){
           
        %>
        <div class="block1">
            <form>
                <div class="kepdiv">
                    <img class="kepimg" src="<%=p.getKep()%>">
                    <div class="kepoverlay">
                        <div class="leiras1">Férőhelyek száma:</div>
                    <p class="leiras2">
                        <%=p.getOsszhely()%>
                        <br>
                        Szabad helyek: 150
                    </p>
                </div>
                </div>
                <h3><%=p.getNev()%></h3>
                <a href="/rent.jsp" class="pl1" href="#"><button>Foglalás</button></a>
            </form>
        </div>
        <% }}else{
            out.println("Jelenleg nincs egy parkoló sem.");
        }  %>
    </div>
    <%}else{ %>
    <script>
                        setTimeout(function() {
                            document.location = "index.jsp";
                        }, 1000);
                      </script>
   <% } %>
</body>
</html>