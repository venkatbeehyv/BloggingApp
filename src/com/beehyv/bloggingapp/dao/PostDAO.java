package com.beehyv.bloggingapp.dao;

import java.util.List;

import com.beehyv.blogging.modal.Post;

public interface PostDAO {

	public List<Post> getRecentPosts();
	public Post getPost();
	public List<Post> getPostsbytag(long tag_id);

}
