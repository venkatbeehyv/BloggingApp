package com.beehyv.bloggingapp.dao;

import java.util.List;

import com.beehyv.blogging.modal.Post;

/**
 * 
 * @author sanjay
 *
 */
public interface PostDAO {

	public List<Post> getRecentPosts();
	public Post getPost(long post_id);
	public List<Post> getHomePosts();
	public List<Post> getPostsbytag(long tag_id);

}
