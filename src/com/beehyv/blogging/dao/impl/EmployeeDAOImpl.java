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
	public static void main(String[] args){
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//employeeDAO.getEmployee((long) 15);
		employeeDAO.loginAuthorization("rgrg27", "beehyv123"); // still have to modify method
	}
}
