package com.beehyv.blogging.modal;

public class Tag {
	private String tag;
	private long idTag;
	private long idPost;
	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * @return the idTag
	 */
	public long getIdTag() {
		return idTag;
	}
	/**
	 * @param idTag the idTag to set
	 */
	public void setIdTag(long idTag) {
		this.idTag = idTag;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return idTag +": " + tag ;
	}
}
