<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>ParkHub | Foglalás</title>
    <link rel="stylesheet" href="res/tortenet_style.css">
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
					email = cookies[i].getValue();
				}
			}
		}
    	 if(oke == 1){%>
        <header>
        <img src="res/parkhub.png">
        <a class="foglalas" href="#"><button><a href="rent.jsp">Foglalás</a></button></a>
        <nav>
            <ul class="navlinks">
                <li><a href="garage.jsp">Garázs</a></li>
                <li><a href="#">Történet</a></li>
                <li><a href="login.jsp">Kijelentkezés</a></li>
            </ul>
        </nav>
        </header>    
        <div class="row">
		

		<div class="container">
			<h2 class="text-center">Foglalások</h2>
			<hr>
			
			<br>
			<table class="content_table">
				<thead>
					<tr>
						<th>Parkoló</th>
						<th>Foglalás kezdete</th>
						<th>Rendszám</th>
						<th>Állapot</th>
                                                
					</tr>
				</thead>
				<tbody>
                <%  
                    int szam = com.luv2code.jsp.FunUtils.Foglalas(com.luv2code.jsp.FunUtils.Felhasznalo(email,"email").get(0).getId().valueOf(),"felhasznalo_idfelhasznalo").size();
                    if(szam>1){%>
					<tr>
                      <th>Pécs Árkád</th>
                      <th>2021.06.15 23:12</th>
                      <th>asd-123</th>
                      <th>Aktív</th>
                      <th class="paybutton"><a href="">FIZETÉS</a></th>
					</tr>
					
				<% }else{ %>
                    Üres a foglalási történeted!
                <%} %>
				</tbody>

			</table>
		</div>
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
