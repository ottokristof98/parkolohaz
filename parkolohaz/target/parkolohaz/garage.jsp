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
    <header>
        <img src="res/parkhub.png">
        <a class="foglalas" href="#"><button><a href="rent.html">Foglalás</a></button></a>
        <nav>
            <ul class="navlinks">
                <li><a href="garage.jsp">Garázs</a></li>
                <li><a href="#">Történet</a></li>
                <li><a href="login.html">Kijelentkezés</a></li>
            </ul>
        </nav>
        
    </header>

    <div class="blocks">
        <%
        int parkolo = com.luv2code.jsp.FunUtils.Parkolo("","").size();
        if(parkolo > 0){
        for (int i = 0; i < parkolo; i++) {
        int idparkolo = Integer.parseInt(com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[0]);
        String cim = (com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[1]);
        String nev = (com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[2]);
        int osszhely = Integer.parseInt(com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[3]);
        double percdij = Double.parseDouble(com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[4]);
        double extra_percdij = Double.parseDouble(com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[5]);
        String kep = (com.luv2code.jsp.FunUtils.Parkolo("","").get(i)[6]);
        %>
        <div class="block1">
            <form>
                <div class="kepdiv">
                    <img class="kepimg" src="<%=kep%>">
                    <div class="kepoverlay">
                        <div class="leiras1">Férőhelyek száma:</div>
                    <p class="leiras2">
                        <%=osszhely%>
                        <br>
                        Szabad helyek: 150
                    </p>
                </div>
                </div>
                <h3><%=nev%></h3>
                <a class="pl1" href="#"><button>Foglalás</button></a>
            </form>
        </div>
        <% }} %>
    </div>
</body>
</html>