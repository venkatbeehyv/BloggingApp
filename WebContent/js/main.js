function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
function searchPosts(){
	 /*$('#search-box').on("keypress",function(event) {
        if (event.keyCode == 13) {
        	var word = $('#search-box').val();
        	var searchURL = "Search.jsp?word="+word;
        	window.location.href = searchURL;
        	searchPosts(word);
         }
});*/
	$('#search-box').keypress(function(e) {
	    if(e.which == 13) {
	    	var word = $('#search-box').val();
        	var searchURL = "/Search.jsp?word="+word.toString();
        	
        	window.location.assign(searchURL);
        	alert(window.location.href)
	    }
	});
}