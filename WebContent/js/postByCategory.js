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
			var first = getUrlVars()["root_id"];
			var root_id= parseInt(first);
			
			postByRootId(root_id);
		});
function postByRootId(root_id){
	jQuery.ajax({
		url: "posts?actionName=postsByCategory&&categoryId="+root_id,
		method: "GET",
		contentType: "",
		success:function(posts){
			var Array = JSON.parse(posts);
			
			var $postByCat = $(".contents");
			$postByCat.append('<div><h2>'+Array[0].root_category+'</h2></div><br>');	
			for(var i in Array){
				$postByCat.append('<div><a href="Post.jsp?postId='+Array[i].post_id+'"><h5>'+Array[i].title+'</h5></div><br>')
				$postByCat.append('<div>'+Array[i].createdAt+'</div> &nbsp <div>'+Array[i].userName+'</div>')
				$postByCat.append('<div class="content-summary"><p class="truncate">'+Array[i].content+'</p></div><br><br>')
			}
		}
});
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}