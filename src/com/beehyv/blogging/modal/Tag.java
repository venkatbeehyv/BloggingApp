package com.beehyv.blogging.modal;

public class Tag {
	private String tag;
	private long idTag;
	private long idPost;
	/**
	 * @return the tag
	 */
	private String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	private void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the idTag
	 */
	private long getIdTag() {
		return idTag;
	}
	/**
	 * @param idTag the idTag to set
	 */
	private void setIdTag(long idTag) {
		this.idTag = idTag;
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
}
