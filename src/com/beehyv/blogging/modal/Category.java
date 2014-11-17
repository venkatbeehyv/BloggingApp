package com.beehyv.blogging.modal;

public class Category {
	private long idCategory;
	private long idParentCategory;
	private String categoryName;
	/**
	 * @return the idCategory
	 */
	private long getIdCategory() {
		return idCategory;
	}
	/**
	 * @param idCategory the idCategory to set
	 */
	private void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}
	/**
	 * @return the idParentCategory
	 */
	private long getIdParentCategory() {
		return idParentCategory;
	}
	/**
	 * @param idParentCategory the idParentCategory to set
	 */
	private void setIdParentCategory(long idParentCategory) {
		this.idParentCategory = idParentCategory;
	}
	/**
	 * @return the categoryName
	 */
	private String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	private void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
