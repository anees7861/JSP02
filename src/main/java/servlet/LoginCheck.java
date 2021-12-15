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

@WebServlet(name = "LoginCheck", urlPatterns = "/LoginCheck")
public class LoginCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		
		
		u.setUser(req.getParameter("user"));
		u.setPass(req.getParameter("pass"));
//		String user = req.getParameter("user");
//		String pass = req.getParameter("pass");
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			PreparedStatement ps = con.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, u.getUser());
			ps.setString(2, u.getPass());
			ResultSet rs = ps.executeQuery();
			PrintWriter out = resp.getWriter();
			// commnet this bro 
			if(rs.next()) {
				
				// create a session to save user data
				// when  user logs in the data is saved and session is started
				// once they log out the session ends
				
				u.setMail(rs.getString("email"));
				u.setRole(rs.getString("role"));
				
				HttpSession hs = req.getSession();
				hs.setMaxInactiveInterval(120); // Specifies the session timeout duration in seconds
				hs.setAttribute("u", u); // stores all of the users data in one attributer, instead of creating 4 separate
										 // ones.
				
				out.println("<script>" // throw a pop up to show user has logged in
							+ "alert('Welcome User "+u.getUser()+"');" 
							+ "window.location='home.jsp';"
							+ "</script>");	
			}
			else
				out.println("<script>" // throw a pop up to show entered info is incorrect
							+ "alert('incorrect username or pass');" 
							+ "window.location='home.jsp';"
							+ "</script>");	
			
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter out = resp.getWriter();
			out.println(e);
		}
	}
}
