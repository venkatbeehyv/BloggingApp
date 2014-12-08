/**creats a Post Object
 * Provides getter and setter method to get different values of this object's field
 */
package com.beehyv.blogging.modal;

import java.util.List;


/**
 * @author sanjay
 *
 */
public class Post {
	private  String title;
	private  String content;
	private  String createdAt;
	private  String userName;
	private  long userId;
	private long categoryID;
	private long root_id;
	private long post_id;
	private String root_category;
	private List<Comment> comments;
	
	
	public long getPost_id() {
		return post_id;
	}
	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getRoot_category() {
		return root_category;
	}
	public void setRoot_category(String root_category) {
		this.root_category = root_category;
	}
	public long getRoot_id() {
		return root_id;
	}
	public void setRoot_id(long root_id) {
		this.root_id = root_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the categoryID
	 */
	public long getCategoryID() {
		return categoryID;
	}
	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}	
	
	@Override
	public String toString() {
		String postString = root_category + "\n" + title + "\n" + userName +": " + createdAt 
				+ "\n" + content + "\n\n";
		if(comments.size() == 0 ){
			return postString;
		}
		else 
		{
			String postStringwithComments =  postString; 
			for(Comment comment: comments){
				postStringwithComments = postStringwithComments.concat(comment.toString());
			}
			return postStringwithComments;
		}
	}	
}
