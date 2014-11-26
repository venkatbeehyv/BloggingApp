function updateRecentPosts(){
	

	jQuery.ajax({
		url: "posts?actionName=recentPosts",
		method: "GET",
		contentType: "",
		success:function(posts){
			var postsArray = JSON.parse(posts)
			
			var $recntPostsContainer = $(".recent");
			for(var i in postsArray){
				$recntPostsContainer.append('<div><a href="posts/post?post_id="'+postsArray[i].post_id+'"">'+postsArray[i].title+'</a></div>')
				$recntPostsContainer.append('<div>'+postsArray[i].createdAt+'</div>')
			}
			
		},
		error:function(e){
			
		}
	});
}