<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");

String name = null;
if(currentUser!=null) {
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
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/post.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/tag.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js'></script>
		<script type="text/javascript">
		
		function loadPost(post_id){
			jQuery.ajax({
				url:"posts?actionName=post&&postId="+post_id,
				method:"GET",
				contentType:"",
				success:function(posts){
					var name = '<%=name%>';
					var post = JSON.parse(posts);
					var $post = $(".contents");
					$post.append('<div class=add-post><a href="addPost.jsp">Add Post</a></div><br><br>');
					
					if(post.userName==name)
					{
						$post.append('<div><h2>'+post.title+'</h2></div>');
						$post.append('<div class="edit-post"><a href="editPost.jsp?post_id='+post.post_id+'">Edit</a></div><br>')
					}
					else{
						$post.append('<div><h2>'+post.title+'</h2></div><br>');
					}
					$post.append('<div>'+post.createdAt+'</div> &nbsp <div>'+post.userName+'</div>')
					$post.append('<div><p>'+post.content+'</p><div><br>')
					$post.append('<div class="comments"><h3 >Comments</h3></div>');
					$post.append('<form class= "form" method="post"> '
							+'<textarea name="textarea" id= jqte-comment class="jqte-test"></textarea><br><br>'
							+'<div ><button type="reset" value="Reset" class="post-submit">Reset</button>'
							+'<input type="submit" value="Submit"></div></form><br>');
							
					var postComments = post.comments;
					for(var i in postComments){
						$post.append('<div class="post-comment"><p>'+postComments[i].comment+'</p></div><br>')
						$post.append('<div class="comment-name"><a href="#">'+postComments[i].name+'</div>&nbsp<div class="comment-time">'+postComments[i].created_at+'</div><br>')
					}
				}
			});
		}
		$(".jqte-test").jqte();
		</script>
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
