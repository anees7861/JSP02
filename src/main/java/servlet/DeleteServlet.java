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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;databaseName=MyDB","sa","123");
			PreparedStatement ps = con.prepareStatement("update books set status = 'D' where bookid=?");
			/*
			 * To delete a book from the table can cause issues while we need to ref it later.So we add a col to our books table 
				signifying the status, this status meed to be changed when we dont want to display the book on out books page.*/
			ps.setInt(1, bookid);
			ps.executeUpdate();
			PrintWriter p = resp.getWriter();
			p.println("<script>"
					+ "alert('Deleted');"
					+ "window.location='books.jsp'"
					+ "</script>");

		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter p = resp.getWriter();
			p.println(e);
		}
	}
}
