<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");
long employee_id=0;
String name = null;
if(currentUser!=null) {
employee_id = currentUser.getEmployee_id();
name = currentUser.getName();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/tag.js'></script>
<script type="text/javascript">
		jQuery(document).ready(function()
				{
					updateRecentPosts();
					initializeMenu();
					updateTags();
				});
</script>
</head>
<body>
<jsp:include page="MyHeader.jsp"></jsp:include>
<jsp:include page="Menu.jsp"></jsp:include>
	<div class="main">
	<div id="changePassword" class="left-section">
		<form class="form" method="post" action=EmployeeServlet?actionName=changePassword&&employee_id=<%=employee_id%>>
		<div class="formColumns">Old Password:</div><div class="formEntries"><input id= old_password type="text" name="old_password"><br><br></div>
			<div class="formColumns">New Password:</div><div class="formEntries"><input id= new_password type="text" name="new_password"><br><br></div>
			<div class="formColumns">Confirm Password:</div><div class="formEntries"><input id= confirm_password type="text" name="confirm_password"><br><br></div>
			<div class="submit"><input id="changePassword-id" type="submit" value="Submit"></div>
		</form>
	</div>
		<div class="right-section">
			<div class = "recent"> <h2>Recent Posts<br></h2></div>
			<div class = "tags"> <h2>Tags</h2> </div>
		</div></div>
		
</body>
</html>