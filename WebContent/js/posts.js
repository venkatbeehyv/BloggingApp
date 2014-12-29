function updateRecentPosts(){
	

	jQuery.ajax({
		url: "posts?actionName=recentPosts",
		method: "GET",
		contentType: "",
		success:function(posts){
			var postsArray = JSON.parse(posts)
			
			var $recntPostsContainer = $(".recent");
			for(var i in postsArray){
				$recntPostsContainer.append('<div class="recent-post"><a href="Post.jsp?postId='+postsArray[i].post_id+'" style="font-size:15px" >'+postsArray[i].title+'</a></div><br>');
				$recntPostsContainer.append('<div>'+postsArray[i].createdAt+'</div><br><br>')
			}
			
		},
		error:function(e){
			
		}
	});
	
}
/*
function updateContents(){
	
	jQuery.ajax({
		url: "posts?actionName=homePosts",
		method: "GET",
		contentType: "application/json",
		
		success:function(posts){
			var postArray = JSON.parse(posts);	
			var $homePostsContainer = $(".contents");
			var value = "<%=((Employee)session.getAttribute("currentUser")).getName()%>";
			for(var i in postArray){
//				if(postArray[i].userName==value){
//					$homePostsContainer.append('<div><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
//				}
				$homePostsContainer.append('<div><a href="Category.jsp?root_id='+postArray[i].root_id+'"><h2>'+postArray[i].root_category+'</h2></div><br>')
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
}*/
/*$('.read-more').click(function(){
	   $('.truncate').html();
});
*/