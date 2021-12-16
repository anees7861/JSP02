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
	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			
			<h1>Change Password</h1>
			<form action = "ChangePassServlet" method = 'post' class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass">
			
						 
				<div class="form-group">
					<label>Enter New Password</label>
					<input type = "password" name="pass" 
					placeholder="Enter New Password" class="form-control"/>				
				</div>
				<br>
				
				<div class="form-group">
					<label>Confirm Password</label>
					<input type = "password" name="cpass" 
					placeholder="Confirm Password" class="form-control"/>				
				</div>
				<br>
				
				<div class="form-group">
					<input type="submit" value="Submit Password" class = "btn btn-primary w-100"/>
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