package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConfirmOTPServlet")
public class ConfirmOTPServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int otp = Integer.parseInt(req.getParameter("otp")); // otp entered by user
		HttpSession hs = req.getSession();
		int sessotp = (Integer)(hs.getAttribute("otp")); // generated otp saved in the session
		
		PrintWriter pw = resp.getWriter();
		
		if(otp==sessotp) {
			
			pw.println("<script>"
					+ "alert('Correct Otp');"
					+ "window.location='changepass.jsp';"
					+ "</script>");
		}
		else {
			pw.println("<script>"
					+ "alert('Wrong Otp');"
					+ "window.location='collectotp.jsp';"
					+ "</script>");
		}
	}
}
