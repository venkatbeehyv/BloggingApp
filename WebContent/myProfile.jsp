<%@ page language="java" contentType="text/html; charset=UTF-8" import = "com.beehyv.blogging.modal.Employee"
    pageEncoding="UTF-8"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");

String name = null;
if(currentUser!=null) {
name = currentUser.name;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Profile</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/myProfile.js'></script>
<script type="text/javascript">
	jQuery(document).ready(function()
	{
		if(name=="null"){
			location.href = "Login.html"
		}
		else{
			updateRecentPosts();
			updateTags();
			
			var first = getUrlVars()["employee_id"];
			var employee_id= parseInt(first);
			myProfile(employee_id);
		}
	});
</script>
</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class= "main">
	<div class="left-section">
	<div class="userDetails"> </div>
	</div>
	<div class="right-section">
		<div class = "recent"> <h2>Recent Posts<br></h2></div>
		<div class = "tags"> <h2>Tags</h2> </div>
	</div>
	</div>
</body>
</html>