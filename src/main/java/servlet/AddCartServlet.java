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
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession hs = req.getSession();
		//String mail = ((User)hs.getAttribute("u")).getMail();
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		String user = ((User)hs.getAttribute("u")).getUser();
		int quan = Integer.parseInt(req.getParameter("qty"));
		
		try {

			PrintWriter pw = resp.getWriter();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			
			PreparedStatement ps = con.prepareStatement("select * from cartitems where bookid=? and userid=?");
			ps.setInt(1, bookid);
			ps.setString(2, user);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				PrintWriter pw1 = resp.getWriter();
				pw1.println("<script>"
						+ "alert('Please increase book quantity as item is already added');"
						+ "window.location='cart.jsp';"
						+ "</script>");
			}
			else {
				PreparedStatement ps1 = con.prepareStatement("insert into cartitems (bookid,userid,quantity) values (?,?,?)");
				ps1.setInt(1, bookid);
				ps1.setString(2, user);
				ps1.setInt(3, quan);
				ps1.executeUpdate();
				
				
			
				pw.println("<script>"
						+ "alert('Book added!');"
						+ "window.location='cart.jsp';"
						+ "</script>");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter p = resp.getWriter();
			p.println(e);
		}
		
	}
}
