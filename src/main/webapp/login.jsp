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
		
		<% 
			// fecthing the cookies
			String user="",pass="";
		
		try{
			Cookie ck[] = request.getCookies(); // adds all the cookies in the browser to the array
			for(Cookie c : ck){
				if(c.getName().equals("un")){ // use this to find your cookie
					user = c.getValue(); // store the cookies for the req user
					// cookie will be deleted after the browser is closed these cookie are non-persistent cookie
					// since cookie timer is not mentioned 
				}
				else if(c.getName().equals("pass")){
					pass=c.getValue();
				}
				}
			}catch(Exception e){
				
			}
		%>
		<!-- this is scriplet tag, which is built in jsp; used to write java code in html 
		this can be difficult hence we use JSTL tags-->
		
		<%
			session.removeAttribute("u"); // removes the current user from the session
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
					<input type = "text" name="user" value = "<%out.println(user); // one way to show the 
					// credential %>"
					placeholder="Enter Username" class="form-control"/>				
				</div>
				<br>
				<div class="form-group">
					<label>Enter password</label>
					<input type = "password" name="pass" value="<%=pass %>" 
					placeholder="Enter Password" class="form-control"/>	<!--  // another way to show the credential %= % -->	
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