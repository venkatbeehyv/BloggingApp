function myPosts(employee_id){
	jQuery.ajax({
		url:"posts?actionName=myPosts&&employeeId="+employeeId,
		method:"GET",
		contentType:"",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $post = $(".contents");
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
			
			var first = getUrlVars()["employeeId"];
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