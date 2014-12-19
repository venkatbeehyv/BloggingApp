function postsByTags(tag_id,tag){
	jQuery.ajax({
		url:"Tag.jsp?actionName=postsbyTag&&tagId="+tag_id+"&&tag="+tag,
		method:"GET",
		contentType:"",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $post = $(".contents");
			$post.append('<div><h2>'+tag+'</h2></div><br>');
			for(var i in postArray){
			$post.append('<div><h2>'+postArray[i].title+'</h2></div><br>')
			$post.append('<div>'+postArray[i].createdAt+'</div> &nbsp <div>'+postArray[i].userName+'</div>')
			$post.append('<div><p>'+postArray[i].content+'</p><div><br>')
         }
			
		},
		error: function (error) {
        }
	});
}

jQuery(document).ready(function()
		{
			
			updateRecentPosts();
			updateTags();
			
			var first = getUrlVars()["tagId"];
			var tag_id= parseInt(first);
			var tag = getUrlVars()["tag"];
			postsByTags(tag_id,tag);
			
		});

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}