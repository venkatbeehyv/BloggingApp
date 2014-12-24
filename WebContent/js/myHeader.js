var currentUser=currentUser1; 
var employee_id = currentUser.getEmployee_id();
jQuery(document).ready(function()
		{
		if(employee_id != 0){
			$(".main_top").append('<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></div>');
			$(".main_top").append('<div id="reg"> <a href="Logout.html" style="color:Azure">Logout</a></div>');
			$(".main_top").append('<div class="addPost"><a href="AddPost.html" style="color:Azure">Add Post</a></div>');
			$(".main_top").append('<div class="myPosts"><a href="MyPosts.jsp?employee_id='+currentUser.employee_id +'" style="color:Azure;">MyPosts</a></div> ');
			$(".main_top").append('<div id="id">'+currentUser.name+'</div>")');
		}
		else{
			
		}			
		});