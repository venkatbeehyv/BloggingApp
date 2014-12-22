var arr= { name:oForm.elements["Name"].value ,
		   password:oForm.elements["Password"].value ,
		   email:oForm.elements["Email"].value ,
		   mobile_no:oForm.elements["Mobile"].value  };
if(oForm.elements["Confirm password"].value==password){
function register(){
	jQuery.ajax({
	    url: 'user?actionName=Register',
	    type: 'POST',
	    data: JSON.stringify(arr),
	    contentType: 'application/json; charset=utf-8',
	    dataType: 'json',
	    async: false,
	    success: function(msg) {
	        alert(msg);
	    }
	});
}
}
else{
	window.location="/Login.html";
}
jQuery(document).ready(function()
		{
			
			register();
			
		
		});