<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/main.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/tag.js'></script>
</head>
<body>
<jsp:include page="MyHeader.jsp"></jsp:include>
<jsp:include page="Menu.jsp"></jsp:include>
	<div id="editPassword">
		<form class="form" method="post">
			<div class="formColumns">New Password:</div><div class="formEntries"><input id= new_password type="text" name="new_password"><br><br></div>
			<div class="formColumns">Confirm Password:</div><div class="formEntries"><input id= confirm_password type="tel" name="confirm_password"><br><br></div>
			<div class="submit"><input id="editPassword-id" type="submit" value="Submit"></div>
		</form>
	</div>
		<div class="right-section">
			<div class = "recent"> <h2>Recent Posts<br></h2></div>
			<div class = "tags"> <h2>Tags</h2> </div>
		</div>
</body>
</html>