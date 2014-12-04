function updateRecentPosts(){
	

	jQuery.ajax({
		url: "posts?actionName=recentPosts",
		method: "GET",
		contentType: "",
		success:function(posts){
			var postsArray = JSON.parse(posts)
			
			var $recntPostsContainer = $(".recent");
			for(var i in postsArray){
				$recntPostsContainer.append('<div><a href="posts/post?post_id="'+postsArray[i].post_id+' style="font-size:15px" >'+postsArray[i].title+'</a></div><br>')
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
			
			var $recntPostsContainer = $(".contents");
			for(var i in postArray){
				$recntPostsContainer.append('<div><a href="posts/post?root_id="'+postArray[i].root_id+'><h2>'+postArray[i].root_category+'</h2></div><br>')
				$recntPostsContainer.append('<div><a href="posts/post?post_id="'+postArray[i].post_id+'><h5>'+postArray[i].title+'</h5></div><br>')
				$recntPostsContainer.append('<div>'+postArray[i].createdAt+'</div> &nbsp <div>'+postArray[i].userName+'</div>')
				$recntPostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content+'</p></div><br><br>')
			}
			
		},
	error:function(e){
		
	}
	});
}