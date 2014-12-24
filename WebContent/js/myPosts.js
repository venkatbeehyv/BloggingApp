function myPosts(employee_id){
	jQuery.ajax({
		url:"posts?actionName=myPosts&&employee_id="+employee_id,
		method:"GET",
		contentType:"",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $post = $(".contents");
			for(var i in postArray){
			$post.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'"><h2>'+postArray[i].title+'</h2></a></div><br>')
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
			
			var first = getUrlVars()["employee_id"];
			var employee_id= parseInt(first);
			myPosts(employee_id);
			
		});

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}