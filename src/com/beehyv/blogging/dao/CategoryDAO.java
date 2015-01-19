package com.beehyv.blogging.dao;

import java.util.List;

import com.beehyv.blogging.modal.Category;


/**
 * Category DAO to
 * @author sanjay
 *
 */
public interface CategoryDAO {

	public List<Category> getChildren(long category_id);
	public Category getRootParent(long category_id);
	public List<Category> getParentTree(long category_id);
	public List<Category[]> getCategoryTree();
	
}
