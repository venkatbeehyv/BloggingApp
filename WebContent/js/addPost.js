function getLeafNodes(){
	jQuery.ajax({
		url:"CategoryServlet?actionName=leafNodes",
		method:"GET",
		contentType:"",
		success:function(categories)
		{
			var categoriesArray = JSON.parse(categories);
			var container = $("#leaf-nodes")
			for(var i in categoriesArray){
				container.append('<option value="'+categoriesArray[i].idCategory+'">'+categoriesArray[i].categoryName+'</option>');
			}
		}
	});
}