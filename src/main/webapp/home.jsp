<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<!-- jsp:include makes a common header for all of the other web pages
	say a new link is added, we will need to make this change only once -->
	
		<jsp:include page="header.jsp" ></jsp:include>
		<h1>This is home page</h1>
		<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>