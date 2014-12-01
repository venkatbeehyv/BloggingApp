/**
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.beehyv.blogging.modal.Comment;
import com.beehyv.blogging.modal.Post;
import com.beehyv.bloggingapp.dao.CommentDAO;
import com.beehyv.bloggingapp.dao.PostDAO;

/**
 * this class contains getRecentPosts, getPost, getPostsbytag
 * and getHomePosts method
 */
public class PostDAOImpl extends BaseDAO implements PostDAO, CommentDAO {

	/* this method will provide recent posts added
	 * in the Database
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
	
	/** this method returns post object
 * when post_id is passed as a parameter it will 
 * return title, content, related comments 
 * 
 */
	 @Override
	 public Post getPost(long post_id) {
	 // TODO Auto-generated method stub
	 Connection connection = getConnection();
	 // create Statement for querying database
	 Post post = new Post();;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 try {
	 statement = connection.createStatement();
	 // query database
	 resultSet = statement.executeQuery("SELECT title, created_at,content from Post Where post_id='"+post_id+"'");
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
	 } // end getPost method
	 
	/** this method gives all posts related to tag in which,
	 * tag_id is passed as a parameter 	
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
			resultSet = statement.executeQuery("SELECT  created_at,title,Content from Post Where Post_id IN (SELECT Post_id from Tag_Post Where Tag_id = '"+tag_id+"') Order by created_at DESC limit  5" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(2));
				post.setCreatedAt(resultSet.getString(1));
				post.setContent(resultSet.getString(3));
				posts.add(post);
			}
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
	} // end getPostsbytag
	
	/** this method returns recent post in each category
 * 
 */
	@Override
	public List<Post> getHomePosts() {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		// create Statement for querying database
		List<Post> posts = new ArrayList<Post>();
		LinkedHashSet<Long> rootids = new LinkedHashSet<Long>();
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;

		try {
			statement = connection.createStatement();
			// query database
			resultSet = statement.executeQuery("SELECT root_id from Post Order by created_at DESC" );
			 System.out.println();
			// process query results
			while ( resultSet.next() )
			{
				rootids.add(resultSet.getLong(1));
			//	System.out.println(rootids);
			} // end while 
			//String sqlquerry = 
					
			Iterator<Long> itr = rootids.iterator();
	        while(itr.hasNext()){
	        	Long root_id = itr.next();
	        	resultSet_1 = statement.executeQuery("SELECT  t2.category_name, Post.title, Post.created_at,"
	        			+"Employee.name, Post.content from Blog.Post "
	        			+"inner join Blog.category as t1 on t1.category_id = Post.category_id "
	        			+"inner join Blog.category as t2 on t2.category_id = Post.root_id "
	        			+"inner join Blog.Employee on Employee.employee_id = Post.created_by "
	        			+"where Post.root_id = "+ root_id +" and Post.created_at = "
	        			+ "(select created_at from Blog.Post where root_id = "+ root_id +" order by created_at Desc limit 1)" );
	        
	        	while(resultSet_1.next()){
	        		Post post = new Post();
	        		post.setRoot_category(resultSet_1.getString(1));
	        		post.setTitle(resultSet_1.getString(2));
	        		post.setCreatedAt(resultSet_1.getString(3));
	        		post.setUserName(resultSet_1.getString(4));
	        		post.setContent(resultSet_1.getString(5));
	        		posts.add(post);
	        		System.out.println(post.getRoot_category().toUpperCase());
	        		System.out.println(post.getTitle());
	        		System.out.println(post.getCreatedAt() +": " + post.getUserName());
	        		System.out.println(post.getContent() +"\n");
	        	} // while ends
	        } // while itr ends
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
	} // end of getHomePosts method 

	/**
	 * returns list of comments by passing post_id as a parameter
	 */
	@Override
	public List<Comment> getComments(long post_id) {
		List<Comment> comments = new ArrayList<Comment>();
		
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("select t1.comment_id, t1.comment, t2.name , t1.created_at from Blog.Comment as t1 "
					+" inner join Blog.Employee as t2 on t1.employee_id = t2.employee_id "
					+" where t1.post_id = " + post_id );

			// process query results
			while ( resultSet.next() )
			{
				Comment comment = new Comment();
				comment.setComment_id(resultSet.getLong(1));
				comment.setComment(resultSet.getString(2));
				comment.setName(resultSet.getString(3));
				comment.setCreated_at(resultSet.getString(4));
				comments.add(comment);
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
		return comments;
	}
	
	public static void main(String[] args){
		PostDAO postDAO = new PostDAOImpl();
		CommentDAO commentDAO = new PostDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		//postDAO.getPost(1);
		//postDAO.getPostsbytag(2);
		postDAO.getHomePosts();
		commentDAO.getComments(1);
	}

} // end of PostDAOImpl.java 
