
function updateTags(){
	

	jQuery.ajax({
		url: "tags?actionName=homeTags",
		method: "GET",
		contentType: "",
		success:function(tags){
			
			var tagsArray =JSON.parse(tags);
			
			var $tagContainer = $(".tags");
			
			for(var i in tagsArray){
				//alert(tagsArray[i].idTag);
				$tagContainer.append('<div class = "homeTags"><a href="Tag.jsp?actionName=postsbyTag&&tagId='+tagsArray[i].idTag+'&&tag='+tagsArray[i].tag+'">'+tagsArray[i].tag+'</a></div><br>')
				
			}
			
		},
		error: function (error) {
        }
	});
}
