package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.CategoryDAO;
import com.beehyv.blogging.dao.impl.CategoryDAOImpl;
import com.beehyv.blogging.modal.Category;

/**
 * 
 * @author sanjay
 *
 */

public class CategoryService {
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	/**
	 * 
	 * @param category_id
	 * @return
	 */
	public List<Category> getChildren( long category_id){
		return categoryDAO.getChildren(category_id);
	}

	public List<Category> getParentTree(Long post_id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
