package com.beehyv.bloggingapp.dao;

import java.util.List;

import com.beehyv.blogging.modal.Post;

public interface PostDAO {

	public List<Post> getRecentPosts();
	public List<Post> getPosts();
}
