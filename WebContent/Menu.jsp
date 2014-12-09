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
        <li><a href="#" class="parent"><span style="width:24px;padding-right: 44px;">UI</span></a>
            <div class="columns two">
                <ul class="one">
                    <li><a href="#"><span>Javascript</span></a></li>
                    <li><a href="#"><span>CSS</span></a></li>
                </ul>
                
            </div>
        </li>
        <li><a href="#"><span style="padding-right: 7px;">Others</span></a></li>
        
    </ul>
</div>