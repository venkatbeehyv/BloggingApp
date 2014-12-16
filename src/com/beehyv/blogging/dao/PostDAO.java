package com.beehyv.blogging.dao;

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
	public List<Post> getMyPosts(Long employee_id);
	public List<Post> getPostsbyCategory(Long category_id);
	public void addPost(Post post);
	public void editPost(Post post);
	public List<Post> searchPosts(String word);

}
