package com.beehyv.blogging.modal;

public class Category {
	private long idCategory;
	private long idParentCategory;
	private String categoryName;
	/**
	 * @return the idCategory
	 */
	public long getIdCategory() {
		return idCategory;
	}
	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}
	/**
	 * @return the idParentCategory
	 */
	public long getIdParentCategory() {
		return idParentCategory;
	}
	/**
	 * @param idParentCategory the idParentCategory to set
	 */
	public void setIdParentCategory(long idParentCategory) {
		this.idParentCategory = idParentCategory;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return idCategory +": " + categoryName;
	}
}
