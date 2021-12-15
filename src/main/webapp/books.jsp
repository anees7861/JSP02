<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- this gives the connection to the data base -->
	<c:setDataSource
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:64101;databaseName=MyDB"
		user="sa"
		password="123"
		var="con"
	/>
	
	<c:query var="rs" dataSource="${con}">
		select * from books
	
	</c:query>
	
	<div class="container">
		<!-- add existing code here  -->
		
		<div class="row">
		
			<j:forEach items="${rs.rows }" var = "row">
			
				<div class = "col-lg-3 col-md-4 col-sm-12 col-xs-12" style="border: 1px sold black" >
					<a href="book.jsp?bookid=${row.bookid }">
						<img src = "ImageServlet?id=${row.bookid }" height="500" class="col-lg-12"/>
					</a>
					
					<h3 class="col-lg-12">${row.bookname }</h3>
					<h3 class="col-lg-12">${row.price }</h3><br>
					
					<div class="row d-grip gap-3" align="center">
						<a href="" class="btn btn-primary col-lg-10">Add to cart</a>
						<a href="" class="btn btn-danger col-lg-10">Buy Now</a>
					</div>
					
				</div>
			</j:forEach>	
		
		</div>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>



<%-- <table class = "table" border="1" style="margin-left: auto;margin-right: auto">
			<tr>
				<th>Book Id</th>
				<th>Book Image</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Book Price</th>
				<th>Book Link</th>
			</tr>
		
		
		
			<j:forEach items="${rs.rows }" var="row">
				<tr>
					<td>${row.bookid }</td>
					<td><img src="ImageServlet?id=${row.bookid }" width="200" height="200"/></td> <!--ID being sent of ImageServelet  -->
					<td>${row.bookname }</td>
					<td>${row.author }</td>
					<td>${row.price }</td>
					<td>${row.link }</td>
				</tr>	
			</j:forEach>
		</table> --%>