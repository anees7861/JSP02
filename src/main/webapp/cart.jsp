<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="j" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		
		
	<sql:query var="rs1" dataSource="${con }">
		
		select * from cartitems where userid = ?
		<sql:param>${u.user }</sql:param>	
	</sql:query>
	
	<j:forEach items="${rs1.rows }" var = "cart">
		<sql:query var="rs" dataSource="${con }">
			
			select * from books where bookid = ?
			<sql:param>${cart.bookid }</sql:param>	
		</sql:query>
		
		<div class="container">
			<div class="row">
			
				<j:forEach items="${rs.rows }" var = "row">
				
					<div class = "col-lg-4 col-md-4 col-sm-12 col-xs-12">
						<a href="book.jsp?bookid=${row.bookid }">
							<img src = "ImageServlet?id=${row.bookid }" height="500" class="col-lg-12"/>
						</a>
					</div>
					
					<div class= "col-lg-8 col-md-8 col-sm-12 col-xs-12" style="text-align: left">
						<h3 class="col-lg-12 col-md-6 col-sm-12 col-xs-12">${row.bookname }</h3>
						<h3 class="col-lg-12">${row.author }</h3>
						<h3 class="col-lg-12">Rs. ${row.price }</h3>
						<form action="UpdateCart?cartid=${cart.cartid}" method="post">
							<h3>Total Price: ${row.price * cart.quantity }</h3>
							<input type = "text" name = "bookid" value="${row.bookid }" hidden/>
							Quantity: <input type = "number" name = "qty" value="${cart.quantity }"/>
							<br>
							<br>
							<input type = "submit" class="btn btn-success col-lg-10" value = "Update Cart"/> 
						</form>
						<br>
						
						 <div class="row d-grip gap-3" align="center"> 
						 	<!-- add item to cart when add to cart is clicked -->
							<a href="PaymentServlet?total=${row.price * cart.quantity }" class="btn btn-success col-lg-10 ">Checkout</a>
							<a href="DeleteFromCartServlet?cartid=${cart.cartid }" class="btn btn-danger col-lg-10 ">Delete from cart</a>
							<!-- use deletefromcartservlet to delete items from cart -->
						</div>
						
						
					</div>
					
					
				</j:forEach>	
			
			</div>
			<!-- comment -->
		</div>
		<br>
		
	</j:forEach>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

