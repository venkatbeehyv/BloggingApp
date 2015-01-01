package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.beehyv.blogging.dao.EmployeeDAO;
import com.beehyv.blogging.modal.Employee;

public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	/** This method returns employee_id if email and password matches
	 * with the database value else it returns null
	 */
	@Override
	public Long loginAuthorization(String email, String password) {		
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		Long employee_id = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("select  employee_id, password from Blog.Employee "
					+"where email = '"+email+"'" );
			
			// get employee_id from queried resultSet
			while(resultSet.next())
			{
				if(resultSet.getString(2).equals(password))
				{
					employee_id = resultSet.getLong(1);
				} // if ends
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
		return employee_id;
	} // end loginAuthorization method

	/** This method returns employee object
	 *  when employee_id is passed as a parameter
	 */
	@Override
	public Employee getEmployee(Long employee_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		Employee employee = new Employee();

		try 
		{
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("select name, designation, email, mobile from Blog.Employee "
					+ "where employee_id = " + employee_id );
			while(resultSet.next()){
				// process query results
				employee.setEmployee_id(employee_id);
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

	/** This method adds an employee into the database
	 * Which is passed as a parameter 
	 */
	@Override
	public void addEmployee(Employee employee) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		
		Date date= new Date();
		employee.setCreated_at(new Timestamp(date.getTime()).toString());
		
		
		try 
		{
			statement = connection.createStatement();
 
			String email = employee.getEmail();
			String name = employee.getName();
			String password = employee.getPassword();
			String designation = employee.getDesignation();
			String mobile_no = employee.getMobile_no();
			String createdAt = employee.getCreated_at();
			String lastLoggedIn = employee.getlastLoggedIn();
			
			// insert an employee into database
			statement.executeUpdate("insert into Blog.Employee (email, name, password, designation, mobile, created_at, last_logged_in, role_id ) "
					+ "values ('"+email+"', '"+name+"', '"+password+"','"+ designation +"',"+mobile_no+", '"+createdAt+"',"+lastLoggedIn+",2)");
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
	
	/** This method edits details of an employee 
	 * which already exists in database
	 * 
	 */
	@Override
	public void editEmployee(Employee employee) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try 
		{
			statement = connection.createStatement();
			
			Long employee_id = employee.getEmployee_id();
			String name = employee.getName();
			String designation = employee.getDesignation();
			String mobile = employee.getMobile_no();
			String updated_at = employee.getUpdated_at();
			String last_logged_in = employee.getlastLoggedIn();
			
			// updating Database
			statement.executeUpdate("update Blog.Employee set name ='"+name+"', designation = '"+designation+"', "
					+"mobile = '"+mobile+"', updated_at = '"+updated_at+"', last_logged_in = '"+last_logged_in+"' "
					+" where employee_id = "+employee_id);
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
	} // end editEmployee method

	/**
	 * This method deletes all entries from the Database
	 * related to an employee, it deletes entries from Post, Comment 
	 * and Employee tables where employee_id matches the passed parameter
	 */
	@Override
	public void deleteEmployee(Long employee_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			// updating database
			statement.executeUpdate("delete from Blog.Post where created_by = "+ employee_id);
			statement.executeUpdate("delete from Blog.Comment where employee_id = "+ employee_id);
			statement.executeUpdate("delete from Blog.Employee where employee_id = "+ employee_id);
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
	} // end method deleteEmployee
	
	/** This method changes the password for an employee
	 *  It takes three parameters employee_id, old password and new password 
	 */
	@Override
	public boolean changePassword(Long employee_id, String oldPassword, String newPassword) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		boolean result = false;
		String enteredPassword = null;
		
		try 
		{
			statement = connection.createStatement();
			
			// query database for password with given employee_id
			resultSet = statement.executeQuery("select password from Blog.Employee where employee_id = "+ employee_id);
			while(resultSet.next())
			{
				enteredPassword = resultSet.getString(1);
			} // while ends
		} // end try block
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} // end catch block
		
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
		
		
		// now after receiving database password it checks the user entered password
		connection = getConnection();

		statement = null;
		
		try 
		{
			statement = connection.createStatement();
			
			// checks whether password matches with the database password, if true then sets new password
			if(oldPassword.equals(enteredPassword))
			{
				statement.executeUpdate("update Blog.Employee set password = '" + newPassword 
						+ "' where employee_id = " + employee_id);
				result = true;
			} // if ends
		} // end try block
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} // end catch block
		
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
		return result;
	} // end changePassword method
	
	public static void main(String[] args){
		//EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		//employeeDAO.getEmployee((long) 15);
		//System.out.println(employeeDAO.loginAuthorization("rgrg27", "beehyv123")); 
		//System.out.println(employeeDAO.changePassword((long) 10, "beehyv1234", "beehyv123"));
		//employeeDAO.deleteEmployee((long) 17);
	}

	

}
