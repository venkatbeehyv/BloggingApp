package com.beehyv.blogging.modal;

public class Comment {
	private long comment_id;
	public long getComment_id() {
		return comment_id;
	}
	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}
	private String comment;
	private String created_at;
	private String updated_at;
	private long idPost;
	private long idEmployee;
	private String name;
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the idPost
	 */
	public long getIdPost() {
		return idPost;
	}
	/**
	 * @param idPost the idPost to set
	 */
	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}
	/**
	 * @return the idEmployee
	 */
	public long getIdEmployee() {
		return idEmployee;
	}
	/**
	 * @param idEmployee the idEmployee to set
	 */
	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +": " + created_at +"\n" + comment + "\n";
	}
	
}
