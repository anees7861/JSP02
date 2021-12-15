package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ImageServlet", urlPatterns = "/ImageServlet")

public class ImageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookid = Integer.parseInt(req.getParameter("id")); // gets the id of the books
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;databaseName=MyDB","sa","123");
			PreparedStatement ps = con.prepareStatement("select Images from books where bookid = ?");
			ps.setInt(1, bookid);
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				Blob blob = rs.getBlob("Images"); //image is BLOB format and will not be supported by the browser and JSP file
				byte arr[]=blob.getBytes(1, (int)blob.length()); //convert BLOB data into byte array so browser can understand
				
				resp.getOutputStream().write(arr); //send bytes to the browser
			}
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter pe = resp.getWriter();
			pe.println(e);
		}
	}

}
