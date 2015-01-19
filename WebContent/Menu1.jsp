<%@ page language="java" import="java.util.List, com.beehyv.blogging.modal.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type="text/javascript">
jQuery(document).ready(function(){		
	jQuery.ajax({
		url: "CategoryServlet?actionName=categoryTree",
		method: "GET",
		contentType: "",
		
		success:function(categories){
			categoryTree = JSON.parse(categories);
			//console.log(categories)
			for(var i in categoryTree){
				for(var j in categoryTree[i]){
					console.log(categoryTree[i][j])
				}
			}
		},
		error: function(request,error) 
		{
		 console.log(arguments);
		 alert ( " Can't do because: " + error );
		}
	}); // end of ajax call
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
<li class="menu-col" id="Technologies">
	<h3><a href="Category.jsp?root_id=2">Technologies</a></h3>
	<ul class="2" >
		
	</ul>
</li>
<li class="menu-col" id="Frameworks"><h3><a href="Category.jsp?root_id=3">Frameworks</a></h3><ul class="3" ></ul></li>
<li class="menu-col" id="Databases"><h3><a href="Category.jsp?root_id=4">Databases</a></h3><ul class="4" ></ul></li>
<li class="menu-col" id="Web Services"><h3><a href="Category.jsp?root_id=5">Web Services</a></h3><ul class="5" ></ul></li>
<li class="menu-col" id="UI"><h3><a href="Category.jsp?root_id=6">UI</a></h3><ul class="6" ></ul></li>
<li class="menu-col" id="Others"><h3><a href="Category.jsp?root_id=7">Others</a></h3><ul class="7"></ul></li>
</ul>
</div>
</body>
</html>