/**
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.beehyv.blogging.dao.PostDAO;
import com.beehyv.blogging.modal.Comment;
import com.beehyv.blogging.modal.Post;

/**
 * this class contains getRecentPosts, getPost, getPostsbytag
 * and getHomePosts method
 */
public class PostDAOImpl extends BaseDAO implements PostDAO {

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
		 Connection connection = getConnection();
		 // create Statement for querying database
		 Post post = new Post();
		 List<Comment> comments = new ArrayList<Comment>();
		 Statement statement = null;
		 ResultSet resultSet = null;
		 ResultSet resultSet_1 = null;
		 try 
		 {
			 statement = connection.createStatement();
			 
			 // query database
			 resultSet = statement.executeQuery("SELECT title, created_at,content from Post Where post_id='"+post_id+"'");
			 // process query results
			 while ( resultSet.next() )
			 {
				 post.setTitle(resultSet.getString(1));
				 post.setCreatedAt(resultSet.getString(2));
				 post.setContent(resultSet.getString(3));
			 } // end while
			 
			 // query database to get Comments list related to a post
			 resultSet_1 = statement.executeQuery("select t1.comment_id, t1.comment, t2.name , t1.created_at "
			 			+ "from Blog.Comment as t1 inner join Blog.Employee as t2 on t1.employee_id = t2.employee_id "
						+" where t1.post_id = " + post_id +" order by created_at asc" );

			// process query results
			while ( resultSet_1.next() )
			{
				Comment comment = new Comment();
				comment.setComment_id(resultSet_1.getLong(1));
				comment.setComment(resultSet_1.getString(2));
				comment.setName(resultSet_1.getString(3));
				comment.setCreated_at(resultSet_1.getString(4));
				comments.add(comment);
				//System.out.println();
			} // end while 
			 post.setComments(comments);
		 } // end try block
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 } // end catch
		 
		 finally // ensure resultSet, statement and connection are closed
		 {
			 try
			 {
				 resultSet.close();
				 resultSet_1.close();
				 statement.close();
				 connection.close();
				 
			 } // end try
			 catch ( Exception exception )
			 {
				 exception.printStackTrace();
			 } // end catch
		 } // end finally
		 System.out.println(post);
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
					
			Iterator<Long> itr = rootids.iterator();
	        while(itr.hasNext()){
	        	Long root_id = itr.next();
	        	resultSet_1 = statement.executeQuery("SELECT  Post.root_id, category.category_name, Post.title, Post.created_at, "
	        			+"Employee.name, Post.content, Post.post_id, Post.category_id from Blog.Post "
	        			+"inner join Blog.category on category.category_id = Post.root_id "
	        			+"inner join Blog.Employee on Employee.employee_id = Post.created_by "
	        			+"where Post.root_id = "+ root_id +" and Post.created_at = "
	        			+ "(select created_at from Blog.Post where root_id = "+ root_id +" order by created_at Desc limit 1)" );
	        
	        	while(resultSet_1.next()){
	        		Post post = new Post();
	        		post.setRoot_id(resultSet_1.getLong(1));
	        		post.setRoot_category(resultSet_1.getString(2));
	        		post.setTitle(resultSet_1.getString(3));
	        		post.setCreatedAt(resultSet_1.getString(4));
	        		post.setUserName(resultSet_1.getString(5));
	        		post.setContent(resultSet_1.getString(6));
	        		post.setPost_id(resultSet_1.getLong(7));
	        		post.setCategoryID(resultSet_1.getLong(8));
	        		posts.add(post);
	        		System.out.println(post.getRoot_id());
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
	 * This method returns 4 recent posts for an employee
	 * where employee_id is passed as a parameter
	 */
	@Override
	public List<Post> getMyPosts(Long employee_id) {
		List<Post> posts = new ArrayList<Post>();
		
		// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT  Post.title, Post.created_at, Employee.name, Post.content "
					+ "from Blog.Post inner join Blog.Employee on Employee.employee_id = Post.created_by "
						+" where Post.created_by = "+employee_id+" order by created_at Desc limit 4" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(1));
				post.setCreatedAt(resultSet.getString(2));
				post.setUserName(resultSet.getString(3));
				post.setContent(resultSet.getString(4));
				posts.add(post);
				System.out.println(post.getTitle());
        		System.out.println(post.getCreatedAt() +": " + post.getUserName());
        		System.out.println(post.getContent() +"\n");
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
	} // end getMyPosts method
	
	/**
	 * This method returns 4 recent posts related to category_id
	 * which is passed as a parameter
	 */
	@Override
	public List<Post> getPostsbyCategory(Long category_id) {
		List<Post> posts = new ArrayList<Post>();
		LinkedHashSet<Long> categories = new LinkedHashSet<Long>();
		// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT t1.category_id AS lev1, t2.category_id as lev2, "
					+ "t3.category_id as lev3, t4.category_id as lev4, "
					+"t5.category_id as lev5,t6.category_id as lev6, t7.category_id as lev7 "
					+" FROM Blog.category t1 "
					+"LEFT JOIN Blog.category  t2 ON t2.parent_id = t1.category_id "
					+"LEFT JOIN Blog.category  t3 ON t3.parent_id = t2.category_id "
					+"LEFT JOIN Blog.category  t4 ON t4.parent_id = t3.category_id "
					+"LEFT JOIN Blog.category  t5 ON t5.parent_id = t4.category_id "
					+"LEFT JOIN Blog.category  t6 ON t6.parent_id = t5.category_id "
					+"LEFT JOIN Blog.category  t7 ON t7.parent_id = t6.category_id "
					+"WHERE t1.category_id = " + category_id );
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

			// process query results
			while ( resultSet.next() )
			{
				for(int i=1; i<=columnCount; i++){
					if(resultSet.getLong(i) != 0){
					categories.add(resultSet.getLong(i));
					} // if ends
				} // for loop ends
			} // end while 
			
			// converting list into a string format of()
			Long[] categoriesArray=new Long[categories.size()];                // creating an Array of Double type elements
			categoriesArray=categories.toArray(categoriesArray); 
			String idsString = categoriesArray[0].toString();
			for(int i=1; i<categoriesArray.length; i++){
				idsString = idsString.concat(", "+categoriesArray[i].toString());
			}
			System.out.println(idsString);
			
			resultSet_1 = statement.executeQuery("SELECT  Post.post_id,  Post.category_id, Post.title, "
					+ "Post.created_at, Employee.name, Post.content from Blog.Post "
					+ "inner join Blog.category on category.category_id = Post.root_id "
					+ "inner join Blog.Employee on Employee.employee_id = Post.created_by "
					+ "where Post.category_id in ("+idsString+") order by Post.created_at desc limit 4");
			while(resultSet_1.next()){
				Post post = new Post();
				post.setPost_id(resultSet_1.getLong(1));
				post.setCategoryID(resultSet_1.getLong(2));
        		post.setTitle(resultSet_1.getString(3));
        		post.setCreatedAt(resultSet_1.getString(4));
        		post.setUserName(resultSet_1.getString(5));
        		post.setContent(resultSet_1.getString(6));
        		
        		posts.add(post);
        		System.out.println(post);
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
	}
	
	/**
	 * This method inserts a new Post in the database
	 */
	@Override
	public void addPost(Post post) {
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			String title = post.getTitle();
			String content = post.getContent();
			String createdAt = post.getCreatedAt();
			Long userId = post.getUserId();
			Long categoryID = post.getCategoryID();
			// query database
			statement.executeUpdate("insert into Blog.Post "
					+ "(title, content, created_at, employee_id, category_id ) values "
					+ "('"+title+"','"+ content +"','"+createdAt+"',"+userId+","+categoryID+")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // ensure resultSet, statement and connection are closed
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
	}
	

	/**
	 * This method is to update a existing post in database
	 * post object is passed as a parameter
	 * which contains information about the changes
	 */
	@Override
	public void editPost(Post post) {
		Connection connection = getConnection();
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			String content = post.getContent();
			Long post_id = post.getPost_id();
			// query database
			statement.executeUpdate("UPDATE Blog.Post SET content = '"+content
					+ "' WHERE post_id = "+post_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // ensure resultSet, statement and connection are closed
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
	}
		
	
	
	public static void main(String[] args){
		PostDAO postDAO = new PostDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		//postDAO.getPost(9);
		postDAO.getPostsbyCategory((long) 2);
		//postDAO.addPost(p);
		//commentDAO.getComments(1);
	}


	
} // end of PostDAOImpl.java 
