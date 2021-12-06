<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>ParkHub | Foglalás</title>
    <link rel="stylesheet" href="res/rent_style.css">
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
					email = cookie[i].getValue();
				}
			}
		}
    	 if(oke == 1){
             
             if (request.getParameter("email") != null && 
			    request.getParameter("rendszam") != null) {
                if (!(request.getParameter("email").equals("")) &&
			!(request.getParameter("rendszam").equals(""))) {
                    //meddig, rendszam, email, parkolo_idparkolo
                    int idf = com.luv2code.jsp.FunUtils.Felhasznalo(request.getParameter("email"), "email").get(0).getId();
                    Foglalas f = new Foglalas();
                    f.setParkolohely(Integer.parseInt(idf)) f.setKezdes(); f.setMeddig(request.getParameter("meddig"));
                    f.setRendszam(request.getParameter("rendszam")); /*f.setFizetes_tranzakcio_szam();*/ f.setParkolo_idparkolo();
                    f.setFelhasznalo_idparkolo();
            }}
             
    %>
    <header>
        <img src="res/parkhub.png">
        <a class="foglalas" href="#"><button><a href="rent.html">Foglalás</a></button></a>
        <nav>
            <ul class="navlinks">
                <li><a href="garage.jsp">Garázs</a></li>
                <li><a href="tortenet.jsp">Történet</a></li>
                <li><a href="kijelentkezes.jsp">Kijelentkezés</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="kitolto">
    <form action="/rent.jsp" method="POST">
        <select>
            <option value="0" name="parkolo_idparkolo">Válassz!</option>
            <%

            
          int parkolo = com.luv2code.jsp.FunUtils.Parkolo("","").size();
            for(Parkolo p :  com.luv2code.jsp.FunUtils.Parkolo("","")){
           
        %>
            <option value="<%=p.getIdParkolo()%>"><%=p.getNev()%></option>
        <% }
            %>

        </select><br>
        <input type="date" name="meddig" placeholder="Időtartam (perc)"><br>
        <input type="text" name="rendszam" placeholder="Rendszám"><br>
        <input type="hidden" name="email" value="<%=email%>">
        <p>Összes hely: 500</p>
        <p>Szabad hely: 500</p>
        <div class="rentnow">
        <input type="submit" name="submit" value="Foglalás indítása"><br>
        </div>
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