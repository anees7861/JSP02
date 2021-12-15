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
<body>
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
					
					 <div class="row d-grip gap-3" align="center"> 
						<a href="" class="btn btn-success col-lg-10 ">Add to cart</a>
						<j:if test="${row.price>0 }">
							<a href="" class="btn btn-primary col-lg-10 ">Buy</a>
						</j:if>
						<j:if test="${row.price<=0 }">
							<a href="${row.link }" target = "_blank" class="btn btn-secondary col-lg-10 ">Read</a>
						</j:if>
						<a href="" class="btn btn-danger col-lg-10 ">Delete</a>
						<a href="" class="btn btn-warning col-lg-10 ">Update</a>
					</div>
					
					
				</div>
			</j:forEach>	
		
		</div>
		<!-- comment -->
	</div>
</body>
</html>

