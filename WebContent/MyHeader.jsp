<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");
	long employee_id = currentUser.getEmployee_id();
%>
<head>
<script type='text/javascript'>
var employee_id = <%=currentUser.getEmployee_id()%>;
var name = '<%=currentUser.getName()%>';
$(document).ready(function()
{
	if(employee_id != 0){
		$(".main_top").append('<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></div>');
		$(".main_top").append('<div id="reg"> <a href="Logout.html" style="color:Azure">Logout</a></div>');
		$(".main_top").append('<div class="addPost"><a href="addPost.jsp" style="color:Azure">Add Post</a></div>');
		$(".main_top").append('<div class="myPosts"><a href="MyPosts.jsp?employee_id='+employee_id +'" style="color:Azure;">MyPosts</a></div> ');
		$(".main_top").append('<div id="id">'+name+'</div>');
	}
	else
	{
	$(".main_top").append('<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></div>');
	$(".main_top").append('<div id="id"><a href="Login.html" style="color:Azure;">Login</a></div>');
	$(".main_top").append('<div id="reg"> <a href="Register.html" style="color:Azure;">Register</a></div>');
	}
});
</script>
</head>
<body>
<div class="main_top">
	<%-- <div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/>
	</div>
		<div id="reg"> <a href="Logout.html" style="color:Azure">Logout</a></div>
		<div class="addPost"><a href="AddPost.html" style="color:Azure">Add Post</a></div>
		<div class="myPosts"><a href="MyPosts.jsp?employee_id=<%=currentUser1.employee_id %>" style="color:Azure;">MyPosts</a></div> 
		<div id="id"><%=currentUser1.name %></div> --%>
	</div> 
</body>