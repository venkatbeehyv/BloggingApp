$("#register-id").click(function() {
			var name = $("#name").val();
			var psw = $("#password").val();
			var confPsw =$("#conf-psw").val();
			var email = $("#email").val();
			var mob = $("#mob").val();
			
			var arr= { name:name ,
					   password:psw ,
					   email:email ,
					   mobile_no:mob  };
			if(confPsw==psw){
			function register(){
				jQuery.ajax({
				    url: 'user?actionName=Register',
				    type: 'POST',
				    data: JSON.stringify(arr),
				    contentType: 'application/json; charset=utf-8',
				    dataType: 'json',
				    async: false,
				    success: function(msg) {
				    	window.location= "/MyHomePage.jsp";
				    }
				});
			}
	}
	else{
		window.location="/Register.html";
	}
		});