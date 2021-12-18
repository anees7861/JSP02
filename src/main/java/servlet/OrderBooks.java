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

@WebServlet("/OrderBooks")
public class OrderBooks extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String asc = req.getParameter("asc");
		String desc = req.getParameter("desc");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			
			PreparedStatement ps;
			

			if(asc.equals("Ascending")) {
				ps = con.prepareStatement("select * from books where status = 'A' order by price asc");
				
			}
			else {
				ps = con.prepareStatement("select * from books where status = 'A' order by price desc");
			}
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				resp.sendRedirect("books.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter pw = resp.getWriter();
			pw.println(e);
		}
	}
}
