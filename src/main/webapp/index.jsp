<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- using traditional scriplet to make variable 
	This becomes very tedious hence we combination of tags and jsp-->
	
	<%-- <%
		float salary = 50000;
		out.println("<h1>Salary is: " + salary + "</h1>");	
	%> --%>
	
	<!-- Set tag  -->
	<%-- <c:set var = "salary" value = "40000"/> <!-- used to set variable -->
	Salary is: <c:out value="${salary }"/><br> <!-- used to print variable -->
	Salary is: ${salary } <!-- Another way to print the variable --> --%>
	
	
	<!-- If tag -->
<%-- 	<c:set var = "salary" value = "40000"/>
	<c:if test="${salary > 20000 }">
		<p>Salary is greater than 20000</p>
	
	</c:if>
	
	<c:if test="${salary <= 20000 }">
		<p>Salary is less than or equal to 20000</p>
	</c:if> --%>
	
	<!-- FOr each tage -->
<%-- 	<ul>
		<c:forEach var="i" begin="1" end="10" step="2"> <!-- Step allows you to set the no. of steps to be taken
															 from the current no.  -->
			<li>${i}</li> 								<!-- Creates a for loop and iterates automatically  -->
		</c:forEach>
	</ul> --%>
	
	<!-- TO decrement the value, use following loop foreach tag  -->
<%-- 	<c:forEach var="i" begin="1" end="10" step = '1'>
		<li>${11-i}</li><!-- if we set step to -1 an error will be given, so we have to
						 use the following logic to decrement numbers  -->	
	</c:forEach> --%>
	
	<!-- Using switch case choose tag -->
<%-- 	<c:set var = "salary" value = "40000"/>
	<c:choose>
		<c:when test="${salary >=40000 }">
			Salary is good
		</c:when>
		
		<c:when test="${salary>=20000 && salary<=40000 }">
			Salary is decent
		</c:when>
		
		<c:when test="${salary < 20000 }">
			Salary is low
		</c:when>
		<c:otherwise> <!-- Default condition  -->
			Cant say nothing
		</c:otherwise>
	</c:choose> --%>
	
	
	<!-- Using try catch -->
<%-- 	<c:catch var="e">
		<% int c = 2/0; %>
	</c:catch>
	
	<c:if test="${e!=null}">	
		${e}<br>
		Message: ${e.message}
	</c:if> --%>
	
	<!-- for tokens this is string tokenizer which splits the string based on the value given -->
<%-- 	<c:forTokens var="shirt" items="blue shirt,white shirt,green shirt,maroon shirt" delims=",">
		${shirt }<br>
	
	
	</c:forTokens> --%>
	
	<!-- redirect tag  -->
<%-- 	<c:redirect url="https://google.com"></c:redirect> --%>

	<!--import tage this is used for data scrapping and mining-->
	<c:import url="https://www.google.com" var="data"></c:import> <!-- var will store the data from the website it will store the code to
	the website -->
	<c:out value="${data }"></c:out> <!-- this will print the data of the website as the variable stores a large amount of data  -->
	
</body>
</html>