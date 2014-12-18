function loadPost(post_id){
	jQuery.ajax({
		url:"posts?actionName=post&&postId="+post_id,
		method:"GET",
		contentType:"",
		success:function(posts){
			var post = JSON.parse(posts);
			var $post = $(".contents");
			$post.append('<div><h2>'+post.title+'</h2></div><br>')
			$post.append('<div>'+post.createdAt+'</div> &nbsp <div>'+post.userName+'</div>')
			$post.append('<div><p>'+post.content+'</p><div><br>')
			$post.append('<div><h3 class="comments">Comments</h3></div>')
			var postComments = post.comments;
			for(var i in postComments){
				$post.append('<div class="post-comment"><p>'+postComments[i].comment+'</p></div><br>')
				$post.append('<div class="comment-name"><a href="#">'+postComments[i].name+'</div>&nbsp<div class="comment-time">'+postComments[i].created_at+'</div><br>')
			}
		}
	});
}

jQuery(document).ready(function()
		{
			
			updateRecentPosts();
			updateTags();
			
			var first = getUrlVars()["postId"];
			var post_id= parseInt(first);
			
			loadPost(post_id);
			
		});

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}