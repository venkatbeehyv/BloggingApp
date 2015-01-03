<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$("#menu-bar").hover
</script>
<jsp:include page="Lib.jsp"></jsp:include>
</head>
<body>
<div class="menu-bar">
	<div class="home" id="menu-bar">
		<h3>
			<a href="Home.jsp">Home</a>
			<li>
			<ul>a</ul>
			<ul>b</ul>
			<ul>c</ul> 
			</li>
		</h3>
	</div>
<div class="Technologies" id="menu-bar"><h3><a href="Category.jsp?root_id=2">Technologies</a></h3></div>
<div class="Frameworks" id="menu-bar"><h3><a href="Category.jsp?root_id=3">Frameworks</a></h3></div>
<div class="Databases" id="menu-bar"><h3><a href="Category.jsp?root_id=4">Databases</a></h3></div>
<div class="Web Services" id="menu-bar"><h3><a href="Category.jsp?root_id=5">Web Services</a></h3></div>
<div class="UI" id="menu-bar"><h3><a href="Category.jsp?root_id=3">UI</a></h3></div>
<div class="Others" id="menu-bar"><h3><a href="Category.jsp?root_id=3">Others</a></h3></div>
</div>
</body>
</html>