package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.impl.PostDAOImpl;
import com.beehyv.blogging.modal.Post;
import com.beehyv.bloggingapp.dao.PostDAO;

public class PostService {

	private PostDAO postDAO = new PostDAOImpl();
	
	
	public List<Post> getRecentPosts(){
		return postDAO.getRecentPosts();
	}
	
	public List<Post> getPosts(){
		return postDAO.getPosts();
		
	}
}
