package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.impl.CategoryDAOImpl;
import com.beehyv.blogging.dao.impl.PostDAOImpl;
import com.beehyv.blogging.modal.Category;
import com.beehyv.blogging.modal.Post;
import com.beehyv.bloggingapp.dao.CategoryDAO;
import com.beehyv.bloggingapp.dao.PostDAO;

public class CategoryService {
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public List<Category> getChildTree( long category_id){
		return categoryDAO.getChildTree(category_id);
	}
}
