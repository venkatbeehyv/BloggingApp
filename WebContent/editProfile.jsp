<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");
	long employee_id=0;
	String name = null;
	if(currentUser!=null) 
	{
		employee_id = currentUser.getEmployee_id();
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="Lib.jsp"></jsp:include>
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
		<div id="editProfile" class="left-section">
			<form class="form" method="post" action="EmployeeServlet?actionName=editEmployee&&employee_id=<%=employee_id%>">
			<div class="formColumns">Name:</div><div class="formEntries"><input id= designation type="text" name="name"><br><br></div>
			<div class="formColumns">Designation:</div><div class="formEntries"><input id= designation type="text" name="designation"><br><br></div>
			<div class="formColumns">Mobile:</div><div class="formEntries"><input id= mob type="tel" name="mobile_no"><br><br></div>
			<div class="submit"><input id="editProfile-id" type="submit" value="Submit"></div>
			</form>
		</div>
		<div class="right-section">
			<div class = "recent"> <h2>Recent Posts<br></h2></div>
			<div class = "tags"> <h2>Tags</h2> </div>
		</div>
		</div>
</body>
</html>