<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,com.beehyv.blogging.modal.Post"  
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
   <link rel='stylesheet' type='text/css' href='stylesheet.css'/>
    <script type='text/javascript' src='test.js'></script>
</head>
<body>
<!--  
<%

%> -->
<div class="main_top">
		<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/>
		</div>
		<div id="id"><a href="#" style="color:red;">Login</a> | <a href="#" style="color:red;">Register</a>
		</div>
	</div>
	<div id="categories"><h4>Home</h4> </div>
	<div class="categories"><h4>Technologies</h4>
		<div class="tech"> Java </div>
		<div class="tech"> C </div>
		<div class="tech"> C++</div>
	 </div>
	 
	<div class="categories"><h4>Frameworks</h4> 
		<div class = "frame"> Spring</div>
		<div class = "frame"> Django</div>
		<div class = "frame"> Struts</div>
	</div>
	
	<div class="categories"><h4>Databases</h4> 
		<div class="db"> MySql</div>
		<div class="db"> CouchDB</div>
		<div class="db"> Big Data</div>
	</div>
	
	<div class="categories"><h4>Web Services</h4>
		<div class="webs"> JSON-RPC </div>
		<div class="webs"> JSON-WSP</div>
		<div class="webs"> Web Template</div>
	</div>
	
	<div class="categories"><h4>UI</h4>
		<div class="ui"> Javascript </div>
		<div class="ui"> CSS </div>
	</div>
	
	<div class="categories"><h4>Others</h4> </div>
	
	<form class="search"><input type="search" placeholder="Search">
	</form>
	<div class="contents">posts
	</div>
	
	<div class = "recent"> <h1>Recent Posts</h1>
		<c:import var="post" url="/recent"/> 
		<c:forTokens items ="${post}" delims=",[]" var="pos"  >
		<c:out value="${pos}"></c:out><br>
		</c:forTokens>
		
	</div>
	
	<div class = "tags"> <h1>Tags</h1> 
	</div>
</body>
</html>