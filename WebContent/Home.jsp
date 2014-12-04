<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,com.beehyv.blogging.modal.Post"  
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
  
    <link type="text/css" href="${pageContext.request.contextPath}/js/lib/apycom.com-16-gray/menu.css" rel="stylesheet" />
  
    
      <link href="http://apycom.com/ssc-data/themes/default/styles/menu.css" type="text/css" rel="stylesheet" />
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/jquery.color.js" language="javascript"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/jquery.easing.js" language="javascript"></script>
        
        
    
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/menu.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/posts.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/main.js'></script>
    
	<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	 <link rel='stylesheet' type='text/css' href='stylesheet.css'/>
	<script>
	$(document).ready(function(){
		$( "#login" ).dialog({ autoOpen: false });
		$( "#id" ).click(function() {
		$( "#login" ).dialog( "open" );
		});
		$( "#register" ).dialog({ autoOpen: false });
		$( "#reg" ).click(function() {
		$( "#register" ).dialog( "open" );
		});
		});
	</script>
    
<!-- 	Creates a menu with an unordered list of menu-items. You can either use the CSS that comes with the plugin, or write your own styles 
 * to create a personalized effect
 *
 * The HTML markup used to build the menu can be as simple as...
 *
 *       <ul class="lavaLamp">
 *           <li><a href="#">Home</a></li>
 *           <li><a href="#">Plant a tree</a></li>
 *           <li><a href="#">Travel</a></li>
 *           <li><a href="#">Ride an elephant</a></li>
 *       </ul> -->
	    
</head>
<body>

<div class="main_top">
		<div class="pic"><img alt="Beehyv" src="http://www.beehyv.com/images/logo.jpg"/>
		</div>
		<div id="id"><a href="#" style="color:red;">Login</a></div> <div id="reg"> <a href="#" style="color:red;">Register</a>
		</div>
	</div>
	<div id="login" title="Login">
	<form>
	E-mail id: <input type="text" name="Email id"><br><br>
	Password:  <input type="text" name="Password"><br><br>
	<input type="submit" value="Submit">
	</form>
	</div>
	<div id="register" title="Register">
	<form>
	Name <input type="text" name="Name"><br><br>
	Password:  <input type="text" name="Pass"><br><br>
	Confirm password: <input type="text" name="confirm Password"><br><br>
	Email: <input type="text" name="email"><br><br>
	Mobile: <input type="tel" name="phone"><br><br>
	<input type="submit" value="Submit">
	</form>
	</div>
<div id="menu">
    <ul class="lavaLamp">
        <li><a href="#"><span>Home</span></a>
            
        </li>
        
        <li><a href="#" class="parent"><span style="width:86px">Technologies</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Java</span></a></li>
                    <li><a href="#"><span>C</span></a></li>
                    <li><a href="#"><span>C++</span></a></li>
                </ul>
                
            </div>
        </li>
         <li><a href="#" class="parent"><span style="width:78px">Frameworks</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Spring</span></a></li>
                    <li><a href="#"><span>Django</span></a></li>
                    <li><a href="#"><span>Struts</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:67px">Databases</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>MySql</span></a></li>
                    <li><a href="#"><span>CouchDB</span></a></li>
                    <li><a href="#"><span>Big Data</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:89px">Web Services</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>JSON-RPC</span></a></li>
                    <li><a href="#"><span>JSON-WSP</span></a></li>
                    <li><a href="#"><span>Web Template</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:24px">UI</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Javascript</span></a></li>
                    <li><a href="#"><span>CSS</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#"><span>Others</span></a></li>
        
    </ul>
</div>
	<div class="search-container">
		<form class="search"><input type="search" placeholder="Search">
		</form>
	</div>
	<div class="matter">
	<div class="contents">
	</div>
	<div class="right-section">
		<div class = "recent"> <h2>Recent Posts<br></h2></div>
		<div class = "tags"> <h2>Tags</h2> </div>
	</div>
	</div>
</body>
</html>
