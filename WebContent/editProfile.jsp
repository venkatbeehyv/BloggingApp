<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
		<div id="editProfile">
			<form class="form" method="post">
			<div>Name:</div><div><br><br></div>
			<div class="formColumns">Designation:</div><div class="formEntries"><input id= designation type="text" name="designation"><br><br></div>
			<div>Email:</div><div><br><br></div>
			<div class="formColumns">Mobile:</div><div class="formEntries"><input id= mob type="tel" name="phone"><br><br></div>
			<div class="submit"><input id="editProfile-id" type="submit" value="Submit"></div>
			</form>
		</div>
		<div class="right-section">
			<div class = "recent"> <h2>Recent Posts<br></h2></div>
			<div class = "tags"> <h2>Tags</h2> </div>
		</div>
</body>
</html>