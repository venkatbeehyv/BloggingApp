package com.beehyv.blogging.dao;

import com.beehyv.blogging.modal.Employee;

public interface EmployeeDAO {

	public boolean loginAuthorization(String email, String password);

	public Employee getEmployee(Long employee_id);

	public void addEmployee(Employee employee);

	public void editEmployee(Employee employee);
	
}
