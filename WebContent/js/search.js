function searchPosts(word){
jQuery.ajax({
        		url: "posts?actionName=searchPosts&&word="+word,
        		method: "GET",
        		contentType: "application/json",
        		
        		success:function(posts){
        			var postArray = JSON.parse(posts);	
        			var $homePostsContainer = $(".contents");
        			var name = '<%=name%>';
        			if(postArray.length==0){
        				$homePostsContainer.append('<div><p>No results found for keyword '+word+'</p></div><br>')
        			}
        			else{
	        			$homePostsContainer.append('<div><p>Search results for keyword '+word+'</p></div><br>')
	        			for(var i in postArray){
	        				if(postArray[i].userName==name){
	        					
	        					$homePostsContainer.append('<div class="edit-post"><a href="editPost.jsp?post_id='+postArray[i].post_id+'">Edit</a></div><br>')
	        				}
	        				$homePostsContainer.append('<div><a href="Post.jsp?postId='+postArray[i].post_id+'" ><h5>'+postArray[i].title+'</h5></div><br>')
	        				$homePostsContainer.append('<div class="post-time">'+postArray[i].createdAt+'</div> &nbsp <div class="post-name">'+postArray[i].userName+'</div>')
	        				$homePostsContainer.append('<div class="content-summary"><p class="truncate">'+postArray[i].content.substring(0, 1000)+'</p></div>');
	        				$homePostsContainer.append('<div class="read-more"><a href="#">Read more</a></div><br><br>')
	        			}	
	        		}
        		},
        		error:function(t, ts, tse){
        			console.log("error")
        		}
        });
}