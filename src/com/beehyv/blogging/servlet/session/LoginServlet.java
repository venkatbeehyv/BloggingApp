package com.beehyv.blogging.servlet.session;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beehyv.blogging.modal.Employee;
import com.beehyv.blogging.service.EmployeeService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MyHomePage")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/BlogginApp/Home.jsp");
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get request parameters for userID and password
		EmployeeService employeeService = EmployeeService.getEmployeeServiceInstance();
        String user = request.getParameter("emailId");
        String pwd = request.getParameter("password");
        System.out.println("check msg");
         
        Long employeeId = employeeService.loginAuthorization(user, pwd);
        if(employeeId != null){
        	
            HttpSession session = request.getSession();
            Employee employee = employeeService.getEmployee(employeeId);
            session.setAttribute("currentUser", employee);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/MyHomePage.jsp");
            requestDispatcher.forward(request, response);
            //response.sendRedirect("Home.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
 
    }

}
