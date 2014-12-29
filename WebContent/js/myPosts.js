jQuery(document).ready(function()
		{
			
			updateRecentPosts();
			updateTags();
			
			var first = getUrlVars()["employee_id"];
			var employee_id= parseInt(first);
			myPosts(employee_id);
			
		});

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}