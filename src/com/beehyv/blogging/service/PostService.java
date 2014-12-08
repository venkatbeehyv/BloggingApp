package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.PostDAO;
import com.beehyv.blogging.dao.impl.PostDAOImpl;
import com.beehyv.blogging.modal.Post;

public class PostService {

	private PostDAO postDAO = new PostDAOImpl();
	
	/**
	 * Gets posts for 'Recent Posts' Section in the home page
	 * @return
	 */
	public List<Post> getRecentPosts(){
		return postDAO.getRecentPosts();
	}
	
	/**
	 * Getting Posts for Home Page
	 * @return
	 */
	public List<Post> getHomePosts(){
		return postDAO.getHomePosts();
	}
	/**
	 * 
	 * @param post_id
	 * @return
	 */
	public Post getPost(long post_id){
		return postDAO.getPost(post_id);
		
	}
	/**
	 * 
	 * @param tag_id
	 * @return
	 */
	public List<Post> getPostsbytag(long tag_id){
		return postDAO.getPostsbytag(tag_id);
		
	} 
	/**
	 * 
	 * 
	 * @param post
	 */
	public void addPost(Post post){
		postDAO.addPost(post);
		
	}

	public List<Post> getMyPosts(Long employee_id) {
		return postDAO.getMyPosts(employee_id);
	}

	public List<Post> getPostsbyCategory(Long category_id) {
		return postDAO.getPostsbyCategory(category_id);
	}
	
	public void editPost(Post post){
		postDAO.editPost(post);
	}

}
