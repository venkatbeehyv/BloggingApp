package com.beehyv.bloggingapp.dao;

import java.util.List;

import com.beehyv.blogging.modal.Category;

public interface CategoryDAO {

	public List<Category> getChildTree(long category_id);
	public List<Category> getParentTree(long category_id);
	


}
