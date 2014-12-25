<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div>
		<div><a href="editProfile.jsp">Edit</a></div>
		<div><a href="editPassword.jsp">Edit Password</a></div>
	</div>
	<div class="left-section">
		<div>Name: </div>
		<div>Designation: </div>
		<div>Email: </div>
		<div>Mob: </div>
	</div>
	<div class="right-section">
		<div class = "recent"> <h2>Recent Posts<br></h2></div>
		<div class = "tags"> <h2>Tags</h2> </div>
	</div>
</body>
</html>