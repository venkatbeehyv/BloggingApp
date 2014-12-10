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
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Category> categories = new ArrayList<Category>();
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT  t2.category_id as id, t2.category_name as name "
							+ "FROM category AS t1 LEFT JOIN category AS t2 ON t2.parent_id = t1.category_id "
							+ "WHERE t1.category_id = '" + category_id + "';");
			
			// process query results
			while ( resultSet.next() )
			{
				Category category = new Category();
				category.setIdCategory(resultSet.getLong(1));
				category.setCategoryName(resultSet.getString(2));
				categories.add(category);
			} // end while 
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
		return categories;
	} // end getChildren method
	
	/** This method returns list of parent categories 
	 * where category_id is passed as a parameter
	 * first value of the list is category_id itself and 
	 * last one is root category 
	 */
	@Override
	public List<Category> getParentTree(long category_id) {
	// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Category> categories = new ArrayList<Category>();
		Long parent;
		
		try 
		{
			statement = connection.createStatement();
			
			parent = category_id;
			
			while(parent != 0)
			{
				resultSet = statement.executeQuery("select category_id, category_name, parent_id from Blog.category "
					+ "where category_id = " + parent);
				
				Category category = new Category();
				
				while(resultSet.next())
				{
					category.setIdCategory(resultSet.getLong(1));
					category.setCategoryName(resultSet.getString(2));
					category.setIdParentCategory(resultSet.getLong(3));
					parent = resultSet.getLong(3);
					categories.add(category);
				} // while ends
				try
				{
					resultSet.close();
				} // try block ends
				
				catch(SQLException e)
				{
					e.printStackTrace();
				} // block catch ends
			} // end of while
		} // ends try block
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} // ends catch block
		
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
		return categories;
		} // end getParentTree method
	
/**
 *  this method provides root parent of any category
 *  root parents are one of {Technologies, Frameworks etc}
 */
	@Override
	public Category getRootParent(long category_id) {
		List<Category> categories = getParentTree(category_id);
		Category root_category = categories.get(categories.size()-2);
		return root_category;
	} // end getChildren method
	
	public static void main(String[] args){
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		//System.out.println(categoryDAO.getParentTree(11));
		//System.out.println(categoryDAO.getRootParent(11));
		System.out.println(categoryDAO.getChildren(5));
	}

}
