package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.blogging.dao.TagDAO;
import com.beehyv.blogging.modal.Tag;

public class TagDAOImpl extends BaseDAO implements TagDAO {
	
	/**
	 * This method returns list of tags
	 * which will be shown on the homePage
	 */
	@Override
	public List<Tag> getHomeTags() {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Tag>  tags= new ArrayList<Tag>();

		try 
		{
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT tag_id, tag_name from Tag_list" );

			// process query results
			while ( resultSet.next() )
			{
				Tag tag = new Tag();
				tag.setIdTag(resultSet.getLong(1));
				tag.setTag(resultSet.getString(2));
				tags.add(tag);
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
		return tags;
	} // end method getHomeTags
	
	/**
	 * This method takes a list of tags object as parameter
	 * and adds those list into the database's Tag_list table 
	 */
	@Override
	public void addTags(List<Tag> tags) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		String tag_name;

		try 
		{
			statement = connection.createStatement();

			// insert an employee into database
			for(Tag tag:tags){
				tag_name = tag.getTag();
				statement.executeUpdate("insert into Blog.Tag_list (tag_name) values ('"+tag_name+"')");
			}
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
	} // end addTags method

	/**
	 * This method deletes all entries from the Database
	 * related to a tag, it deletes entries from Tag_list, Tag_Post 
	 * tables where employee_id matches the passed parameter
	 */
	@Override
	public void deleteTag(Long tag_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			// updating database
			statement.executeUpdate("delete from Blog.Tag_list where tag_id = "+ tag_id);
			statement.executeUpdate("delete from Blog.Tag_Post where tag_id = "+ tag_id);
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
	} // end deleteTag method
	
	public static void main(String[] args){
		TagDAO tagDAO = new TagDAOImpl(); 
		System.out.println(tagDAO.getHomeTags());
	}

}