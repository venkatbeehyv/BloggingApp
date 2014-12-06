/**
 * 
 */
package com.beehyv.blogging.service;

import com.beehyv.blogging.dao.EmployeeDAO;
import com.beehyv.blogging.dao.PostDAO;
import com.beehyv.blogging.dao.impl.EmployeeDAOImpl;
import com.beehyv.blogging.dao.impl.PostDAOImpl;
import com.beehyv.blogging.modal.Employee;

/**
 * @author pooja
 *
 */
public class EmployeeService {
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	public Employee getEmployee(Long employee_id) {
		return employeeDAO.getEmployee(employee_id);
	}
	
	public boolean loginAuthorization(String email, String password){
		return employeeDAO.loginAuthorization( email, password);
	}
	
	public void addEmployee(Employee employee){
		employeeDAO.addEmployee(employee);
	}

}
