function initializeMenu(){
	jQuery.ajax({
		url: "CategoryServlet?actionName=categoryTree",
		method: "GET",
		contentType: "",
		
		success:function(categories){
			var categoryTree = JSON.parse(categories);
			//console.log(categories)
			for(var i in categoryTree){
				for(var j in categoryTree[i]){
					var next =parseInt(j,10)+1;
					var nextString = next.toString();
					var element = $("#menu-bar #c"+categoryTree[i][j].idCategory+"");
					
					if(element!=null  && next<categoryTree[i].length){ 
						var checkElement = $("#menu-bar #c"+categoryTree[i][nextString].idCategory+"");
						
						if(checkElement.length==0){
							//console.log(i+","+j)
							element.append('<li class="menu-col"><a href="Category.jsp?root_id='+categoryTree[i][nextString].idCategory+'">'+categoryTree[i][nextString].categoryName+'</a><ul id="c'+categoryTree[i][nextString].idCategory+'"></ul></li>');
						}
					}
				}
			}
		},
		error: function(request,error) 
		{
		 console.log(arguments);
		 alert ( " Can't do because: " + error );
		}
	}); // end of ajax call
}