package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.blogging.dao.CategoryDAO;
import com.beehyv.blogging.modal.Category;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO 
{
	/**
	 * this method gives all immediate children of a category
	 */
	@Override 
	public List<Category> getChildren( long category_id) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		List<Category> categories = new ArrayList<Category>();;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement
					.executeQuery("SELECT  t2.category_id as id, t2.category_name as name "
							+ "FROM category AS t1 LEFT JOIN category AS t2 ON t2.parent_id = t1.category_id "
							+ "WHERE t1.category_id = '" + category_id + "';");
			
			// process query results
			while ( resultSet.next() )
				{
					Category category = new Category();
					category.setIdCategory(resultSet.getLong(1));
					category.setCategoryName(resultSet.getString(2));
					categories.add(category);
					System.out.println(category);
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
/**
 *  this method provides root parent of any category
 *  root parents are one of {Technologies, Frameworks etc}
 */
	@Override
	public Long getRootParent(long category_id) {
		Connection connection = getConnection();
		// create Statement for querying database
		List<Category> categories = new ArrayList<Category>();;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement
					.executeQuery("SELECT  t2.category_id as id, t2.category_name as name "
							+ "FROM category AS t1 LEFT JOIN category AS t2 ON t2.parent_id = t1.category_id "
							+ "WHERE t1.category_id = '" + category_id + "';");
			
			// process query results
			while ( resultSet.next() )
				{
					Category category = new Category();
					category.setIdCategory(resultSet.getLong(1));
					category.setCategoryName(resultSet.getString(2));
					categories.add(category);
					System.out.println(category);
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
		long a =0;
		return a;
	} // end getChildren method
	
	public static void main(String[] args){
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		categoryDAO.getChildren(1);
	}

}
