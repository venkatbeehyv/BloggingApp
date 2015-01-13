function searchPosts(word){
	jQuery.ajax({
		url: "posts?actionName=searchPosts&&word="+word,
		method: "GET",
		contentType: "application/json",
		success:function(posts){
			var postArray = JSON.parse(posts);
			var $homePostsContainer = $(".contents");
			var name = '<%=name%>';
			var displayWordArray = word.split("+");
			var displayWord ="";
			for(var k in displayWordArray){
				displayWord += displayWordArray[k] +" ";
			}
			displayWord = displayWord.substring(0, displayWord.length-1);
			if(postArray.length==0){
				$homePostsContainer.append('<div><p>No results found for keyword <b>"'+displayWord+'"</b></p></div><br>')
			} // end of if statement
			else{
				$homePostsContainer.append('<div><p>Search results for keyword <b>"'+displayWord+'"</b></p></div><br>')
				for(var i in postArray){
					if(postArray[i].userName==name){
						$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
					}  // end of if
					$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
					$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
					$homePostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content.substring(0, 1000)+'</p></div>');
					$homePostsContainer.append('<div><a href="#" class="read-more '+postArray[i].post_id+'">Read more</a></div><br><br>')
				} // end for loop
			} // end of else statement
		},  // end of success function
		error:function(t, ts, tse){
			console.log("error")
		} // end of error function
	}); // end of ajax call
} // end of method searchPosts