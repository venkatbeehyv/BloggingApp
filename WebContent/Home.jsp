<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,com.beehyv.blogging.modal.Post"  
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
   <link rel='stylesheet' type='text/css' href='stylesheet.css'/>
    <link type="text/css" href="${pageContext.request.contextPath}/js/lib/apycom.com-16-gray/menu.css" rel="stylesheet" />
  
     <link href="http://apycom.com/ssc-data/themes/default/styles/styles.css" type="text/css" rel="stylesheet" />
      <link href="http://apycom.com/ssc-data/themes/default/styles/menu.css" type="text/css" rel="stylesheet" />
      
       <script src="http://apycom.com/ssc-data/themes/default/scripts/jquery.js" language="javascript"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/jquery.color.js" language="javascript"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/jquery.easing.js" language="javascript"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/menu.js" language="javascript"></script>
        <script src="http://apycom.com/ssc-data/themes/default/scripts/main.js" language="javascript"></script>
        
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/main.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/menu.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/posts.js'></script>

    
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
		<div id="id"><a href="#" style="color:red;">Login</a> | <a href="#" style="color:red;">Register</a>
		</div>
	</div>
<div id="menu">
    <ul class="lavaLamp">
        <li><a href="#" class="parent"><span>Home</span></a>
            <div><ul>
                <li><a href="#" class="parent"><span>Sub Item 1</span></a>
                    <div><ul>
                        <li><a href="#" class="parent"><span>Sub Item 1.1</span></a>
                            <div><ul>
                                <li><a href="#"><span>Sub Item 1.1.1</span></a></li>
                                <li><a href="#"><span>Sub Item 1.1.2</span></a></li>
                            </ul></div>
                        </li>
                        <li><a href="#"><span>Sub Item 1.2</span></a></li>
                        <li><a href="#"><span>Sub Item 1.3</span></a></li>
                        <li><a href="#"><span>Sub Item 1.4</span></a></li>
                        <li><a href="#"><span>Sub Item 1.5</span></a></li>
                        <li><a href="#"><span>Sub Item 1.6</span></a></li>
                        <li><a href="#" class="parent"><span>Sub Item 1.7</span></a>
                            <div><ul>
                                <li><a href="#"><span>Sub Item 1.7.1</span></a></li>
                                <li><a href="#"><span>Sub Item 1.7.2</span></a></li>
                            </ul></div>
                        </li>
                    </ul></div>
                </li>
                <li><a href="#"><span>Sub Item 2</span></a></li>
                <li><a href="#"><span>Sub Item 3</span></a></li>
            </ul></div>
        </li>
        <li><a href="#" class="parent"><span>Technologies</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Java</span></a></li>
                    <li><a href="#"><span>C</span></a></li>
                    <li><a href="#"><span>C++</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#"><span>Help</span></a></li>
        <li class="last"><a href="#"><span>Contacts</span></a></li>
    </ul>
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
		
		
	</div>
	
	<div class = "tags"> <h1>Tags</h1> 
	</div>
</body>
</html>