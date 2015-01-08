<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Posts</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/postByCategory.js'></script>
<script type="text/javascript">
	jQuery(document).ready(function()
	{
		updateRecentPosts();
		updateTags();
		
		var first = getUrlVars()["root_id"];
		var root_id= parseInt(first);
		
		postByRootId(root_id);
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