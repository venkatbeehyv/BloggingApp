/**
 * 
 */
package com.beehyv.blogging.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Venkat
 *
 */
public class HomeServlet extends HttpServlet {
	
	Service

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Inside HomeServlet::");
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/Home.jsp");
		req.setAttribute("name", "Hi This is venkat");
		
		dispatcher.forward(req, resp);
		
	}
}
