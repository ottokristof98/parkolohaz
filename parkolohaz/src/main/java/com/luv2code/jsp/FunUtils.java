package com.luv2code.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public static List<String[]> Parkolo(String mit, String mi) throws SQLException, ClassNotFoundException, IOException{
        Connection con = get_data();
        Statement stmt = con.createStatement();
        List<String[]> eredmeny = new ArrayList<String[]>();
        String[] tomb = new String[7];
        int nem = 0;
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM parkolo;");
        if(mi == "idparkolo"){
             rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE idparkolo=" + "'" + mit + "';");
        }else if(mi == "cim"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE cim=" + "'" + mit + "';");
        }else if(mi == "nev"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE nev=" + "'" + mit + "';");
        }else if(mi == "osszhely"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE oszhely=" + "'" + mit + "';");
        }else if(mi == "percdij"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE percdij=" + "'" + mit + "';");
        }else if(mi == "extra_percdij"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE extra_percdij=" + "'" + mit + "';");
        }else if(mi == "kep"){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo WHERE kep=" + "'" + mit + "';");
        }else if(mi == ""){
            rs1 = stmt.executeQuery("SELECT * FROM parkolo;");
        }
        else{
            nem = 1;
        }
        if(nem != 1){
        while (rs1.next()) {
            tomb[0] = rs1.getString(1);tomb[1] = rs1.getString(2);tomb[2] = rs1.getString(3);
            tomb[3] = rs1.getString(4);tomb[4] = rs1.getString(5);tomb[5] = rs1.getString(6);
            tomb[6] = rs1.getString(7);
            eredmeny.add(tomb);
        }
            
    }
        return eredmeny;
    }
    
    
}