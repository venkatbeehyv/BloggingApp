package com.beehyv.blogging.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.blogging.modal.Post;
import com.beehyv.blogging.service.PostService;
import com.beehyv.blogging.service.TagService;
import com.google.gson.Gson;

/**
 * @author Venkat
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
		if("recentPosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getRecentPosts();
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		else if("homePosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getHomePosts();
			req.setAttribute("posts", posts);
			Gson gson = new Gson();
			String postsJSONString = gson.toJson(posts);
			PrintWriter writer = resp.getWriter();
			System.out.println(postsJSONString);
			writer.println(postsJSONString);
		}
		else if("homeTags".equalsIgnoreCase(actionName)){
			List<com.beehyv.blogging.modal.Tag> tags = tagService.getHomeTags();
			req.setAttribute("tags", tags);
			Gson gson = new Gson();
			String tagsJSONString = gson.toJson(tags);
			PrintWriter writer = resp.getWriter();
			System.out.println(tagsJSONString);
			writer.println(tagsJSONString);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside HomeServlet::");
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/Home.jsp");
		req.setAttribute("name", "Hi This is venkat");
		dispatcher.forward(req, resp);
	}

}