<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,com.beehyv.blogging.modal.Post"  
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Post page</title>
		<jsp:include page="Lib.jsp"></jsp:include>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/post.js'></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="Menu.jsp"></jsp:include>
		
		<div class="search-container">
			<form class="search"><input type="search" placeholder="Search">
			</form>
		</div>
		<div class="matter">
			<div class="contents">
			</div>
			<div class="right-section">
				<div class = "recent"> <h2>Recent Posts<br></h2></div>
				<div class = "tags"> <h2>Tags</h2> </div>
			</div>
		</div>
	</body>
</html>
