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