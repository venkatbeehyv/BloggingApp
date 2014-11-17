/** this programs helps in getting a connection to database 
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {

	// database URL 
		static final String DATABASE_URL = "jdbc:mysql://localhost/Blog";
		// launch the application
		public Connection getConnection()
		{ 
			Connection connection = null; // manages connection
			Statement statement = null; // query statement
			ResultSet resultSet = null; // manages results
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
