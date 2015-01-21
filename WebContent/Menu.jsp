<%@ page language="java" import="java.util.List, com.beehyv.blogging.modal.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Lib.jsp"></jsp:include>
<script type="text/javascript">
jQuery(document).ready(function(){		
	initializeMenu();
});

</script>
<jsp:include page="Lib.jsp"></jsp:include>
</head>
<body>
<div id="menu-bar">
<ul class="menu-bar">
	<li id="home" class="menu-col"><a href="Home.jsp">Home</a></li>
	<li class="menu-col"><a href="Category.jsp?root_id=2">Technologies</a><ul id="2" ></ul></li>
	<li class="menu-col"><a href="Category.jsp?root_id=3">Frameworks</a><ul id="3" ></ul></li>
	<li class="menu-col"><a href="Category.jsp?root_id=4">Databases</a><ul id="4" ></ul></li>
	<li class="menu-col"><a href="Category.jsp?root_id=5">Web Services</a><ul id="5" ></ul></li>
	<li class="menu-col"><a href="Category.jsp?root_id=6">UI</a><ul id="6" ></ul></li>
	<li class="menu-col"><a href="Category.jsp?root_id=7">Others</a><ul id="7"></ul></li>
</ul>
</div>
</body>
</html>