package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.blogging.modal.Tag;
import com.beehyv.bloggingapp.dao.TagDAO;

public class TagDAOImpl extends BaseDAO implements TagDAO {
	
	@Override
	public List<Tag> getHomeTags() {
		List<Tag>  tags= new ArrayList<Tag>();
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;

		try {
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
				System.out.println(tag);
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
		return tags;
	} // end method getHomeTags
	
	public static void main(String[] args){
		TagDAO tagDAO = new TagDAOImpl(); 
		tagDAO.getHomeTags();
	}
}