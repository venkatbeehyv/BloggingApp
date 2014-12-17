function updateRecentPosts(){
	

	jQuery.ajax({
		url: "posts?actionName=recentPosts",
		method: "GET",
		contentType: "",
		success:function(posts){
			var postsArray = JSON.parse(posts)
			
			var $recntPostsContainer = $(".recent");
			for(var i in postsArray){
				$recntPostsContainer.append('<div class="recent-post"><a href="Post.jsp?postId='+postsArray[i].post_id+'" style="font-size:15px" >'+postsArray[i].title+'</a></div><br>')
				$recntPostsContainer.append('<div>'+postsArray[i].createdAt+'</div><br><br>')
			}
			
		},
		error:function(e){
			
		}
	});
	
}
function updateContents(){
	
	jQuery.ajax({
		url: "posts?actionName=homePosts",
		method: "GET",
		contentType: "",
		
		success:function(posts){
			var postArray = JSON.parse(posts)	
			
			var $homePostsContainer = $(".contents");
			for(var i in postArray){
				$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div><br>')
//				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" onclick="return loadPost('+postArray[i].post_id+');"><h5>'+postArray[i].title+'</h5></div><br>')
				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
				//console.log("check"+postArray[i].post_id);
				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
				$homePostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content+'</p></div><br><br>')
			}
			
		},
	error:function(e){
		
	}
	});
}
