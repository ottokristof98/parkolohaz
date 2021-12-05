<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Parkolóház - Bejelentkezés</title>
    <link rel="stylesheet" href="res/login_style.css">  
    <%@ page import="java.util.List" %>
    <%@ page import="com.luv2code.jsp.*" %>
</head>
<body>
    <%
    String bej = "";
    Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		int oke = 0;
		if (cookies != null) { //ha van cookie
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("email") && cookies[i].getValue() != ""){
					oke = 1;
				}
			}
		}
        if(oke == 1){ //ha van cookie
            String redirectURL = "index.jsp";
            response.sendRedirect(redirectURL);
        
    }else{ //ha nincs cookie 
        //ha van POST["email"] és jelszo
        if (request.getParameter("email") != null && 
			    request.getParameter("jelszo") != null) {
                if (!(request.getParameter("email").equals("")) &&
			!(request.getParameter("jelszo").equals(""))) {
                String email = request.getParameter("email");
                String jelszo = request.getParameter("jelszo");
                if(com.luv2code.jsp.FunUtils.Login(email, jelszo) == 1){ %>
                        <% javax.servlet.http.Cookie cookie3 = new javax.servlet.http.Cookie("email", email);
                        response.addCookie(cookie3);
                        javax.servlet.http.Cookie cookie2 = new javax.servlet.http.Cookie("jelszo", jelszo);
                        response.addCookie(cookie2);
                        bej = "Sikeres bejelentkezés"; %>
                        <script>
                        setTimeout(function() {
                            document.location = "index.jsp";
                        }, 1000);
                      </script>
                        <% }else{
                            bej = "Sikertelen bejelentkezés";
                        }
    %>
    
    
    <% } } //ha nincs POST még
        %>
            <div class="login_box">
        <img src="./res/avatar.png" class="avatar">
        <h1>Bejelentkezés</h1>
        <p id="bej"><% out.println(bej); %></p>
            <form action="login.jsp" method="POST">
                <p>E-mail:</p>
                <input type=text name="email" placeholder="Add meg az e-mail címedet!">
                <p>Jelszó:</p>
                <input type="password" name="jelszo" placeholder="Add meg az jelszavadat!"><br>
                <input type="submit" name="submit" value="Bejelentkezés"><br>
                <a href="">Elfelejtetted a jelszavad?</a><br>
                <a href="register.jsp">Itt tudsz regisztrálni, ha még nem vagy tag.</a>
            </form>
    </div>
    <%
    }%>
</body>
</html>