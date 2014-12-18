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

<div id="menu" style="width: 1320px; margin-left:50px;">
    <ul class="lavaLamp">
        <li><a href="http://localhost:8080/BlogginApp/Home.jsp"><span>Home</span></a>
            
        </li>
        
        <li><a href="#" class="parent"><span style="width:86px">Technologies</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Java</span></a>
                    	<div><ul>
                             <li><a href="#"><span style="background-position: -576px bottom; color: rgb(195, 191, 183);">Sub Item 1.1.1</span></a></li>
                             <li><a href="#"><span>Sub Item 1.1.2</span></a></li>
                        </ul></div>
                    </li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Python</span></a>
                        <div><ul>
                             <li><a href="#"><span style="background-position: -576px bottom; color: rgb(195, 191, 183);">Sub Item 2.1.1</span></a></li>
                        </ul></div>
                    </li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">C++</span></a></li>
                </ul>
                
            </div>
        </li>
         <li><a href="#" class="parent"><span style="width:78px;">Frameworks</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Spring</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Django</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Struts</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:67px">Databases</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">MySql</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">CouchDB</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Big Data</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:89px">Web Services</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">JSON-RPC</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">JSON-WSP</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Web Template</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#" class="parent"><span style="width:24px;padding-right: 44px;">UI</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">Javascript</span></a></li>
                    <li><a href="#"><span style="background-position: -616px bottom; color: rgb(195, 191, 183);">CSS</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#"><span style="padding-right: 7px;">Others</span></a></li>
        
    </ul>
</div>