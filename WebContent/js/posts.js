function updateRecentPosts(){
	jQuery.ajax({
		url: "posts?actionName=recentPosts",
		method: "GET",
		contentType: "",
		success:function(posts){
			var postsArray = JSON.parse(posts)
			
			var $recntPostsContainer = $(".recent");
			for(var i in postsArray){
				$recntPostsContainer.append('<div class="recent-post"><a href="Post.jsp?postId='+postsArray[i].post_id+'" style="font-size:15px" >'+postsArray[i].title+'</a></div>');
				$recntPostsContainer.append('<div>'+postsArray[i].createdAt+'</div><br>')
			}
			
		},
		error:function(e){
			
		}
	});
	
}