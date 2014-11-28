package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.impl.TagDAOImpl;
import com.beehyv.blogging.modal.Tag;
import com.beehyv.bloggingapp.dao.TagDAO;

public class TagService {
	private TagDAO tagDAO = new TagDAOImpl();
	
	public List<Tag> getHomeTags(){
		return tagDAO.getHomeTags();
	}
	
}
