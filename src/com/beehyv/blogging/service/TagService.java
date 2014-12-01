package com.beehyv.blogging.service;

import java.util.List;

import com.beehyv.blogging.dao.TagDAO;
import com.beehyv.blogging.dao.impl.TagDAOImpl;
import com.beehyv.blogging.modal.Tag;

public class TagService {
	private TagDAO tagDAO = new TagDAOImpl();
	
	public List<Tag> getHomeTags(){
		return tagDAO.getHomeTags();
	}
	
}
