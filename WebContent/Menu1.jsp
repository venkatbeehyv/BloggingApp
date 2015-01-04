<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type="text/javascript">
	jQuery(document).ready(function(){
		$("#menu-bar").mouseover(function(){
			var a = document.getElementsByClassName(this.className);
			var b= this.className;
			var c = $(this).find("ul")
			
			for (var i = 0; i < c.length; i++) {
				var d = c[i].className;
			}
			var categoryId = parseInt(d, 10);
			jQuery.ajax({
				url: "CategoryServlet?actionName=getChildren&&categoryId="+categoryId,
				method: "GET",
				contentType: "application/json",
				
				success:function(categories){
					var categoriesArray = JSON.parse(categories);	
					
					var $Container = $("."+d);
					
					for(var i in categoriesArray){
						$Container.append('<li class="'+categoriesArray[i].categoryName+'" id="menu-bar">'
											+'<a href="Category.jsp?root_id='+categoriesArray[i].idCategory+'">'+categoriesArray[i].categoryName+'</a>'
											+'<ul class="'+categoriesArray[i].idCategory+'" id="dropdown"></ul></li>');
					}
				},
				error:function(){
					
				}
			});
		});
	}); 
</script>
<jsp:include page="Lib.jsp"></jsp:include>
</head>
<body>
<div class="menu-bar">
<ul>
	<li class="home" id="menu-bar">
		<h3>
			<a href="Home.jsp">Home</a>
		</h3>
		<ul class="1" id="dropdown">
		</ul>
	</li>
<li class="Technologies" id="menu-bar"><h3><a href="Category.jsp?root_id=2">Technologies</a></h3><ul class="2" id="dropdown"></ul></li>
<li class="Frameworks" id="menu-bar"><h3><a href="Category.jsp?root_id=3">Frameworks</a></h3><ul class="3" id="dropdown"></ul></li>
<li class="Databases" id="menu-bar"><h3><a href="Category.jsp?root_id=4">Databases</a></h3><ul class="4" id="dropdown"></ul></li>
<li class="Web Services" id="menu-bar"><h3><a href="Category.jsp?root_id=5">Web Services</a></h3><ul class="5" id="dropdown"></ul></li>
<li class="UI" id="menu-bar"><h3><a href="Category.jsp?root_id=3">UI</a></h3><ul class="6" id="dropdown"></ul></li>
<li class="Others" id="menu-bar"><h3><a href="Category.jsp?root_id=3">Others</a></h3><ul class="7" id="dropdown"></ul></li>
</ul>
</div>
</body>
</html>