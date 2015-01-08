function myHeader(employee_id, name)
{
	if(employee_id != 0){
		
		$(".main_top").append('<div class="pic"><a href="Home.jsp"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></a></div>');
		$(".main_top").append('<div id="reg"> <a href="Logout" style="color:Azure">Logout</a></div>');
		$(".main_top").append('<div class="myProfile"><a href="myProfile.jsp?employee_id='+employee_id+'" style="color:Azure">My Account</a></div>');
		$(".main_top").append('<div class="myPosts"><a href="MyPosts.jsp?employee_id='+employee_id +'" style="color:Azure;">MyPosts</a></div> ');
		$(".main_top").append('<div id="id">'+name+'</div>');
	}
	else
	{
	$(".main_top").append('<div class="pic"><a href="Home.jsp"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/></a></div>');
	$(".main_top").append('<div id="id"><a href="Login.html" style="color:Azure;">Login</a></div>');
	$(".main_top").append('<div id="reg"> <a href="Register.jsp" style="color:Azure;">Register</a></div>');
	}
}
