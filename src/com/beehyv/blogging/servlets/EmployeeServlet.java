package com.beehyv.blogging.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			Employee employee = new Employee();
			employee.setName(request.getParameter("name"));
			employee.setPassword(request.getParameter("password"));
			employee.setEmail(request.getParameter("email"));
			employee.setMobile_no(request.getParameter("mobile_no"));
		    employeeService.addEmployee(employee);
		    // redirecting response to Login Page
            response.sendRedirect("Login.html");
		}
		
		else if("editEmployee".equalsIgnoreCase(actionName)){
			Employee employee = new Employee();
			employee.setName(request.getParameter("name"));
			employee.setDesignation(request.getParameter("designation"));
			employee.setMobile_no(request.getParameter("mobile_no"));
			employee.setEmployee_id(Long.valueOf(request.getParameter("employee_id")));
		    employeeService.editEmployee(employee);
		    
		    HttpSession session = request.getSession();
		    if(session.getAttribute("employee_id")!=null){
		    	response.sendRedirect("myProfile.jsp?employee_id="+session.getAttribute("employee_id"));
		    }
		    else{
		    	response.sendRedirect("Login.html");
		    }
		}
		
		
		else if("changePassword".equalsIgnoreCase(actionName)){
			String old_password = request.getParameter("old_password");
			String new_password = request.getParameter("new_password");
			String confirm_password = request.getParameter("confirm_password");
			long employee_id = Long.valueOf(request.getParameter("employee_id"));
			if(new_password.equals(confirm_password))
			{
					if(employeeService.changePassword(employee_id, old_password, new_password)){
						System.out.println("Your password has been changed successfully");
					}
					else{
						PrintWriter out= response.getWriter();
			            out.println("<font color=red>You enteres Wrong Password</font>");
			            response.sendRedirect("changePassword.jsp?employee_id="+ employee_id);
					}
			}
			else
			{
	            PrintWriter out= response.getWriter();
	            out.println("<font color=red>Please Enter same password in Confirm Password as New Password</font>");
	            response.sendRedirect("changePassword.jsp?employee_id="+ employee_id);
			}
		}
	}

}
