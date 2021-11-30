import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello from Servlet");
		try {
            get_data(request, response);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void con(HttpServletRequest request, HttpServletResponse response)
					throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinemozi", "root",
                "");
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


