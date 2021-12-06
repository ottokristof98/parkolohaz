package com.luv2code.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
    public static List<String[]> Parkoloph(String mit, String mi) throws SQLException, ClassNotFoundException, IOException{
        Connection con = get_data();
        Statement stmt = con.createStatement();
        ArrayList<String[]> eredmeny = new ArrayList<String[]>();
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
    public static ArrayList<Parkolo> Parkolo(String mit, String mi) throws ClassNotFoundException, SQLException, IOException {
        Connection conn= get_data();
        Statement stm;
        stm = conn.createStatement();
        ArrayList<Parkolo> customerList = new ArrayList<>();
        int nem = 0;
        String sql = "Select * From Parkolo;";
        if(mi == "idparkolo"){
            sql = "SELECT * FROM parkolo WHERE idparkolo=" + "'" + mit + "';";
       }else if(mi == "cim"){
            sql = "SELECT * FROM parkolo WHERE cim=" + "'" + mit + "';";
       }else if(mi == "nev"){
            sql = "SELECT * FROM parkolo WHERE nev=" + "'" + mit + "';";
       }else if(mi == "osszhely"){
            sql ="SELECT * FROM parkolo WHERE oszhely=" + "'" + mit + "';";
       }else if(mi == "percdij"){
             sql ="SELECT * FROM parkolo WHERE percdij=" + "'" + mit + "';" ;
       }else if(mi == "extra_percdij"){
             sql ="SELECT * FROM parkolo WHERE extra_percdij=" + "'" + mit + "';";
       }else if(mi == "kep"){
            sql ="SELECT * FROM parkolo WHERE kep=" + "'" + mit + "';";
       }else if(mi == ""){
             sql = "Select * From Parkolo;";
       }
       else{
           nem = 1;
       }
       if(nem != 1){
        ResultSet rst;
        rst = stm.executeQuery(sql);
        while (rst.next()) {
            Parkolo customer = new Parkolo(rst.getInt("idparkolo"), rst.getString("cim"), rst.getString("nev"), rst.getInt("osszhely"), rst.getInt("percdij"), rst.getInt("extra_percdij"), rst.getString("kep"));
            customerList.add(customer);
        }
        }
        return customerList;
    }
    public static ArrayList<Foglalas> Foglalas(String mit, String mi) throws ClassNotFoundException, SQLException, IOException {
        Connection conn= get_data();
        Statement stm;
        stm = conn.createStatement();
        ArrayList<Foglalas> customerList = new ArrayList<>();
        int nem = 0;
        String sql = "Select * From foglalas;";
        if(mi == "parkolohely"){
            sql = "Select * From foglalas WHERE parkolohely=" + "'" + mit + "';";
       }else if(mi == "kezdes"){
            sql = "Select * From foglalas WHERE kezdes=" + "'" + mit + "';";
       }else if(mi == "meddig"){
            sql = "Select * From foglalas WHERE meddig=" + "'" + mit + "';";
       }else if(mi == "rendszam"){
            sql ="Select * From foglalas WHERE rendszam=" + "'" + mit + "';";
       }else if(mi == "fizetes_tranzakcio_szam"){
             sql ="Select * From foglalas WHERE fizetes_tranzakcio_szam=" + "'" + mit + "';" ;
       }else if(mi == "parkolo_idparkolo"){
             sql ="Select * From foglalas WHERE parkolo_idparkolo=" + "'" + mit + "';";
       }else if(mi == "felhasznalo_idfelhasznalo"){
            sql ="Select * From foglalas WHERE felhasznalo_idfelhasznalo=" + "'" + mit + "';";
       }else if(mi == ""){
             sql = "Select * From foglalas;";
       }
       else{
           nem = 1;
       }
       if(nem != 1){
        ResultSet rst;
        rst = stm.executeQuery(sql);
        while (rst.next()) {
            Foglalas customer = new Foglalas(rst.getInt("parkolohely"), LocalDateTime.parse(rst.getString("mettol")), LocalDateTime.parse(rst.getString("meddig")), rst.getString("rendszam"), rst.getInt("fizetes_tranzakcio_szam"), rst.getInt("parkolo_idparkolo"), rst.getInt("felhasznalo_idfelhasznalo"));
            customerList.add(customer);
        }
        }
        return customerList;
    }
    public static ArrayList<Felhasznalo> Felhasznalo(String mit, String mi) throws ClassNotFoundException, SQLException, IOException {
        Connection conn= get_data();
        Statement stm;
        stm = conn.createStatement();
        ArrayList<Felhasznalo> customerList = new ArrayList<>();
        int nem = 0;
        String sql = "Select * From foglalas;";
        if(mi == "parkolohely"){
            sql = "Select * From foglalas WHERE parkolohely=" + "'" + mit + "';";
       }else if(mi == "kezdes"){
            sql = "Select * From foglalas WHERE kezdes=" + "'" + mit + "';";
       }else if(mi == "meddig"){
            sql = "Select * From foglalas WHERE meddig=" + "'" + mit + "';";
       }else if(mi == "rendszam"){
            sql ="Select * From foglalas WHERE rendszam=" + "'" + mit + "';";
       }else if(mi == "fizetes_tranzakcio_szam"){
             sql ="Select * From foglalas WHERE fizetes_tranzakcio_szam=" + "'" + mit + "';" ;
       }else if(mi == "parkolo_idparkolo"){
             sql ="Select * From foglalas WHERE parkolo_idparkolo=" + "'" + mit + "';";
       }else if(mi == "felhasznalo_idfelhasznalo"){
            sql ="Select * From foglalas WHERE felhasznalo_idfelhasznalo=" + "'" + mit + "';";
       }else if(mi == ""){
             sql = "Select * From foglalas;";
       }
       else{
           nem = 1; 
       }
       if(nem != 1){
        ResultSet rst;
        rst = stm.executeQuery(sql);
        while (rst.next()) {
            Felhasznalo customer = new Felhasznalo(rst.getInt("id"), rst.getString("nev"), rst.getString("email"), rst.getString("jelszo"), rst.getString("lakcim"), LocalDate.parse(rst.getString("szuletes")), rst.getString("telefonszam"), LocalDateTime.parse(rst.getString("ref_datum")));
            customerList.add(customer);
        }
        }
        return customerList;
    }
    public static String Regisztracio(String nev, String email, String lakcim, String szuletes, String telefon, String jelszo1, String jelszo2) throws ClassNotFoundException, SQLException, IOException{
        //tomb[0]=nev, tomb[1]=email, tomb[2]=lakcim, tomb[3]=szuletes,tomb[4]=telefon tomb[5]=jelszo1
        //tomb[6]=jelszo2
        int e = Felhasznalo(email, "email").size();
        String v = "";
        
        if(e == 0){
            if(nev.length() < 5 || email. length() < 5 || lakcim.length() < 5 || szuletes.length() < 5 || telefon.length() != 9 || jelszo1.length() < 5 || !jelszo1.equals(jelszo2)){
                
                if(jelszo1.equals(jelszo2)){ v = "Nem egyezik a két jelszó";}
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
    public static String Foglal(Foglalas foglal) throws ClassNotFoundException, SQLException, IOException{
        Connection con = get_data();
        String v = "";
        try {
            Statement stmt = con.createStatement();
            int w = stmt.executeUpdate("INSERT INTO foglalas " + "(parkolohely, kezdes, meddig, rendszam, fizetes_tranzakcio_szam, parkolo_idparkolo, felhasznalo_idfelhasznalo) " + "VALUES ('"+foglal.getParkolohely()+"', '"+foglal.getKezdes()+"', '"+foglal.getMeddig()+"', '"+foglal.getRendszam()+"', '"+foglal.getFizetes_tranzakcio_szam()+"', '"+foglal.getParkolo_idparkolo()+"', '"+foglal.getFelhasznalo_idfelhasznalo()+"');");
            if(w == 0) v = "Sikertelen foglalás!";
                else v = "Sikeres foglalás!";
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return v;
    }
}
