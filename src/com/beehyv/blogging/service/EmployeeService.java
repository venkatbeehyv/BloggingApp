/**
 * 
 */
package com.beehyv.blogging.service;

import com.beehyv.blogging.dao.EmployeeDAO;
import com.beehyv.blogging.dao.impl.EmployeeDAOImpl;
import com.beehyv.blogging.modal.Employee;

/**
 * @author pooja
 *
 */
public class EmployeeService {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	private static EmployeeService employeeService;
	
	private EmployeeService(){
		
	}
	
	public static EmployeeService getEmployeeServiceInstance(){
		if(employeeService == null){
			employeeService = new EmployeeService();
		}
		return employeeService;
	}

	public Employee getEmployee(Long employee_id) {
		return employeeDAO.getEmployee(employee_id);
	}
	
	public Long loginAuthorization(String email, String password){
		return employeeDAO.loginAuthorization( email, password);
	}
	
	public void addEmployee(Employee employee){
		employeeDAO.addEmployee(employee);
	}
	
	public void editEmployee( Employee employee){
		employeeDAO.editEmployee(employee);
	}
	
	public void deleteEmployee(Long employee_id){
		employeeDAO.deleteEmployee(employee_id);
	}
	
	public boolean changePassword(Long employee_id, String oldPassword, String newPassword){
		return employeeDAO.changePassword(employee_id, oldPassword,  newPassword);
	}

}
