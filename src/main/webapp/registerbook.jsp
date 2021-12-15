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
		margine:0 auto;
	
	}


</style>


</head>

<body style="text-align: center;">

	<jsp:include page="header.jsp"></jsp:include>
	<h1>Register your books here</h1>
	<div class="container">
		<form action="BookData" method="post" enctype="multipart/form-data"
		class = "col-lg-12 col-md-6 com-sm-12 col-xs-12 myclass">  <!-- always use enctype=multipart/form-data to send 
																	encrypted images over the net  --> 
			<div class="form-group">
				<label>Book Name</label>
				<input type="text" name="bookname" placeholder="Enter Book Name" class="form-control"/>
			</div>
			<br>
			
			<div class="form-group">
				<label>Author</label>
				<input type="text" name="author" placeholder="Enter Author" class="form-control"/>
			</div>
			<br>
			
			<div class="form-group">
				<label>Price</label>
				<input type="text" name="price" placeholder="Enter Price" class="form-control"/>
			</div>
			<br>
			
			<div class="form-group">
				<label>Link</label>
				<input type="text" name="link" placeholder="Enter Link" class="form-control"/>
			</div>
			<br>
			
			<div class="form-group">
				<label>Select Image</label> <!-- Use this to add image  -->
				<input type="file" name="image"  class="form-control"/>
			</div>
			<br>
			
			<div class="form-group">
				<input type="submit" value="Submit" class="btn btn-primary w-100"/>
			</div>
			<br>
			
			<div class="form-group">
				<input type="reset" value="Reset" class="btn btn-danger w-100"/>
			</div>
			<br>
		
		
		
		</form>
	
	
	</div>


</body>
</html>