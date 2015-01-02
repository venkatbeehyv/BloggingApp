function myProfile(employee_id){
	jQuery.ajax({
		url:"EmployeeServlet?actionName=myDetails&&employeeId="+employee_id,
		method:"GET",
		contentType:"",
		success:function(userDetails)
		{
			var user = JSON.parse(userDetails);
			var $user = $(".userDetails");
			$user.append('<div style=" margin-left: -20px"><h2>My Account</h2></div>'
					+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
					+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
					+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
					+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
					+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'
					+'<div class="edit-account"><a href="editProfile.jsp?employee_id='+employee_id+'">Edit Account</a></div>&nbsp&nbsp'
					+'<div class="change-password"><a href="changePassword.jsp?employee_id='+employee_id+'">Change Password</a></div><br><br>');
			$user.append('<div>Name:'+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' + user.name+'</div><br><br>');
			if(user.designation=null){
				$user.append('<div>Designation: &nbsp&nbsp   '+-+'</div><br><br>');
			}
			else{
				$user.append('<div>Designation: &nbsp&nbsp   '+user.designation+'</div><br><br>');
			}
			$user.append('<div>Email:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp '+user.email+'</div><br><br>');
			$user.append('<div>Mobile:  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp '+user.mobile_no+'</div><br><br>')
		}
	});
}
	
jQuery(document).ready(function(){
		updateTags();
		updateRecentPosts();
		
		var first = getUrlVars()["employee_id"];
		var employee_id= parseInt(first);
		
		myProfile(employee_id);
});
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}