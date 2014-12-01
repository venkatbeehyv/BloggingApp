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
	jQuery.ajax({
		url: "posts?actionName=homePosts",
		method: "GET",
		contentType: "",
		
		success:function(posts){
			var postArray = JSON.parse(posts)	
			
			var $recntPostsContainer = $(".contents");
			for(var i in postArray){
				$recntPostsContainer.append('<div><a href="posts/post?root_id="'+postArray[i].root_id+' style="font-size:30px"><h1>'+postArray[i].root_category+'</h1></div><br>')
				$recntPostsContainer.append('<div><a href="posts/post?post_id="'+postArray[i].post_id+'><h3>'+postArray[i].title+'</h3></div><br>')
				$recntPostsContainer.append('<div>'+postArray[i].createdAt+'</div><div>'+postArray[i].userName+'</div>')
				$recntPostsContainer.append('<div><p>'+postArray[i].content+'</p></div><br><br><br>')
			}
			
		},
	error:function(e){
		
	}
	});
}