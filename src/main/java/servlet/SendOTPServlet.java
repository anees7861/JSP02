package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendOTPServlet")
public class SendOTPServlet extends HttpServlet{
	
	// 1 Check is mail id is correct
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mail = req.getParameter("email");
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;databaseName=MyDB","sa","123");
			PreparedStatement ps = con.prepareStatement("select * from users where email = ?");
			ps.setString(1, mail);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = (Integer) rs.getObject("userid");
				Random rnd = new Random();
				int otp = rnd.nextInt(888)+1000; // generates 4 digit otp
				
				HttpSession hs = req.getSession(); // store the otp in the session for later use, to check is otp
				// put in matches session otp
				hs.setAttribute("otp", otp);
				hs.setAttribute("email", mail);
				hs.setAttribute("id", id );
				
				Email e = new Email(mail,"Your otp", "otp is:" + otp);
				e.sendEmail();
				
				resp.sendRedirect("collectotp.jsp");
			}
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter pw = resp.getWriter();
			pw.println(e);
		}
	}
}
