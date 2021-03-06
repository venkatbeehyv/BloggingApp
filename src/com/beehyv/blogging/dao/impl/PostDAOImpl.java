/**
 * 
 */
package com.beehyv.blogging.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

	/* This method will provide 3 most recent posts 
	 * added in the Database
	 */
	@Override
	public List<Post> getRecentPosts() {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;

		List<Post> posts = new ArrayList<Post>(); // posts is Output for this method
		
		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT title, created_at, post_id from Post "
					+ "Order by created_at DESC limit 3" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(1));
				post.setCreatedAt(resultSet.getString(2));
				post.setPost_id(resultSet.getLong(3));
				posts.add(post);
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
		return posts;
	} // end getReacentPosts method
	
	/** This method returns post object
 * when post_id is passed as a parameter it will 
 * return title, content, related comments etc 
 */
	 @Override
	 public Post getPost(long post_id) { 
		 Connection connection = getConnection();
		 
		 // create Statement for querying database
		 Statement statement = null;
		 ResultSet resultSet = null;
		 ResultSet resultSet_1 = null;
		 
		 Post post = new Post();
		 List<Comment> comments = new ArrayList<Comment>();
		 
		 try 
		 {
			 statement = connection.createStatement();
			 
			 // query database
			 resultSet = statement.executeQuery("SELECT  Post.title, Post.created_at, Post.content, "
			 		+ "Post.category_id, Employee.name, Post.created_by from Blog.Post "
					+ "inner join Blog.Employee on Employee.employee_id = Post.created_by "
			 		+ "Where post_id='"+post_id+"'");
			 
			 // process query results
			 while ( resultSet.next() )
			 {
				 post.setTitle(resultSet.getString(1));
				 post.setCreatedAt(resultSet.getString(2));
				 post.setContent(resultSet.getString(3));
				 post.setCategoryID(resultSet.getLong(4));
				 post.setUserName(resultSet.getString(5));
				 post.setUserId(resultSet.getLong(6));
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
		 return post;
	 } // end getPost method
	 
	/** This method gives all posts related to a tag 
	 * in which, tag_id is passed as a parameter 	
	 */
	@Override
	public List<Post> getPostsbytag(long tag_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Post> posts = new ArrayList<Post>(); // posts is Output for this method

		try {
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT  Post.title, Post.created_at, Post.content, "
			 		+ "Post.category_id, Employee.name, Post.created_by, Post.post_id from Blog.Post "
					+ "inner join Blog.Employee on Employee.employee_id = Post.created_by "
					+ "Where Post_id IN (SELECT Post_id from Blog.Tag_Post Where Tag_id = "+tag_id+") "
							+ "Order by created_at DESC limit  5" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(1));
				post.setCreatedAt(resultSet.getString(2));
				post.setContent(resultSet.getString(3));
				post.setCategoryID(resultSet.getLong(4));
				post.setUserName(resultSet.getString(5));
				post.setUserId(resultSet.getLong(6));
				post.setPost_id(resultSet.getLong(7));
				posts.add(post);
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
		return posts;
	} // end getPostsbytag method
	
	/** This method returns most recent post in each root category
	 *  root category is one of {Technologies, Databases, Frameworks etc}
	 */
	@Override
	public List<Post> getHomePosts() {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;
		
		List<Post> posts = new ArrayList<Post>(); // posts is Output for this method
		LinkedHashSet<Long> rootids = new LinkedHashSet<Long>(); // It contains root_ids in the order of created_at desc

		try {
			statement = connection.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT root_id from Post Order by created_at DESC" );
			
			// process query results
			while ( resultSet.next() )
			{
				rootids.add(resultSet.getLong(1));
			} // end while 
					
			Iterator<Long> itr = rootids.iterator();
	        while(itr.hasNext())
	        {
	        	Long root_id = itr.next();
	        	resultSet_1 = statement.executeQuery("SELECT  Post.root_id, category.category_name, Post.title, Post.created_at, "
	        			+"Employee.name, Post.content, Post.post_id, Post.category_id from Blog.Post "
	        			+"inner join Blog.category on category.category_id = Post.root_id "
	        			+"inner join Blog.Employee on Employee.employee_id = Post.created_by "
	        			+"where Post.root_id = "+ root_id +" and Post.created_at = "
	        			+ "(select created_at from Blog.Post where root_id = "+ root_id +" order by created_at Desc limit 1) limit 1" );
	        
	        	while(resultSet_1.next())
	        	{
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
	        	} // while ends
	        } // while itr ends
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
		return posts;
	} // end of getHomePosts method 

	/** This method returns 4 recent posts for an employee
	 * where employee_id is passed as a parameter
	 */
	@Override
	public List<Post> getMyPosts(Long employee_id) {		
		// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Post> posts = new ArrayList<Post>();

		try 
		{
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT  Post.title, Post.created_at, Employee.name, Post.content, "
					+ "Post.post_id from Blog.Post inner join Blog.Employee on Employee.employee_id = Post.created_by "
						+" where Post.created_by = "+employee_id+" order by created_at Desc limit 4" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(1));
				post.setCreatedAt(resultSet.getString(2));
				post.setUserName(resultSet.getString(3));
				post.setContent(resultSet.getString(4));
				post.setPost_id(resultSet.getLong(5));
				posts.add(post);
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
		return posts;
	} // end getMyPosts method
	
	/** This method returns 4 recent posts related to category_id
	 * which is passed as a parameter
	 */
	@Override
	public List<Post> getPostsbyCategory(Long category_id) {
		// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;
		
		List<Post> posts = new ArrayList<Post>();
		LinkedHashSet<Long> categories = new LinkedHashSet<Long>();

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
			
			// converting list into a string format to query database
			Long[] categoriesArray=new Long[categories.size()];
			categoriesArray=categories.toArray(categoriesArray); 
			String idsString = categoriesArray[0].toString();
			
			for(int i=1; i<categoriesArray.length; i++)
			{
				idsString = idsString.concat(", "+categoriesArray[i].toString());
			}
			
			resultSet_1 = statement.executeQuery("SELECT  Post.post_id,  Post.category_id, Post.title, "
					+ "Post.created_at, Employee.name, Post.content, t2.category_name, t1.category_name from Blog.Post "
					+ "inner join Blog.category t1 on t1.category_id = Post.root_id "
					+ "inner join Blog.Employee on Employee.employee_id = Post.created_by "
					+" inner join Blog.category t2 on Post.category_id = t2.category_id "
					+ "where Post.category_id in ("+idsString+") order by Post.created_at desc limit 4");
			
			while(resultSet_1.next())
			{
				Post post = new Post();
				post.setPost_id(resultSet_1.getLong(1));
				post.setCategoryID(resultSet_1.getLong(2));
        		post.setTitle(resultSet_1.getString(3));
        		post.setCreatedAt(resultSet_1.getString(4));
        		post.setUserName(resultSet_1.getString(5));
        		post.setContent(resultSet_1.getString(6));
        		post.setCategory_name(resultSet_1.getString(7));
        		post.setRoot_category(resultSet_1.getString(8));
        		posts.add(post);
			}
						
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
		return posts;
	} // end getPostsbyCategory method
	
	/**
	 * This method inserts a new Post in the database
	 */
	@Override
	public void addPost(Post post) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		Date date= new Date();
		post.setCreatedAt(new Timestamp(date.getTime()).toString());

		try {
			statement = connection.createStatement();
 
			String title = post.getTitle();
			String content = post.getContent();
			String createdAt = post.getCreatedAt();
			Long userId = post.getUserId();
			Long categoryID = post.getCategoryID();
			Long root_id = post.getRoot_id();
			
			// updating database
			statement.executeUpdate("insert into Blog.Post (title, content, created_at, created_by, category_id, root_id )"
					+ " values ('"+title+"','"+ content +"','"+createdAt+"',"+userId+","+categoryID+","+root_id+")");
			System.out.println(post);
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
	} // end addPost method	

	/** This method is to update a existing post in database
	 * post object is passed as a parameter
	 * which contains information about the changes
	 */
	@Override
	public void editPost(Post post) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try
		{
			statement = connection.createStatement();
 
			String content = post.getContent();
			Long post_id = post.getPost_id();
			
			// updating database
			statement.executeUpdate("UPDATE Blog.Post SET content = '"+content +" WHERE post_id = "+post_id);
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
	} // end editPost method
	
	/**
	 * This method deletes all entries from the Database
	 * related to a post_id, it deletes entries from Post, Comment 
	 * and Tag_Post tables where post_id matches the passed parameter
	 */
	@Override
	public void deletePost(Long post_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			// updating database
			statement.executeUpdate("delete from Blog.Post where post_id = "+ post_id);
			statement.executeUpdate("delete from Blog.Comment where post_id = "+ post_id);
			statement.executeUpdate("delete from Blog.Tag_Post where post_id = "+ post_id);
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
	} // end method deletePost
	
	/** 
	 * This method inserts a new comment in the database
	 */
	@Override
	public void addComment(Comment comment) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;
		
		Date date= new Date();
		comment.setCreated_at(new Timestamp(date.getTime()).toString());

		try {
			statement = connection.createStatement();
 
			String Comment = comment.getComment();
			String createdAt = comment.getCreated_at();
			Long post_id = comment.getIdPost();
			Long employee_id = comment.getIdEmployee();
			
			// updating database
			statement.executeUpdate("insert into Blog.Comment (Comment, created_at, post_id, employee_id )"
					+ " values ('"+Comment+"','"+createdAt+"',"+post_id+","+employee_id+")");
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
		
	}
	
	/**
	 * This method deletes all entries from the Database
	 * related to a comment_id, it deletes entries from Comment table
	 * where comment_id matches the passed parameter
	 */
	@Override
	public void deleteComment(Long comment_id) {
		Connection connection = getConnection();
		
		// create Statement for querying database
		Statement statement = null;

		try {
			statement = connection.createStatement();
 
			// updating database
			statement.executeUpdate("delete from Blog.Comment where comment_id = "+ comment_id);
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
		
	}
	
	/** This method returns list of Posts
	 * related to searched words
	 * 
	 */
	@Override
	public List<Post> searchPosts(String word) {
		// create Statement for querying database
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		List<Post> posts = new ArrayList<Post>();
		String newWord ="";
		for(int k=0; k<word.length();k++)
		{
			char charAtK = word.charAt(k);
			System.out.println(charAtK);
			if(charAtK =='.' || charAtK ==  '+' || charAtK == '?' || charAtK == '[' || charAtK == ']'){
				newWord = newWord.concat("["+Character.toString(charAtK)+"]");
				
			}
			else if(charAtK == "'".charAt(0)){
				newWord = word.substring(0, k);
				if(Math.abs(k-word.length()) == 1){
					break;
				}
			}
			else{
				newWord = newWord.concat(Character.toString(charAtK));
				}
		}
		word = newWord;
		if(!word.equals(word.toLowerCase())){
			word = word.concat("|"+ word.toLowerCase());
		}
		else{
			word = word.concat("|"+ word.toUpperCase());
		}
		String[] words = word.split(" ");
		String sqlWord = word;
		System.out.println(sqlWord);
		for(String oneWord: words){
			if(oneWord.toUpperCase().charAt(0) == oneWord.charAt(0)){
				if(sqlWord.indexOf(oneWord)==-1)
				{
					sqlWord = sqlWord.concat("|" + oneWord);
				}
			}
			else{
				if(sqlWord.indexOf(oneWord)==-1)
				{
					sqlWord = sqlWord.concat("|" + oneWord);
				}
				sqlWord = sqlWord.concat("|" + oneWord.toUpperCase().substring(0,1) + oneWord.substring(1));
			}
		}
		
		System.out.println(sqlWord);
		try 
		{
			statement = connection.createStatement();

			// query database
			resultSet = statement.executeQuery("SELECT  Post.title, Post.created_at, Employee.name, Post.content, "
					+ "Post.post_id from Blog.Post inner join Blog.Employee on Employee.employee_id = Post.created_by "
					+" where (title regexp '"+ sqlWord +"'   or content  regexp '"+ sqlWord +"') "
					+ " or Employee.name regexp '"+ sqlWord +"' limit 4;" );

			// process query results
			while ( resultSet.next() )
			{
				Post post = new Post();
				post.setTitle(resultSet.getString(1));
				post.setCreatedAt(resultSet.getString(2));
				post.setUserName(resultSet.getString(3));
				post.setContent(resultSet.getString(4));
				post.setPost_id(resultSet.getLong(5));
				posts.add(post);
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
		return posts;
	} // end searchPosts method
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args){
		PostDAO postDAO = new PostDAOImpl();
		//System.out.println(postDAO.getRecentPosts());
		//System.out.println(postDAO.getPost(8));
		//System.out.println(postDAO.getPostsbytag(2));
		//System.out.println(postDAO.getHomePosts());sqlWord = sqlWord.concat("|" + oneWord);
		//System.out.println(postDAO.getMyPosts((long) 10));
		//System.out.println(postDAO.getPostsbyCategory((long) 3));
		//postDAO.addPost(p);
		postDAO.deletePost((long) 22);
		//postDAO.deleteComment((long) 14);
		//System.out.println(postDAO.searchPosts("c++"));
	}
} // end of PostDAOImpl.java 
