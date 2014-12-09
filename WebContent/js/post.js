function loadPost(post_id){
	jquery.ajax({
		url:"posts?actionName=post",
		method:"GET",
		contentType:"",
		success:function(posts){
			var post = JSON.parse(posts);
			var $post = $(".contents");
			$post.append('<div><h2>'+post.title+'</h2></div><br>')
			$post.append('<div>'+post.createdAt+'</div>')
			$post.append('<div><p>'+post.content+'</p><div><br>')
			$post.append('<div><h4>Comments</h4></div>')
			var postComments = post.comments;
			for(var i in postComments){
				$post.append('<div><p>'+postComments[i].comment+'</p></div><br>')
				$post.append('<div><a href="#">'+postComments[i].name+'</div>&nbsp<div>'+postComments[i].created_at+'</div><br>')
			}
		}
	});
}
function init(){
	$( "#login" ).dialog({ autoOpen: false });
	
	$( "#id" ).click(function() {
		$( "#login" ).dialog( "open" );
	});
	
	$( "#register" ).dialog({ autoOpen: false });
	
	$( "#reg" ).click(function() {
		$( "#register" ).dialog( "open" );
	});
}
jQuery(document).ready(function()
		{
			init();
			updateRecentPosts();
			loadPost(post_id);
		});