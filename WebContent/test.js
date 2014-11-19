/**
 * 
 */
$(Document).ready(function()
{
	$('a').click(function(e){
		   e.preventDefault();
		  $.ajax({
		       url: "http://localhost:8081/BlogginApp/recent",
		       type: "POST",//type of posting the data
		       data: hi,
		       success: function (data) {
		         //what to do in success
		       },
		       error: function(xhr, ajaxOptions, thrownError){
		          //what to do in error
		       },
		       timeout : 15000//timeout of the ajax call
		  });

		});
});