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

@WebServlet("/DeleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cartid = Integer.parseInt(req.getParameter("cartid"));
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			
			
			
			
			PreparedStatement ps = con.prepareStatement("delete from cartitems where cartid=?");
			ps.setInt(1, cartid);
			ps.executeUpdate();
			
			PrintWriter pw = resp.getWriter();
			pw.println("<script>"
					+ "alert('Item deleted from cart');"
					+ "window.location='cart.jsp';"
					+ "</script>");
		
			
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter pw1 = resp.getWriter();
			pw1.println(e);
		}
	}
}
