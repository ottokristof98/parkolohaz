package com.luv2code.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public static List<String[]> Felhasznalo(String mit, String mi)throws SQLException, ClassNotFoundException, IOException{
        Connection con = get_data();
        Statement stmt = con.createStatement();
        List<String[]> eredmeny = new ArrayList<String[]>();
        String[] tomb = new String[7];
        int nem = 0;
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM felhasznalo;");
        if(mi == "nev"){
             rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE nev=" + "'" + mit + "';");
        }else if(mi == "email"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE email=" + "'" + mit + "';");
        }else if(mi == "jelszo"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE jelszo=" + "'" + mit + "';");
        }else if(mi == "lakcim"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE lakcim=" + "'" + mit + "';");
        }else if(mi == "szuletes"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE szuletes=" + "'" + mit + "';");
        }else if(mi == "telefonszam"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE telefonszam=" + "'" + mit + "';");
        }else if(mi == "reg_datum"){
            rs1 = stmt.executeQuery("SELECT * FROM felhasznalo WHERE reg_datum=" + "'" + mit + "';");
        }else if(mi == ""){
            rs1 = stmt.executeQuery("SELECT * FROM felhaszalo;");
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
        }}
        return eredmeny;
    }
    public static String Regisztracio(String nev, String email, String lakcim, String szuletes, String telefon, String jelszo1, String jelszo2) throws ClassNotFoundException, SQLException, IOException{
        //tomb[0]=nev, tomb[1]=email, tomb[2]=lakcim, tomb[3]=szuletes,tomb[4]=telefon tomb[5]=jelszo1
        //tomb[6]=jelszo2
        int e = Felhasznalo(email, "email").size();
        String v = "";
        
        if(e == 0){
            if(nev.length() < 5 || email. length() < 5 || lakcim.length() < 5 || szuletes.length() < 5 || telefon.length() != 9 || jelszo1.length() < 5 || !jelszo1.equals(jelszo2)){
                
                if(jelszo1.equals(jelszo2)){ v = "0Nem egyezik a két jelszó (" + jelszo1 + ") (" + jelszo2 + ")";}
                else{ v = "Nins kitöltve rendesen az összes mező..";}
            }else{
                //update
                Connection con = get_data();
                Statement stmt = con.createStatement();
                LocalDate d = LocalDate.parse(szuletes);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();
                int w = stmt.executeUpdate("INSERT INTO felhasznalo " + "(nev, email, jelszo, lakcim, szuletes, telefonszam, reg_datum) " + "VALUES ('"+nev+"', '"+email+"', '"+jelszo1+"', '"+lakcim+"', '"+d+"', '"+telefon+"', '"+dtf.format(now)+"');");
                if(w == 0) v = "Sikertelen regisztráció!";
                else v = "Sikeres regisztráció!";
            } 
        }else{
            if(nev.length() < 5 || email. length() < 5 || lakcim.length() < 5 || szuletes.length() < 5 || telefon.length() < 5 || jelszo1.length() < 5 || !jelszo1.equals(jelszo2)){
                if(jelszo1.equals(jelszo2)) v = "Nem egyezik a két jelszó";
                else v = "Nincs kitöltve rendesen az összes mező..";
            }else{
                //van már ilyen felhasználónév vagy jelszó
                v = "Az adott E-mail már regisztrálva van!";
            }
        }
        return v;
    }
    
}
