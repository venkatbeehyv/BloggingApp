<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");

	String name = null;
	if(currentUser!=null) 
	{
		name = currentUser.getName();
	}
%>

<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Post page</title>
		<jsp:include page="Lib.jsp"></jsp:include>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js'></script>
		<script type="text/javascript">
		jQuery(document).ready(function()
		{
			
			updateRecentPosts();
			updateTags();
			
			var first = getUrlVars()["postId"];
			var post_id= parseInt(first);
			
			loadPost(post_id);
		});
		$(".jqte-test").jqte();
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
