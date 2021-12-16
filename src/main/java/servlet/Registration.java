package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Registration", urlPatterns = "/Registration")
public class Registration extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = req.getParameter("user"); // get info from the jsp 
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load SQL server driver
			
			Connection con = 
					DriverManager.getConnection("jdbc:sqlserver://localhost:64101;databaseName=MyDB","sa","123"); //set up connection
			
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)"); // provide a statement
			ps.setString(1, uname); // set the values to be passed (index, value)
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, "user");
			ps.executeUpdate();
			
			
			// use the fillowing class to send email to users upon registration
			Email em = new Email(email, "Registered Successfully", "Welcome to MyApp");
			em.sendEmail();
			
			resp.sendRedirect("home.jsp"); // redirects the page after this servlet has beedn executed. This is dope comment
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
