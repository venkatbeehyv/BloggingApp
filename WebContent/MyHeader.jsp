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
var employee_id = <%=employee_id%>;
var name = '<%=name%>';

$(document).ready(function()
{
	if(employee_id != 0){
		
		$(".main_top").append('<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></div>');
		$(".main_top").append('<div id="reg"> <a href="Logout" style="color:Azure">Logout</a></div>');
		$(".main_top").append('<div class="myProfile"><a href="myProfile.jsp?employee_id='+employee_id+'" style="color:Azure">My Account</a></div>');
		$(".main_top").append('<div class="myPosts"><a href="MyPosts.jsp?employee_id='+employee_id +'" style="color:Azure;">MyPosts</a></div> ');
		$(".main_top").append('<div id="id">'+name+'</div>');
	}
	else
	{
	$(".main_top").append('<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></div>');
	$(".main_top").append('<div id="id"><a href="Login.html" style="color:Azure;">Login</a></div>');
	$(".main_top").append('<div id="reg"> <a href="Register.jsp" style="color:Azure;">Register</a></div>');
	}
});
</script>
</head>
<body>
<div class="main_top"></div> 
</body>