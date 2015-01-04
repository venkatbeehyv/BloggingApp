package com.beehyv.blogging.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.blogging.modal.Category;
import com.beehyv.blogging.service.CategoryService;
import com.google.gson.Gson;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryService categoryService = new CategoryService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside CategoryServlet::");
   		String actionName = request.getParameter("actionName");
		System.out.println("actionNAme: " + actionName);
		// returns parent tree of given category
		if("parentTree".equalsIgnoreCase(actionName)){
			String postId = request.getParameter("postId");
			List<Category> tree = categoryService.getParentTree(Long.valueOf(postId));
			request.setAttribute("tree", tree);
			Gson gson = new Gson();
			String treeJSONString = gson.toJson(tree);
			PrintWriter writer = response.getWriter();
			System.out.println(treeJSONString);
			writer.println(treeJSONString);
		}
		// returns menu bar children
		else if("getChildren".equalsIgnoreCase(actionName)){
			String categoryId = request.getParameter("categoryId");
			List<Category> categories = categoryService.getChildren(Long.valueOf(categoryId));
			request.setAttribute("categories", categories);
			Gson gson = new Gson();
			String menuJSONString = gson.toJson(categories);
			PrintWriter writer = response.getWriter();
			System.out.println(menuJSONString);
			writer.println(menuJSONString);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
