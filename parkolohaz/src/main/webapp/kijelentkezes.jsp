<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%  
        //csak akkor tud bejönni ez az oldal, ha van cookie
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        String email = "";
        int szam = 0;
		if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("email") && cookies[i].getValue() != null){
					szam = 1;
					out.println(cookies[i].getName());
				}

			}
        if(szam==1){
            javax.servlet.http.Cookie cookie3 = new javax.servlet.http.Cookie("email", null);
            response.addCookie(cookie3);
            javax.servlet.http.Cookie cookie2 = new javax.servlet.http.Cookie("jelszo", null);
            response.addCookie(cookie2);
            
        %>
        <h1>Sikeres kijelentkezés!!</h1>
         <script>
                        setTimeout(function() {
                            document.location = "index.jsp";
                        }, 1000);
                      </script>
        <%
        szam = 0;
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("email") && cookies[i].getValue() != null){
                szam = 1;
                
            } 
            
            

        }%>
        <% }
        }else{%>
            <script>
                        setTimeout(function() {
                            document.location = "index.jsp";
                        }, 1000);
                      </script>
        <% }
        
        
    %>
    
   
</body>
</html>