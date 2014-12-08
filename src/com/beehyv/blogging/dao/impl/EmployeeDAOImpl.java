package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beehyv.blogging.dao.EmployeeDAO;
import com.beehyv.blogging.modal.Employee;

public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	@Override
	public boolean loginAuthorization(String email, String password) {
		boolean loginAuthorised = false;
		
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("select  employee_id from Blog.Employee "
					+"where password = '"+password+"' and email = '"+email+"'" );
			while(resultSet.next()){
				loginAuthorised = true;
			} // end while
		} // end try block 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}  // end catch block
		
		finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			} // end try
			catch ( Exception exception )
			{
				exception.printStackTrace();
			} // end catch
		} // end finally
		System.out.println(loginAuthorised);

		return loginAuthorised;
	} // end loginAuthorization method

	@Override
	public Employee getEmployee(Long employee_id) {
		Employee employee = new Employee();
		
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("select name, designation, email, mobile from Blog.Employee "
					+ "where employee_id = " + employee_id );
			while(resultSet.next()){
				// process query results
				employee.setName(resultSet.getString(1));
				employee.setDesignation(resultSet.getString(2));
				employee.setEmail(resultSet.getString(3));
				employee.setMobile_no(resultSet.getString(4));
				System.out.println(employee.toString());
			} // end while
		} // end try block 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}  // end catch block
		
		finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			} // end try
			catch ( Exception exception )
			{
				exception.printStackTrace();
			} // end catch
		} // end finally
		return employee;
	} // end getEmployee method

	@Override
	public void addEmployee(Employee employee) {
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			String email = employee.getEmail();
			String name = employee.getName();
			String password = employee.getPassword();
			String mobile_no = employee.getMobile_no();
			String createdAt = employee.getCreated_at();
			String lastLoggedIn = employee.getlastLoggedIn();
			// insert an employee into database
			statement.executeUpdate("insert into Blog.Employee "
					+ "(email, name, password, mobile, created_at, last_logged_in, role_id ) "
					+ "values ('"+email+"', '"+name+"', '"+password+"', "+mobile_no+", '"+createdAt+"',"+lastLoggedIn+",2)");

		} // end try block
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} // end catch block
		
		finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				statement.close();
				connection.close();
			} // end try
			catch ( Exception exception )
			{
				exception.printStackTrace();
			} // end catch
		} // end finally
	} // end addEmployee method
	
	@Override
	public void editEmployee(Employee employee) {
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
			
			Long employee_id = employee.getEmployee_id();
			String name = employee.getName();
			String designation = employee.getDesignation();
			String mobile = employee.getMobile_no();
			String updated_at = employee.getUpdated_at();
			String last_logged_in = employee.getlastLoggedIn();
			// query database
			statement.executeUpdate("update Blog.Employee set name ='"+name+"', designation = '"+designation+"', "
					+"mobile = '"+mobile+"', updated_at = '"+updated_at+"', last_logged_in = '"+last_logged_in+"' "
					+" where employee_id = "+employee_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				statement.close();
				connection.close();
			} // end try
			catch ( Exception exception )
			{
				exception.printStackTrace();
			} // end catch
		} // end finally
	}
	
	public static void main(String[] args){
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//employeeDAO.getEmployee((long) 15);
		employeeDAO.loginAuthorization("rgrg27", "beehyv123"); // still have to modify method
	}

}
