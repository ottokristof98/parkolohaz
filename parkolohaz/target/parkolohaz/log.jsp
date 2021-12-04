<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Document</title>
    <%@ page import="java.util.List" %>
    <%@ page import="com.luv2code.jsp.*" %>
</head>
<body>
    <% 
        
        
        
            if (request.getParameter("nev") != null && 
			   request.getParameter("nev") != null) {
                if (!(request.getParameter("nev").equals("")) &&
			!(request.getParameter("nev").equals(""))) {
                String nev = request.getParameter("nev");
                String jelszo = request.getParameter("jelszo");
                

                %>
    
       
                <% 
                    if(com.luv2code.jsp.FunUtils.Login(nev, jelszo) == 1){ %>
                        Sikeres bejelentkezés! <br> Átírányítás a főoldalra...
                        <% javax.servlet.http.Cookie cookie3 = new javax.servlet.http.Cookie("email", nev);
                        response.addCookie(cookie3);
                        javax.servlet.http.Cookie cookie2 = new javax.servlet.http.Cookie("jelszo", jelszo);
                        response.addCookie(cookie2);
                        out.println(com.luv2code.jsp.FunUtils.Login("",""));
                        
                        Cookie[] cookies = request.getCookies();
                        Cookie cookie = null;
                        int oke = 0;
                        if (cookies != null) {
                            for (int i = 0; i < cookies.length; i++) {
                                
                                out.println(cookies[i].getName());
                            }
                    
                        }
                        %>
                <% }else{ %>
                    Rossz felhasználónév vagy jelszó! Próbálkozzon újra!!!!!!!
                    out.println(com.luv2code.jsp.FunUtils.Login("",""));
                    <script>
                        setTimeout(function() {
                            document.location = "login.html";
                        }, 1000); // <-- this is the delay in milliseconds
                      </script>
                <% } %>
       
    <% }
            }
    %>
</body>
</html>