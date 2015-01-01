package com.beehyv.blogging.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.blogging.modal.Employee;
import com.beehyv.blogging.service.EmployeeService;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	EmployeeService employeeService = EmployeeService.getEmployeeServiceInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeServlet::");
   		String actionName = request.getParameter("actionName");
		System.out.println("actionNAme: " + actionName);
		// returns my account details 
		if("myDetails".equalsIgnoreCase(actionName)){
			String employeeId = request.getParameter("employeeId");
			Employee userDetails = employeeService.getEmployee(Long.valueOf(employeeId));
			request.setAttribute("userDetails", userDetails);
			Gson gson = new Gson();
			String userJSONString = gson.toJson(userDetails);
			PrintWriter writer = response.getWriter();
			System.out.println(userJSONString);
			writer.println(userJSONString);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeServlet::");
		String actionName = request.getParameter("actionName");
	
		System.out.println("actionName: " + actionName);
		
		//adds an Employee to the database
		if("Register".equalsIgnoreCase(actionName)){
			/*Gson gson = new Gson();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
			  BufferedReader reader = request.getReader();
			  while ((line = reader.readLine()) != null)
			    jb.append(line);
			  } catch (Exception e) { report an error }
			
			System.out.println(jb.toString());
		    Employee employee = gson.fromJson(jb.toString(),Employee.class);*/
			Employee employee = new Employee();
			employee.setName(request.getParameter("name"));
			employee.setPassword(request.getParameter("password"));
			employee.setEmail(request.getParameter("email"));
			employee.setMobile_no(request.getParameter("mobile_no"));
		    employeeService.addEmployee(employee);
		    
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            requestDispatcher.forward(request, response);
		}
		
		else if("editEmployee".equalsIgnoreCase(actionName)){
			Gson gson = new Gson();
			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
			  BufferedReader reader = request.getReader();
			  while ((line = reader.readLine()) != null)
			    jb.append(line);
			  } catch (Exception e) { /*report an error*/ }
			
		    Employee employee = gson.fromJson(jb.toString(),Employee.class);
		    employeeService.editEmployee(employee);
		}
	}

}
