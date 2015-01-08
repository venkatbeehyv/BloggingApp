<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");
long employee_id=0;
String name = null;
if(currentUser!=null) {
employee_id = currentUser.getEmployee_id();
name = currentUser.getName();
}
%>
<head>
<script type='text/javascript'>
	var employee_id = 0;
	var name = '';
	var employee_id = <%=employee_id%>;
	var name = '<%=name%>';

	$(document).ready(function()
	{
		myHeader(employee_id, name)
	});
</script>
</head>

<body>
<div class="main_top"></div> 
</body>