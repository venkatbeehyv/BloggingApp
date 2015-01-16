<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add a Post</title>
		<jsp:include page="Lib.jsp"></jsp:include>
		<script type="text/javascript">
		jQuery(document).ready(function()
			{
				if(name=="null"){
					location.href = "Login.html"
				}
				else{
					updateRecentPosts();
					initializeMenu();
					updateTags();
				}
			});
		</script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js'></script>
		<script type="text/javascript">
		$(".jqte-test").jqte();
		</script>
	</head>
<body>
	<jsp:include page="MyHeader.jsp"></jsp:include>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="main">
		<div class="left-section">
			<div class="post-head"><h2>EDIT POST</h2></div><br><br>
			<form class= "form" method="post"> 
				<div>Please select a category:  
					<select>
					  	<option value="2">Technologies</option>
					  	<option value="3">Frameworks</option>
					  	<option value="4">Databases</option>
					  	<option value="5">Web services</option>
					  	<option value="6">UI</option>
					  	<option value="0">Others</option>
					</select>
				</div><br><br>
				<div>Title: <input type="text" name="title" class="title"><br><br></div><br>
				<div>Post Content: </div><br><br>
				<textarea name="textarea" class="jqte-test"></textarea><br><br>
				<div>Tags:  <input  type="text" name="tags" class="addPost-tags"><br><br></div><br>
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