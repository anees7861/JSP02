<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
	
	<sql:query var="rs" dataSource="${con}">
		select * from users	
	</sql:query>
	
	<div class = "container">
		<table class="table" border="1" style="margin-left: auto; margin-right: auto">
			<tr>
				<th>User Name</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
			
			<c:forEach items="${rs.rows}" var="row">
					<tr>
						<td>${row.username }</td>
						<td>${row.email }</td>
						<td>${row.password }</td>					
					</tr>
	
			</c:forEach>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>