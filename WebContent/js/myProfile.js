function myProfile(employee_id){
	jQuery.ajax({
		url:"EmployeeServlet?actionName=myDetails&&employeeId="+employee_id,
		method:"GET",
		contentType:"",
		success:function(userDetails)
		{
			var user = JSON.parse(userDetails);
			var $user = $(".userDetails");
			$user.append('<div class ="account-head" style=" margin-left: -20px"><h2>My Account</h2>'
					+'<a class="edit-account" href="editProfile.jsp?employee_id='+employee_id+'">Edit Account</a>'
					+'<a class="change-password" href="changePassword.jsp?employee_id='+employee_id+'">Change Password</a><br><br>');
			$user.append('<div>Name:'+'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' + user.name+'</div><br><br>');
			
			$user.append('<div>Designation: &nbsp&nbsp   '+user.designation+'</div><br><br>');
			$user.append('<div>Email:   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp '+user.email+'</div><br><br>');
			$user.append('<div>Mobile:  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp '+user.mobile_no+'</div><br><br>')
		}
	});
}