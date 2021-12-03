package com.luv2code.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FunUtils{
    
    public static Connection get_data() throws ClassNotFoundException, SQLException, IOException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkolohaz", "root","");
            
        return con;
    }
    public static int Login(String email, String jelszo) throws ClassNotFoundException, SQLException, IOException{
        Connection con = get_data();
        Statement stmt = con.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE email=" + "'" + email + "' AND jelszo=" + "'" + jelszo + "';");
        int vane = 0;
        /*System.out.println("<p>");*/
        while (rs1.next()) {
                        /*System.out.println(rs1.getString(1) + ' ' + rs1.getString(2) + ' ' + rs1.getString(3) + ' ' + rs1.getString(4)
                    + "<br>");
            szov +=rs1.getString(1) + ' ' + rs1.getString(2) + ' ' + rs1.getString(3) + ' ' + rs1.getString(4)
            + "<br>";*/
            vane++;
        }
        
       
       return vane;
       
    }
    
}
