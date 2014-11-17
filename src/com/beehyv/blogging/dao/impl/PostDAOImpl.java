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
			resultSet = statement.executeQuery("SELECT Post_title, created_at from Post Order by created_at DESC" );
			
			// process query results
				while ( resultSet.next() )
				{
					Post post = new Post();
					post.setTitle(resultSet.getString(1));
					post.setCreatedAt(resultSet.getString(2));
					//Post_title = resultSet.getString(1);
					//created_at = resultSet.getString(2);
					posts.add(post);
					System.out.println("title :" + post.getTitle());
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

	/* (non-Javadoc)
	 * @see com.beehyv.bloggingapp.dao.PostDAO#getPosts()
	 */
	@Override
	public List<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		PostDAO postDAO = new PostDAOImpl();
		postDAO.getRecentPosts();
		
	}

}
