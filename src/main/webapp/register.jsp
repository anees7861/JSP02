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
		<h1>This is register page</h1>
		<div class="container">
			<form action="Registration" method="post" 
			class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass">
				<div class="form-group">
					<label>Enter Username</label>
					<input type="text" name ="user" placeholder="Enter Username" class="form-control"/>			
				</div>
				<br>
				<div class="form-group">
					<label>Enter Email</label>
					<input type="email" name ="email" placeholder="Enter Email" class="form-control"/>			
				</div>
				<br>
				<div class="form-group">
					<label>Enter Password</label>
					<input type="password" name ="pass" placeholder="Enter Password" class="form-control"/>			
				</div>
				<br>
				<div class="form-group">
					<input type="submit" value="Register" class = "btn btn-primary w-100" />
				</div>
				<br>
				<div class="form-group">
					<input type = "reset" value = "Reset" class = "btn btn-danger w-100"/>		
				</div>
			
			</form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>