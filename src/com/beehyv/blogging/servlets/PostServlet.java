package com.beehyv.blogging.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.blogging.modal.Comment;
import com.beehyv.blogging.modal.Post;
import com.beehyv.blogging.modal.Tag;
import com.beehyv.blogging.service.PostService;
import com.beehyv.blogging.service.TagService;
import com.google.gson.Gson;

/**
 * @author VenkatNo restriction on the depth of the links
 *
 */

public class PostServlet extends HttpServlet {
	
	PostService postService = new PostService();
	TagService tagService = new TagService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside PostServlet:");
		
		String actionName = req.getParameter("actionName");
		System.out.println("actionName: " + actionName);
	//	String actionName = "recentPosts";
		//returns 3 recent posts
		if("recentPosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getRecentPosts();
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		//returns posts displayed in main blog
		else if("homePosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getHomePosts();
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		// returns tags displayed in homepage
		else if("homeTags".equalsIgnoreCase(actionName)){
			List<Tag> tags = tagService.getHomeTags();
			req.setAttribute("tags", tags);
			Gson gson = new Gson();
			String tagsJSONString = gson.toJson(tags);
			PrintWriter writer = resp.getWriter();
			System.out.println(tagsJSONString);
			writer.println(tagsJSONString);
		}
		//search
		else if("searchPosts".equalsIgnoreCase(actionName)){
			String word = req.getParameter("word");
			List<Post> posts = postService.searchPosts(word);
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		// returns posts linked to that particular tag
		else if("postsbyTag".equalsIgnoreCase(actionName)){
			String tagId = req.getParameter("tagId");
			List<Post> posts = postService.getPostsbytag(Long.valueOf(tagId));
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		// returns recent posts in that particular Category
		else if("postsByCategory".equalsIgnoreCase(actionName)){
			String categoryId = req.getParameter("categoryId");
			List<Post> posts = postService.getPostsbyCategory(Long.valueOf(categoryId));
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		// returns all the posts posted by loggedin user
		else if("myPosts".equalsIgnoreCase(actionName)){
			String employeeId = req.getParameter("employee_id");
			List<Post> posts = postService.getMyPosts(Long.valueOf(employeeId));
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		// returns whole post when clicked on it
		else if("post".equalsIgnoreCase(actionName)){
			String postId = req.getParameter("postId");
			Post post = postService.getPost(Long.valueOf(postId));
			req.setAttribute("post", post);
			Gson gson = new Gson();
			String postJSONString = gson.toJson(post);
			PrintWriter writer = resp.getWriter();
			System.out.println(postJSONString);
			writer.println(postJSONString);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("Inside PostServlet::");
		
		String actionName = request.getParameter("actionName");
		System.out.println("actionNAme: " + actionName);
		
		
		//adds a post to the database
		if("addPost".equalsIgnoreCase(actionName)){
			// adding a post
			Post post = new Post();
			
			
			String employee_id = request.getParameter("employee_id");
			post.setUserId(Long.valueOf(employee_id));
			post.setTitle(request.getParameter("title"));
			post.setContent(request.getParameter("contents"));
			post.setCategoryID(2);
			postService.addPost(post);
			
			System.out.println("check1");
			//adding taglist
			String tags = request.getParameter("tags");
			String[] tagArray = tags.split(", ");
			List<Tag> tagList = new ArrayList<Tag>();
			for(int i=0; i<tagArray.length;i++){
				Tag tag = new Tag();
				tag.setTag(tagArray[i]);
				tagList.add(tag);
			}
			tagService.addTags(tagList);
			
			response.sendRedirect("MyPosts.jsp?employee_id="+employee_id);
		}
		
		//add comment to the database
		else if("addComment".equalsIgnoreCase(actionName)){
			Comment comment=new Comment();
			comment.setComment(request.getParameter("comment"));
			String employee_id = request.getParameter("employee_id");
			comment.setIdEmployee(Long.valueOf(employee_id));
			String post_id = request.getParameter("post_id");
			comment.setIdPost(Long.valueOf(post_id));
			postService.addComment(comment);
			response.sendRedirect("Post.jsp?employee_id="+employee_id);
		}
		// edit post
		else if("editPost".equalsIgnoreCase(actionName)){
			Gson gson = new Gson();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
			  BufferedReader reader = request.getReader();
			  while ((line = reader.readLine()) != null)
			    jb.append(line);
			  } catch (Exception e) { /*report an error*/ }
			
		    Post post = gson.fromJson(jb.toString(),Post.class);
			postService.editPost(post);
		}
	}

}