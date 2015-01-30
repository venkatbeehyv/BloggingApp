<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");
long employee_id=0;

if(currentUser!=null) {
	employee_id = currentUser.getEmployee_id();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add a Post</title>
		<jsp:include page="Lib.jsp"></jsp:include>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/addPost.js'></script>
		<script type="text/javascript">
		jQuery(document).ready(function()	
			{
			if(name=="null"){
				location.href = "Login.html";
			}
			else{
				updateRecentPosts();
				initializeMenu();
				updateTags();
				getLeafNodes();
			}
			$('.jqte-test').jqte();
			});
		</script>
	</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
	<jsp:include page="searchContainer.jsp"></jsp:include>
	<div class="main">
		<div class="left-section">
			<div class="post-head"><h2>NEW POST</h2></div>
			<form class="form" method="post" action="posts?actionName=addPost&&employee_id=<%=employee_id%>"> 
				<div><b>Please select a relevant category:</b>  &nbsp
					<select name="selected-leaf" id ="leaf-nodes">
					</select>
				</div><br>
				<div><b>Title:</b> &nbsp <input type="text" name="title" class="title"></div><br>
				<div><b>Post Content: </b></div>
				<div id="textar" style=" display:block;">	
				<textarea name="textarea" class="jqte-test"></textarea>
				</div>
				<div><b>Tags:</b> &nbsp <input  type="text" name="tags" class="addPost-tags"><br><br></div><br>
				<div ><button type="reset" value="Reset" class="post-submit">Reset</button>
					<input type="submit" value="Submit">
				</div><br>
			</form>
		</div>
	<div class="right-section">
		<div class = "recent"> <h2>Recent Posts<br></h2></div>
		<div class = "tags"> <h2>Tags</h2> </div>
	</div>
	</div>
</body>
</html>