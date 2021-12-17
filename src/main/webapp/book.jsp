<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="j" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<jsp:include page="header.jsp"></jsp:include>
	
	<sql:setDataSource
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:64101;databaseName=MyDB"
		user="sa"
		password="123"
		var="con"
	/>
		
		
	<sql:query var="rs" dataSource="${con }">
		
		select * from books where bookid = ?
		<sql:param>${param.bookid }</sql:param>	
	</sql:query>
	
	<div class="container">
		<div class="row">
		
			<j:forEach items="${rs.rows }" var = "row">
			
				<div class = "col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<a href="book.jsp?bookid=${row.bookid }">
						<img src = "ImageServlet?id=${row.bookid }" height="500" class="col-lg-12"/>
					</a>
				</div>
				
				<div class= "col-lg-8 col-md-8 col-sm-12 col-xs-12">
					<h3 class="col-lg-12">${row.bookname }</h3>
					<h3 class="col-lg-12">${row.author }</h3>
					<h3 class="col-lg-12">Rs. ${row.price }</h3><br>
					
					 <div class="row d-grip gap-3"> 
					 	<!-- add item to cart when add to cart is clicked -->
						<form action="AddCartServlet" method="post">
							<input type = "text" name = "bookid" value="${row.bookid }" hidden/>
							Quantity: <input type = "number" name = "qty"/>
							<br>
							<br>
							<input type = "submit" class="btn btn-success col-lg-10" value = "Add to Cart"/> 
						</form>
						
						<j:if test="${row.price>0 }">
							<!-- display buy button only if price > 0  -->
							<a href="" class="btn btn-primary col-lg-10 " style="align-content: center;">Buy</a>
						</j:if>
						<!-- show read when person has bought the book or the book is free to read  -->
						<j:if test="${row.price<=0 }">
							<a href="${row.link }" target = "_blank" class="btn btn-secondary col-lg-10 ">Read</a>
						</j:if>
						
						<j:if test="${u.role=='admin' }"> <!-- use this to hide admin control buttons -->
							<a href="DeleteServlet?bookid=${row.bookid }" class="btn btn-danger col-lg-10 ">Delete</a>
							<a href="update.jsp?bookid=${row.bookid}" class="btn btn-warning col-lg-10 ">Update</a>
						</j:if>
					</div>
					
					
				</div>
			</j:forEach>	
		
		</div>
		<!-- comment -->
	</div>
</body>
</html>

