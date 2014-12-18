function myHomePosts(){
	jQuery.ajax({
		url: "posts?actionName=myPosts",
		method: "GET",
		contentType: "",
		
		success:function(posts){
			var postArray = JSON.parse(posts)	
			
			var $homePostsContainer = $(".contents");
			for(var i in postArray){
				$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div><br>')
				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div>')
				$homePostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content+'</p></div><br><br>')
			}
			
		},
	error:function(e){
		
	}
	});
}