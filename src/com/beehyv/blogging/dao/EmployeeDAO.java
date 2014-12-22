package com.beehyv.blogging.dao;

import com.beehyv.blogging.modal.Employee;

public interface EmployeeDAO {

	public Long loginAuthorization(String email, String password);

	public Employee getEmployee(Long employee_id);

	public void addEmployee(Employee employee);

	public void editEmployee(Employee employee);

	public boolean changePassword(Long employee_id, String oldPassword, String newPassword);

	public void deleteEmployee(Long employee_id);
	
}
