package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int cartid = Integer.parseInt(req.getParameter("cartid"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			
			PreparedStatement ps = con.prepareStatement("update cartitems set quantity = ? where bookid = ? and cartid = ?");
			ps.setInt(1, qty);
			ps.setInt(2, bookid);
			ps.setInt(3, cartid);
			ps.executeUpdate();
			
			PrintWriter p = resp.getWriter();
			p.println("<script>"
					+ "alert('Quantity changed');"
					+ "window.location='cart.jsp';"
					+ "</script>");
		
			
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter p = resp.getWriter();
			p.println(e);
		}
	}
}
