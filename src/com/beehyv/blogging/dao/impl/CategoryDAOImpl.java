package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.blogging.modal.Category;
import com.beehyv.blogging.modal.Post;
import com.beehyv.bloggingapp.dao.CategoryDAO;
import com.beehyv.bloggingapp.dao.PostDAO;
import com.mysql.jdbc.ResultSetMetaData;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO 
{
	@Override 
	public List<Category> getChildTree( long category_id) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		List<Category> categories = new ArrayList<Category>();;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT title, created_at from Post Order by created_at DESC limit 3" );
			
			java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

			int columnsNumber = resultData.getColumnCount();
			
			// process query results
			Category category = new Category();	
			while ( resultSet.next() )
				{
					for(int i=1; i<columnsNumber; i++){
						resultSet.getString(i);
					}
					//System.out.println();
				} // end while 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // ensure resultSet, statement and connection are closed
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
		return categories;
	} // end getReacentPosts method

	@Override
	public List<Category> getParentTree(long category_id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] args){
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		categoryDAO.getChildTree(2);
		
	}

}