package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				int bookid = Integer.parseInt(req.getParameter("bookid"));
				String name = req.getParameter("bookname1");
				String author = req.getParameter("author");
				float price = Float.parseFloat(req.getParameter("price"));
				String link = req.getParameter("link");

				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
							"sa","123");
					PreparedStatement ps = con.prepareStatement("update books\r\n"
							+ "set bookname = ?, author = ?, price = ?, link = ? where bookid = ?");
					
					ps.setString(1, name);
					ps.setString(2, author);
					ps.setFloat(3, price);
					ps.setString(4, link);
					ps.setString(5, name);
					ps.setInt(5, bookid);
						
					ps.executeUpdate();
					resp.sendRedirect("books.jsp"); // use this to redirect the site to the requried web page 
					
					
					
					
					
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
		
	}

}
