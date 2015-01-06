<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");

String name = null;
if(currentUser!=null) {
name = currentUser.getName();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/tag.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/posts.js'></script>
<script type="text/javascript">

function updateContents(){
	
	jQuery.ajax({
		url: "posts?actionName=homePosts",
		method: "GET",
		contentType: "application/json",
		
		success:function(posts){
			var postArray = JSON.parse(posts);	
			var $homePostsContainer = $(".contents");
			var name = '<%=name%>';
			for(var i in postArray){
				if(postArray[i].userName==name){
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div>')
					$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
				}
				else{
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div><br>')
				}
				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
				$homePostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content.substring(0, 1000)+'</p></div>');
				$homePostsContainer.append('<div class="read-more"><a href="#">Read more</a></div><br><br>')
			}
		},
		error:function(t, ts, tse){
			console.log("error")
		}
	});
}
function postByRootId(root_id){
	jQuery.ajax({
		url: "posts?actionName=postsByCategory&&categoryId="+root_id,
		method: "GET",
		contentType: "",
		success:function(posts){
			var Array = JSON.parse(posts);
			var name = '<%=name%>';
			var $postByCat = $(".contents");
			$postByCat.append('<div><h2>'+Array[0].root_category+'</h2></div><br>');	
			for(var i in Array){
				
				if(Array[i].userName==name){
					$postByCat.append('<div><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></div>').append('<div class="edit-post"><a href="editPost.jsp?post_id='+Array[i].post_id+'">Edit</a></div><br>')
				}
				else{
					$postByCat.append('<div><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></div>')
				}
				$postByCat.append('<div>'+Array[i].createdAt+'</div> &nbsp <div>'+Array[i].userName+'</div>')
				$postByCat.append('<div class="content-summary"><p class="truncate">'+Array[i].content+'</p></div>')
				$postByCat.append('<div class="read-more"><a href="#">Read more</a></div><br><br>')
			}
		}
});
}
function myPosts(employee_id){
	jQuery.ajax({
		url:"posts?actionName=myPosts&&employee_id="+employee_id,
		method:"GET",
		contentType:"",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $post = $(".contents");
			if(postArray.length==0){
				$post.append('<div class="no-post"><p><h2>You have not added any posts yet.To add new post, '
						+'click <a href="addPost.jsp">here</a></h2></p></div><br><br>');
			}
			else{
				$post.append('<div class=add-post><a href="addPost.jsp">Add Post</a></div><br><br>');
				for(var i in postArray){
				$post.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'"><h2>'+postArray[i].title+'</h2></a></div>');
				$post.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>');
				$post.append('<div>'+postArray[i].createdAt+'</div> &nbsp <div>'+postArray[i].userName+'</div>');
				$post.append('<div><p>'+postArray[i].content+'</p><div>');
				$post.append('<div class="read-more"><a href="#">Read more</a></div><br><br>');
			}
         }
			
		},
		error: function (error) {
        }
	});
}
</script>
</head>
<body>
<div class="contents"></div>
</body>
</html>