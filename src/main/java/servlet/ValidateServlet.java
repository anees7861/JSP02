package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String value = req.getParameter("value");
		String id = req.getParameter("id");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			
			PreparedStatement ps = con.prepareStatement("select * from users where " + id +"= ?");
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			
			PrintWriter pw = resp.getWriter();
			
			
			
			if(rs.next()) {
				
				pw.println(id+" exists");
			}
			else
			{
				pw.println(id+" Available");
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			
			PrintWriter pw = resp.getWriter();
			pw.println(e);
		}
		
	}
}
