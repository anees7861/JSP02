package servlet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateBooksTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:64101;database=MyDB","sa","123")){
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Statement st = con.createStatement();
			System.out.println("Connection");
			st.execute("create table books"
					+ "( bookid int primary key identity,"
					+ "bookname varchar(50),"
					+ "author varchar(50),"
					+ "price float,"
					+ "link varchar(500))");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
