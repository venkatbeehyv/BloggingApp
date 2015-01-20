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
			var categoryTree = JSON.parse(categories);
			//console.log(categories)
			for(var i in categoryTree){
				for(var j in categoryTree[i]){
					var next =parseInt(j,10)+1;
					var nextString = next.toString();
					var element = $("#"+categoryTree[i][j].idCategory+"");
					console.log(i+","+j)
					if(element!=null && next<categoryTree[i].length){
						console.log(categoryTree[i][nextString].idCategory+": "+categoryTree[i][nextString].categoryName);
						element.append('<li class="menu-col"><h3><a href="Category.jsp?root_id='+categoryTree[i][nextString].idCategory+'">'+categoryTree[i][nextString].categoryName+'</a></h3><ul id="'+categoryTree[i][nextString].idCategory+'"></ul></li>');
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
});

</script>
<jsp:include page="Lib.jsp"></jsp:include>
</head>
<body>
<div id="menu-bar">
<ul class="menu-bar">
	<li id="home"><h3><a href="Home.jsp">Home</a></h3></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=2">Technologies</a></h3><ul id="2" ></ul></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=3">Frameworks</a></h3><ul id="3" ></ul></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=4">Databases</a></h3><ul id="4" ></ul></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=5">Web Services</a></h3><ul id="5" ></ul></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=6">UI</a></h3><ul id="6" ></ul></li>
	<li class="menu-col"><h3><a href="Category.jsp?root_id=7">Others</a></h3><ul id="7"></ul></li>
</ul>
</div>
</body>
</html>