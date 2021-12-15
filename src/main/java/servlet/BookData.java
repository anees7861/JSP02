package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "BookData", urlPatterns = "/BookData")
@MultipartConfig(maxFileSize = 999999999L) //this will allow to send binary file data to the server
public class BookData extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("bookname");
		String author = req.getParameter("author");
		float price = Float.parseFloat(req.getParameter("price"));
		String link = req.getParameter("link");
		Part part = req.getPart("image"); //get parts of image from the submission
		InputStream is = part.getInputStream(); //put it in an input stream to send data to serve
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB",
					"sa","123");
			PreparedStatement ps = con.prepareStatement("insert into books (bookname,author,price,link,Images) values(?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, author);
			ps.setFloat(3, price);
			ps.setString(4, link);
			ps.setBlob(5, is); // set the part to the query
			ps.executeUpdate();
			resp.sendRedirect("books.jsp"); // use this to redirect the site to the requried web page 
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
}
