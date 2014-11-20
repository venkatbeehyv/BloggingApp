/**
 * 
 */
package com.beehyv.blogging.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.blogging.modal.Post;
import com.beehyv.blogging.service.PostService;

/**
 * @author Venkat
 *
 */
//@WebServlet("/recent")
public class HomeServlet extends HttpServlet {
	
	PostService postService = new PostService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside HomeServlet::");
		
		System.out.println(req.getParameter("actionName"));
		String actionName = "recentPosts";
		if("recentPosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getRecentPosts();
			PrintWriter writer = resp.getWriter();
			writer.println(posts);
		}
		/*else if("post".equalsIgnoreCase(actionName)){
			Post post = postService.getPost();
			PrintWriter writer = resp.getWriter();
			writer.println(post);
		} */
		else if("tag".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getPosts();
			PrintWriter writer = resp.getWriter();
			writer.println(posts); 
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