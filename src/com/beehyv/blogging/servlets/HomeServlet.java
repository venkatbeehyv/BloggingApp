/**
 * 
 */
package com.beehyv.blogging.servlets;

import java.io.IOException;
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
@WebServlet("/recent")
public class HomeServlet extends HttpServlet {
	
	PostService postService = new PostService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside HomeServlet::");
		Map<String,String[]> parameters = req.getParameterMap();
		//String actionName = parameters.get("actionName")[0];
		//System.out.println(req.getParameter("actionName"));
		String actionName = "recentPosts";
		if("recentPosts".equalsIgnoreCase(actionName)){
			List<Post> posts = postService.getRecentPosts();
			req.setAttribute("recentPosts", posts);
		}
		
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/Home.jsp");
		req.setAttribute("name", "Hi This is venkat");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Inside HomeServlet::");
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/Home.jsp");
		req.setAttribute("name", "Hi This is venkat");
		dispatcher.forward(req, resp);
	}
}
