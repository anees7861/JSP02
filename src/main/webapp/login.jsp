<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	.myclass
	{
		margin:0 auto;
	
	}

</style>

</head>


<body>

		<!-- this is scriplet tag, which is built in jsp; used to write java code in html -->
			<%
			
				session.removeAttribute("un"); // removes the current user from the session
				session.invalidate(); //invalidates the entire session after logout
		
		
			%>
		

		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			
			<h1>This is login page</h1>
			<form action = "LoginCheck" method = 'post' class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass">
			
			<!-- col-lg-6 col-md-6 col-sm-12 col-xs-12 
			DETERMINES THE NUMBER OF COLS THE DATA SHOULD
			COVER 
			
			btn btn-primary w-100 SETS A BUTTON TO PRIMARY AND SPANS THE ACROSS THE PAGE
			btn btn-danger w-100 SETS A BUTTON TO RED AND SPANS IT ACROSS THE PAGE
			
			class="container" SETS A CLASS TO CONTAINER
			
			class="form-group" SIGNIFIES A FORM
			 -->
			 
				<div class="form-group">
					<label>Enter username</label>
					<input type = "text" name="user" 
					placeholder="Enter Username" class="form-control"/>				
				</div>
				<br>
				<div class="form-group">
					<label>Enter password</label>
					<input type = "password" name="pass" 
					placeholder="Enter Password" class="form-control"/>				
				</div>
				<br>
				<div class = "form-group" style="text-align: left;">
					<a href = "collectmail.jsp">Forgot Password</a>
					
				</div>
				<br>
				<div class="form-group">
					<input type="submit" value="Login" class = "btn btn-primary w-100"/>
				</div>
				<br>
				<div class="form-group">
					<input type = "reset" value = "Reset" class = "btn btn-danger w-100"/>		
				</div>
				
				
			</form>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>