/**
 * 
 */

jQuery(document).ready(function()
{
	init();
	updateRecentPosts();
	initializeMenu();
	updateContents();
	updateTags();
//	categoryClick();
});
function init(){
	$( "#login" ).dialog({ autoOpen: false });
	
	$( "#id" ).click(function() {
		$( "#login" ).dialog( "open" );
	});
	
	$( "#register" ).dialog({ autoOpen: false });
	
	$( "#reg" ).click(function() {
		$( "#register" ).dialog( "open" );
	});
}