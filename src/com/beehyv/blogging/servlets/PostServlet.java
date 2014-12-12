package com.beehyv.blogging.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
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
		System.out.println("Inside PostServlet::");
		
		String actionName = req.getParameter("actionName");
		System.out.println("actionNAme: " + actionName);
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
			String employeeId = req.getParameter("employeeId");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside PostServlet::");
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/Home.jsp");
		String actionName = req.getParameter("actionName");
		System.out.println("actionNAme: " + actionName);
		
		req.setAttribute("name", "Hi This is venkat");
		dispatcher.forward(req, resp);
		
		//adds a post to the database
		if("addPost".equalsIgnoreCase(actionName)){
			Gson gson = new Gson();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
			  BufferedReader reader = req.getReader();
			  while ((line = reader.readLine()) != null)
			    jb.append(line);
			  } catch (Exception e) { /*report an error*/ }
			
		    Post post = gson.fromJson(jb.toString(),Post.class);
			postService.addPost(post);
		}
		
		else if("editPost".equalsIgnoreCase(actionName)){
			Gson gson = new Gson();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
			  BufferedReader reader = req.getReader();
			  while ((line = reader.readLine()) != null)
			    jb.append(line);
			  } catch (Exception e) { /*report an error*/ }
			
		    Post post = gson.fromJson(jb.toString(),Post.class);
			postService.editPost(post);
		}
	}

}