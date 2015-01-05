<%@ page language="java" import="com.beehyv.blogging.modal.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type="text/javascript">
	jQuery(document).ready(function(){
			var a = document.getElementsByClassName("menu-col");
			/* var b= this.className;
			var c = $(this).find("ul") */
			
			for (var i = 0; i < a.length; i++) {
				var d = $(a[i]).find("ul");
				if(d==null){
					i++;
				}
				if(d!=null){
					var categoryId = parseInt(d[0].className, 10);
					jQuery.ajax({
						url: "CategoryServlet?actionName=getChildren&&categoryId="+categoryId,
						method: "GET",
						contentType: "application/json",
						
						success:function(categories){
							if(categories == null){
								
							}
							else {
								var categoriesArray = JSON.parse(categories);	
								
								var $Container = $(".menu-col ."+categoryId);
								
								for(var i in categoriesArray){
									if(categoriesArray[i].idCategory!=0){
									$Container.append('<li class="menu-col" id="'+categoriesArray[i].categoryName+'">'
														+'<a href="Category.jsp?root_id='+categoriesArray[i].idCategory+'">'+categoriesArray[i].categoryName+'</a>'
														+'<ul class="'+categoriesArray[i].idCategory+'"></ul></li>');
									}
								}
							}
						},
						error: function(request,error) 
						{
						 console.log(arguments);
						 alert ( " Can't do because: " + error );
						}
					}); // end of ajax call
				}
			}
	});
</script>
<jsp:include page="Lib.jsp"></jsp:include>
</head>
<body>
<div id="menu-bar">
<ul class="menu-bar">
	<li id="home">
		<h3>
			<a href="Home.jsp">Home</a>
		</h3>
	</li>
<li class="menu-col" id="Technologies"><h3><a href="Category.jsp?root_id=2">Technologies</a></h3><ul class="2" ></ul></li>
<li class="menu-col" id="Frameworks"><h3><a href="Category.jsp?root_id=3">Frameworks</a></h3><ul class="3" ></ul></li>
<li class="menu-col" id="Databases"><h3><a href="Category.jsp?root_id=4">Databases</a></h3><ul class="4" ></ul></li>
<li class="menu-col" id="Web Services"><h3><a href="Category.jsp?root_id=5">Web Services</a></h3><ul class="5" ></ul></li>
<li class="menu-col" id="UI"><h3><a href="Category.jsp?root_id=6">UI</a></h3><ul class="6" ></ul></li>
<li class="menu-col" id="Others"><h3><a href="Category.jsp?root_id=7">Others</a></h3><ul class="7"></ul></li>
</ul>
</div>
</body>
</html>