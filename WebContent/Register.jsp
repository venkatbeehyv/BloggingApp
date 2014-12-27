<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel='stylesheet' type='text/css' href='stylesheet.css'/>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type='text/javascript'>
	
	
		$("#register-id").click(function() {
			var name = $("#name").val();
			var psw = $("#password").val();
			var confPsw =$("#conf-psw").val();
			var email = $("#email").val();
			var mob = $("#mob").val();
			
			var arr= { name:name ,
					   password:psw ,
					   email:email ,
					   mobile_no:mob  };
			if(confPsw==psw){
			function register(){
				jQuery.ajax({
				    url: 'user?actionName=Register',
				    type: 'POST',
				    data: JSON.stringify(arr),
				    contentType: 'application/json; charset=utf-8',
				    dataType: 'json',
				    async: false,
				    success: function(msg) {
				        alert(msg);
				    }
				});
			}
	}
	else{
		window.location="/Register.html";
	}
		});
</script>
</head>
<body id="Register">
	<div class="main_top">
		<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/>
		</div>
		<div id="id"><a href="Login.html" style="color:Azure;">Login</a></div> <div id="reg"> <a href="Register.html" style="color:Azure;">Register</a>
		</div>
	</div>
	<div id="register">
		<form class="form" method="post">
		<div class="formColumns">Name:</div><div class="formEntries"><input id= name type="text" name="Name"><br><br></div>
		<div class="formColumns">Password:</div><div class="formEntries"><input id= password type="password" name="Pass"><br><br></div>
		<div class="formColumns">Confirm password:</div><div class="formEntries"><input id= conf-psw type="password" name="confirm Password"><br><br></div>
		<div class="formColumns">Email:</div><div class="formEntries"><input id= email type="text" name="email"><br><br></div>
		<div class="formColumns">Mobile:</div><div class="formEntries"><input id= mob type="tel" name="phone"><br><br></div>
		<div class="submit"><input id="register-id" type="submit" value="Submit"></div>
		</form>
	</div>
</body>
</html>>