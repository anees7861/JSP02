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
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");
		
		if(pass.equals(cpass)) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;databaseName=MyDB",
						"sa","123");
				
				HttpSession hs = req.getSession();
				int id = (Integer) hs.getAttribute("id"); // get id of the user from the session
				
				PreparedStatement ps1 = con.prepareStatement("update users set password = ? where userid = ?");
				ps1.setString(1, pass);
				ps1.setInt(2, id );
				ps1.executeUpdate();
				
				PrintWriter pw = resp.getWriter();
				
				pw.println("<script>"
						+ "alert('Password Updated');"
						+ "window.location = 'login.jsp;'"
						+ "</script>");
				
			}catch (Exception e) {
				// TODO: handle exception
				PrintWriter pw = resp.getWriter();
				pw.println(e);
			}
		}
		else {
			PrintWriter pw = resp.getWriter();
			
			pw.println("<script>"
					+ "alert('Password does not match');"
					+ "window.location = 'changepass.jsp;'"
					+ "</script>");
		}
		
	}
}
