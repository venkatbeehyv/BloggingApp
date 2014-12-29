
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,com.beehyv.blogging.modal.Employee,com.beehyv.blogging.modal.Tag,com.beehyv.blogging.modal.Employee"  
    pageEncoding="ISO-8859-1"%>
<% Employee currentUser=(Employee)session.getAttribute("currentUser");
	String userName = currentUser.name;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My HomePage</title>
	<jsp:include page="Lib.jsp"></jsp:include>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/main.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/tag.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/posts.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/Register.js'></script>	
</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="search-container">
			<form class="search"><input type="search" placeholder="Search">
			</form>
	</div>
	<div class="matter">
		<jsp:include page="contents.jsp"></jsp:include>
		<div class="right-section">
			<div class = "recent"> <h2>Recent Posts<br></h2></div>
			<div class = "tags"> <h2>Tags</h2> </div>
		</div>
	</div>
</body>
</html>