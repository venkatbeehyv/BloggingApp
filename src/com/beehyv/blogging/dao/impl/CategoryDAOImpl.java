package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.beehyv.blogging.dao.CategoryDAO;
import com.beehyv.blogging.modal.Category;
import com.beehyv.blogging.modal.Post;
import com.mysql.fabric.xmlrpc.base.Array;

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
				if(resultSet.getLong(1)!=0){
					category.setIdCategory(resultSet.getLong(1));
					category.setCategoryName(resultSet.getString(2));
					categories.add(category);
				}
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
				if(resultSet!=null){
				resultSet.close();}
				statement.close();
				connection.close();
			} // end try
			catch ( Exception exception )
			{
				exception.printStackTrace();
			} // end catch
		} // end finally
		System.out.println(categories.size());
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
	
	@Override
	public List<List<Category>> getCategoryTree() {
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<List<Category>> categoryTree = new ArrayList<List<Category>>();
		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT t2.category_id AS id2, t2.category_name as name2, "
					+"t3.category_id AS id3, t3.category_name as name3, "
					+"t4.category_id AS id4, t4.category_name as name4, "
					+"t5.category_id AS id5, t5.category_name as name5, "
					+"t6.category_id AS id6, t6.category_name as name6, "
					+"t7.category_id AS id7, t7.category_name as name7 "
					+"FROM Blog.category AS t1 "
					+"LEFT JOIN Blog.category  AS t2 ON t2.parent_id = t1.category_id "
					+"LEFT JOIN Blog.category  t3 ON t3.parent_id = t2.category_id "
					+"LEFT JOIN Blog.category  t4 ON t4.parent_id = t3.category_id "
					+"LEFT JOIN Blog.category  t5 ON t5.parent_id = t4.category_id "
					+"LEFT JOIN Blog.category  t6 ON t6.parent_id = t5.category_id "
					+"LEFT JOIN Blog.category  t7 ON t7.parent_id = t6.category_id "
					+"WHERE t1.category_id = 1");
			

			// process query results
			while ( resultSet.next() )
			{
				List<Category> categoryList = new ArrayList<Category>();
				for(int i=0; i<6; i++){
					Category category = new Category();
					if(resultSet.getLong(2*i+1) != 0){
						category.setIdCategory(resultSet.getLong(2*i+1));
						category.setCategoryName(resultSet.getString(2*i+2));
						categoryList.add(category);
					}
					else{
						i = 7;
					}
				} // for loop ends
				for(Category cat : categoryList){
					System.out.println(cat);
				}
				System.out.println();
				categoryTree.add(categoryList);
			} // end while 
		} // end try block
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
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
		return categoryTree;
	}
	
	public static void main(String[] args){
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		//System.out.println(categoryDAO.getParentTree(11));
		//System.out.println(categoryDAO.getRootParent(11));
		//System.out.println(categoryDAO.getChildren(6));
		//System.out.println(new ArrayList<Category>());
		//categoryDAO.getCategoryTree();
		categoryDAO.getCategoryTree();
	}

}
