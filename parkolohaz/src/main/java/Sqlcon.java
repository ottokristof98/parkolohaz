import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sqlcon extends HttpServlet {
	
	public void get_data(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkolohaz", "root","");
        Statement stmt = con.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM adatlap;");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<p>");
        while (rs1.next()) {
            out.println(rs1.getString(1) + ' ' + rs1.getString(2) + ' ' + rs1.getString(3) + ' ' + rs1.getString(4)
                    + "<br>");
        }
        out.println("</p>");
    }
}


