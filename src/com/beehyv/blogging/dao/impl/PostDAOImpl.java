/**
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.blogging.modal.Post;
import com.beehyv.bloggingapp.dao.PostDAO;

/**
 * @author sanjay
 *
 */
public class PostDAOImpl extends BaseDAO implements PostDAO  {

	/* (non-Javadoc)
	 * @see com.beehyv.bloggingapp.dao.PostDAO#getRecentPosts()
	 */
	@Override
	public List<Post> getRecentPosts() {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		List<Post> posts = new ArrayList<Post>();;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT title, created_at from Post Order by created_at DESC limit 3" );
			
			// process query results
				while ( resultSet.next() )
				{
					Post post = new Post();
					post.setTitle(resultSet.getString(1));
					post.setCreatedAt(resultSet.getString(2));
					posts.add(post);
					System.out.printf("%s : %s\n" , post.getTitle(), post.getCreatedAt());
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
		return posts;
	} // end getReacentPosts method

	@Override
	public Post getPost() {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		Post post = new Post();;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT title, created_at,content from Post Where post_id='2' " );
			
			// process query results
				while ( resultSet.next() )
				{
					//Post post = new Post();
					post.setTitle(resultSet.getString(1));
					post.setCreatedAt(resultSet.getString(2));
					post.setContent(resultSet.getString(3));
					//posts.add(post);
					System.out.printf("%s : %s\n %s\n" , post.getTitle(), post.getCreatedAt(),post.getContent());
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
		return post;
	} // end getReacentPosts method
	
	
	
	/* (non-Javadoc)
	 * @see com.beehyv.bloggingapp.dao.PostDAO#getPosts()
	 */	

	@Override
	public List<Post> getPostsbytag(long tag_id) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		List<Post> posts = new ArrayList<Post>();;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT  created_at,title,Content from Post Where Post_id IN (SELECT Post_id from Tag_Post Where Tag_id = 'tag_id') Order by created_at DESC limit  5" );
			
			// process query results
				while ( resultSet.next() )
				{
					Post post = new Post();
					post.setTitle(resultSet.getString(2));
					post.setCreatedAt(resultSet.getString(1));
					post.setContent(resultSet.getString(3));
					posts.add(post);
					System.out.printf("%s : %s\n %s\n" , post.getTitle(), post.getCreatedAt(),post.getContent());
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
		return posts;
		
	}
	public static void main(String[] args){
		PostDAO postDAO = new PostDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		postDAO.getPost();
		
	}
}
