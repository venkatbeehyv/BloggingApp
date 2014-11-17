package com.beehyv.blogging.modal;

public class Comment {
	private String comment;
	private String created_at;
	private String updated_at;
	private long idPost;
	private long idEmployee;
	private String name;
	/**
	 * @return the comment
	 */
	private String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	private void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the created_at
	 */
	private String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	private void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	private String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	private void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the idPost
	 */
	private long getIdPost() {
		return idPost;
	}
	/**
	 * @param idPost the idPost to set
	 */
	private void setIdPost(long idPost) {
		this.idPost = idPost;
	}
	/**
	 * @return the idEmployee
	 */
	private long getIdEmployee() {
		return idEmployee;
	}
	/**
	 * @param idEmployee the idEmployee to set
	 */
	private void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}
	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
}
