<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel='stylesheet' type='text/css' href='stylesheet.css'/>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body id="Register">
	<div class="main_top">
		<div class="pic"><a href="Home.jsp"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></a>
		</div>
		<div id="id"><a href="Login.html" style="color:Azure;">Login</a></div> <div id="reg"> <a href="Register.jsp" style="color:Azure;">Register</a>
		</div>
	</div>
	<div id="register">
		<form class="form" method="post" action="EmployeeServlet?actionName=Register">
		<div class="formColumns">Name:</div><div class="formEntries"><input id= name type="text" name="name"><br><br></div>
		<div class="formColumns">Password:</div><div class="formEntries"><input id= password type="password" name="password"><br><br></div>
		<div class="formColumns">Confirm password:</div><div class="formEntries"><input id= conf-psw type="password" name="confirm Password"><br><br></div>
		<div class="formColumns">Email:</div><div class="formEntries"><input id= email type="text" name="email"><br><br></div>
		<div class="formColumns">Mobile:</div><div class="formEntries"><input id= mob type="tel" name="mobile_no"><br><br></div>
		<div class="submit"><input id="register-id" type="submit" value="Submit"></div>
		</form>
	</div>
</body>
</html>