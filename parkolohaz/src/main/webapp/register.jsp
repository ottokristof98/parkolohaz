<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Parkolóház - Regisztráció</title>
     <%@ page import="java.util.List" %>
    <%@ page import="com.luv2code.jsp.*" %>
    <link rel="stylesheet" href="res/register_style.css">
</head>
<body>
<div id="box">
      <% 
          String vanehiba = "";
          String nincshiba = "";
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
    if(oke != 1){

      //if(sikeres_reg == 1)
      //nev, email, cim, szuletes, telefon, jelszo1, jelszo2
        if (request.getParameter("nev") != null && 
			   request.getParameter("email") != null) {
                if (!(request.getParameter("nev").equals("")) &&
			!(request.getParameter("email").equals(""))) {
                String nev = request.getParameter("nev");
                String email = request.getParameter("email");
                String cim = request.getParameter("cim");
                String szuletes = request.getParameter("szuletes");
                String telefon = request.getParameter("telefon");
                String jelszo1 = request.getParameter("jelszo1");
                String jelszo2 = request.getParameter("jelszo2");
                String[] s = new String[7];
                  s[0] = nev; s[1] = email; s[2] = cim; s[3] = szuletes; s[4] = telefon;
                  s[5] = jelszo1; s[6] = jelszo2;
                 vanehiba = com.luv2code.jsp.FunUtils.Regisztracio(nev, email, cim, szuletes, telefon, jelszo1, jelszo2);
                 if(vanehiba.equals("Sikeres regisztráció!")){
                   nincshiba = vanehiba;
                   vanehiba = "";
                   javax.servlet.http.Cookie cookie3 = new javax.servlet.http.Cookie("email", email);
                        response.addCookie(cookie3);
                        javax.servlet.http.Cookie cookie2 = new javax.servlet.http.Cookie("jelszo", jelszo1);
                        response.addCookie(cookie2);
                %>
                <script>
                        setTimeout(function() {
                            document.location = "index.jsp";
                        }, 1000);
                      </script>
                <%   
                 }else{
                   nincshiba = "";
                 }
                
                
      %>
      <%}else{
        vanehiba = "Töltsd ki az összes mezőt rendesen!";
      }
      }
       %>
    <div class="register_box">
        <img src="res/avatar.png" class="avatar">
        <h1>Regisztráció</h1>
        <p id="vanehiba"><% out.println(vanehiba); %></p>
        <p id="nincshiba"><% out.println(nincshiba); %></p>
            <form name="myForm" action="register.jsp" method="POST" onsubmit="return validateForm()">
                <p>Név:</p>
                <input type=text name="nev" placeholder="Add meg a Nevedet!">
                <p>E-mail cím:</p>
                <input type=text name="email" placeholder="Add meg a E-mail címedet!">
                <p>Lakcím:</p>
                <input type=text name="cim" placeholder="Add meg a lakcímedet">
                <p>Születési dátum:</p>
                <input type="date" id="birthday" name="szuletes">
                <input type="text" id="telefon" name="telefon" placeholder="Telefonszám">
                
                <p>Jelszó:</p>
                <input type="password" name="jelszo1" placeholder="Jelszó (1)">
                <input type="password" name="jelszo2" placeholder="Jelszó (2)"><br>
                <input type="submit" name="submit" value="Regisztráció" ><br>
                <a href="login.html">Ha már tag vagy, itt jelentkezhetsz be.</a>

            </form>
    </div>
    </div>
    
    <%  } else{ 
    String redirectURL = "index.jsp";
    response.sendRedirect(redirectURL);
    }%>
</body>
</html>