
function updateTags(){
	

	jQuery.ajax({
		url: "tags?actionName=homeTags",
		method: "GET",
		contentType: "",
		success:function(tags){
			
			var tagsArray = JSON.parse(tags);
			
			var $tagContainer = $(".tags");
			for(var i in tagsArray){
				//alert(tagsArray[i].idTag);
				$tagContainer.append('<div><a href="tags/tag?actionName=postsbyTag&tagId='+tagsArray[i].idTag+'">'+tagsArray[i].tag+'</a></div>')
				
			}
			
		},
		error:function(e){
			
		}
	});
}
