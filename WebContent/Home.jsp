<%@ page language="java"  import="java.util.List,com.beehyv.blogging.modal.*"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home page</title>
		
		<jsp:include page="Lib.jsp"></jsp:include>
		
		<script type='text/javascript'>
		jQuery(document).ready(function()
		{
			updateRecentPosts();
			initializeMenu();
			updateContents();
			updateTags();
			//searchPosts();
		});
		</script>
		
	</head>
	
	<body>
		<jsp:include page="MyHeader.jsp"></jsp:include>
		<jsp:include page="Menu.jsp"></jsp:include>
		<jsp:include page="searchContainer.jsp"></jsp:include>
		<div class="matter">
			<jsp:include page="contents.jsp"></jsp:include>
			<div class="right-section">
				<div class = "recent"> <h2>Recent Posts<br></h2></div>
				<div class = "tags"> <h2>Tags</h2> </div>
			</div>
		</div>
	</body>
</html>
