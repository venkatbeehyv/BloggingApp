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
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></a></div>');
					$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div>')
				}
				else{
					$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></a></div>')
				}
				$homePostsContainer.append('<div class="post-title"><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></a></div>')
				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+' &nbsp '+postArray[i].userName+'</div>')
				$homePostsContainer.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
				$homePostsContainer.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br>');
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
			if(Array.length!=0){
				$postByCat.append('<div><h2>'+Array[0].category_name+'</h2></div><br>');	
				for(var i in Array){
					
					if(Array[i].userName==name){
						$postByCat.append('<div class="post-title"><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></a><div class="edit-post"><a href="editPost.jsp?post_id='+Array[i].post_id+'">Edit</a></div></div>')
					}
					else{
						$postByCat.append('<div class="post-title"><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></a></div>')
					}
					$postByCat.append('<div>'+Array[i].createdAt+' &nbsp '+Array[i].userName+'</div>')
					$postByCat.append('<div class="content-summary" id="'+Array[i].post_id+'"><p class="truncate">'+Array[i].content+'</p></div>')
					$postByCat.append('<div class="read-more"><a class='+Array[i].post_id+' href= "javascript:void(0)" onclick="theFunction('+Array[i].post_id+');">Read more</a></div><br>')
				}
			}
			else{
				$postByCat.append('<div style="margin-left: 185px; margin-top:35px; font-size:120%"><b>No post</b><em> has been added yet in this category!</em></div>');
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
			var Array = JSON.parse(posts);
			var $postByCat = $(".contents");
			$postByCat.append('<div><h2>'+tag+'</h2></div>');
			for(var i in Array){
					if(Array[i].userName==name){
						$postByCat.append('<div class="post-title"><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></a><div class="edit-post"><a href="editPost.jsp?post_id='+Array[i].post_id+'">Edit</a></div></div>')
					}
					else{
						$postByCat.append('<div class="post-title"><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></a></div>')
					}
					$postByCat.append('<div>'+Array[i].createdAt+' &nbsp '+Array[i].userName+'</div>')
					$postByCat.append('<div class="content-summary" id="'+Array[i].post_id+'"><p class="truncate">'+Array[i].content+'</p></div>')
					$postByCat.append('<div class="read-more"><a class='+Array[i].post_id+' href= "javascript:void(0)" onclick="theFunction('+Array[i].post_id+');">Read more</a></div><br>');
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
				$homePostsContainer.append('<div><p>Search results for keyword <b>"'+displayWord+'"</b></p></div>')
				for(var i in postArray){
					if(postArray[i].userName==name){
						$homePostsContainer.append('<div class="post-title"><a href="Post.jsp?postId='+postArray[i].post_id+'"><h5>'+postArray[i].title+'</h5></a><div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div></div>')
					}
					else{
						$homePostsContainer.append('<div class="post-title"><a href="Post.jsp?postId='+postArray[i].post_id+'"><h5>'+postArray[i].title+'</h5></a></div>')
					}
					$homePostsContainer.append('<div>'+postArray[i].createdAt+'&nbsp'+postArray[i].userName+'</div>')
					$homePostsContainer.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
					$homePostsContainer.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br>')
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
				$post.append('<div class="myposts-head"><h2>My Posts</h2><a href="addPost.jsp" class="add-post">Add new post</a></div><br>');
				for(var i in postArray){
				$post.append('<div class="post-title"><a href="Post.jsp?postId='+postArray[i].post_id+'"><h5>'+postArray[i].title+'</h5></a><a class="edit-post" href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div>');
				$post.append('<div>'+postArray[i].createdAt+'&nbsp&nbsp'+postArray[i].userName+'</div>');
				$post.append('<div class="content-summary" id="'+postArray[i].post_id+'"><p class="truncate">'+postArray[i].content+'</p></div>');
				$post.append('<div class="read-more"><a class="'+postArray[i].post_id+'" href= "javascript:void(0)" onclick="theFunction('+postArray[i].post_id+');">Read more</a></div><br>');
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
			if(name!="null"){
				$post.append('<div class=add-post><a href="addPost.jsp">Add Post</a></div>');
			}
			
			if(post.userName==name)
			{
				$post.append('<div><h2>'+post.title+'</h2></div>');
				$post.append('<div class="edit-post"><a href="editPost.jsp?post_id='+post_id+'">Edit</a></div>')
			}
			else{
				$post.append('<div><h2>'+post.title+'</h2></div><br>');
			}
			$post.append('<div>'+post.createdAt+'&nbsp&nbsp<b>'+post.userName+'</b></div>')
			$post.append('<div><p>'+post.content+'</p><div>')
			$post.append('<div class="comments"><h3>Comments:</h3></div><br>');
			$post.append('<br><form class= "form" method="post" action="posts?actionName=addComment&&employee_id='+employee_id+'&&postId='+post_id+'"> '
					+'<textarea name="comment" id= jqte-comment class="jqte-test"></textarea><br><br>'
					+'<div ><button type="reset" value="Reset" class="post-submit">Reset</button>'
					+'<input type="submit" value="Submit"></div></form><br>');
					
			var postComments = post.comments;
			for(var i in postComments){
				$post.append('<div class="post-comment"><p>'+postComments[i].comment+'</p></div>');
				$post.append('<div class="comment-name"><b>'+postComments[i].name+'</b>&nbsp&nbsp'+postComments[i].created_at+'</div><br>')
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