/**
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author sanjay
 *
 */
public class BaseDAO {

	// database URL 
		static final String DATABASE_URL = "jdbc:mysql://localhost/Blog";
		// launch the application
		public Connection getConnection()
		{ 
			Connection connection = null; // manages connection
			Statement statement = null; // query statement
			ResultSet resultSet = null; // manages results
			String Post_title;
			String created_at;
			// connect to database books and query database
			try {
				connection = DriverManager.getConnection(DATABASE_URL, "root", "beehyv123" );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
			
		} 
}
