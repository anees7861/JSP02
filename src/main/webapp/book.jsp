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
		
		select * from books where bookid = ${param.bookid}	
	</sql:query>
	
	<div class="container">
		<div class="row" class = "col-lg-6 col-md-4 col-sm-12 col-xs-12">
		
			<j:forEach items="${rs.rows }" var="row">
				<img src = "ImageServlet?id=${row.bookid }" height="500" class="col-lg-4"/>
				<h1 class="col-lg-3" >${row.bookname }<br>Rs.${row.price }</h1>				
			</j:forEach>		
					
		</div>
		<br>
		
		<div class="row d-grip gap-3" align="center">
						<a href="" class="btn btn-primary col-lg-4">Add to cart</a>
	
		</div>
		<br>
		
		<div class="row d-grip gap-3" align="center">
						<a href="" class="btn btn-danger col-lg-4">Buy Now</a>

		</div>
		<!-- comment -->
	</div>
</body>
</html>

