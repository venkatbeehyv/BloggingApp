<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<%	Employee currentUser=(Employee)session.getAttribute("currentUser");

String name = null;
if(currentUser!=null) {
name = currentUser.name;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
/* $(document).ready(function(){
	$(".read-more a").click( function() {
		alert("hi");
	});
}); */
function theFunction(post_id){
	var name = "<%=name%>";
	if(name != "null"){
		var $summary = $("#"+post_id+" p");
		$summary.toggleClass("truncate");
		var rmdiv = document.getElementsByClassName(post_id);
		if($summary.hasClass("truncate")){
			$(rmdiv[0]).html("Read More");
		}
		else{
			$(rmdiv[0]).html("Read Less");
		}
	}
	else{
		location.href="Login.html";
	}
}; // end theFunction
function updateContents(){
	
	jQuery.ajax({
		url: "posts?actionName=homePosts",
		method: "GET",
		contentType: "application/json",
		
		success:function(posts){
			var postArray = JSON.parse(posts);	
			var $homePostsContainer = $(".contents");
			var name = "<%=name%>";
			for(var i in postArray){
				if(postArray[i].userName==name){
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div>');
					$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
				}
				else{
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div><br>')
				}
				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
				$homePostsContainer.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
				$homePostsContainer.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br><br>');
			}
		},
		error:function(t, ts, tse){
			alert("hh");
			console.log("error")
		}
	});
};  // end updateContents

function postByRootId(root_id){
	jQuery.ajax({
		url: "posts?actionName=postsByCategory&&categoryId="+root_id,
		method: "GET",
		contentType: "",
		success:function(posts){
			var Array = JSON.parse(posts);
			var name = '<%=name%>';
			var $postByCat = $(".contents");
			$postByCat.append('<div><h2>'+Array[0].root_category+'</h2></div><br><br>');	
			for(var i in Array){
				
				if(Array[i].userName==name){
					$postByCat.append('<div><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></div>').append('<div class="edit-post"><a href="editPost.jsp?post_id='+Array[i].post_id+'">Edit</a></div><br>')
				}
				else{
					$postByCat.append('<div><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></div><br>')
				}
				$postByCat.append('<div>'+Array[i].createdAt+'</div> &nbsp <div>'+Array[i].userName+'</div>')
				$postByCat.append('<div class="content-summary" id="'+Array[i].post_id+'"><p class="truncate">'+Array[i].content+'</p></div>')
				$postByCat.append('<div class="read-more"><a class='+Array[i].post_id+' href= "javascript:void(0)" onclick="theFunction('+Array[i].post_id+');">Read more</a></div><br><br>')
			}
		}
});
}; // end postByRootId
function postsByTags(tag_id,tag){
	jQuery.ajax({
		url:"posts?actionName=postsbyTag&&tagId="+tag_id+"&&tag="+tag,
		method:"GET",
		contentType:"",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $post = $(".contents");
			$post.append('<div><h2>'+tag+'</h2></div><br><br>');
			for(var i in postArray){
			$post.append('<div><h3>'+postArray[i].title+'</h3></div><br>')
			$post.append('<div>'+postArray[i].createdAt+'</div> &nbsp <div>'+postArray[i].userName+'</div>')
			$post.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p><div><br>')
			$post.append('<div class="read-more"><a class='+postArray[i].post_id+' href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br><br>')
         }
			
		},
		error: function (error) {
        }
	});
} // end postsByTags
function searchPosts(word){
	jQuery.ajax({
		url: "posts?actionName=searchPosts&&word="+word,
		method: "GET",
		contentType: "application/json",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $homePostsContainer = $(".contents");
			var name = '<%=name%>';
			var displayWordArray = word.split("+");
			var displayWord ="";
			for(var k in displayWordArray){
				displayWord += displayWordArray[k] +" ";
			}
			displayWord = displayWord.substring(0, displayWord.length-1);
			if(postArray.length==0){
				$homePostsContainer.append('<div><p>No results found for keyword <b>"'+displayWord+'"</b></p></div><br>')
			} // end of if statement
			else{
				$homePostsContainer.append('<div><p>Search results for keyword <b>"'+displayWord+'"</b></p></div><br>')
				for(var i in postArray){
					if(postArray[i].userName==name){
						$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
					}  // end of if
					$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
					$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
					$homePostsContainer.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
					$homePostsContainer.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br><br>')
				} // end for loop
			} // end of else statement
		},  // end of success function
		error:function(t, ts, tse){
			console.log("error")
		} // end of error function
	}); // end of ajax call
} // end of method searchPosts

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
				$post.append('<div class = "contents-head"><div class="left-head"><h2>My Posts</h2></div><div class="right-head add-post"><a href="addPost.jsp">Add new post</a></div></div><br><br>');
				for(var i in postArray){
				$post.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'"><h3>'+postArray[i].title+'</h3></a></div>');
				$post.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>');
				$post.append('<div>'+postArray[i].createdAt+'</div> &nbsp <div>'+postArray[i].userName+'</div>');
				$post.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
				$post.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br><br>');
			}
         }
			
		},
		error: function (error) {
        }
	});
} // end myPosts

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
				$post.append('<div class="edit-post"><a href="editPost.jsp?post_id='+post_id+'">Edit</a></div><br>')
			}
			else{
				$post.append('<div><h2>'+post.title+'</h2></div><br>');
			}
			$post.append('<div>'+post.createdAt+'</div> &nbsp <div>'+post.userName+'</div>')
			$post.append('<div><p>'+post.content+'</p><div><br>')
			$post.append('<div class="comments"><h3 >Comments</h3></div>');
			$post.append('<form class= "form" method="post" action="posts?actionName=addComment&&employee_id='+employee_id+'&&postId='+post_id+'"> '
					+'<textarea name="comment" id= jqte-comment class="jqte-test"></textarea><br><br>'
					+'<div ><button type="reset" value="Reset" class="post-submit">Reset</button>'
					+'<input type="submit" value="Submit"></div></form><br>');
					
			var postComments = post.comments;
			for(var i in postComments){
				$post.append('<div class="post-comment"><p>'+postComments[i].comment+'</p></div><br>');
				$post.append('<div class="comment-name"><a href="#">'+postComments[i].name+'</div>&nbsp<div class="comment-time">'+postComments[i].created_at+'</div><br>')
			}
		}
	});
} // end loadPost
</script>
</head>
<body>
<div class="contents"></div>
</body>
</html>