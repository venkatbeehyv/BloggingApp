<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%Employee currentUser=(Employee)session.getAttribute("currentUser"); %>
<div class="main_top">
		<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/>
		</div>
		<div id="id"><%=currentUser.name %></div><a href="MyPosts.jsp?employee_id=<%=currentUser.employee_id %>" style="color:Azure;"></a>MyPosts</div> <div id="reg"> <a href="Logout.html" style="color:Azure;">Logout</a>
		</div>


